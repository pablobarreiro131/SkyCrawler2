package edu.dir;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.concurrent.CompletableFuture;

public class HttpManager {
    private HttpClient client;
    private Gson gson;

    public HttpManager() {
        this.client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();
        this.gson = new Gson();
    }

    public <T> CompletableFuture<T> fetchData(String url, Class<T> clase) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .build();
        return client.sendAsync(request, java.net.http.HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    if (response.statusCode() != 200) {
                        throw new RuntimeException("Failed to fetch data: " + response.statusCode());
                    }
                    return gson.fromJson(response.body(), clase);
                });
    }
}



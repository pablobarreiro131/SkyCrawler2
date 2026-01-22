package edu.dir;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.concurrent.CompletableFuture;

public class HttpManager {
    private final HttpClient client;
    private final Gson gson;

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

                    T resultado = gson.fromJson(response.body(), clase);
                    return resultado;
                });
    }

    public <T> CompletableFuture<T> fetchDataFromProperties(String url, Class<T> clase) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .build();
        return client.sendAsync(request, java.net.http.HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    if (response.statusCode() != 200) {
                        throw new RuntimeException("Failed to fetch data: " + response.statusCode());
                    }
                    JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
                    JsonObject result = jsonObject.getAsJsonObject("result");
                    JsonObject properties = result.getAsJsonObject("properties");
                    T resultado = gson.fromJson(properties, clase);
                    System.out.println("[CRAWLER] guardado: " + url);
                    if (resultado != null) {
                        System.out.println(resultado.toString());
                    }

                    return resultado;
                });
    }

}



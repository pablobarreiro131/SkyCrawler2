package edu.dir;

import edu.dir.Modelo.Informacion;
import edu.dir.Modelo.POJOs.*;
import edu.dir.Modelo.PaginaSWAPI;
import edu.dir.Modelo.RespuestaSWAPI;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SkyCrawler {

    private final HttpManager httpManager = new HttpManager();
    private final Set<String> urlsVisitadas = new HashSet<>();
    private final List<Object> resultados = new ArrayList<>();

    public void iniciarCrawl(String urlInicial) {
        RespuestaSWAPI root = httpManager.fetchData(urlInicial, RespuestaSWAPI.class).join();
        Map<String, String> enlaces = (Map<String, String>) root.result;
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (Map.Entry<String, String> entry : enlaces.entrySet()) {
            String categoria = entry.getKey();
            String url = entry.getValue();
            executorService.execute(() -> procesarCategoria(url, categoria));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        generarInforme();
    }

    public void procesarCategoria(String url, String categoria) {
        String proximaPagina = url;
        while (proximaPagina != null) {
            PaginaSWAPI paginaSWAPI = httpManager.fetchData(proximaPagina, PaginaSWAPI.class).join();
            if (paginaSWAPI == null || paginaSWAPI.results == null) break;
            for (Informacion info : paginaSWAPI.results) {
                descargarDetalle(info.url, categoria);
            }
            proximaPagina = paginaSWAPI.next;
        }
    }

    public void descargarDetalle(String url, String categoria){
        synchronized (urlsVisitadas){
            if (urlsVisitadas.contains(url)) return;
            urlsVisitadas.add(url);
        }

        Class<?> claseDestino = determinarClase(categoria);
        Object detalle = httpManager.fetchDataFromProperties(url, claseDestino).join();

        if (detalle != null) {
            synchronized (resultados) {
                resultados.add(detalle);
            }
        }
    }

    public Class<?> determinarClase(String categoria){
        return switch (categoria) {
            case "people" -> PersonProps.class;
            case "planets" -> PlanetProps.class;
            case "films" -> FilmProps.class;
            case "species" -> SpeciesProps.class;
            case "vehicles" -> VehicleProps.class;
            case "starships" -> StarshipProps.class;
            default -> Object.class;
        };
    }

    public void generarInforme() {
        System.out.println("--------------------------------------------------");
        System.out.println("Crawl completado. Total de objetos recolectados: " + resultados.size());
        for (Object obj : resultados) {
            System.out.println(obj.toString());
        }
        System.out.println("--------------------------------------------------");
    }

}

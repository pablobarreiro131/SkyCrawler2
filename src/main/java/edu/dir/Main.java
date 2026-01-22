package edu.dir;

public class Main {
    public static void main(String[] args) {
        String URL_BASE = "https://www.swapi.tech/api/";
        SkyCrawler skyCrawler = new SkyCrawler();
        skyCrawler.iniciarCrawl(URL_BASE);
        skyCrawler.generarInforme();
    }
}
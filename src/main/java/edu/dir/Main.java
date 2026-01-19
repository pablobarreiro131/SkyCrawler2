package edu.dir;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String URL_BASE = "https://www.swapi.tech/api/";
        SkyCrawler skyCrawler = new SkyCrawler();
        skyCrawler.iniciarCrawl(URL_BASE);
    }
}
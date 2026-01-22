package edu.dir.Modelo.POJOs;

import java.util.List;

public class FilmProps {
    public String title, director, producer, release_date, opening_crawl, url;
    public int episode_id;
    public List<String> characters, planets, species, starships, vehicles;

    @Override
    public String toString() {
        return String.format("""
                ╔════════════════════════════════════════════════════════════════
                ║ PELÍCULA: %s
                ╠════════════════════════════════════════════════════════════════
                ║ Episodio: %d
                ║ Director: %s
                ║ Productor: %s
                ║ Fecha de lanzamiento: %s
                ║ Personajes: %d
                ║ Planetas: %d
                ║ Especies: %d
                ║ Naves: %d
                ║ Vehículos: %d
                ║──────────────────────────────────────────────────────────────
                ║ Opening Crawl:
                ║ %s
                ╚════════════════════════════════════════════════════════════════
                """,
                title != null ? title : "Desconocido",
                episode_id,
                director != null ? director : "Desconocido",
                producer != null ? producer : "Desconocido",
                release_date != null ? release_date : "Desconocido",
                characters != null ? characters.size() : 0,
                planets != null ? planets.size() : 0,
                species != null ? species.size() : 0,
                starships != null ? starships.size() : 0,
                vehicles != null ? vehicles.size() : 0,
                opening_crawl != null ? opening_crawl.replaceAll("\r\n", "\n║ ") : "N/A"
        );
    }
}

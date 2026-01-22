package edu.dir.Modelo.POJOs;

import java.util.List;

public class SpeciesProps {
    public String name, classification, designation, average_height, average_lifespan, eye_colors, hair_colors, skin_colors, language, homeworld, url;
    public List<String> people, films;

    @Override
    public String toString() {
        return String.format("""
                ╔════════════════════════════════════════════════════════════════
                ║ ESPECIE: %s
                ╠════════════════════════════════════════════════════════════════
                ║ Clasificación: %s
                ║ Designación: %s
                ║ Altura promedio: %s cm
                ║ Esperanza de vida: %s años
                ║ Colores de ojos: %s
                ║ Colores de pelo: %s
                ║ Colores de piel: %s
                ║ Lenguaje: %s
                ║ Planeta natal: %s
                ║ Personas: %d
                ║ Películas: %d
                ╚════════════════════════════════════════════════════════════════
                """,
                name != null ? name : "Desconocido",
                classification != null ? classification : "Desconocido",
                designation != null ? designation : "Desconocido",
                average_height != null ? average_height : "Desconocido",
                average_lifespan != null ? average_lifespan : "Desconocido",
                eye_colors != null ? eye_colors : "Desconocido",
                hair_colors != null ? hair_colors : "Desconocido",
                skin_colors != null ? skin_colors : "Desconocido",
                language != null ? language : "Desconocido",
                homeworld != null ? homeworld : "Desconocido",
                people != null ? people.size() : 0,
                films != null ? films.size() : 0
        );
    }
}
package edu.dir.Modelo.POJOs;

import java.util.List;

public class PersonProps {
    public String name, birth_year, eye_color, gender, hair_color, height, mass, skin_color, homeworld, url;
    public List<String> films, species, starships, vehicles;

    @Override
    public String toString() {
        return String.format("""
                ╔════════════════════════════════════════════════════════════════
                ║ PERSONAJE: %s
                ╠════════════════════════════════════════════════════════════════
                ║ Año de nacimiento: %s
                ║ Género: %s
                ║ Altura: %s cm
                ║ Peso: %s kg
                ║ Color de ojos: %s
                ║ Color de pelo: %s
                ║ Color de piel: %s
                ║ Planeta natal: %s
                ║ Películas: %d
                ║ Especies: %d
                ║ Naves: %d
                ║ Vehículos: %d
                ╚════════════════════════════════════════════════════════════════
                """,
                name != null ? name : "Desconocido",
                birth_year != null ? birth_year : "Desconocido",
                gender != null ? gender : "Desconocido",
                height != null ? height : "Desconocido",
                mass != null ? mass : "Desconocido",
                eye_color != null ? eye_color : "Desconocido",
                hair_color != null ? hair_color : "Desconocido",
                skin_color != null ? skin_color : "Desconocido",
                homeworld != null ? homeworld : "Desconocido",
                films != null ? films.size() : 0,
                species != null ? species.size() : 0,
                starships != null ? starships.size() : 0,
                vehicles != null ? vehicles.size() : 0
        );
    }
}

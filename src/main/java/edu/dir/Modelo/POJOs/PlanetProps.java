package edu.dir.Modelo.POJOs;

import java.util.List;

public class PlanetProps {
    public String name, diameter, rotation_period, orbital_period, gravity, population, climate, terrain, surface_water, url;
    public List<String> residents, films;

    @Override
    public String toString() {
        return String.format("""
                ╔════════════════════════════════════════════════════════════════
                ║ PLANETA: %s
                ╠════════════════════════════════════════════════════════════════
                ║ Diámetro: %s km
                ║ Período de rotación: %s horas
                ║ Período orbital: %s días
                ║ Gravedad: %s
                ║ Población: %s
                ║ Clima: %s
                ║ Terreno: %s
                ║ Agua superficial: %s%%
                ║ Residentes: %d
                ║ Películas: %d
                ╚════════════════════════════════════════════════════════════════
                """,
                name != null ? name : "Desconocido",
                diameter != null ? diameter : "Desconocido",
                rotation_period != null ? rotation_period : "Desconocido",
                orbital_period != null ? orbital_period : "Desconocido",
                gravity != null ? gravity : "Desconocido",
                population != null ? population : "Desconocido",
                climate != null ? climate : "Desconocido",
                terrain != null ? terrain : "Desconocido",
                surface_water != null ? surface_water : "Desconocido",
                residents != null ? residents.size() : 0,
                films != null ? films.size() : 0
        );
    }
}
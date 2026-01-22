package edu.dir.Modelo.POJOs;

import java.util.List;

public class VehicleProps {
    public String name, model, vehicle_class, manufacturer, cost_in_credits, length, crew, passengers;
    public String max_atmosphering_speed, cargo_capacity, consumables, url;
    public List<String> films, pilots;

    @Override
    public String toString() {
        return String.format("""
                ╔════════════════════════════════════════════════════════════════
                ║ VEHÍCULO: %s
                ╠════════════════════════════════════════════════════════════════
                ║ Modelo: %s
                ║ Clase: %s
                ║ Fabricante: %s
                ║ Costo: %s créditos
                ║ Longitud: %s m
                ║ Tripulación: %s
                ║ Pasajeros: %s
                ║ Velocidad máxima: %s
                ║ Capacidad de carga: %s kg
                ║ Consumibles: %s
                ║ Películas: %d
                ║ Pilotos: %d
                ╚════════════════════════════════════════════════════════════════
                """,
                name != null ? name : "Desconocido",
                model != null ? model : "Desconocido",
                vehicle_class != null ? vehicle_class : "Desconocido",
                manufacturer != null ? manufacturer : "Desconocido",
                cost_in_credits != null ? cost_in_credits : "Desconocido",
                length != null ? length : "Desconocido",
                crew != null ? crew : "Desconocido",
                passengers != null ? passengers : "Desconocido",
                max_atmosphering_speed != null ? max_atmosphering_speed : "Desconocido",
                cargo_capacity != null ? cargo_capacity : "Desconocido",
                consumables != null ? consumables : "Desconocido",
                films != null ? films.size() : 0,
                pilots != null ? pilots.size() : 0
        );
    }
}

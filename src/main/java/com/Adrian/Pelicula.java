package com.Adrian;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Pelicula {

    @JsonProperty("titulo")
    private String titulo;

    @JsonProperty("detalles")
    private List<Detalle> detalles; // Cambiado a List<Detalle>

    public Pelicula() {}

    public Pelicula(String titulo, List<Detalle> detalles) {
        this.titulo = titulo;
        this.detalles = detalles;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }
}

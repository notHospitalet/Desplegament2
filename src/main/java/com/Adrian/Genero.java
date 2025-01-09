package com.Adrian;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Genero {

    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("peliculas")
    private List<Pelicula> peliculas;
    @JsonProperty("imagen")
    private String imagen;

    public Genero() {}
    public Genero(String nombre, List<Pelicula> peliculas, String imagen) {
        this.nombre = nombre;
        this.peliculas = peliculas;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}

package com.Adrian;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Detalle {

    @JsonProperty("sinopsis")
    private String sinopsis;

    @JsonProperty("director")
    private String director;

    @JsonProperty("anyo")
    private int anyo;

    @JsonProperty("duracion")
    private int duracion;

    @JsonProperty("imagen")
    private String imagen;

    public Detalle() {}
    public Detalle(String sinopsis, String director, int anyo, int duracion, String imagen) {
        this.sinopsis = sinopsis;
        this.director = director;
        this.anyo = anyo;
        this.duracion = duracion;
        this.imagen = imagen;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}

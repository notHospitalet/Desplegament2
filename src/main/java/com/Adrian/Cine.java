package com.Adrian;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Cine {

    @JsonProperty("generos")
    private List<Genero> generos;

    public Cine() {}

    public Cine(List<Genero> generos) {
        this.generos = generos;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }
}

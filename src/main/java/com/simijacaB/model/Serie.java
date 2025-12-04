package com.simijacaB.model;

public class Serie {

    String titulo;
    String genero; // "Drama", "Comedia", "Ciencia Ficción"
    String plataforma; // "Netflix", "HBO", "Disney+"
    long visualizaciones;

    public Serie() {}

    public Serie(String titulo, String genero, String plataforma, long visualizaciones) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.visualizaciones = visualizaciones;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public long getVisualizaciones() {
        return visualizaciones;
    }

    public void setVisualizaciones(long visualizaciones) {
        this.visualizaciones = visualizaciones;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", visualizaciones=" + visualizaciones +
                '}';
    }
}

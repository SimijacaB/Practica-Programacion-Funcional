package com.simijacaB.model;

import java.util.List;

public class Estudiante {

    String nombre;
    List<Calificacion> notas;

    public Estudiante(String nombre, List<Calificacion> notas) {
        this.nombre = nombre;
        this.notas = notas;
    }
    public List<Calificacion> getNotas() { return notas; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNotas(List<Calificacion> notas) {
        this.notas = notas;
    }
}

package com.simijacaB.model;

public class Calificacion {
    String materia; // "Matemáticas", "Historia", etc.
    double puntaje; // 0.0 a 10.0

    public Calificacion(String m, double p) { this.materia = m; this.puntaje = p; }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return "Calificacion{" +
                "materia='" + materia + '\'' +
                ", puntaje=" + puntaje +
                '}';
    }
}

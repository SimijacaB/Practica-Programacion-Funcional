package com.simijacaB.model;

public class Producto {

    public String nombre;
    public Double precio;

    public Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }


}

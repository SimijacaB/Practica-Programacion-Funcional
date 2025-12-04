package com.simijacaB.model;

public class Empleado {
        public String nombre;
        public String departamento; // "TI", "Ventas", "RRHH"
        public double salario;

    public Empleado(String n, String d, double s) {
        this.nombre = n;
        this.departamento = d;
        this.salario = s;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return nombre;
    }

}

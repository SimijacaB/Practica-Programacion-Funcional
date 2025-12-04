package com.simijacaB.streams;

import com.simijacaB.model.Producto;

import java.util.Arrays;
import java.util.List;

public class RetoFiltrarProducto {

    public static void main(String[] args) {
        /*
        Usando la misma lista inventario, quiero saber cuánto suman todos los precios de los productos que cuestan menos de 50 dólares.
         */

        List<Producto> inventario = Arrays.asList(
                new Producto("Laptop", 1200.0),
                new Producto("Mouse", 25.0),
                new Producto("Teclado", 75.0),
                new Producto("Monitor", 300.0),
                new Producto("Cables", 10.0));

        // Forma mas eficiente
        double suma = inventario.stream()
                .filter(p -> p.precio < 50)
                .mapToDouble(p -> p.precio)
                .sum();

        System.out.println("El total a pagar es: " + suma);
    }
}

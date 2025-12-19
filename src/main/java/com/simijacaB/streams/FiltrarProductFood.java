package com.simijacaB.streams;

import com.simijacaB.model.ProductFood;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FiltrarProductFood {
    public static void main(String[] args) {

        List<ProductFood> productos = List.of(
                new ProductFood("Queso", "Lácteos", "10", 15.0),
                new ProductFood("Piña", "Frutas", "5", 2.0),
                new ProductFood("Tomate", "Verduras", "5", 10.0),
                new ProductFood("Leche", "Lácteos", "2", 10.0),
                new ProductFood("Mango", "Frutas", "23", 10.0),
                new ProductFood("Kumis", "Lácteos", "4", 10.0),
                new ProductFood("Sandia", "Frutas", "18", 10.0),
                new ProductFood("Yogurt", "Lácteos", "2", 10.0));

        //filtrarPorCategoria(productos);
        //calcularTotalFrutas(productos);
        //precioMasBajo(productos);
        //agruparCategoria(productos);
        calcularPrecioPromedioPorCategoria(productos);


    }

    //Filtrar por categoria
    public static void filtrarPorCategoria(List<ProductFood> productos){
        List<ProductFood> lacteos = productos.stream()
                .filter(p -> p.getCategory().equals("Lácteos"))
                .toList();

        System.out.println("Categoria Lácteos " + lacteos);
    }

    //Calcular precio total frutas
    public static void calcularTotalFrutas(List<ProductFood> productos){

        double totalCategoriaFrutas = productos.stream()
                .filter(p -> p.getCategory().equals("Frutas"))
                .mapToDouble(ProductFood::getPrice)
                .sum();

        System.out.println("El total de frutas es: " + totalCategoriaFrutas);

    }

    //Obtener el producto con el precio mas bajo
    public static void precioMasBajo(List<ProductFood> productos){
        ProductFood precioMasBajo = productos.stream()
                .min(Comparator.comparingDouble(ProductFood::getPrice))
                .orElse(null);

        System.out.println(precioMasBajo);

    }

    //Agrupar por categoria
    public static void agruparCategoria(List<ProductFood> productos){
        Map<String, List<String>> porCategoria = productos.stream()
                .collect(Collectors.groupingBy(ProductFood::getCategory, Collectors.mapping(ProductFood::getName, Collectors.toList())));

        System.out.println(porCategoria);
    }

    //Calcular el precio promedio de cada categoria y obtener la categoria con el precio mas alto
    public static void calcularPrecioPromedioPorCategoria(List<ProductFood> productos){
        Map<String, Double> precioPromedioPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(ProductFood::getCategory, Collectors.averagingDouble(ProductFood::getPrice)));

        System.out.println(precioPromedioPorCategoria);

        String categoriaPrecioMasAlto = precioPromedioPorCategoria.entrySet().stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("No se encontró");

        System.out.println("Categoria con precio mas alto: " + categoriaPrecioMasAlto);


    }


}

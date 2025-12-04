package com.simijacaB.streams;

import com.simijacaB.model.Serie;

import java.util.*;
import java.util.stream.Collectors;

public class CatalogoSeries {




    public static void main(String[] args) {


        List<Serie> catalogo = Arrays.asList(
                new Serie("The Last of Us", "Drama", "HBO", 1200000),
                new Serie("Succession", "Drama", "HBO", 800000),
                new Serie("Stranger Things", "Ciencia Ficción", "Netflix", 1500000),
                new Serie("Mandalorian", "Ciencia Ficción", "Disney+", 1100000),
                new Serie("The Office", "Comedia", "Netflix", 3000000),
                new Serie("Game of Thrones", "Drama", "HBO", 2500000),
                new Serie("Andor", "Ciencia Ficción", "Disney+", 600000)
        );

        Boolean existMovie = catalogo.stream()
                .anyMatch(s -> s.getPlataforma().equals("HBO") && s.getVisualizaciones() > 2000000);

        System.out.println(existMovie);

        List<Serie> masVistas = catalogo.stream()
                .sorted(Comparator.comparing( Serie::getVisualizaciones).reversed())
                .limit(3)
                .toList();

        System.out.println(masVistas);


        Map<String, Optional<Serie>> masVistaPorGenero = catalogo.stream()
                .collect(Collectors.groupingBy(Serie::getGenero, Collectors.maxBy(Comparator.comparing(Serie::getVisualizaciones))));

        System.out.println(masVistaPorGenero);



    }
}

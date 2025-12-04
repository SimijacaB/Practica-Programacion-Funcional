package com.simijacaB.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalisisTexto {
    public static void main(String[] args) {
        List<String> frases = Arrays.asList(
                "Java es genial",
                "Java tiene streams",
                "streams son poderosos",
                "es genial aprender"
        );


        Map<String, Long> palabrasRepetidas = frases.stream()
                .flatMap(frase -> Arrays.stream(frase.split(" ")))
                .collect(Collectors.groupingBy(frase -> frase, Collectors.counting()));

        System.out.println(palabrasRepetidas);


    }
}

package com.simijacaB.basics;

import com.simijacaB.model.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Generics {

    public static void main(String[] args) {


        IntBinaryOperator suma = (a, b) -> a + b;
        int resultado = suma.applyAsInt(3, 4);
        System.out.println("Resultado: " + resultado);

        List<String> lista = List.of("Magnolia", "Patricia", "Carla", "Pedro");


        List<String> letras = lista.stream().filter(l -> l.contains("a")).toList();

        letras.forEach(System.out::println);
        PredicateMetodoAbstracto();
        ConsumerMetodoAbstracto();
        SupplierMetodoAbstracto();
        FuntionMetodoAbstracto();
        PruebadeCodigo();

    }

    static void PredicateMetodoAbstracto() {

        Predicate<Integer> esMayorDeEdad = edad -> edad >= 18;


        boolean resultado = esMayorDeEdad.test(20);
        boolean resultado2 = esMayorDeEdad.test(15);

        System.out.println(resultado);

    }

    static void ConsumerMetodoAbstracto() {
        Consumer<String> impresor = texto -> System.out.println("Imprimiendo: " + texto);

        impresor.accept("Hola Mundo");
    }

    static void SupplierMetodoAbstracto() {

        Supplier<Double> generadorAleatorio = () -> Math.random();

        Double numero = generadorAleatorio.get();
        System.out.println(numero);
    }

    static void FuntionMetodoAbstracto() {

        Function<Integer, String> convertidor = numero -> "El número es " + numero;

        String texto = convertidor.apply(50);
        System.out.println(texto);
    }

    static void PruebadeCodigo() {

        Predicate<String> esLargo = s -> s.length() > 5;

        Function<String, Integer> obtenerLongitud = s -> s.length();

        Consumer<Integer> imprimirNumero = n -> System.out.println("Longitud: " + n);


        //Iniciamos
        String miTexto = "Aprendiendo Java";

        // Paso 1: ¿Es largo?
        if (esLargo.test(miTexto)) {
            // Paso 2: Transformar a numero
            Integer largo = obtenerLongitud.apply(miTexto);
            // Paso 3: Consumir (imprimir)
            imprimirNumero.accept(largo);


        }
    }


}








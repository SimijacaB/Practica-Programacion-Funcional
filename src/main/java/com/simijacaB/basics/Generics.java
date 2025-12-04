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
        // Sintaxis: Predicate<TipoDeDato> nombre = parametro -> condicion;
        Predicate<Integer> esMayorDeEdad = edad -> edad >= 18;

        // Usándolo (sin streams aún):
        boolean resultado = esMayorDeEdad.test(20); // true
        boolean resultado2 = esMayorDeEdad.test(15); // false

        System.out.println(resultado);

    }

    static void ConsumerMetodoAbstracto() {
        // Sintaxis: Consumer<TipoDeDato> nombre = parametro -> accion;
        Consumer<String> impresor = texto -> System.out.println("Imprimiendo: " + texto);

        // Usándolo:
        impresor.accept("Hola Mundo"); // Salida consola: Imprimiendo: Hola Mundo
    }

    static void SupplierMetodoAbstracto() {
        // Sintaxis: Supplier<TipoDeRetorno> nombre = () -> valor_a_devolver;
        Supplier<Double> generadorAleatorio = () -> Math.random();

        // Usándolo:
        Double numero = generadorAleatorio.get();
        System.out.println(numero);
    }

    static void FuntionMetodoAbstracto() {
        // Sintaxis: Function<Entrada, Salida> nombre = parametro -> retorno;
        Function<Integer, String> convertidor = numero -> "El número es " + numero;

        // Usándolo:
        String texto = convertidor.apply(50); // "El número es 50"
        System.out.println(texto);
    }

    static void PruebadeCodigo() {

        // 1. Un Predicate que valide si un String tiene más de 5 letras.
        // T es String.
        Predicate<String> esLargo = s -> s.length() > 5;

        // 2. Una Function que reciba un String y devuelva su longitud (Integer).
        // T es String, R es Integer.
        Function<String, Integer> obtenerLongitud = s -> s.length();

        // 3. Un Consumer que reciba un numero e imprima "Longitud: X".
        // T es Integer.
        Consumer<Integer> imprimirNumero = n -> System.out.println("Longitud: " + n);


        // --- PROBEMOS EL FLUJO ---
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








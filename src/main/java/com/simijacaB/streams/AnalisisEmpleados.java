package com.simijacaB.streams;

import com.simijacaB.model.Empleado;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class AnalisisEmpleados {

    public static void main(String[] args) {
        //Lista de datos
        List<Empleado> empleados = Arrays.asList(
                new Empleado("Carlos", "TI", 3000),
                new Empleado("Ana", "Ventas", 1500),
                new Empleado("Elena", "TI", 4500),
                new Empleado("Pedro", "RRHH", 2800),
                new Empleado("Luisa", "Ventas", 1200),
                new Empleado("Javier", "TI", 3200)
        );

        SueldosPorDepartamento(empleados);
        QuienGanaMas(empleados);

        /*
        Reto 1: El Equipo Elite (Filtro + Orden)
        Obtén una lista de nombres (List<String>) de los empleados de "TI" que ganan más de 3000, ordenados alfabéticamente.
         */
        List<String> gananMas = empleados.stream()
                .filter(e -> e.salario > 3000)
                .filter(e -> e.departamento.equals("TI"))
                .map(e -> e.nombre)
                .sorted()
                .toList();

        gananMas.forEach(System.out::println);

        //Solo para imprimir (no devuelve nada)
        empleados.stream()
                .filter(e -> e.salario > 3000)
                .filter(e -> e.departamento.equals("TI"))
                .map(e -> e.nombre)
                .sorted()
                .forEach(System.out::println);



        System.out.println(gananMas);

        /*
        Reto 2: Estadísticas Financieras (Matemáticas)
        Calcula el promedio de salario (double) de todo el departamento de "Ventas".
         */
        double promedio = empleados.stream()
                .filter(e -> e.departamento.equals("Ventas"))
                .mapToDouble(e -> e.salario)
                .average()
                .orElse(0);

        System.out.println("Promedio departamento de ventas: " + promedio);

        /*
        Reto 3: El Buscador (Optional)
        Encuentra al primer empleado que gane más de 6000 dólares.
        Pregunta trampa: ¿Qué pasa si no hay ninguno? Tu código no debe fallar, debe devolver un mensaje "Nadie gana tanto" o un empleado por defecto.
         */

        Optional<Empleado> empleadoRico = empleados.stream()
                .filter(e -> e.salario > 6000)
                .findFirst();

        if (empleadoRico.isEmpty()) {
            System.out.println("Nadie gana tanto");
        }

        /*
        Reto 4: El Reporte (Concatenación)
        Genera un solo String que contenga los nombres de todos los empleados separados por comas.
        Ejemplo esperado: "Carlos, Ana, Elena, Pedro, Luisa, Javier"
         */

        String nombres = empleados.stream()
                .map(e -> e.nombre)
                .collect(Collectors.joining(", "));

        System.out.println(nombres);


        /*
        ESCENARIO 1: LISTAS ANIDADAS
        "Toma la lista de empleados y devuélveme un Mapa donde la clave sea el Departamento y el valor sea la lista de empleados de ese departamento."
         */
        Map<String, List<Empleado>> porDepto = empleados.stream()
                .collect(Collectors.groupingBy(e -> e.departamento));

        System.out.println(porDepto);

    }

    static void QuienGanaMas(List<Empleado> empleados){
         /*
        Reto 1: El Equipo Elite (Filtro + Orden)
        Obtén una lista de nombres (List<String>) de los empleados de "TI" que ganan más de 3000, ordenados alfabéticamente.
         */
        List<String> gananMas = empleados.stream()
                .filter(e -> e.salario > 3000)
                .filter(e -> e.departamento.equals("TI"))
                .map(e -> e.nombre)
                .sorted()
                .toList();

        gananMas.forEach(System.out::println);

        //Solo para imprimir,  no devuelve nada
        empleados.stream()
                .filter(e -> e.salario > 3000)
                .filter(e -> e.departamento.equals("TI"))
                .map(e -> e.nombre)
                .sorted()
                .forEach(System.out::println);



        System.out.println(gananMas);
    }

    static void SueldosPorDepartamento(List<Empleado> empleados){

        Map<String, Double> sueldosPorDepto = empleados.stream()
                .collect(Collectors.groupingBy(e -> e.departamento,
                        Collectors.summingDouble(e -> e.salario)));

        System.out.println(sueldosPorDepto);

    }
}

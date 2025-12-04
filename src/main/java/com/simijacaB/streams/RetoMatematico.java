package com.simijacaB.streams;

import com.simijacaB.model.Calificacion;
import com.simijacaB.model.Estudiante;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RetoMatematico {

    public static void main(String[] args) {

        //El director de la escuela no quiere saber las notas por alumno. Quiere saber qué materia es la más difícil.

        List<Estudiante> escuela = Arrays.asList(
                new Estudiante("Juan", Arrays.asList(
                        new Calificacion("Matemáticas", 8.0),
                        new Calificacion("Historia", 5.0)
                )),
                new Estudiante("Maria", Arrays.asList(
                        new Calificacion("Matemáticas", 9.0),
                        new Calificacion("Historia", 9.0)
                )),
                new Estudiante("Pedro", Arrays.asList(
                        new Calificacion("Matemáticas", 4.0),
                        new Calificacion("Historia", 6.0)
                ))
        );

        Map<String, Double> promedioPorMateria = escuela.stream()
                .flatMap(estudiante -> estudiante.getNotas().stream())
                .collect(Collectors.groupingBy(
                        Calificacion::getMateria,
                        Collectors.averagingDouble(Calificacion::getPuntaje)
                ));

        System.out.println(promedioPorMateria);
    }
}

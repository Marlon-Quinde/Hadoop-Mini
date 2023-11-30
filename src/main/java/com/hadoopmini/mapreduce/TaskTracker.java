package com.hadoopmini.mapreduce;

import com.hadoopmini.sadness.SadnessReducer;
import com.hadoopmini.temperature.TemperatureReducer;

import java.util.ArrayList;
import java.util.List;

public class TaskTracker {
    public void runReducer(TemperatureReducer reducer, List<String> mapOutput) {
        // Crear una lista para almacenar los resultados finales
        List<String> finalOutput = new ArrayList<>();

        // Llamar al método reduce y pasar la lista finalOutput
        reducer.reduce("KeyPlaceholder", mapOutput, finalOutput);

        // No olvides manejar la lista finalOutput según tus necesidades
        // Puedes guardarla en un archivo o procesarla de alguna otra manera
    }

    public void runReducer(SadnessReducer reducer, List<String> mapOutput) {
        // Crear una lista para almacenar los resultados finales
        List<String> finalOutput = new ArrayList<>();

        // Llamar al método reduce y pasar la lista finalOutput
        reducer.reduce("KeyPlaceholder", mapOutput);

        // No olvides manejar la lista finalOutput según tus necesidades
        // Puedes guardarla en un archivo o procesarla de alguna otra manera
    }
}
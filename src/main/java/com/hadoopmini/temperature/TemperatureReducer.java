package com.hadoopmini.temperature;
import java.util.List;

public class TemperatureReducer {
    public void reduce(String key, List<String> values, List<String> output) {
        double minTemperature = Integer.MAX_VALUE;
        double maxTemperature = Integer.MIN_VALUE;

        // Iterar sobre los valores y encontrar la temperatura mínima y máxima
        for (String value : values) {
            double temperature = Double.parseDouble(value);


            minTemperature = Math.min(minTemperature, temperature);
            maxTemperature = Math.max(maxTemperature, temperature);
        }

        // Emitir la ubicación y las temperaturas mínima y máxima como clave/valor
        output.add(key + "," + minTemperature);
        output.add(key + "," + maxTemperature);
        System.out.println(key + ", Mínima: " + minTemperature + ", Máxima: " + maxTemperature);
    }
}

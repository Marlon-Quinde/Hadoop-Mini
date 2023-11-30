package com.hadoopmini.temperature;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class TemperatureMapper {
    public void map(String input, List<String> intermediateOutput) {
        try {
            // Utilizar Apache Commons CSV para parsear el CSV
            CSVParser parser = CSVParser.parse(new StringReader(input), CSVFormat.DEFAULT);
            List<CSVRecord> records = parser.getRecords();

            // Iterar sobre los registros y emitir la ubicación y la temperatura como clave/valor
            for (CSVRecord record : records) {

                String temperature = record.get(8); //

                intermediateOutput.add( temperature);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

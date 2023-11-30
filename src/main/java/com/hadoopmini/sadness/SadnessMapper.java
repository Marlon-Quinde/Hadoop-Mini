package com.hadoopmini.sadness;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class SadnessMapper {
    public void map(String input, List<String> intermediateOutput) {
        try {
            // Utilizar tabulador como delimitador
            CSVParser parser = CSVParser.parse(new StringReader(input), CSVFormat.TDF);
            List<CSVRecord> records = parser.getRecords();

            for (CSVRecord record : records) {
                String word = record.get(0);
                double happinessAverage = Double.parseDouble(record.get(2));
                String twitterRank = record.get(3);

                if (happinessAverage < 2 && !twitterRank.equals("--")) {
                    intermediateOutput.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

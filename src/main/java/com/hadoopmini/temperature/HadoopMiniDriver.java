package com.hadoopmini.temperature;

import com.hadoopmini.hdfs.DataNode;
import com.hadoopmini.hdfs.NameNode;
import com.hadoopmini.mapreduce.JobTracker;
import com.hadoopmini.mapreduce.TaskTracker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HadoopMiniDriver {
    public static void main(String[] args) {
        // Configurar HDFS
        NameNode nameNode = new NameNode();
        DataNode dataNode = new DataNode();

        // Configurar MapReduce
        JobTracker jobTracker = new JobTracker();
        TaskTracker taskTracker = new TaskTracker();
        jobTracker.addTaskTracker(taskTracker);

        // Ruta del archivo CSV
            String csvFilePath = "src/main/resources/JCMB_last31days.csv";

        // Simular entrada de datos
        List<String> inputData = readCSVFile(csvFilePath);

        // Simular ejecución de MapReduce
        TemperatureMapper mapper = new TemperatureMapper();
        List<String> intermediateOutput = new ArrayList<>();
        for (String input : inputData) {
            // Llamar al método map y pasar la lista intermediateOutput
            mapper.map(input, intermediateOutput);
        }

        TemperatureReducer reducer = new TemperatureReducer();
        List<String> finalOutput = new ArrayList<>();
        taskTracker.runReducer(reducer, intermediateOutput);

        for (String result : finalOutput) {
            System.out.println(result);
        }
    }

    private static List<String> readCSVFile(String filePath) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}

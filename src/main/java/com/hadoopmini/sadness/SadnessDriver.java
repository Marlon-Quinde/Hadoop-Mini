package com.hadoopmini.sadness;

import com.hadoopmini.hdfs.DataNode;
import com.hadoopmini.hdfs.NameNode;
import com.hadoopmini.mapreduce.JobTracker;
import com.hadoopmini.mapreduce.TaskTracker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SadnessDriver {
    public static void main(String[] args) {
        NameNode nameNode = new NameNode();
        DataNode dataNode = new DataNode();

        JobTracker jobTracker = new JobTracker();
        TaskTracker taskTracker = new TaskTracker();
        jobTracker.addTaskTracker(taskTracker);

        String filePath = "src/main/resources/happiness.txt";
        List<String> inputData = readCSVFile(filePath);

        SadnessMapper sadnessMapper = new SadnessMapper();
        List<String> intermediateOutput = new ArrayList<>();
        for (String input : inputData) {
            sadnessMapper.map(input, intermediateOutput);
        }

        SadnessReducer sadnessReducer = new SadnessReducer();
        taskTracker.runReducer(sadnessReducer, intermediateOutput);
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

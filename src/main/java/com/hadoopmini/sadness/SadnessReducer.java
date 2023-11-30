package com.hadoopmini.sadness;

import java.util.List;

public class SadnessReducer {
    public void reduce(String key, List<String> values) {
        for (String word : values) {
            System.out.println("Palabra extremadamente triste: " + word);
        }
    }
}

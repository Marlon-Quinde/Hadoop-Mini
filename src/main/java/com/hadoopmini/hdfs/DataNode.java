package com.hadoopmini.hdfs;

import java.util.ArrayList;
import java.util.List;

public class DataNode {
    private List<String> data = new ArrayList<>();

    public void storeData(String content) {
        data.add(content);
    }

    public List<String> getData() {
        return data;
    }
}


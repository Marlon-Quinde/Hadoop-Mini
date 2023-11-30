package com.hadoopmini.hdfs;

import java.util.HashMap;
import java.util.Map;

public class NameNode {
    private Map<String, Integer> blockAssignments = new HashMap<>();
    private int nextBlockId = 1;

    public int assignBlock(String location) {
        int blockId = nextBlockId++;
        blockAssignments.put(location, blockId);
        return blockId;
    }

    public int getBlockId(String location) {
        return blockAssignments.get(location);
    }
}
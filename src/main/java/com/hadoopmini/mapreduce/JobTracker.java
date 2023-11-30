package com.hadoopmini.mapreduce;

import java.util.ArrayList;
import java.util.List;
import com.hadoopmini.mapreduce.*;
public class JobTracker {
    private List<TaskTracker> taskTrackers = new ArrayList<>();

    public void addTaskTracker(TaskTracker taskTracker) {
        taskTrackers.add(taskTracker);
    }

    public List<TaskTracker> getTaskTrackers() {
        return taskTrackers;
    }
}

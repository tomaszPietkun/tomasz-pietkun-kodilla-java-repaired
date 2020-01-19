
package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {
    String taskName;
    String color;
    String whatToPaint;
    public static boolean isExecuted = false;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint =whatToPaint;
    }

    @Override
    public String executeTask() {
        return "Executing painting task!";
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return isExecuted;
    }
}
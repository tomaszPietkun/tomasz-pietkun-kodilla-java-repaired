
package com.kodilla.patterns.factory.tasks;

import java.util.ArrayList;

public class ShoppingTask implements Task{
    String taskName;
    String whatToBuy;
    double quantity;
    public static boolean isExecuted = false;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public String executeTask() {
        return "Executing shopping task!";
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
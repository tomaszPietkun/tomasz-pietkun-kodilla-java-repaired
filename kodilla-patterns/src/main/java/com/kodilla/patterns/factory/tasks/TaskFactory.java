
package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";

    public final Task createTask(final String taskClass) {
        switch(taskClass) {
            case DRIVING:
                DrivingTask.isExecuted = true;
                return new DrivingTask("Driving task number 1", "CinemaCity", "Uber");
            case PAINTING:
                PaintingTask.isExecuted = true;
                return new PaintingTask("Painting task number 1", "White", "Summer bower");
            case SHOPPING:
                ShoppingTask.isExecuted = true;
                return new ShoppingTask("Shopping task number 1", "Bottle of watter", 6.0);
            default:
                return null;
        }
    }
}
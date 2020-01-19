package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryDriving() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task driving = factory.createTask(TaskFactory.DRIVING);
        boolean isCompleted = driving.isTaskExecuted();
        //Then
        Assert.assertEquals("Driving task number 1", driving.getTaskName());
        Assert.assertEquals("Executing driving task!", driving.executeTask());
        Assert.assertTrue(isCompleted);
    }

    @Test
    public void testFactoryPainting() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task painting = factory.createTask(TaskFactory.PAINTING);
        boolean isCompleted = painting.isTaskExecuted();
        //Then
        Assert.assertEquals("Painting task number 1", painting.getTaskName());
        Assert.assertEquals("Executing painting task!", painting.executeTask());
        Assert.assertTrue(isCompleted);
    }

    @Test
    public void testFactoryShopping() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shopping = factory.createTask(TaskFactory.SHOPPING);
        boolean isCompleted = shopping.isTaskExecuted();
        //Then
        Assert.assertEquals("Shopping task number 1", shopping.getTaskName());
        Assert.assertEquals("Executing shopping task!", shopping.executeTask());
        Assert.assertTrue(isCompleted);
    }
}
package com.kodilla.spring.testing;

import com.kodilla.spring.portfolio.Board;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.portfolio");
        Board board = context.getBean(Board.class);

        boolean addTask1 = board.getToDoList().addTask("Pass Session");
        boolean addTask2 = board.getInProgressList().addTask("Finish Bootcamp");
        boolean addTask3 = board.getDoneList().addTask("Travel to Australia");


        Assert.assertTrue(addTask1);
        Assert.assertTrue(addTask2);
        Assert.assertTrue(addTask3);
        Assert.assertEquals("Pass Session", board.getToDoList().getTasks().get(0));
        Assert.assertEquals("Finish Bootcamp", board.getInProgressList().getTasks().get(0));
        Assert.assertEquals("Travel to Australia", board.getDoneList().getTasks().get(0));
    }
}
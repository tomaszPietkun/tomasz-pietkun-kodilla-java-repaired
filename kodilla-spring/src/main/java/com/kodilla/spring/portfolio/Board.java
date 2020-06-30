package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public final class Board {

    final TaskList toDoList;
    final TaskList inProgressList;
    final TaskList doneList;

    public Board(final TaskList toDoList, final TaskList inProgressList, final TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }

    public void readList() {
        System.out.println("To do List: " + toDoList);
        System.out.println("In progress list: " + inProgressList);
        System.out.println("Done list: " + doneList);
    }
}
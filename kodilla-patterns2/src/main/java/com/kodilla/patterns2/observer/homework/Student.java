package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Student implements Observable{
    private final List<Observer> mentors;
    private final List<String> tasks;
    private final String name;

    public Student(String name) {
        mentors = new ArrayList<>();
        tasks = new ArrayList<>();
        this.name = name;
    }

    public void addTask(String task) {
        tasks.add(task);
        notifyMentors();
    }

    @Override
    public void registerMentor(Observer observer) {
        mentors.add(observer);
    }

    @Override
    public void notifyMentors() {
        for (Observer observer : mentors) {
            observer.update(this);
        }
    }

    @Override
    public void removeMentor(Observer observer) {
        mentors.remove(observer);
    }

    public List<String> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }
}

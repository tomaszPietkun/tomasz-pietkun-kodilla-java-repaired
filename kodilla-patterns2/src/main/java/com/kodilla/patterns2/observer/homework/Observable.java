package com.kodilla.patterns2.observer.homework;

public interface Observable {
    void registerMentor(Observer observer);
    void notifyMentors();
    void removeMentor(Observer observer);
}

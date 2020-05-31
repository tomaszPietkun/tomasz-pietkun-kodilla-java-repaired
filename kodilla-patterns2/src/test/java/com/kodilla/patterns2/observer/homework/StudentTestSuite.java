package com.kodilla.patterns2.observer.homework;

import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTestSuite {
    @Test
    public void testUpdate() {
        //Given
        Student pawelPaczul = new PawelPaczulStudent();
        Student wojtekPiela = new WojtekPielaStudent();
        Student jakubWisniowski = new JakubWisniowskiStudent();
        Mentor mateuszBorek = new Mentor("Mateusz Borek");
        Mentor wojciechKowalczyk = new Mentor("Wojciech Kowalczyk");
        pawelPaczul.registerMentor(wojciechKowalczyk);
        wojtekPiela.registerMentor(wojciechKowalczyk);
        jakubWisniowski.registerMentor(mateuszBorek);
        //When
        pawelPaczul.addTask("Zadanie: try! catch! finally!");
        pawelPaczul.addTask("Zadanie: Obsługa wyjątku");
        wojtekPiela.addTask("Zadanie: tworzymy tabele z zadaniami");
        wojtekPiela.addTask("Zadanie: wyświetlamy zadania na listach zadań");
        wojtekPiela.addTask("Zadanie: aktywni użytkownicy ");
        jakubWisniowski.addTask("Zadanie: Utwórz metodę do wyszukiwania pojedynczego zadania");
        jakubWisniowski.addTask("Zadanie: usuwanie zadania");
        //Then
        assertEquals(5, wojciechKowalczyk.getUpdateCount());
        assertEquals(2, mateuszBorek.getUpdateCount());
    }
}

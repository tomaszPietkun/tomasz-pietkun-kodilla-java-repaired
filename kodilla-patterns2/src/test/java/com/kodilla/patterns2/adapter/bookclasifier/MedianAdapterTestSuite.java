package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        //Given
        MedianAdapter theAdapter = new MedianAdapter();
        Book book1 = new Book("The World According to Clarkson volume seven.", "Jeremy Clarkson", 2018, "1");
        Book book2 = new Book("A breif history of Time", "Stephen Hawking", 2016, "2");
        Book book3 = new Book("Mio padre Enzo", "Pierro Ferrari", 2007, "3");
        Book book4 = new Book("Kuba Wojewodzki biografia", "Kuba Wojewodzki", 2018, "4");
        Set<Book> books = new HashSet<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        //When
        int median = theAdapter.publicationYearMedian(books);
        //Then
        System.out.println(median);
        assertEquals(median, 2017);
    }
}

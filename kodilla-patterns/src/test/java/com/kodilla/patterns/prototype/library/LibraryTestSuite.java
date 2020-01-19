package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Library 1");
        Book book1 = new Book("The World According to Clarkson volume seven.", "Jeremy Clarkson", LocalDate.of(2018, 03, 21));
        Book book2 = new Book("A breif history of Time", "Stephen Hawking", LocalDate.of(2016, 02, 12));
        Book book3 = new Book("Mio padre Enzo", "Pierro Ferrari", LocalDate.of(2007, 05, 15));
        Book book4 = new Book("Kuba Wojewodzki biografia", "Kuba Wojewodzki", LocalDate.of(2018, 12, 12));

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName ("Library 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Library 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().remove(book4);

        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        Assert.assertEquals(3, library.getBooks().size());
        Assert.assertEquals(3, clonedLibrary.getBooks().size());
        Assert.assertEquals(4, deepClonedLibrary.getBooks().size());

    }
}

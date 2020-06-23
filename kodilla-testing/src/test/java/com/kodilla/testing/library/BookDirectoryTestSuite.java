package com.kodilla.testing.library;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite {
    @Test
    public void testListBooksWithConditionsReturnList() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        ArrayList<Book> resultListOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret"))
                .thenReturn(resultListOfBooks);

        // When
        ArrayList<Book> theListOfBooks = (ArrayList<Book>) bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    private ArrayList<Book> generateListOfNBooks(int booksQuantity) {
        ArrayList<Book> resultList = new ArrayList<Book>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        ArrayList<Book> resultListOf0Books = new ArrayList<Book>();
        ArrayList<Book> resultListOf15Books = generateListOfNBooks(15);
        ArrayList<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);

        // When
        ArrayList<Book> theListOfBooks0 = (ArrayList<Book>) bookLibrary.listBooksWithCondition("ZeroBooks");
        ArrayList<Book> theListOfBooks15 = (ArrayList<Book>) bookLibrary.listBooksWithCondition("Any title");
        ArrayList<Book> theListOfBooks40 = (ArrayList<Book>) bookLibrary.listBooksWithCondition("FortyBooks");
        // Then

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        ArrayList<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf10Books);

        // When
        ArrayList<Book> theListOfBooks10 = (ArrayList<Book>) bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testListBooksInHandsOf0() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        ArrayList<Book> resultListOfBooks = new ArrayList<Book>();
        LibraryUser user = new LibraryUser("John", "Kowalski", "7907032213");
        when(libraryDatabaseMock.listBooksInHandsOf(user))
                .thenReturn(resultListOfBooks);

        //When
        List<Book> userBooks = bookLibrary.listBooksInHandsOf(user);

        //Then
        assertEquals(0, userBooks.size());
    }

    @Test
    public void testListBooksInHandsOf1() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        ArrayList<Book> resultListOfBooks = new ArrayList<Book>();
        LibraryUser user = new LibraryUser("John", "Kowalski", "7907032213");
        Book b1 = new Book("Thinking in C++", "Bruce Eckel", 2002);
        resultListOfBooks.add(b1);
        when(libraryDatabaseMock.listBooksInHandsOf(user))
                .thenReturn(resultListOfBooks);

        //When
        List<Book> userBooks = bookLibrary.listBooksInHandsOf(user);

        //Then
        assertEquals(1, userBooks.size());
    }

    @Test
    public void testListBooksInHandsOf5() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        ArrayList<Book> resultListOfBooks = new ArrayList<Book>();
        LibraryUser user = new LibraryUser("John", "Kowalski", "7907032213");

        Book b1 = new Book("Thinking in C++", "Bruce Eckel", 2002);
        Book b2 = new Book("Zbrodnia i kara", "Fiodor Dostojewski", 1866);
        Book b3 = new Book("Folwark zwierzęcy", "George Orwell", 1945);
        Book b4 = new Book("Wichrowe wzgórza", " Emily Jane Brontë", 1847);
        Book b5 = new Book("Jądro ciemności", "Joseph Condrad", 1902);

        resultListOfBooks.add(b1);
        resultListOfBooks.add(b2);
        resultListOfBooks.add(b3);
        resultListOfBooks.add(b4);
        resultListOfBooks.add(b5);

        when(libraryDatabaseMock.listBooksInHandsOf(user))
                .thenReturn(resultListOfBooks);

        //When
        List<Book> userBooks = bookLibrary.listBooksInHandsOf(user);

        //Then
        assertEquals(5, userBooks.size());


    }
}
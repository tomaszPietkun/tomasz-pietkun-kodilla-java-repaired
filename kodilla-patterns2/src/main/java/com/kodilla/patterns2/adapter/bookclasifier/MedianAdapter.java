package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;

import java.util.*;
import java.util.stream.Collectors;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        List<Book> books = new ArrayList<>();
        books.addAll(bookSet);
        List<Integer> yearsOfPublicationList = books.stream()
                .map(o -> o.getPublicationYear())
                .collect(Collectors.toList());

        Collections.sort(yearsOfPublicationList);
        int median;

        if(yearsOfPublicationList.size() % 2 != 0) {
            median = yearsOfPublicationList.get(yearsOfPublicationList.size()) / 2;
        } else {
            median = (yearsOfPublicationList.get(yearsOfPublicationList.size()/2) + yearsOfPublicationList.get(yearsOfPublicationList.size()/2-1))/2;
        }
        return median;
    }
}

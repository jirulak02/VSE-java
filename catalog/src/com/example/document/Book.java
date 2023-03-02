package com.example.document;

import com.example.catalog.Searchable;

public class Book implements Searchable {
    private String name;
    private String ISBN;
    private String publisher;
    private String year;
    private int numberOfPages;

    @Override
    public String getDisplayName() {
        return name;
    }

    @Override
    public String prepareSearchableString() {
        return name + ISBN + publisher + year;
    }
    public Book(String name, String ISBN, String publisher, String year, int numberOfPages) {
        this.name = name;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.year = year;
        this.numberOfPages = numberOfPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}

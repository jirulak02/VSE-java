package com.example.document;

import com.example.catalog.Searchable;

public class Magazine implements Searchable {
    private String name;
    private String ISSN;
    private String publisher;
    private String year;
    private int numberOfPages;

    public Magazine(String name, String ISSN, String publisher, String year, int numberOfPages) {
        this.name = name;
        this.ISSN = ISSN;
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

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
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

    @Override
    public String getDisplayName() {
        return name;
    }

    @Override
    public String prepareSearchableString() {
        return name + ISSN + publisher + year;
    }
}

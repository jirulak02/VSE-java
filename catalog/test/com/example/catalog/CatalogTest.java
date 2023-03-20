package com.example.catalog;

import com.example.document.Document;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatalogTest {
    Catalog catalog;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        catalog = new Catalog();
        Searchable document1 = new Document("FA-234", "Dopis 1", "Ahoj, jak se mas?");
        Searchable document2 = new Document("FA-878", "Dopis 2", "Ahoj, jak se mate?");

        catalog.addStoredItem(document1);
        catalog.addStoredItem(document2);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void find1() {
        String query = "mas";
        String result = catalog.find(query);
        assertNotNull(result);
    }

    @org.junit.jupiter.api.Test
    void find2() {
        String query = "mas dsvsdbsdbsbsdbs";
        String result = catalog.find(query);
        assertNotNull(result);
    }
}
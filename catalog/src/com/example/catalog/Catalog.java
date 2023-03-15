package com.example.catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Searchable> storedItems = new ArrayList<>();

    public void addStoredItem (Searchable storedItem) {
        this.storedItems.add(storedItem);
    }

    public String printAll() {
        String all = "";

        for (Searchable storedItem: this.storedItems) {
            all += " - " + storedItem.getDisplayName() + "\n";
        }

        return all;
    }

    public String find(String query) {
        String result = "";

        for (Searchable storedItem: this.storedItems) {
            if (storedItem.prepareSearchableString().contains(query)) {
                result += " - " + storedItem.getDisplayName() + "\n";
            }
        }

        if (result.isEmpty()) {
            result = "Žádný záznam nevyhovuje...";
        }

        return result;
    }
}

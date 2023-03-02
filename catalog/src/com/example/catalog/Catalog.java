package com.example.catalog;

public class Catalog {
    private Searchable storedItem2;
    private Searchable storedItem1;
    private Searchable storedItem3;
    private Searchable storedItem4;
    private Searchable storedItem5;

    public Searchable getStoredItem2() {
        return storedItem2;
    }

    public void setStoredItem2(Searchable storedItem2) {
        this.storedItem2 = storedItem2;
    }

    public Searchable getStoredItem1() {
        return storedItem1;
    }

    public void setStoredItem1(Searchable storedItem1) {
        this.storedItem1 = storedItem1;
    }

    public Searchable getStoredItem3() {
        return storedItem3;
    }

    public void setStoredItem3(Searchable storedItem3) {
        this.storedItem3 = storedItem3;
    }

    public Searchable getStoredItem4() {
        return storedItem4;
    }

    public void setStoredItem4(Searchable storedItem4) {
        this.storedItem4 = storedItem4;
    }

    public Searchable getStoredItem5() {
        return storedItem5;
    }

    public void setStoredItem5(Searchable storedItem5) {
        this.storedItem5 = storedItem5;
    }

    public String printAll() {
        String all = "";

        all += " - " + storedItem1.getDisplayName() + "\n";
        all += " - " + storedItem2.getDisplayName() + "\n";
        all += " - " + storedItem3.getDisplayName() + "\n";
        all += " - " + storedItem4.getDisplayName() + "\n";
        all += " - " + storedItem5.getDisplayName() + "\n";

        return all;
    }

    public String find(String query) {
        String result = "";

        if (storedItem1.prepareSearchableString().contains(query)) {
            result += " - " + storedItem1.getDisplayName() + "\n";
        }

        if (storedItem2.prepareSearchableString().contains(query)) {
            result += " - " + storedItem2.getDisplayName() + "\n";
        }

        if (storedItem3.prepareSearchableString().contains(query)) {
            result += " - " + storedItem3.getDisplayName() + "\n";
        }

        if (storedItem4.prepareSearchableString().contains(query)) {
            result += " - " + storedItem4.getDisplayName() + "\n";
        }

        if (storedItem5.prepareSearchableString().contains(query)) {
            result += " - " + storedItem5.getDisplayName() + "\n";
        }

        if (result.isEmpty()) {
            result = "Žádný záznam nevyhovuje...";
        }

        return result;
    }
}

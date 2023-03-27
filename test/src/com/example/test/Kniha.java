package com.example.test;

public class Kniha implements Produkt {
    private String nazev;
    private float cena;
    private boolean dostupnost;
    private String ISBN;

    public Kniha(float cena, String nazev, boolean dostupnost, String ISBN) {
        this.nazev = nazev;
        this.cena = cena;
        this.dostupnost = dostupnost;
        this.ISBN = ISBN;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public void setDostupnost(boolean dostupnost) {
        this.dostupnost = dostupnost;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public float getCena() {
        return cena;
    }

    @Override
    public String getNazev() {
        return nazev;
    }

    @Override
    public boolean isDostupny() {
        return dostupnost;
    }
}

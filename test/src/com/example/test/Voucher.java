package com.example.test;

public class Voucher implements Produkt {
    private String nazev;
    private float cena;
    private boolean dostupnost;
    private int platnostVTydnech;

    public Voucher(float cena, String nazev, boolean dostupnost, int platnostVTydnech) {
        this.nazev = nazev;
        this.cena = cena;
        this.dostupnost = dostupnost;
        this.platnostVTydnech = platnostVTydnech;
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

    public int getPlatnostVTydnech() {
        return platnostVTydnech;
    }

    public void setPlatnostVTydnech(int platnostVTydnech) {
        this.platnostVTydnech = platnostVTydnech;
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

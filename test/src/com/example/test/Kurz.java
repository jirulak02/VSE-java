package com.example.test;

public class Kurz implements Produkt {
    private String nazev;
    private float cena;
    private boolean dostupnost;
    private String jmenoLektora;

    public Kurz(float cena, String nazev, boolean dostupnost, String jmenoLektora) {
        this.nazev = nazev;
        this.cena = cena;
        this.dostupnost = dostupnost;
        this.jmenoLektora = jmenoLektora;
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

    public String getJmenoLektora() {
        return jmenoLektora;
    }

    public void setJmenoLektora(String jmenoLektora) {
        this.jmenoLektora = jmenoLektora;
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

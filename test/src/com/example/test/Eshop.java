package com.example.test;

import java.util.ArrayList;
import java.util.List;

public class Eshop {
    private String nazev;
    private String domena;
    private List<Produkt> produkty = new ArrayList<>();
    private List<Zakaznik> zakaznici = new ArrayList<>();

    public Eshop(String nazev, String domena) {
        this.nazev = nazev;
        this.domena = domena;
    }

    public String getNazev() {
        return nazev;
    };

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getDomena() {
        return domena;
    }

    public void setDomena(String domena) {
        this.domena = domena;
    }

    public void pridejProdukt(Produkt produkt) {
        produkty.add(produkt);
    }

    public void odeberProdukt(Produkt produkt) {
        produkty.remove(produkt);
    }

    public void pridejZakaznika(Zakaznik zakaznik) {
        zakaznici.add(zakaznik);
    }

    public void odeberZakaznika(Zakaznik zakaznik) {
        zakaznici.remove(zakaznik);
    }

    public float getCelkoveTrzby() {
        float trzby = 0;

        for (Zakaznik zakaznik: zakaznici) {
            for (Objednavka objednavka: zakaznik.getObjednavky()) {
                trzby += objednavka.getCelkovaCena();
            }
        }

        return trzby;
    }
}

package com.example.test;

import java.util.ArrayList;
import java.util.List;

public class Zakaznik {
    private Eshop eshop;
    private String jmeno;
    private String prijmeni;
    private String adresa;
    private List<Objednavka> objednavky = new ArrayList<>();

    public Zakaznik(Eshop eshop, String jmeno, String prijmeni, String adresa) {
        this.eshop = eshop;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.adresa = adresa;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public List<Objednavka> getObjednavky() {
        return objednavky;
    }

    public Objednavka objednejProduktyAUhrad(List<Produkt> produkty) {
        Objednavka novaObjednavka = new Objednavka(this);

        for (Produkt produkt: produkty) {
            novaObjednavka.pridejNakoupenyProdukt(produkt);
        }

        novaObjednavka.uhradObjednavku();
        objednavky.add(novaObjednavka);

        return novaObjednavka;
    }
}

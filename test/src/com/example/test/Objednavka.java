package com.example.test;

import java.util.ArrayList;
import java.util.List;

public class Objednavka {
    private Zakaznik zakaznik;
    private boolean uhrazeno = false;
    private List<Produkt> produkty = new ArrayList<>();

    public Objednavka(Zakaznik zakaznik) {
        this.zakaznik = zakaznik;
    }

    public Zakaznik getZakaznik() {
        return zakaznik;
    }

    public boolean isUhrazeno() {
        if (this.uhrazeno == true) {
            return true;
        } else {
            return false;
        }
    }

    public void uhradObjednavku() {
        this.uhrazeno = true;
    }

    public void pridejNakoupenyProdukt(Produkt produkt) {
        if (produkt.isDostupny() == true) {
            produkty.add(produkt);
        }
    }

    public void odeberNakoupenyProdukt(Produkt produkt) {
        produkty.remove(produkt);
    }

    public float getCelkovaCena() {
        float cena = 0;

        for (Produkt produkt: produkty) {
            cena += produkt.getCena();
        }

        return cena;
    }
}

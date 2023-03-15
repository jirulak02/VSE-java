package com.example.hotel;

import java.util.HashSet;
import java.util.Set;

public class StandardniBouda implements Bouda {
    private int vyska = 1;
    private int sirka = 1;
    private int hloubka = 2;
    private int kapacita = 1;
    private Set<Pes> ubytovani = new HashSet<>();
    private String nazev;

    public StandardniBouda(String nazevBoudy) {
        this.nazev = nazevBoudy;
    }

    @Override
    public int getKapacita() {
        return kapacita;
    }

    @Override
    public void setKapacita(int kapacita) {
        this.kapacita = kapacita;
    }

    @Override
    public boolean isObsazeno() {
        return this.kapacita <= this.ubytovani.size();
    }

    @Override
    public boolean pridejPsa(Pes pes) {
        if (isObsazeno()) {
            return false;
        }

        if (this.ubytovavaPsa(pes)) {
            return false;
        }

        if (pes.getDelka() > this.hloubka && pes.getDelka() > this.sirka) {
            return false;
        }

        this.ubytovani.add(pes);
        pes.setBouda(this);

        return true;
    }

    @Override
    public boolean odeberPsa(Pes pes) {
        this.ubytovani.remove(pes);

        return true;
    }

    @Override
    public boolean ubytovavaPsa(Pes pes) {
        return this.ubytovani.contains(pes);
    }

    @Override
    public Set<Pes> getUbytovaniPsi() {
        return this.ubytovani;
    }

    @Override
    public int getObjem() {
        return vyska * sirka * hloubka;
    }

    @Override
    public String getDisplayName() {
        return nazev;
    }

    @Override
    public String prepareSearchableString() {
        return nazev + ubytovani;
    }
}

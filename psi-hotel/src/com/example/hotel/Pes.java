package com.example.hotel;

public class Pes implements Searchable {
    private static final String VYCHOZI_BARVA_PSA = "- barva je tajná -";
    private String jmeno;
    private String barva;
    private int delka;
    private Bouda bouda;

    public Pes(String jmeno, int delka) {
        this(jmeno, delka, VYCHOZI_BARVA_PSA);
    }
    public Pes(String jmeno, int delka, String barva) {
        this.jmeno = jmeno;
        this.delka = delka;
        this.barva = barva;

        this.bouda = null;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getBarva() {
        return barva;
    }

    public void setBarva(String barva) {
        this.barva = barva;
    }

    public int getDelka() {
        return delka;
    }

    public void setDelka(int delka) {
        this.delka = delka;
    }

    public Bouda getBouda() {
        return bouda;
    }

    public void setBouda(Bouda bouda) {
        this.bouda = bouda;
    }

    public boolean isUbytovany() {
        return null != bouda;
    }

    public int getObjemBoudy() {
        return this.bouda.getObjem();
    }

    public String zastekej() {
        System.out.println(this);

        return toString();
    }

    @Override
    public String toString() {
        return "Já jsem pes " + jmeno + " Haf haf!";
    }

    @Override
    public String getDisplayName() {
        return jmeno;
    }

    @Override
    public String prepareSearchableString() {
        return toString() + barva + bouda;
    }
}

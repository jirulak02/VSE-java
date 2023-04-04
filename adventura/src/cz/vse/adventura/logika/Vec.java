package cz.vse.adventura.logika;

public class Vec {
    private String nazev;
    private boolean prenositelna;
    private float objem;


    public Vec(String nazev, boolean prenositelna, float objem) {
        this.nazev = nazev;
        this.prenositelna = prenositelna;
        this.objem = objem;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public boolean isPrenositelna() {
        return prenositelna;
    }

    public void setPrenositelna(boolean prenositelna) {
        this.prenositelna = prenositelna;
    }

    public float getObjem() {
        return objem;
    }

    public void setObjem(float objem) {
        this.objem = objem;
    }
}

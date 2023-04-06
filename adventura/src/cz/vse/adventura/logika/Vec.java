package cz.vse.adventura.logika;

/**
 *  Třída Vec - popisuje jednotlivé věci.
 *
 *  "Věc" reprezentuje jednotlivý objekt pohozený po místnostech.
 *  Věc má název, objem a může či nemusí být přenositelná.
 *
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Jiří Šimeček
 *@version    Duben 2023
 */
public class Vec {
    private String nazev;
    private boolean prenositelna;
    private float objem;

    /**
     *  Konstruktor věci.
     *
     *@param    nazev název věci, jednoznačný identifikátor bez mezer
     *@param    prenositelna určuje zda se věc dá zvednout (dát do batohu)
     *@param    objem velikost věci
     */
    public Vec(String nazev, boolean prenositelna, float objem) {
        this.nazev = nazev;
        this.prenositelna = prenositelna;
        this.objem = objem;
    }

    /**
     *  Vrací název věci (byl zadán při vytváření věci jako parametr konstruktoru).
     *
     *@return   název věci
     */
    public String getNazev() {
        return nazev;
    }

    /**
     *  Zjištuje zda se věc dá přenášet
     *
     *@return   boolean přenositelnosti věci
     */
    public boolean isPrenositelna() {
        return prenositelna;
    }

    /**
     *  Zjištuje velikost (objem) věci
     *
     *@return   číslo, jak je věc veliká
     */
    public float getObjem() {
        return objem;
    }
}

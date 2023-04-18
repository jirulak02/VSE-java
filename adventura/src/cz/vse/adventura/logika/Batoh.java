package cz.vse.adventura.logika;

import java.util.HashMap;
import java.util.Map;

/**
 *  Třída Batoh - popisuje batoh, který slouží k přenosu věcí.
 *
 *  "Batoh" reprezentuje úložný prostor, který si uživatel nosí sebou.
 *  Batoh má objem, volné objem a přidané věci.
 *
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Jiří Šimeček
 *@version    Duben 2023
 */
public class Batoh {
    private int objem;
    private int zbyleMisto;
    private Map<String, Vec> veci = new HashMap<>();

    /**
     *  Konstruktor batohu.
     *
     *@param    objem číslo určující maximální objem batohu
     */
    public Batoh(int objem) {
        this.objem = objem;
        this.zbyleMisto = objem;
    }

    /**
     *  Vrací odkaz na věc podle názvu
     *
     *@param    nazev název věci kterou hledáme
     *@return   odkaz na celý objekt věc
     */
    public Vec getVec(String nazev) {
        return veci.get(nazev);
    }

    /**
     *  Zkontroluje pokud vec lze do batohu přidat a přidá ji.
     *
     *@param    vec věc, kterou chceme přidat do batohu
     */
    public void addVec(Vec vec) {
        if (vec.getNazev().equals("thorovo_kladivo")) {
            throw new RuntimeException("Bohužel nejste vyvolení, takže Thorovo kladivo se vám nepodařilo zvednout.");
        }

        if (!vec.isPrenositelna()) {
            throw new RuntimeException("Věc je nepřenositelná.");
        }

        int objemVeci = vec.getObjem();

        if (objemVeci > zbyleMisto) {
            throw new RuntimeException("Věc se do batohu nevejde.");
        }

        veci.put(vec.getNazev(), vec);
        setZbyleMisto(zbyleMisto - objemVeci);
    }

    /**
     *  Odstraní věc z batohu podle názvu.
     *
     *@param    vec věc, kterou chceme odstanit z batohu
     */
    public void removeVec(Vec vec) {
        veci.remove(vec.getNazev());

        int objemVeci = vec.getObjem();

        setZbyleMisto(zbyleMisto + objemVeci);
    }

    /**
     *  Vyhledá zda je věc již v batohu.
     *
     *@param    nazev název, podle kterého zjistíme, zda je věc již batohu obsažena
     *@return   boolean podle toho, jestli funkce našla danou věc
     */
    public boolean hasVec(String nazev) {
        return veci.containsKey(nazev);
    }

    /**
     *  Přepíše zbyleMisto na novou hodnotu.
     *
     *@param    zbyleMisto nová hodnata, kterou chceme proměnné přidělit
     */
    public void setZbyleMisto(int zbyleMisto) {
        this.zbyleMisto = zbyleMisto;
    }

    /**
     *  Vrací výpis věcí v batohu.
     *
     *@return   String popis obsahu batohu
     */
    public String popisBatohu() {
        String vracenyText = "Obsah batohu:";

        for (String nazevVeci : veci.keySet()) {
            vracenyText += " " + nazevVeci;
        }

        return vracenyText + "\n" +
                "Volno v batohu: " + zbyleMisto;
    }
}

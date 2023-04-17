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
    private float objem;
    private float zbyleMisto;
    private Map<String, Vec> veci = new HashMap<>();

    /**
     *  Konstruktor batohu.
     *
     *@param    objem číslo určující maximální objem batohu
     */
    public Batoh(float objem) {
        this.objem = objem;
        this.zbyleMisto = objem;
    }

    /**
     *  Zkontroluje pokud vec lze do batohu přidat a přidá ji.
     *
     *@param    vec vec, kterou chceme přidat do batohu
     */
    public void addVec(Vec vec) {
        if (!vec.isPrenositelna()) {
            System.out.println("Věc nelze vložit do batohu - je nepřenositelná.");
            return;
        }

        float objemVeci = vec.getObjem();

        if (objemVeci > zbyleMisto) {
            System.out.println("Věc nelze vložit do batohu - nevejde se.");
            return;
        }

        veci.put(vec.getNazev(), vec);
        setZbyleMisto(zbyleMisto - objemVeci);
    }

    /**
     *  Odstraní věc z batohu podle názvu.
     *
     *@param    nazev název, podle kterého najdeme věc, kterou odstanit z batohu
     */
    public void removeVec(String nazev) {
        veci.remove(nazev);
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
    public void setZbyleMisto(float zbyleMisto) {
        this.zbyleMisto = zbyleMisto;
    }
}

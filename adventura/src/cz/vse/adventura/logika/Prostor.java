package cz.vse.adventura.logika;

import java.util.*;

/**
 *  Trida Prostor - popisuje jednotlivé prostory (místnosti) hry.
 *
 *  "Prostor" reprezentuje jedno místo (místnost, prostor, ..) ve scénáři hry.
 *  Prostor může mít sousední prostory připojené přes východy. Pro každý východ
 *  si prostor ukládá odkaz na sousedící prostor.
 *
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author       Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Jiří Šimeček
 *@version      Duben 2023
 */
public class Prostor {
    private String nazev;
    private String popis;
    private Set<Prostor> vychody = new HashSet<>();
    private Map<String, Vec> veci = new HashMap<>();
    private boolean smrtelny = false;
    private boolean odemceno = false;

    /**
     *  Konstruktor prostoru.
     *
     *@param    nazev název prostoru, jednoznačný identifikátor bez mezer
     *@param    popis krátký popis prostoru
     */
    public Prostor(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
    }

    /**
     *  Konstruktor třídy Prostor.
     *
     *@param    nazev název prostoru, jednoznačný identifikátor bez mezer
     *@param    popis krátký popis prostoru
     *@param    smrtelny určení, zda je místnost pro uživatele smrtelná
     */
    public Prostor(String nazev, String popis, boolean smrtelny) {
        this.nazev = nazev;
        this.popis = popis;
        this.smrtelny = smrtelny;
    }

    /**
     *  Definuje východ z prostoru (sousední/vedlejsi prostor). Vzhledem k tomu,
     *  že je použit Set pro uložení východů, může být sousední prostor uveden
     *  pouze jednou (tj. nelze mít dvoje dveře do stejné sousední místnosti).
     *  Druhé zadání stejného prostoru tiše přepíše předchozí zadání (neobjeví se
     *  žádné chybové hlášení). Lze zadat též cestu ze do sebe sama.
     *
     *@param    vedlejsi prostor, který sousedi s aktualnim prostorem
     */
    public void setVychod(Prostor vedlejsi) {
        vychody.add(vedlejsi);
    }

    /**
     *  Přidává věc do mapy věcí.
     *
     *@param    vec věc, kterou chceme přidat
     */
    public void addVec(Vec vec) {
        veci.put(vec.getNazev(), vec);
    }

    /**
     *  Odstraní věc z mapy věcí prostoru.
     *
     *@param    nazev název věci k odstranění z prostoru
     */
    public void removeVec(String nazev) {
        veci.remove(nazev);
    }

    /**
     *  Zjišťuje zda se věc vyskytuje v tomto prostoru.
     *
     *@param    nazev název věci kterou hledáme
     */
    public boolean hasVec(String nazev) {
        return veci.containsKey(nazev);
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
     *  Metoda equals pro porovnání dvou prostorů. Překrývá se metoda equals ze
     *  třídy Object. Dva prostory jsou shodné, pokud mají stejný název. Tato
     *  metoda je důležitá z hlediska správného fungování seznamu východů (Set).
     *
     *  Bližší popis metody equals je u třídy Object.
     *
     *@param    o object, který se má porovnávat s aktuálním
     *@return   hodnotu true, pokud má zadaný prostor stejný název, jinak false
     */
    @Override
    public boolean equals(Object o) {
        // porovnáváme zda se nejedná o dva odkazy na stejnou instanci
        if (this == o) {
            return true;
        }

        // porovnáváme jakého typu je parametr 
        if (!(o instanceof Prostor)) {
            return false;    // pokud parametr není typu Prostor, vrátíme false
        }

        // přetypujeme parametr na typ Prostor 
        Prostor druhy = (Prostor) o;

        // metoda equals třídy java.util.Objects porovná hodnoty obou názvů.
        // Vrátí true pro stejné názvy a i v případě, že jsou oba názvy null,
        // jinak vrátí false.
        return (java.util.Objects.equals(this.nazev, druhy.nazev));
    }

    /**
     *  Metoda hashCode vrací číselný identifikátor instance, který se používá
     *  pro optimalizaci ukládání v dynamických datových strukturách.
     *  Při překrytí metody equals je potřeba překrýt i metodu hashCode.
     *  Podrobný popis pravidel pro vytváření metody hashCode je u metody
     *  hashCode ve třídě Object.
     *
     *@return   číselný identifikátor instance
     */
    @Override
    public int hashCode() {
        int vysledek = 3;
        int hashNazvu = java.util.Objects.hashCode(this.nazev);
        vysledek = 37 * vysledek + hashNazvu;
        return vysledek;
    }

    /**
     *  Vrací název prostoru (byl zadán při vytváření prostoru jako parametr
     *  konstruktoru).
     *
     *@return   název prostoru
     */
    public String getNazev() {
        return nazev;       
    }

    /**
     *  Vrací popis prostoru včetně aktuálních východů a věcí v prostoru.
     *
     *@return   dlouhý popis prostoru
     */
    public String dlouhyPopis() {
        return "Jste v místnosti " + popis + ".\n"
                + popisVychodu() + "\n"
                + popisVeci();
    }

    /**
     *  Vrací textový řetězec, který popisuje sousední východy.
     *
     *@return   text k vypsání, popis východů (názvů sousedních prostorů)
     */
    public String popisVychodu() {
        String vracenyText = "východy:";

        for (Prostor sousedni : vychody) {
            vracenyText += " " + sousedni.getNazev();
        }

        return vracenyText;
    }

    /**
     *  Vrací text, který popisuje věci nacházející se v aktuálním prostoru.
     *
     *@return   text k vypsání, popis věcí v prostoru
     */
    public String popisVeci() {
        String vracenyText = "věci:";

        for (String nazevVeci : veci.keySet()) {
            vracenyText += " " + nazevVeci;
        }

        return vracenyText;
    }

    /**
     *  Vrací prostor, který sousedí s aktuálním prostorem a jehož název je zadán
     *  jako parametr. Pokud prostor s udaným jménem nesousedí s aktuálním
     *  prostorem, vrací se hodnota null.
     *
     *@param    nazevSouseda jméno sousedního prostoru (východu)
     *@return   prostor, který se nachází za příslušným východem, nebo hodnota
     *                   null, pokud prostor zadaného jména není sousedem
     */
    public Prostor vratSousedniProstor(String nazevSouseda) {
        List<Prostor> hledaneProstory =
            vychody.stream()
                   .filter(sousedni -> sousedni.getNazev().equals(nazevSouseda))
                   .collect(java.util.stream.Collectors.toList());

        if (hledaneProstory.isEmpty()) {
            return null;
        } else {
            return hledaneProstory.get(0);
        }
    }

    /**
     *  Vyhledá sousední místnosti, které jsou smrtelné pro hráče.
     *
     *@return   Set sousedních místností, které by uživatele zabili
     */
    public Set<Prostor> vratSmrtelneProstory() {
        Set<Prostor> hledaneProstory = new HashSet<>();

        for (Prostor vychod : vychody) {
            if (vychod.isSmrtelny()) {
                hledaneProstory.add(vychod);
            }
        }

        return hledaneProstory;
    }

    /**
     *  Zjištuje zda tento prostor je smrtelny.
     *
     *@return   boolean zda je prostor smrtelny
     */
    public boolean isSmrtelny() {
        return smrtelny;
    }

    /**
     *  Přepisuje proměnnou smrtelny na novou hodnotu.
     *
     *@param    smrtelny nová hodnota k použití
     */
    public void setSmrtelny(boolean smrtelny) {
        this.smrtelny = smrtelny;
    }

    /**
     *  Zjištuje zda je brána odemčena.
     *
     *@return   boolean zda je brána odemčena
     */
    public boolean isOdemceno() {
        return odemceno;
    }

    /**
     *  Přepisuje proměnnou odemceno na novou hodnotu.
     *
     *@param    odemceno nová hodnota k použití
     */
    public void setOdemceno(boolean odemceno) {
        this.odemceno = odemceno;
    }
}

package cz.vse.adventura.logika;

import java.util.Set;

/**
 *  Třída PrikazJsemMimino implementuje pro hru příkaz jsem_mimino.
 *
 *  Příkaz umožňující odhalit sousední místnosti, které jsou pro hráče smrtelné.
 *
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Jiří Šimeček
 *@version    Duben 2023
 */
public class PrikazJsemMimino implements IPrikaz {
    private static final String NAZEV = "jsem_mimino";
    private HerniPlan plan;

    /**
     *  Konstruktor příkazu jsem_mimo.
     *
     *@param    plan herní plán s místnostmi pro určení těch smrtelných
     */
    public PrikazJsemMimino(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *  Provádí příkaz "jsem_mimino". Objevuje sousední místnosti,
     *  které hráče při vstupu zabijou.
     *
     *@param    parametry parametr obsahuje jméno příkazu
     *@return   zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {
        // chceme délku parametru 0, název příkazu byl odstraněn
        if (parametry.length > 0) {
            return "Error: Nezajímá mě jaké jste mimino, použijte jen jedno slovo.";
        }

        Set<Prostor> hledaneProstory = plan.getAktualniProstor().vratSmrtelneProstory();
        String textKVypsani = "Smrtelné východy:";

        textKVypsani += " \u001B[31m";

        for (Prostor vychod : hledaneProstory) {
            textKVypsani += vychod.getNazev();
        }

        textKVypsani += "\u001B[0m";

        return textKVypsani;
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání).
     *
     *@return   nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}

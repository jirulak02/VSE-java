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

    public PrikazJsemMimino(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        Set<Prostor> hledaneProstory = plan.getAktualniProstor().vratSmrtelneProstory();
        String textKVypsani = "Smrtelné východy:";

        for (Prostor vychod : hledaneProstory) {
            textKVypsani += " \u001B[31m" + vychod.getNazev();
        }

        textKVypsani += "\u001B[0m";

        return textKVypsani;
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}

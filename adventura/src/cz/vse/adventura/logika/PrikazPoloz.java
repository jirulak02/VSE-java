package cz.vse.adventura.logika;

/**
 *  Třída PrikazPoloz implementuje pro hru příkaz polož.
 *
 *  Příkaz vyndavá věc z batohu a pokládá ji na zem do prostoru.
 *
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Jiří Šimeček
 *@version    Duben 2023
 */
public class PrikazPoloz implements IPrikaz{
    private static final String NAZEV = "polož";
    private HerniPlan plan;

    /**
     *  Konstruktor příkazu polož.
     *
     *@param    plan herní plán, ve kterém se bude ve hře "chodit"
     */
    public PrikazPoloz(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *  Vyndavá věc z batohu a pokládá ji na zem do prostoru.
     *
     *@param    parametry věc kterou chceme položit
     *@return   zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {
        // chceme délku parametru 1, název příkazu byl odstraněn
        if (parametry.length == 0) {
            return "Co mám položit? Musíte zadat jméno věci.";
        } else if (parametry.length > 1) {
            return "Nelze položit více věcí zároveň, zadejte pouze jednu.";
        }

        String nazevVeci = parametry[0];

        try {
            plan.polozVec(nazevVeci);
        } catch (IllegalStateException e) {
            return e.getMessage();
        } catch(NullPointerException e) {
            return e.getMessage();
        }

        return "Věc '" + nazevVeci + "' byla vyndána z batohu\n" + plan.vypisBatoh();
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

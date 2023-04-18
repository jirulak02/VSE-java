package cz.vse.adventura.logika;

/**
 *  Třída PrikazSeber implementuje pro hru příkaz seber.
 *
 *  Příkaz sbírá věc z prostoru a dává ji do batohu.
 *
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Jiří Šimeček
 *@version    Duben 2023
 */
public class PrikazSeber implements IPrikaz{
    private static final String NAZEV = "seber";
    private HerniPlan plan;

    /**
     *  Konstruktor příkazu seber.
     *
     *@param    plan herní plán, ve kterém se bude ve hře "chodit"
     */
    public PrikazSeber(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *  Sbírá věc z prostoru a dává ji do batohu.
     *
     *@param    parametry věc kterou chceme sebrat
     *@return   zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {
        // chceme délku parametru 1, název příkazu byl odstraněn
        if (parametry.length == 0) {
            return "Error: Co mám sebrat? Musíte zadat jméno věci.";
        } else if (parametry.length > 1) {
            return "Error: Nelze sebrat více věcí zároveň, zadejte pouze jednu.";
        }

        String nazevVeci = parametry[0];

        if (nazevVeci.equals("bota")) {
            return plan.teleportovat();
        }

        try {
            plan.seberVec(nazevVeci);
        } catch(NullPointerException e) {
            return "Error: Věc '" + nazevVeci + "' v této místnosti není.";
        } catch (RuntimeException e) {
            return "Error: " + e.getMessage();
        }

        return "Věc '" + nazevVeci + "' je nyní v batohu\n" + plan.vypisBatoh();
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

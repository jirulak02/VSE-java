package cz.vse.adventura.logika;

/**
 *  Třída PrikazVypis implementuje pro hru příkaz vypiš.
 *
 *  Příkaz vypisuje věci v batohu nebo východy a věci z prostoru.
 *
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Jiří Šimeček
 *@version    Duben 2023
 */
public class PrikazVypis implements IPrikaz {
    private static final String NAZEV = "vypiš";
    private HerniPlan plan;

    /**
     *  Konstruktor příkazu vypiš.
     *
     *@param    plan herní plán, ve kterém se bude ve hře "chodit"
     */
    public PrikazVypis(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *  Sbírá věc z prostoru a dává ji do batohu.
     *
     *@param    parametry určení zda chceme vypsat batoh nebo prostor
     *@return   zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {
        // chceme délku parametru 1, název příkazu byl odstraněn
        if (parametry.length == 0) {
            return "Error: Co mám vypsat? Vyberte buď 'batoh' nebo 'prostor'.";
        } else if (parametry.length > 1) {
            return "Error: Nelze vypsat vše zároveň, zadejte pouze jedno.";
        }

        String parametr = parametry[0];

        if (parametr.equals("batoh")) {
            return plan.vypisBatoh();
        } else if (parametr.equals("prostor")) {
            Prostor prostor = plan.getAktualniProstor();
            return prostor.popisVychodu() + "\n" + prostor.popisVeci();
        }

        return "Error: '" + parametr + "'" + " nelze vypsat.";
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

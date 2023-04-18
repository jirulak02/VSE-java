package cz.vse.adventura.logika;

/**
 *  Třída PrikazOdemknout implementuje pro hru příkaz odemknout.
 *
 *  Příkaz odemikající bránu z labyrintu.
 *
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Jiří Šimeček
 *@version    Duben 2023
 */
public class PrikazOdemknout implements IPrikaz {
    private static final String NAZEV = "odemknout";
    private HerniPlan plan;
    private Batoh batoh;

    /**
     *  Konstruktor příkazu odemknout.
     *
     *@param    plan herní plán, ve kterém se bude ve hře "chodit"
     *@param    batoh na zkontrolování přítomnosti klíče
     */
    public PrikazOdemknout(HerniPlan plan, Batoh batoh) {
        this.plan = plan;
        this.batoh = batoh;
    }

    /**
     *  Odemiká bránu z labyrintu
     *
     *@param    parametry nejlépe žádné nechceme
     *@return   zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {
        // chceme délku parametru 0, název příkazu byl odstraněn
        if (parametry.length > 0) {
            return "Nemusíte zadávat co chcete odemknout, stačí příkaz 'odemknout'";
        }

        if (!batoh.hasVec("klíč")) {
            return "K odemčení potřebujete klíč.";
        }

        Prostor mistnost = plan.getAktualniProstor();

        if (mistnost.getNazev().equals("příšerný_tunel")) {
            mistnost.setOdemceno(true);
            return "Brána labyrintu je odemknuta, můžete uniknout.";
        }

        return "K odemčení brány před ní musíte stát.";
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

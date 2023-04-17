package cz.vse.adventura.logika;

public class PrikazSeber implements IPrikaz{
    private static final String NAZEV = "seber";
    private HerniPlan plan;

    public PrikazSeber(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        // chceme délku parametru 1, název příkazu byl odstraněn
        if (parametry.length == 0) {
            return "Co mám vybrat? Musíte zadat jméno věci.";
        } else if (parametry.length > 1) {
            return "Nelze sebrat více věcí zároveň, zadejte pouze jednu.";
        }

        String nazevVeci = parametry[0];

        try {
            plan.seberVec(nazevVeci);
        } catch (IllegalStateException e) {
            return e.getMessage();
        }

        return "Věc '" + nazevVeci + "' je nyní v batohu\n" + plan.getAktualniProstor();
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}

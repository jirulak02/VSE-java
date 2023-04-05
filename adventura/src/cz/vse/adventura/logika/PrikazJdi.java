package cz.vse.adventura.logika;

/**
 *  Třída PrikazJdi implementuje pro hru příkaz jdi.
 *
 *  Příkaz umožňující pohyb z jedné místnosti do druhé.
 *
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author     Jarmila Pavlickova, Luboš Pavlíček, Jiří Šimeček
 *@version    Duben 2023
 */
class PrikazJdi implements IPrikaz {
    private static final String NAZEV = "jdi";
    private HerniPlan plan;
    private Hra hra;
    private Batoh batoh;
    
    /**
    *  Konstruktor třídy
    *  
    *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
    */
    public PrikazJdi(HerniPlan plan) {
        this.plan = plan;
    }

    public PrikazJdi(HerniPlan plan, Hra hra, Batoh batoh) {
        this.plan = plan;
        this.hra = hra;
        this.batoh = batoh;
    }

    /**
     *  Provádí příkaz "jdi". Zkouší se vyjít do zadaného prostoru. Pokud prostor
     *  existuje, vstoupí se do nového prostoru. Pokud zadaný sousední prostor
     *  (východ) není, vypíše se chybové hlášení.
     *
     *@param parametry - jako  parametr obsahuje jméno prostoru (východu),
     *                         do kterého se má jít.
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Kam mám jít? Musíte zadat jméno východu";
        }

        String smer = parametry[0];

        // zkoušíme přejít do sousedního prostoru
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(smer);

        if (sousedniProstor == null) {
            return "Tam se odsud jít nedá!";
        } else if (sousedniProstor.isSmrtelny() && batoh.hasVec("špunt")) {
            String[] easterEgg = {
                    "Dobrý nápad, černou díru jste zašpuntovali a našli jste můj easter egg.",
                    "        \033[33m________",
                    "     \033[33m_//\033[0m        \033[33m\\\\_\033[0m",
                    "    \033[33m/\033[0m              \033[33m\\\033[0m",
                    "   \033[33m/><><><><><><><><\\\033[0m",
                    "  \033[33m/~~~~~~~~~~~~~~~~~~\\\033[0m",
                    " \033[33m|\033[0m                    \033[33m|\033[0m",
                    " \033[33m|\033[0m    Jiří Šimeček    \033[33m|\033[0m",
                    " \033[33m|\033[0m                    \033[33m|\033[0m",
                    "  \033[33m\\~~~~~~~~~~~~~~~~~~/\033[0m",
                    "   \033[33m\\><><><><><><><></\033[0m",
                    "    \033[33m\\_\033[0m            \033[33m_/\033[0m",
                    "      \033[33m\\\\________//\033[0m"
            };

            for (String line : easterEgg) {
                System.out.println(line);

                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println("Error message: " + e.getMessage());
                }
            }

            plan.setAktualniProstor(sousedniProstor);
            return sousedniProstor.dlouhyPopis();
        } else if (sousedniProstor.isSmrtelny()) {
            hra.setKonecHry(true);
            System.out.println("V místnosti vás vtáhla a zabila černá díra. Hra ukončena!");
            return "Zkuste to znovu. Případně pokud máte dost, tak...";
        } else {
            plan.setAktualniProstor(sousedniProstor);
            return sousedniProstor.dlouhyPopis();
        }
    }
    
    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}

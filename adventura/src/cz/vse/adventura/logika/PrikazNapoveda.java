package cz.vse.adventura.logika;

/**
 *  Třída PrikazNapoveda implementuje pro hru příkaz nápověda.
 *
 *  Příkaz, který hráči vysvětlý co má dělat a jaké může použít příkazy.
 *
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author     Jarmila Pavlickova, Luboš Pavlíček, Jiří Šimeček
 *@version    Duben 2023
 */
class PrikazNapoveda implements IPrikaz {
    private static final String NAZEV = "nápověda";
    private SeznamPrikazu platnePrikazy;

    /**
     *  Konstruktor příkazu nápověda.
     *
     *@param    platnePrikazy seznam příkazů, které je možné ve hře použít,
     *                        aby je nápověda mohla zobrazit uživateli
     */
    public PrikazNapoveda(SeznamPrikazu platnePrikazy) {
        this.platnePrikazy = platnePrikazy;
    }
    
    /**
     *  Vrací základní nápovědu po zadání příkazu "nápověda".
     *  Nyní se vypisuje vcelku primitivní zpráva a seznam dostupných příkazů.
     *
     *@param    parametry obsahuje název příkazu nápověda
     *@return   napoveda ke hre
     */
    @Override
    public String provedPrikaz(String... parametry) {
        // chceme délku parametru 0, název příkazu byl odstraněn
        if (parametry.length > 0) {
            return "Jaká nápověda? Nechápu, proč jste zadali druhé slovo.";
        }

        return "Tvým úkolem je najít klíč, odemknout si bránu a utéct z labyrintu.\n"
        + "\n"
        + "Můžeš zadat tyto příkazy:\n"
        + platnePrikazy.vratNazvyPrikazu()
        + "\n(Příkaz 'jsem_mimino' vám ukáže které místnosti vás při vstupu zabijou.)";
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

package cz.vse.adventura.logika;

/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Jiří Šimeček
 *@version    Duben 2023
 */
public class HerniPlan {
    private Prostor aktualniProstor;
    private Batoh batoh;
    private Prostor teleport;
    
    /**
     *  Konstruktor herního plánu.
     *
     *@param    batoh batoh, do kterého lze přidávat předměty
     */
    public HerniPlan(Batoh batoh) {
        this.batoh = batoh;
        zalozProstoryHry();
    }

    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Vytváří věci a přiřazuje je do prostorů.
     *  Jako výchozí aktuální prostor nastaví temnou síň.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor temnaSin = new Prostor("temná_síň", "temná síň");
        Prostor tichaMistnost = new Prostor("tichá_místnost", "tichá místnost", true);
        Prostor zrcadlovaKomnata = new Prostor("zrcadlová_komnata", "zrcadlová komnata");
        Prostor prazdnyPokoj = new Prostor("prázdný_pokoj", "prázdný pokoj");
        Prostor cestaBezKonce = new Prostor("cesta_bez_konce", "cesta bez konce", true);
        Prostor tajemnaLoznice = new Prostor("tajemná_ložnice", "tajemná ložnice");
        Prostor rozcestiZahad = new Prostor("rozcestí_záhad", "rozcestí záhad");
        Prostor zelenaHala = new Prostor("zelená_hala", "zelená hala");
        Prostor zpetnaMistnost = new Prostor("zpětná_místnost", "zpětná místnost");
        Prostor prisernyTunel = new Prostor("příšerný_tunel", "příšerný tunel");
        Prostor skrytaKoje = new Prostor("skrytá_kóje", "skrytá kóje", true);
        Prostor ztracenyKout = new Prostor("ztracený_kout", "ztracený kout");
        Prostor branaLabyrintu = new Prostor("brána_labyrintu", "brána labyrintu");
        
        // přiřazují se průchody mezi prostory (sousedící prostory)
        temnaSin.setVychod(zrcadlovaKomnata);
        tichaMistnost.setVychod(zrcadlovaKomnata);
        zrcadlovaKomnata.setVychod(temnaSin);
        zrcadlovaKomnata.setVychod(tichaMistnost);
        zrcadlovaKomnata.setVychod(prazdnyPokoj);
        zrcadlovaKomnata.setVychod(rozcestiZahad);
        prazdnyPokoj.setVychod(zrcadlovaKomnata);
        prazdnyPokoj.setVychod(cestaBezKonce);
        prazdnyPokoj.setVychod(zelenaHala);
        cestaBezKonce.setVychod(prazdnyPokoj);
        cestaBezKonce.setVychod(zpetnaMistnost);
        tajemnaLoznice.setVychod(rozcestiZahad);
        tajemnaLoznice.setVychod(prisernyTunel);
        rozcestiZahad.setVychod(zrcadlovaKomnata);
        rozcestiZahad.setVychod(tajemnaLoznice);
        rozcestiZahad.setVychod(zelenaHala);
        rozcestiZahad.setVychod(skrytaKoje);
        zelenaHala.setVychod(prazdnyPokoj);
        zelenaHala.setVychod(rozcestiZahad);
        zelenaHala.setVychod(zpetnaMistnost);
        zpetnaMistnost.setVychod(cestaBezKonce);
        zpetnaMistnost.setVychod(zelenaHala);
        zpetnaMistnost.setVychod(ztracenyKout);
        prisernyTunel.setVychod(tajemnaLoznice);
        prisernyTunel.setVychod(branaLabyrintu);
        skrytaKoje.setVychod(rozcestiZahad);
        ztracenyKout.setVychod(zpetnaMistnost);

        // určuje místo k teleportaci
        this.setTeleport(tajemnaLoznice);

        // vytvářejí se speciální věci
        Vec mikrofon = new Vec("mikrofon", true, 1);
        Vec spunt = new Vec("špunt", true, 1);
        Vec bota = new Vec("bota", true, 1);
        Vec klic = new Vec("klíč", true, 1);

        // vytvářejí se ostatní věci
        Vec prsten = new Vec("prsten", true, 1);
        Vec koste = new Vec("koště", true, 2);
        Vec zidle = new Vec("židle", false, 1);
        Vec thorKladivo = new Vec("thorovo_kladivo", false, 1);
        Vec pivo = new Vec("pivo", true, 1);
        Vec gps = new Vec("gps", true, 1);
        Vec retez = new Vec("řetěz", false, 1);
        Vec kybl = new Vec("kýbl", true, 2);
        Vec lucerna = new Vec("lucerna", true, 1);
        Vec mec = new Vec("meč", true, 2);
        Vec mapa = new Vec("mapa", true, 1);
        Vec truhlice = new Vec("truhlice", false, 1);
        Vec nuz = new Vec("nůž", true, 1);
        Vec kriz = new Vec("kříž", true, 1);
        Vec stit = new Vec("štít", true, 2);
        Vec stul = new Vec("stůl", false, 1);

        // přiřazují se věci do prostorů
        zrcadlovaKomnata.addVec(mikrofon);
        tajemnaLoznice.addVec(spunt);
        zpetnaMistnost.addVec(bota);
        ztracenyKout.addVec(klic);
        temnaSin.addVec(stit);
        temnaSin.addVec(koste);
        zrcadlovaKomnata.addVec(stul);
        zrcadlovaKomnata.addVec(prsten);
        prazdnyPokoj.addVec(kriz);
        tajemnaLoznice.addVec(zidle);
        rozcestiZahad.addVec(thorKladivo);
        rozcestiZahad.addVec(pivo);
        rozcestiZahad.addVec(gps);
        zelenaHala.addVec(retez);
        zelenaHala.addVec(kybl);
        zpetnaMistnost.addVec(lucerna);
        zpetnaMistnost.addVec(mec);
        ztracenyKout.addVec(mapa);
        prisernyTunel.addVec(truhlice);
        prisernyTunel.addVec(nuz);

        // hra začíná v temné síni
        aktualniProstor = temnaSin;
    }

    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return   aktuální prostor
     */
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu
     *  mezi prostory.
     *
     *@param    prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }

    /**
     *  Přidává věc do batohu a odebírá ji z prostoru.
     *
     *@param    nazev název veci kterou chceme sebrat
     */
    public void seberVec (String nazev) {
        Vec vec = this.getAktualniProstor().getVec(nazev);

        this.batoh.addVec(vec);
        this.getAktualniProstor().removeVec(nazev);
    }

    /**
     *  Přidává věc do prostoru a odebírá ji z batohu.
     *
     *@param    nazev název veci kterou chceme položit
     */
    public void polozVec (String nazev) {
        Vec vec = batoh.getVec(nazev);

        this.getAktualniProstor().addVec(vec);
        this.batoh.removeVec(vec);
    }

    /**
     *  Vypisuje všechni věci, které jsou aktuálně v batohu.
     *
     *@return   seznam věcí v batohu
     */
    public String vypisBatoh () {
        return batoh.popisBatohu();
    }

    /**
     *  Teleportuje hráče do místnosti určené v neznámé 'teleport'.
     *
     *@return    oznámení teleportace uživateli
     */
    public String teleportovat() {
        this.setAktualniProstor(teleport);

        Prostor mistnost = this.getAktualniProstor();

        return "Začarovaná bota vás teleportovala do tajemné ložnice.\n" +
                mistnost.popisVychodu() + "\n" +
                mistnost.popisVeci();
    }

    /**
     *  Nastavuje nový teleportační prostor.
     *
     *@param    teleport Prostor, který chceme nastavit jako ten, kam se uživatel teleportuje
     */
    public void setTeleport(Prostor teleport) {
        this.teleport = teleport;
    }
}

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
     *  Jako výchozí aktuální prostor nastaví Temnou síň.
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

        // vytvářejí se jednotlivé věci
        Vec mikrofon = new Vec("mikrofon", true, 1);
        Vec spunt = new Vec("špunt", true, 1);
        Vec bota = new Vec("bota", true, 1);
        Vec klic = new Vec("klíč", true, 1);

        // přiřazují se věci do prostorů
        zrcadlovaKomnata.addVec(mikrofon);
        tajemnaLoznice.addVec(spunt);
        zpetnaMistnost.addVec(bota);
        ztracenyKout.addVec(klic);

        batoh.addVec(spunt);
        batoh.addVec(mikrofon);
        aktualniProstor = temnaSin;  // hra začíná v Temné síni
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
}

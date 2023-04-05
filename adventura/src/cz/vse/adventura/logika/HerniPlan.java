package cz.vse.adventura.logika;


/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */
public class HerniPlan {
    
    private Prostor aktualniProstor;
    private Batoh batoh;
    
     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan(Batoh batoh) {
        this.batoh = batoh;
        zalozProstoryHry();
    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor temnaSin = new Prostor("temná_síň", "temná síň");
        Prostor tichaMistnost = new Prostor("tichá_místnost", "tichá místnost", true);
        Prostor zrcadlovaKomnata = new Prostor("zrcadlová_komnata", "zrcadlová komnata");
        Prostor prazdnyPokoj = new Prostor("prázdný_pokoj", "prázdný pokoj");
        Prostor cestaBezKonce = new Prostor("cesta_bez_konce", "cesta bez konce", true);
        Prostor tajemnaLoznice = new Prostor("tajemná_ložnice", "tajemná ložnice");
        Prostor krizovatkaTajemnstvi = new Prostor("križovatka_tajemství", "križovatka tajemství");
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
        zrcadlovaKomnata.setVychod(krizovatkaTajemnstvi);
        prazdnyPokoj.setVychod(zrcadlovaKomnata);
        prazdnyPokoj.setVychod(cestaBezKonce);
        prazdnyPokoj.setVychod(zelenaHala);
        cestaBezKonce.setVychod(prazdnyPokoj);
        cestaBezKonce.setVychod(zpetnaMistnost);
        tajemnaLoznice.setVychod(krizovatkaTajemnstvi);
        tajemnaLoznice.setVychod(prisernyTunel);
        krizovatkaTajemnstvi.setVychod(zrcadlovaKomnata);
        krizovatkaTajemnstvi.setVychod(tajemnaLoznice);
        krizovatkaTajemnstvi.setVychod(zelenaHala);
        krizovatkaTajemnstvi.setVychod(skrytaKoje);
        zelenaHala.setVychod(prazdnyPokoj);
        zelenaHala.setVychod(krizovatkaTajemnstvi);
        zelenaHala.setVychod(zpetnaMistnost);
        zpetnaMistnost.setVychod(cestaBezKonce);
        zpetnaMistnost.setVychod(zelenaHala);
        zpetnaMistnost.setVychod(ztracenyKout);
        prisernyTunel.setVychod(tajemnaLoznice);
        prisernyTunel.setVychod(branaLabyrintu);
        skrytaKoje.setVychod(krizovatkaTajemnstvi);
        ztracenyKout.setVychod(zpetnaMistnost);

        // vytvářejí se jednotlivé věci
        Vec mikrofon = new Vec("mikrofon", true, 1);
        Vec spunt = new Vec("špunt", true, 1);
        Vec bota = new Vec("bota", true, 1);
        Vec klic = new Vec("klíč", true, 1);

        // přiřazují se věci mezi prostory (sousedící prostory)
        zrcadlovaKomnata.addVec(mikrofon);
        tajemnaLoznice.addVec(spunt);
        zpetnaMistnost.addVec(bota);
        ztracenyKout.addVec(klic);

        batoh.addVec(spunt);
        aktualniProstor = temnaSin;  // hra začíná v Temné síni
    }

    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }

}

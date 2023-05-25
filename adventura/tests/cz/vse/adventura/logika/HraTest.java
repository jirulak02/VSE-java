package cz.vse.adventura.logika;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra
 *
 *@author     Jarmila Pavlíčková, Jiří Šimeček
 *@version    Květen 2023
 */
public class HraTest {
    private Hra hra1;

    /**
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @BeforeEach
    public void setUp() {
        hra1 = new Hra();
    }

    /**
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @AfterEach
    public void tearDown() {
        hra1.zpracujPrikaz("konec");
    }

    /**
     * Testuje průběh hry, po zavolání každěho příkazu testuje, zda hra končí
     * a v jaké aktuální místnosti se hráč nachází.
     * Při dalším rozšiřování hry doporučujeme testovat i jaké věci nebo osoby
     * jsou v místnosti a jaké věci jsou v batohu hráče.
     */
    @Test
    public void testPrubehHry() {
        assertEquals("temná_síň", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi zrcadlová_komnata");
        assertEquals(false, hra1.konecHry());
        assertEquals("zrcadlová_komnata", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi prázdný_pokoj");
        assertEquals(false, hra1.konecHry());
        assertEquals("prázdný_pokoj", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("konec");
        assertEquals(true, hra1.konecHry());
    }

    /**
     * Testuje fungování příkazu jsem_mimino.
     */
    @Test
    public void testPrikazJsemMimino() {
        assertEquals("Smrtelné východy: \u001B[31m\u001B[0m", hra1.zpracujPrikaz("jsem_mimino"));
        hra1.zpracujPrikaz("jdi zrcadlová_komnata");
        assertEquals("Smrtelné východy: \u001B[31mtichá_místnost\u001B[0m", hra1.zpracujPrikaz("jsem_mimino"));
    }

    /**
     * Testuje zda lze hru vyhrát.
     */
    @Test
    public void testLzeVyhrat() {
        hra1.zpracujPrikaz("jdi zrcadlová_komnata");
        hra1.zpracujPrikaz("jdi prázdný_pokoj");
        hra1.zpracujPrikaz("jdi zelená_hala");
        hra1.zpracujPrikaz("jdi zpětná_místnost");
        hra1.zpracujPrikaz("jdi ztracený_kout");
        hra1.zpracujPrikaz("seber klíč");
        hra1.zpracujPrikaz("jdi zpětná_místnost");
        hra1.zpracujPrikaz("seber bota");
        hra1.zpracujPrikaz("jdi příšerný_tunel");
        hra1.zpracujPrikaz("odemknout");
        assertEquals("Úspěšně se vám podařilo uniknout z labyrintu a hru jste tak dohráli.", hra1.zpracujPrikaz("jdi brána_labyrintu"));
    }

    /**
     * Testuje omezenou kapacitu batohu.
     */
    @Test
    public void testOmezenyPocetVeci() {
        hra1.zpracujPrikaz("seber štít");
        hra1.zpracujPrikaz("seber koště");
        hra1.zpracujPrikaz("jdi zrcadlová_komnata");
        assertEquals("Error: Věc se do batohu nevejde.", hra1.zpracujPrikaz("seber prsten"));
    }

    /**
     * Testuje zda lze sebrat nepřenositelnou věc.
     */
    @Test
    public void testNeprenositelnostVeci() {
        hra1.zpracujPrikaz("jdi zrcadlová_komnata");
        assertEquals("Error: Věc je nepřenositelná.", hra1.zpracujPrikaz("seber stůl"));
    }

    /**
     * Testuje existenci černých děr.
     */
    @Test
    public void testCernaDira() {
        hra1.zpracujPrikaz("jdi zrcadlová_komnata");
        assertEquals("V místnosti vás vtáhla a zabila černá díra. Hra ukončena!\nZkuste to znovu. Případně pokud máte dost, tak...", hra1.zpracujPrikaz("jdi tichá_místnost"));
    }

    /**
     * Testuje možnost získat easter egg.
     */
    @Test
    public void testEasterEgg() {
        hra1.zpracujPrikaz("jdi zrcadlová_komnata");
        hra1.zpracujPrikaz("jdi rozcestí_záhad");
        hra1.zpracujPrikaz("jdi tajemná_ložnice");
        hra1.zpracujPrikaz("seber špunt");
        hra1.zpracujPrikaz("jdi rozcestí_záhad");
        assertEquals("Jste v místnosti skrytá kóje.\nvýchody: rozcestí_záhad\nvěci:", hra1.zpracujPrikaz("jdi skrytá_kóje"));
    }
}

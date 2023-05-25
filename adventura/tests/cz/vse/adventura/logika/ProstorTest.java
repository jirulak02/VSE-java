package cz.vse.adventura.logika;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testovací třída ProstorTest slouží ke komplexnímu otestování
 * třídy Prostor
 *
 *@author     Jarmila Pavlíčková, Jiří Šimeček
 *@version    Květen 2023
 */
public class ProstorTest {
    /**
     * Testuje, zda jsou správně nastaveny průchody mezi prostory hry. Prostory
     * nemusí odpovídat vlastní hře.
     */
    @Test
    public void testLzeProjit() {
        Prostor prostor1 = new Prostor("temná_síň", "temná síň");
        Prostor prostor2 = new Prostor("brána_labyrintu", "brána labyrintu");
        prostor1.setVychod(prostor2);
        prostor2.setVychod(prostor1);
        assertEquals(prostor2, prostor1.vratSousedniProstor("brána_labyrintu"));
        assertEquals(null, prostor2.vratSousedniProstor("zrcadlová_komnata"));
    }
}

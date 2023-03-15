import com.example.hotel.*;

public class Application {
    public static void main (String[] args) {
        // Vytvořím psí hotel
        PsiHotel hotel = new PsiHotel();

        // Nastavím maximální objem pro boudy na 18m3
        hotel.setMaximalniObjemProBoudy(18);

        // Ubytovaní psy v hotelu:
        hotel.vypisBoudySePsi(); // Prázdné

        // Ubytování psa
        Pes karel = new Pes("Karel", 1);
        hotel.ubytujPsa(karel); // true

        Pes jiri = new Pes("Jiří", 2);
        hotel.ubytujPsa(jiri); // true

        //  Jiří i Karel by nyní měli mít vlastní boudu:
        for (Pes pes: new Pes[]{karel, jiri}) {
            System.out.println("Je " + pes.getJmeno() + " ubytovaný v boudě? " + pes.isUbytovany());
        }

        // Pokusím se ubytovat příliš velkého psa do příliš malé boudy:
        Bouda bouda = new StandardniBouda("Nefunkční bouda");
        Pes jaromir = new Pes("Jaromír", 3);
        hotel.ubytujPsa(jaromir, bouda); // false
        System.out.println("Je " + jaromir.getJmeno() + " ubytovaný v boudě? " + jaromir.isUbytovany());

        // Je hotel obsazený boudami? Tzn. je prostor pro boudy vyčerpán?
        System.out.println("Je hotel obsazený boudami? " + hotel.isObsazeno()); // false

        // Přidám do zásoby pár psích boud:
        hotel.pridejBoudu(new SdilenaBouda("Bouda 3")); // true
        hotel.pridejBoudu(new LuxusniBouda("Bouda 4")); // true
        hotel.pridejBoudu(new StandardniBouda("Bouda 5")); // true
        hotel.pridejBoudu(new LuxusniBouda("Bouda 6")); // false
        hotel.pridejBoudu(new SdilenaBouda("Bouda 7")); // false
        hotel.pridejBoudu(new StandardniBouda("Bouda 8")); // true
        hotel.pridejBoudu(new StandardniBouda("Bouda 9")); // false

        // Obsadím volné boudy pár psi:
        hotel.ubytujPsa(new Pes("Erben", 1)); // true
        hotel.ubytujPsa(new Pes("Hyne", 1)); // true
        hotel.ubytujPsa(new Pes("Mácha", 2)); // true
        hotel.ubytujPsa(new Pes("Vodník", 2)); // true
        hotel.ubytujPsa(new Pes("testPes1", 4)); // false
        hotel.ubytujPsa(new Pes("testPes2", 1)); // true
        hotel.ubytujPsa(new Pes("testPes3", 3)); // false
        hotel.ubytujPsa(new Pes("testPes4", 2)); // true
        System.out.println();
        System.out.println("Všichni psi zaštěkají, protože se už nový pes nikam nevejde:");
        hotel.ubytujPsa(new Pes("testPes5", 2)); // false (všichni zaštěkají)

        // výpis všech psů
        System.out.println();
        System.out.println("Výpis všech psů v boudách:");
        hotel.vypisBoudySePsi();

        // Vyhledávání pomocí query
        String query = "testPes";
        System.out.println();
        System.out.println("Vyhledávám výraz '" + query + "':");

        String result = hotel.find(query);
        System.out.println(result);
    }
}
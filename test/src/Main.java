import com.example.test.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Eshop eshop = new Eshop("Test", "example.com");

        Kniha dasenka = new Kniha(
                250,
                "Dášenka čili život štěněte",
                true,
                "978-80-277-0497-2"
        );

        Kurz programovani = new Kurz(
                5000,
                "Kurz programování v Javě",
                true,
                "Karel Hynek Mácha"
        );

        Voucher voucher2000 = new Voucher(
                2000,
                "Dárkový poukaz v hodnotě 2000 Kč",
                true,
                52
        );

        Voucher voucher4000 = new Voucher(
                4000,
                "Dárkový poukaz v hodnotě 4000 Kč",
                true,
                52
        );

        eshop.pridejProdukt(dasenka);
        eshop.pridejProdukt(programovani);
        eshop.pridejProdukt(voucher2000);
        eshop.pridejProdukt(voucher4000);

        Zakaznik karel = new Zakaznik(eshop, "Karel", "Hynek", "Ulice 123, Město 123 45");
        List<Produkt> karluvNakup = new ArrayList<>();
        karluvNakup.add(dasenka);
        karluvNakup.add(voucher4000);
        karel.objednejProduktyAUhrad(karluvNakup);

        Zakaznik jaromir = new Zakaznik(eshop, "Jaromír", "Erben", "Ulice 123, Město 123 45");
        List<Produkt> jaromiruvNakup = new ArrayList<>();
        jaromiruvNakup.add(programovani);
        jaromiruvNakup.add(dasenka);
        jaromiruvNakup.add(voucher2000);
        jaromir.objednejProduktyAUhrad(jaromiruvNakup);

        eshop.pridejZakaznika(karel);
        eshop.pridejZakaznika(jaromir);

        float celkoveTrzby = eshop.getCelkoveTrzby();

        System.out.print("Zákazníci v obchodě utratili celkem ");
        System.out.print(celkoveTrzby);
        System.out.println(" Kč.");
    }
}
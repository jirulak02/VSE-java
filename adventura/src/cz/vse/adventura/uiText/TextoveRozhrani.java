package cz.vse.adventura.uiText;

import java.io.*;
import java.util.Scanner;
import cz.vse.adventura.logika.IHra;

/**
 *  Třída TextoveRozhrani.
 * 
 *  Toto je uživatelského rozhraní aplikace Adventura.
 *  Tato třída vytváří instanci třídy Hra, která představuje logiku aplikace.
 *  Čte vstup zadaný uživatelem a předává tento řetězec logice a vypisuje odpověď logiky na konzoli.
 *
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */
public class TextoveRozhrani {
    private IHra hra;

    /**
     *  Konstruktor textového rozhraní.
     */
    public TextoveRozhrani(IHra hra) {
        this.hra = hra;
    }

    /**
     *  Hlavní metoda hry. Vypíše úvodní text a pak opakuje čtení a zpracování
     *  příkazu od hráče do konce hry (dokud metoda konecHry() z logiky nevrátí
     *  hodnotu true). Nakonec vypíše text epilogu.
     */
    public void hraj() {
        System.out.println(hra.vratUvitani());

        // základní cyklus programu - opakovaně se čtou příkazy a poté
        // se provádějí do konce hry.
        while (!hra.konecHry()) {
            String radek = prectiString();
            System.out.println(hra.zpracujPrikaz(radek));
        }

        System.out.println(hra.vratEpilog());
    }

    /**
     *  Metoda přečte příkaz z příkazového řádku.
     *
     *@return    Vrací přečtený příkaz jako instanci třídy String
     */
    private String prectiString() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("> ");
        return scanner.nextLine();
    }

    public void hrajZeSouboru (String nazevSouboru) {
        try (
                // Dekorace (rozšiřování funkcionality) třídy FileReader třídou BufferedReader
                BufferedReader cteni = new BufferedReader(new FileReader(nazevSouboru));

                // Dekorace (rozšiřování funkcionality) třídy FileWriter třídou PrintWriter
                PrintWriter zapis = new PrintWriter(new FileWriter("vystup.txt"))
        ) {
            System.out.println(hra.vratUvitani());
            zapis.println(hra.vratUvitani());

            // Dokud je ve vstupním souboru další řádek textu, nebo hra neskončila, prováděj cyklus.
            for (String radek = cteni.readLine(); radek != null && !hra.konecHry(); radek = cteni.readLine())
            {
                // Vypiš příkaz do výstupu
                System.out.println("> " + radek);
                zapis.println("> " + radek);

                // Zpracuj příkaz
                String vystup = hra.zpracujPrikaz(radek);

                // Vypiš výsledek příkazu do výstupu
                System.out.println(vystup);
                zapis.println(vystup);
            }

            System.out.println(hra.vratEpilog());
            zapis.println(hra.vratEpilog());

        } catch (FileNotFoundException e) {
            File file = new File(nazevSouboru);
            System.out.println("Soubor nebyl nalezen!\nProhledávaná cesta byla: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Nelze hrát hru ze souboru, něco se pokazilo: " + e.getMessage());
        }
    }
}

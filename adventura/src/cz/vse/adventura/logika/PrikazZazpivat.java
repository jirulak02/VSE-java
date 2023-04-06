package cz.vse.adventura.logika;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *  Třída PrikazZazpivat implementuje pro hru příkaz zazpívat.
 *
 *  Příkaz umožňující si společně zazpívat krásnou písničku.
 *
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Jiří Šimeček
 *@version    Duben 2023
 */
public class PrikazZazpivat implements IPrikaz {
    private static final String NAZEV = "zazpívat";
    private Batoh batoh;

    /**
     *  Konstruktor příkazu zazpívat.
     *
     *@param    batoh pro kontrolu přítomnosti mikrofonu
     */
    public PrikazZazpivat(Batoh batoh) {
        this.batoh = batoh;
    }

    /**
     *  Spouští písničku ze složky a uspí provádění příkazů na 19 sekund.
     */
    public void zazpivej() {
        try {
            System.out.println("Zapněte si zvuk.\n");

            // Otevírá audio stream
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    PrikazZazpivat.class.getResourceAsStream("../audio/Pisnicka.wav"));

            Clip clip = AudioSystem.getClip();
            // Otevírá audio klip a vloží do něj vytvořený audio stream
            clip.open(audioInputStream);

            // Spouští audio klip
            clip.start();
            Thread.sleep(19000);
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
        }
    }

    /**
     *  Zkontroluje přítomnost mikrofonu v batohu.
     *  Volá funkci, která spouští zvuk písničky.
     *  Vypisuje lyrics písničky řádek po řádku každých 3,4 vteřiny.
     *
     *@param    parametry obsahuje název příkazu zazpívat
     *@return   lyrics přehrávané písničky
     */
    @Override
    public String provedPrikaz(String... parametry) {
        // chceme délku parametru 0, název příkazu byl odstraněn
        if (parametry.length > 0) {
            return "Písnička je již vybraná, takže stačí pouze příkaz zazpívat";
        }

        if (!batoh.hasVec("mikrofon")) {
            return "Ke zpěvu potřebujete mikrofon.";
        }

        String[] pisnicka = {
                "We’re no strangers to love",
                "You know the rules and so do I",
                "A full commitment’s what I’m thinking of",
                "You wouldn’t get this from any other guy",
                "I just wanna tell you how I’m feeling",
                "Gotta make you understand",
                "Never gonna give you up",
                "Never gonna let you down",
                "Never gonna run around and desert you",
                "Never gonna make you cry",
                "Never gonna say goodbye",
                "Never gonna tell a lie and hurt you",
        };

        zazpivej();

        for (String line : pisnicka) {
            System.out.println(line);

            try {
                Thread.sleep(3400);
            } catch (Exception e) {
                System.out.println("Error message: " + e.getMessage());
            }
        }

        return "\nDík, že jste si se mnou zazpívali.";
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

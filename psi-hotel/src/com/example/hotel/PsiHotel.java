package com.example.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PsiHotel {
    private int maximalniObjemProBoudy = 20;
    private List<Bouda> boudy = new ArrayList<>();

    public int getMaximalniObjemProBoudy() {
        return maximalniObjemProBoudy;
    }

    public void setMaximalniObjemProBoudy(int maximalniObjemProBoudy) {
        this.maximalniObjemProBoudy = maximalniObjemProBoudy;
    }

    public boolean pridejBoudu(Bouda bouda) {
        boolean obsazenyHotel = isObsazeno();

        if (!obsazenyHotel) {
            boudy.add(bouda);
            return true;
        }

        return false;
    }

    public boolean odeberBoudu(Bouda bouda) {
        boolean boudaJePrazdna = false;
        if (bouda.getUbytovaniPsi().size() == 0) {
            boudaJePrazdna = true;
        }

        if (!boudaJePrazdna) {
            return false;
        }
        return boudy.remove(bouda);
    }

    public void zastekejteVsichniPsi() {
        for (Bouda bouda: this.boudy) {
            for (Pes pes: bouda.getUbytovaniPsi()) {
                pes.zastekej();
            }
        }
    }

    public boolean isObsazeno() {
        int vyuzityObjem = 0;

        for (Bouda bouda: boudy) {
            vyuzityObjem += bouda.getObjem();
        }

        return vyuzityObjem + 2 > maximalniObjemProBoudy;
    }

    public boolean ubytujPsa(Pes pes) {
        Bouda volnaBouda = null;

        for (Bouda bouda: boudy) {
            if (!bouda.isObsazeno()) {
                volnaBouda = bouda;
                break;
            }
        }

        if (volnaBouda == null && isObsazeno()) {
            zastekejteVsichniPsi();
            return false;
        }

        boolean pesUbytovan = false;
        if (null != volnaBouda) {
            pesUbytovan = ubytujPsa(pes, volnaBouda);
        }

        if (pesUbytovan) {
            return true;
        }

        Bouda vychoziBouda = new StandardniBouda("Bouda 1 a 2"); // Vytváření unikátního názvu je příliš komplikované
        boolean boudaPridana = pridejBoudu(vychoziBouda);

        if (!boudaPridana) {
            return false;
        }
        return ubytujPsa(pes, vychoziBouda);
    }

    public boolean ubytujPsa(Pes pes, Bouda bouda) {
        boolean jeUbytovan = ubytovavaPsa(pes);

        if (jeUbytovan) {
            return false;
        }

        boolean maHotelBoudu = boudy.contains(bouda);

        if (!maHotelBoudu) {
            return false;
        }

        boolean jeBoudaObsazena = bouda.isObsazeno();

        if (jeBoudaObsazena) {
            return false;
        }

        return bouda.pridejPsa(pes);
    }

    private boolean ubytovavaPsa(Pes pes) {
        for (Bouda bouda: boudy) {
            if (bouda.ubytovavaPsa(pes)) {
                return true;
            }
        }

        return false;
    }

    public boolean odhlasPsa(Pes pes) {
        for (Bouda bouda: boudy) {
            if (bouda.ubytovavaPsa(pes)) {
                bouda.odeberPsa(pes);
            }
        }

        return true;
    }

    public void vypisBoudySePsi () {
        for (Bouda bouda: boudy) {
            Set<Pes> ubytovaniPsi = bouda.getUbytovaniPsi();

            System.out.print("Bouda typu " + bouda.getClass());
            System.out.print(", ubytováno " + ubytovaniPsi.size() + " psů:\n");

            for (Pes pes: ubytovaniPsi) {
                System.out.println("  - " + pes);
            }
        }
    }

    public String find(String query) {
        String result = "";

        for (Searchable bouda: this.boudy) {
            if (bouda.prepareSearchableString().contains(query)) {
                result += " - " + bouda.getDisplayName() + "\n";
            }
        }

        if (result.isEmpty()) {
            result = "Žádný záznam nevyhovuje...";
        }

        return result;
    }
}

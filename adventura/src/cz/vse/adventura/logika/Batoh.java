package cz.vse.adventura.logika;

import java.util.HashMap;
import java.util.Map;

public class Batoh {
    private float objem;

    private float zbyleMisto = objem;
    private Map<String, Vec> veci = new HashMap<>();

    public Batoh(float objem) {
        this.objem = objem;
    }

    public float getObjem() {
        return objem;
    }

    public void setObjem(float objem) {
        this.objem = objem;
    }

    public Map<String, Vec> getVeci() {
        return veci;
    }

    public void setVeci(Map<String, Vec> veci) {
        this.veci = veci;
    }

    public void addVec(Vec vec) {
        if (!vec.isPrenositelna()) {
            return;
        }

        float objemVeci = vec.getObjem();

        if (objemVeci > zbyleMisto) {
            return;
        }

        veci.put(vec.getNazev(), vec);
        setZbyleMisto(zbyleMisto - objemVeci);
    }

    public void removeVec(String nazev) {
        veci.remove(nazev);
    }

    public boolean hasVec(String nazev) {
        return veci.containsKey(nazev);
    }

    public Vec getVec(String nazev) {
        return veci.get(nazev);
    }

    public float getZbyleMisto() {
        return zbyleMisto;
    }

    public void setZbyleMisto(float zbyleMisto) {
        this.zbyleMisto = zbyleMisto;
    }
}

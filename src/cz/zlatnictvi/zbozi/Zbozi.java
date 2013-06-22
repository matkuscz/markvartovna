package cz.zlatnictvi.zbozi;

import cz.zlatnictvi.zbozi.zasobovani.Vyrobce;
import cz.zlatnictvi.zbozi.zasobovani.Dodavatel;
import cz.zlatnictvi.Zamestnanec;

public class Zbozi {

    private final double cenaNakupni;
    //private Skupina skupina;
    private Dodavatel dodavatel;
    private Vyrobce vyrobce;
    public final static double DPH = 1.2;
    /**
     * prodavac nesmi zjistit marzi
     */
    private double marze;
    private final boolean marzeFix;
    private String popis;

    /**
     *
     * @param dodavatel
     * @param vyrobce
     * @param cenaNakupni
     * @param marze
     * @param marzeFix
     */
    public Zbozi(Dodavatel dodavatel, Vyrobce vyrobce, double cenaNakupni, double marze, boolean marzeFix, String popis) {
        this.dodavatel = dodavatel;
        this.vyrobce = vyrobce;
        this.marze = marze;
        this.cenaNakupni = cenaNakupni;
        this.marzeFix = marzeFix;
        this.popis = popis;
    }

    public double spocitejZlevnenouCenuS_DPH(Zamestnanec zamestnanec) {
        return zamestnanec.spocitejSlevu(getCenaBezDPH()) * DPH;
    }

    private double getCenaBezDPH() {
        if (marzeFix) {
            return cenaNakupni + marze;
        }
        return cenaNakupni + cenaNakupni * marze;
    }

    @Override
    public String toString() {
        return dodavatel.toString() + ", " + vyrobce.toString() + ", cena: " + getCenaBezDPH() * DPH + popis;
    }
}

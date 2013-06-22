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

    /**
     *
     * @param dodavatel
     * @param vyrobce
     * @param cenaNakupni
     * @param marze
     * @param marzeFix
     */
    public Zbozi(Dodavatel dodavatel, Vyrobce vyrobce, double cenaNakupni, double marze, boolean marzeFix) {
        this.dodavatel = dodavatel;
        this.vyrobce = vyrobce;
        this.marze = marze;
        this.cenaNakupni = cenaNakupni;
        this.marzeFix = marzeFix;
    }

    public double getCena(Zamestnanec zamestnanec) {
        if (marzeFix) {
            return (zamestnanec.spocitejSlevu(cenaNakupni + marze)) * DPH;
        }
        return (zamestnanec.spocitejSlevu(cenaNakupni + cenaNakupni * marze)) * DPH;       
    }
}

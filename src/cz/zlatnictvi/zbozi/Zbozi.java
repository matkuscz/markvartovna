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
    private final String popis;
    private final String jmeno;

    /**
     *
     * @param dodavatel
     * @param vyrobce
     * @param cenaNakupni
     * @param marze
     * @param marzeFix
     */
    public Zbozi(Dodavatel dodavatel, Vyrobce vyrobce, double cenaNakupni, double marze, boolean marzeFix, String jmeno, String popis) {
        this.dodavatel = dodavatel;
        this.vyrobce = vyrobce;
        this.marze = marze;
        this.cenaNakupni = cenaNakupni;
        this.marzeFix = marzeFix;
        this.popis = popis;
        this.jmeno = jmeno;
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
        return dodavatel.toString() + ", " + vyrobce.toString() + ", cena: " +
                getCenaBezDPH() * DPH +"Kč, "+jmeno+" - "+ popis;
    }
}

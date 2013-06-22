package cz.zlatnictvi;

import cz.zlatnictvi.zbozi.Zbozi;
import cz.zlatnictvi.skladovehospodarstvi.SkladoveHospodarstvi;
import java.util.ArrayList;

public class Pokladna {

    private final int idProdejny;
    private double zustatekHotovosti = 0;
    private SkladoveHospodarstvi sklad;

    public Pokladna(int idProdejny, double zustatekHotovosti) {
        this(idProdejny);
        this.zustatekHotovosti = zustatekHotovosti;
    }

    public Pokladna(int idProdejny) {
        this.idProdejny = idProdejny;
        sklad = SkladoveHospodarstvi.getInstance(idProdejny);
    }

    public ZakazkovyList vytvorZakazkovyList(ArrayList<Zbozi> zbozi, Zamestnanec zamestnanec) {
        double cenaTrasakce = 0;
        for (Zbozi aktZbozi : zbozi) {
            cenaTrasakce += (aktZbozi.getCena() - zamestnanec.spocitejSlevu(aktZbozi));

            //sklad.odskladniZbozi(aktZbozi);
        }
        zustatekHotovosti += cenaTrasakce;
        ZakazkovyList retList = new ZakazkovyList(zbozi, cenaTrasakce);

        return null;
    }

    public double getZustatekHotovosti() {
        return zustatekHotovosti;
    }
    
    
}

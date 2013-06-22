
package cz.zlatnictvi;

import cz.zlatnictvi.zbozi.Zbozi;


public class Zamestnanec {
    private final POZICE pozice;

    public Zamestnanec() {
    pozice = POZICE.PRODAVAC;
    }

    
    
    public Zamestnanec(POZICE pozice) {
        this.pozice = pozice;
    }

    public POZICE getPozice() {
        return pozice;
    }

  public  double spocitejSlevu(Zbozi aktZbozi) {
        switch(pozice){
            case PRODAVAC:
                return aktZbozi.getCena() * 0.95;
            case VEDOUCI_PRODEJNY:
                return aktZbozi.getCena() * 0.9;
            default:
                return aktZbozi.getCena()* 0.99;
                       }
                
    }
    
    
    
}

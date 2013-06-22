package cz.zlatnictvi;

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

    public double spocitejSlevu(double cena) {
        switch (pozice) {
            case PRODAVAC:
                return cena * 1;
            case VEDOUCI_PRODEJNY:
                return cena * 0.9;
            default:
                return cena * 0.99;
        }
    }
}

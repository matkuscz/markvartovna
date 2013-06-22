package cz.zlatnictvi.skladovehospodarstvi;

public class SkladoveHospodarstvi {

    private static SkladoveHospodarstvi[] prodejny;
    private static final int POCET_PRODEJEN = 10;

    public static SkladoveHospodarstvi getInstance(int idProdejny) {
        if (prodejny == null) {
            prodejny = new SkladoveHospodarstvi[POCET_PRODEJEN];
        }
        if (prodejny[idProdejny] == null) {
            prodejny[idProdejny] = new SkladoveHospodarstvi(idProdejny);
        }

        return prodejny[idProdejny];

    }

    private SkladoveHospodarstvi(int idProdejny) {
        
    }
}

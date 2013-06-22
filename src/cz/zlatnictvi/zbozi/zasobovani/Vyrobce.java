
package cz.zlatnictvi.zbozi.zasobovani;
public class Vyrobce {
private final int idVyrobce;

    public Vyrobce(int idVyrobce) {
        this.idVyrobce = idVyrobce;
    }

    @Override
    public String toString() {
        return "idVyrobce["+idVyrobce+"]";
    }


}

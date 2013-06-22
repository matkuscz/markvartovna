package cz.zlatnictvi.zbozi.zasobovani;

public class Dodavatel {

    private final int id;

    public Dodavatel(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "idDodavatele["+id + "]";
    }
}

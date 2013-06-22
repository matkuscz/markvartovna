package cz.zlatnictvi.skladovehospodarstvi;

public class SkladoveHospodarstvi {

    private static SkladoveHospodarstvi instance;

    public static SkladoveHospodarstvi getInstance() {
        if (instance == null) {
            instance = new SkladoveHospodarstvi();
        }
        return instance;
    }

    private SkladoveHospodarstvi() {
    }
}

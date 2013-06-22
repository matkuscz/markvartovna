package cz.zlatnictvi.skladovehospodarstvi;

import static cz.zlatnictvi.skladovehospodarstvi.SkladoveHospodarstvi.DB_CLASS;
import static cz.zlatnictvi.skladovehospodarstvi.SkladoveHospodarstvi.DB_PASSWD;
import static cz.zlatnictvi.skladovehospodarstvi.SkladoveHospodarstvi.DB_URL;
import static cz.zlatnictvi.skladovehospodarstvi.SkladoveHospodarstvi.DB_USER;
import static cz.zlatnictvi.skladovehospodarstvi.SkladoveHospodarstvi.logger;
import cz.zlatnictvi.zbozi.Zbozi;
import cz.zlatnictvi.zbozi.zasobovani.Dodavatel;
import cz.zlatnictvi.zbozi.zasobovani.Vyrobce;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import org.apache.log4j.Logger;

public final class SkladoveHospodarstvi {

    protected static final Logger logger = Logger.getLogger(SkladoveHospodarstvi.class);
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
    private Connection conn = null;
    private LinkedList<Zbozi> zboziNaProdejne;
    public static final String DB_CLASS = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://37.157.194.208:3306/zlatnictvi?characterEncoding=utf8"; // pro pripojeni na databazi na svn
    public static final String DB_USER = "zlatnik";
    public static final String DB_PASSWD = "zlatnik";
    ///
    private PreparedStatement isAlive;
    private PreparedStatement getZbozi;
    private PreparedStatement updateMaterial;
private final int idProdejny;
    private SkladoveHospodarstvi(int idProdejny) {
        this.idProdejny = idProdejny;
        connect();
        zboziNaProdejne = getZbozi();
    }

    private boolean connect() {
        try {
            Class.forName(DB_CLASS).newInstance();
            conn = null;

            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
        } catch (ClassNotFoundException ex) {
            logger.error("Nelze nacist driver databaze", ex);
            return false;
        } catch (SQLException ex) {
            logger.error("Nepodarilo se vytvorit pripojeni", ex);
            return false;
        } catch (Exception ex) {
            logger.error("Neco se pokazilo pro pokusu o pripojeni k databazi", ex);
            return false;
        }
        clearStatements();
        prepareStatements();
        return true;
    }

    public void clearStatements() {
        isAlive = null;
        getZbozi = null;
        // misto pro pridani dalsich statementu
    }

    public final void prepareStatements() {
        try {
            if (conn != null) {
                isAlive = conn.prepareStatement("SELECT 1");
                //         getUsers = conn.prepareStatement("SELECT id, name, surname, pin, admin FROM users ORDER BY surname ASC");
                getZbozi = conn.prepareStatement("SELECT idDodavatele, idVyrobce, cenaNakupni, marze, fixniMarze, carovyKod, jmeno, popis FROM zbozi WHERE zbozi.idProdejny ="+
                    idProdejny    +" ORDER BY carovyKod ASC");
                //   updateMaterial = conn.prepareStatement("UPDATE material SET metry=?, ks=? WHERE id = ?");
//                insertPohyb = conn.prepareStatement("INSERT INTO movements (material,date,user,pohyb,stav) VALUES(?,NOW(),?,?,?);");
//                getMovements = conn.prepareStatement("select movements.id id_poh,pohyb,date,stav,material.id id_mat,material.name mat, "
//                        + "code,users.id id_uzi,users.name name,users.surname surname "
//                        + "FROM movements JOIN material on movements.material = material.id "
//                        + "JOIN users on movements.user = users.id ORDER BY code, date;");
                // misto pro vytvoreni dalsich statementu
            }
        } catch (SQLException ex) {
            logger.error("Nepodarilo se vyrobit prepared statementy", ex);
        }
    }

    private LinkedList<Zbozi> getZbozi() {
        LinkedList<Zbozi> list = new LinkedList<>();
        if (getZbozi != null) {
            try {
                ResultSet rs = getZbozi.executeQuery();
                while (rs.next()) {

                    int idDodavatele, idVyrobce;
                    double marze, cenaNakupni;
                    boolean fixniMarze;
                    String popis , jmeno;
                    idDodavatele = rs.getInt("idDodavatele");
                    idVyrobce = rs.getInt("idVyrobce");
                    cenaNakupni = rs.getDouble("cenaNakupni");
                    marze = rs.getDouble("marze");
                    fixniMarze = rs.getBoolean("fixniMarze");
                    jmeno = rs.getString("jmeno");
                    popis = rs.getString("popis");
                    Zbozi z = new Zbozi(new Dodavatel(idDodavatele),
                            new Vyrobce(idVyrobce), cenaNakupni,
                            marze, fixniMarze,
                            jmeno,popis);
                    list.add(z);
                }
            } catch (SQLException ex) {
                logger.error("Nepodarilo se ziskat seznam zbozi", ex);
            }
        }
        return list;
    }

    public LinkedList<Zbozi> getZboziNaProdejne() {
        return zboziNaProdejne;
    }
}

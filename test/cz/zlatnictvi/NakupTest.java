
package cz.zlatnictvi;

import cz.zlatnictvi.zbozi.Zbozi;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
public class NakupTest {
    
    public NakupTest() {
    }
    
  
    @Before
    public void setUp() {
    }
  
    @Test
    public void testZakaznikKoupiRetizek() {
        Zakaznik zakaznik = new Zakaznik();
        Zamestnanec prodavac = new Zamestnanec();
        Pokladna pokladna = new Pokladna(1);
        Zbozi retizek = new Zbozi(null, null, 200, 100, true,null, null);
        ArrayList<Zbozi> zbozi = new ArrayList<>();
        zbozi.add(retizek);
        ZakazkovyList zakList =pokladna.vytvorZakazkovyList(zbozi, prodavac);
    }
    
    
    
}
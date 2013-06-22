
package cz.zlatnictvi;

import cz.zlatnictvi.zbozi.Retizek;
import cz.zlatnictvi.zbozi.Zbozi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class NakupTest {
    
    public NakupTest() {
    }
    
  
    @Before
    public void setUp() {
    }
  
    @Test
    public void testZakaznikKoupiRetizek() {
        Zakaznik zakaznik = new Zakaznik();
        Pokladna pokladna = new Pokladna();
        Zbozi retizek = new Retizek();
        
        pokladna.prodejZboziZakaznikovi(retizek, zakaznik);
    }
    
    
    
}
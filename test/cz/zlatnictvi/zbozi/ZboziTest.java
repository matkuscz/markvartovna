/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.zlatnictvi.zbozi;

import cz.zlatnictvi.Zamestnanec;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ZboziTest {
    
      Zamestnanec zamestnanec = new Zamestnanec();
    
    @Before
    public void setUp() {
    }
  
    @Test
    public void testZjistiCenuZboziZa200ProcentualniMarze() {
        System.out.println("getCena");
        Zbozi instance = new Zbozi(null, null,200, 0.5, false, null, null);
        double expResult = (200 + 200*0.5)* Zbozi.DPH;
        double result = instance.spocitejZlevnenouCenuS_DPH(zamestnanec);
        assertEquals(expResult, result, 0.0);
    }
      @Test
    public void testZjistiCenuZboziZa200SPevnouMarzi200() {
        System.out.println("getCena");
        double pevnaMarze = 200;
        Zbozi instance = new Zbozi(null, null,200, pevnaMarze, true, null,null);
        double expResult =(200 + pevnaMarze)* Zbozi.DPH;
        double result = instance.spocitejZlevnenouCenuS_DPH(zamestnanec);
        assertEquals(expResult, result, 0.0);
    }
}
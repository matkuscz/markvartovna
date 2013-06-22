
package cz.zlatnictvi.skladovehospodarstvi;

import cz.zlatnictvi.zbozi.Zbozi;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;


public class SkladoveHospodarstviTest {
   
  

    @Test
    public void testCtor() {
        System.out.println("getZbozi");
        SkladoveHospodarstvi instance = SkladoveHospodarstvi.getInstance(1);
        
      LinkedList<Zbozi> pom =   instance.getZboziNaProdejne();
        System.out.println("pocet zbozi:"+ pom.size());
        for (Zbozi zbozi : pom) {
            System.out.println(zbozi.toString());
        }
    }
}

package cz.zlatnictvi;
import cz.zlatnictvi.zbozi.Zbozi;
import cz.zlatnictvi.skladovehospodarstvi.SkladoveHospodarstvi;
import java.util.ArrayList;

public class Pokladna {
private double zustatekHotovosti;
private SkladoveHospodarstvi sklad = SkladoveHospodarstvi.getInstance();

   public ZakazkovyList vytvorZakazkovyList(ArrayList<Zbozi> zbozi) {
       for (Zbozi aktZbozi : zbozi) {
           zustatekHotovosti += aktZbozi.getCena(); //-- zakaznik.sleva
           
        sklad.odskladniZbozi(aktZbozi);
       }
        
        return null;//new ZakazkovyList(zbozi);
    }
    
    
    
    // TO DO test vyjed kasu

}

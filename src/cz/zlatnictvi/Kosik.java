/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.zlatnictvi;

import cz.zlatnictvi.zbozi.Zbozi;
import java.util.LinkedList;

/**
 *
 * @author Matka
 */
public class Kosik {
    private LinkedList<Zbozi> zbozi;
    
    public Kosik(){
        zbozi = new LinkedList<>();
    }

    public void pridejZbozi(Zbozi pridavanyKus){
        this.zbozi.add(pridavanyKus);
    }
    
    public boolean odeberZbozi(Zbozi odebiranyKus){
        return zbozi.remove(odebiranyKus);
    }
  
    public void vypisObsahKosiku(){
        for (Zbozi kus : zbozi) {
            System.out.println(kus.toString());
        }
    }
    
    public LinkedList<Zbozi> getObsahKosiku(){
        return zbozi;
    }
            
}
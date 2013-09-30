/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.emulatoras.instrukcia;

import emulatoras.Instrukcia;
import emulatoras.Stav;
import emulatoras.StavException;
import emulatoras.Zasobnik;
import emulatoras.ZasobnikException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Tomi
 */
public class Store extends Instrukcia{
    Stav stav = new Stav();
    @Override
    public void vykonaj(String instrukcia) {
        String premenna;
        int hodnota;
        
        instrukcia = instrukcia.replaceAll("\\s", "");                          
        instrukcia = instrukcia.toUpperCase();
        
        Pattern pattern = Pattern.compile(regexp());                            
        Matcher match = pattern.matcher(instrukcia);

        if (match.find()) {
            premenna = match.group(1);                                         
            try {
                hodnota = Integer.parseInt(Zasobnik.getZasobnik().vyber());     //zisti do akej premennej sa ma ulozit hodnota
                stav.vlozHodnotu(premenna, hodnota);                            //vlozenie do stavu
                
            
            } catch (ZasobnikException ex) {
            } catch (NumberFormatException e) {
                try {
                    throw new StavException("nieje mozne ulozit bool hodnotu");
                } catch (StavException ex) {
                    Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    
    }
    }

    @Override
    public String regexp() {
    return "^STORE-(([A-Z])+)$";
    }

 
    @Override
    public String platnost() {
   return "^STORE-(([A-Z])+)$";
     }
    
}

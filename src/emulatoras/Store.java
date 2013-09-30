/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

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
    void vykonaj(String instrukcia) {
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
    String regexp() {
    return "^STORE-(([A-Z])+)$";
    }

 
    @Override
    String platnost() {
   return "^STORE-(([A-Z])+)$";
     }
    
}

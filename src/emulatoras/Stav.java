/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author Tomi
 */
public class Stav {

    Hashtable<String, Integer> stav = new Hashtable<String, Integer>();
    List<Hashtable> stavy = new ArrayList<Hashtable>();

    /**
     *vlozi premennu do stavu nula bez jeho aktuaizacie
     * @param premenna
     * @param hodnota
     */
    public void vlozPremennu(String premenna, Integer hodnota) {
       premenna = premenna.toUpperCase();
        if (stavy.isEmpty()) {
            if (hodnota == null) {
            stav.put(premenna, null);   // vyskusat s new integer
        } else {
            stav.put(premenna, hodnota);
        }
            stavy.add(stav);
        } else {
            if (hodnota == null) {
           stavy.get(0).put(premenna, null);
        } else {
           stavy.get(0).put(premenna, hodnota);
        }
        }
        
    }

    /**
     *vlozi konkretnej premennej v stave hodnotu a aktualizuje stav
     * @param premenna
     * @param hodnota
     */
    public void vlozHodnotu(String premenna, Integer hodnota) {
        premenna = premenna.toUpperCase();
        Hashtable<String, Integer> stav = (Hashtable) stavy.get(stavy.size()-1).clone() ; //vytvorenie noveho stavu po zmene hodnoty 
        
        stav.put(premenna, hodnota);
        stavy.add(stav);
           

    }

    /**
     *vrati hodnotu premenne v danom stave
     * @param premenna
     * @param stav
     * @return
     */
    public Integer vratHodnotu(String premenna, Integer stav) {
        premenna = premenna.toUpperCase();
        Hashtable<String, Integer> stavv = stavy.get(stav);
        return stavv.get(premenna);
    }


}

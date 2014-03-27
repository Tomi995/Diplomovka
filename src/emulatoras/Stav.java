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
 * Trieda pre spravovanie stavov.
 *
 * @author Tomi
 */
public class Stav  {

    /**
     * Vytvorí tabuľku pre stavy a ich hodnoty
     */
    public static final List<Hashtable> stavy = new ArrayList<Hashtable>();                  //List vsetkych stavov 

    public static void clear() {
        stavy.clear();
    }

    /**
     * Vloží premennu do stavu nula bez aktuaizácie stavu
     *
     * @param premenna
     * @param hodnota
     */
    public  void vlozPremennu(String premenna, Integer hodnota) {

        premenna = premenna.toUpperCase();
        if (stavy.isEmpty()) {                      //ak este stav neexistuje vytvori sa stav nula
            Hashtable<String, Integer> stav = new Hashtable<String, Integer>();
            stav.put(premenna, hodnota);            //vlozi premennu s hodnotou do stavu
            stavy.add(stav);
        } else {
                                                    //ak uz stav nula existuje tak don vlozi premenne
            stavy.get(0).put(premenna, hodnota);     //vlozi premennu s hodnotou do stavu
        }
    }

    /**
     * Aktualizuje stav a danej premennej priradí konkrétnu hodnotu.
     *
     * @param premenna
     * @param hodnota
     */
    public void vlozHodnotu(String premenna, Integer hodnota) {

        premenna = premenna.toUpperCase();
        Hashtable<String, Integer> novyStav = new Hashtable<String, Integer>();
        if (stavy.isEmpty()) {
        } else {
            novyStav = (Hashtable) stavy.get(stavy.size() - 1).clone(); //vytvorenie noveho stavu po zmene hodnoty 
        }

        novyStav.put(premenna, hodnota);            //vlozenie hodnoty do stavu
        System.out.println(premenna+""+novyStav.get(premenna));
        stavy.add(novyStav);                         // pridanie noveho stavu medzi vsetky stavy
    }

    /**
     * Vráti hodnotu premennej v poslednom stave.
     *
     * @param premenna
     * @param stav
     * @return
     */
    public Integer vratHodnotu(String premenna) throws StavException {

        premenna = premenna.toUpperCase();
        try {
            Hashtable<String, Integer> stavv = stavy.get(stavy.size() - 1);   //z posledneho stavu vrati hodnotu 
            int hodnota = stavv.get(premenna);

            return hodnota;

        } catch (IndexOutOfBoundsException | NullPointerException ex) {
        }
        throw new StavException("Premenná " + premenna + " nemá hodnotu v danom stave");

    }
}

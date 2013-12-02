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
 * trieda pre spravovanie stavov
 *
 * @author Tomi
 */
public class Stav {

    //hashtable pre premennu a jej hodnotu- stav
    static final List<Hashtable> stavy = new ArrayList<Hashtable>();                  //List vsetkych stavov 

    /**
     * vlozi premennu do stavu nula bez jeho aktuaizacie
     *
     * @param premenna
     * @param hodnota
     */
    public void vlozPremennu(String premenna, Integer hodnota) {

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
     * vlozi konkretnej premennej v stave hodnotu a aktualizuje stav
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
        stavy.add(novyStav);                         // pridanie noveho stavu medzi vsetky stavy

    }

    /**
     * vrati hodnotu premennej v poslednom
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
        throw new StavException("Premenna " + premenna + " nema hodnotu v danom stave");

    }
}

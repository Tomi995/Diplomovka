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

    Hashtable<String, String> stav = new Hashtable<String, String>();  //hashtable pre premennu a jej hodnotu- stav
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
            if (hodnota == null) {
                stav.put(premenna, "null");               //ak nezadam hodnotu vlozi sa s null (!!!!!nefunguje musim domysliet ako vlozit null)
            } else {
                stav.put(premenna, hodnota.toString());            //vlozi premennu s hodnotou do stavu
            }
            stavy.add(stav);
        } else {
            if (hodnota == null) {                  //ak uz stav nula existuje tak don vlozi premenne
                stavy.get(0).put(premenna, "null");        //ak nezadam hodnotu vlozi sa s null (!!!!!nefunguje musim domysliet ako vlozit null)
            } else {
                stavy.get(0).put(premenna, hodnota.toString());     //vlozi premennu s hodnotou do stavu
            }
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

        if (stavy.isEmpty()) {
            Hashtable<String, String> stav;
        } else {
            Hashtable<String, String> stav = (Hashtable) stavy.get(stavy.size() - 1).clone(); //vytvorenie noveho stavu po zmene hodnoty 
        }

        stav.put(premenna, hodnota.toString());  //vlozenie hodnoty do stavu
        stavy.add(stav);                         // pridanie noveho stavu medzi vsetky stavy

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
            Hashtable<String, String> stavv = stavy.get(stavy.size() - 1);   //z posledneho stavu vrati hodnotu 
            int hodnota = Integer.parseInt(stavv.get(premenna));


            return hodnota;

        } catch (NumberFormatException ex) {
        } catch (IndexOutOfBoundsException ex) {
        } catch (NullPointerException ex){
               }
            throw new StavException("Premenna " + premenna + " nema hodnotu v danom stave");
            
        }
     
            
    }


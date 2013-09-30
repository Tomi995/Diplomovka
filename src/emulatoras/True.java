/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class True extends Instrukcia{
/**
 * vykonanie instrukcie TRUE
 * @param instrukcia 
 */
    @Override
    void vykonaj(String instrukcia){
        try {
            Zasobnik.getZasobnik().vloz("TRUE");                                //vlozi do zasobnika hodnitu true
        } catch (ZasobnikException ex) {
            
        }
    }

    @Override
    String regexp() {
        return "^TRUE$";
    }


    @Override
    String platnost() {
        return "^TRUE$";
    }
    
}

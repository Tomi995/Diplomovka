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

    @Override
    void vykonaj() {
        try {
            Zasobnik.getZasobnik().vloz("TRUE");
        } catch (ZasobnikException ex) {
            
        }
    }

    @Override
    String regexp() {
        return "TRUE";
    }

    @Override
    Boolean platnost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

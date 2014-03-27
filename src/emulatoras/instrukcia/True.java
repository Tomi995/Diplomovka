/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras.instrukcia;

import emulatoras.Instrukcia;
import emulatoras.MyParserException;
import emulatoras.Zasobnik;
import emulatoras.ZasobnikException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class True extends Instrukcia {

    /**
     * Vykonanie inštrukcie TRUE.
     *
     * @param instrukcia
     */
    @Override
    public void vykonaj(String instrukcia) throws MyParserException {
        Zasobnik.getZasobnik().vloz("TRUE");                                //vlozi do zasobnika hodnitu true
    }

    /**
     * Regulárny výraz pre funkciu TRUE.
     * @return 
     */
    @Override
    public String regexp() {
        return "^TRUE$";
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.emulatoras.instrukcia;

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
     * vykonanie instrukcie TRUE
     *
     * @param instrukcia
     */
    @Override
    public void vykonaj(String instrukcia) throws MyParserException {
        Zasobnik.getZasobnik().vloz("TRUE");                                //vlozi do zasobnika hodnitu true
    }

    @Override
    public String regexp() {
        return "^TRUE$";
    }

    @Override
    public String platnost() {
        return "^TRUE$";
    }
}

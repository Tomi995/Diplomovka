/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras.instrukcia;

import emulatoras.Instrukcia;
import emulatoras.MyParserException;
import emulatoras.Zasobnik;
import emulatoras.ZasobnikException;

/**
 *
 * @author Tomi
 */
public class False extends Instrukcia {

    /**
     * Vykonanie inštrukcie FALSE.
     * @param instrukcia
     * @throws MyParserException 
     */
    @Override
    public void vykonaj(String instrukcia) throws MyParserException {
        Zasobnik.getZasobnik().vloz("FALSE");                               //vlozenie hodnoty do zasobnika
    }

    /**
     * Regulárny výraz pre funkciu FALSE.
     * @return 
     */
    @Override
    public String regexp() {
        return "^FALSE$";
    }
}

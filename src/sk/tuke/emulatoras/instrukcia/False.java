/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.emulatoras.instrukcia;

import emulatoras.Instrukcia;
import emulatoras.Zasobnik;
import emulatoras.ZasobnikException;

/**
 *
 * @author Tomi
 */
public class False extends Instrukcia{

    @Override
    public void vykonaj(String instrukcia) {
        try {
            Zasobnik.getZasobnik().vloz("FALSE");                               //vlozenie hodnoty do zasobnika
        } catch (ZasobnikException ex) {
            
        }}

    @Override
    public String regexp() {
        return "^FALSE$";
    }

    @Override
    public String platnost() {
    return "^FALSE$";
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

/**
 *
 * @author Tomi
 */
public class False extends Instrukcia{

    @Override
    void vykonaj(String instrukcia) {
        try {
            Zasobnik.getZasobnik().vloz("FALSE");                               //vlozenie hodnoty do zasobnika
        } catch (ZasobnikException ex) {
            
        }}

    @Override
    String regexp() {
        return "^FALSE$";
    }

    @Override
    String platnost() {
    return "^FALSE$";
    }
    
}

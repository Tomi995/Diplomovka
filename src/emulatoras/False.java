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
    void vykonaj() {
        try {
            Zasobnik.getZasobnik().vloz("FALSE");
        } catch (ZasobnikException ex) {
            
        }}

    @Override
    String regexp() {
        return "FALSE";
    }

    @Override
    Boolean platnost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

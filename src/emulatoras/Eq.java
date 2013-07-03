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
public class Eq extends Instrukcia {

    @Override
    void vykonaj(String instrukcia) {
        Boolean prveJeCislo = false;
        Boolean druheJeCislo = false;

        try {
            if (Zasobnik.getZasobnik().jeCislo()) {
                prveJeCislo = true;
            }
            String prvaHodnota = Zasobnik.getZasobnik().vyber();
            if (Zasobnik.getZasobnik().jeCislo()) {
                druheJeCislo = true;
            }
            String druhaHodnota = Zasobnik.getZasobnik().vyber();

            if (prveJeCislo && druheJeCislo) {
                if (prvaHodnota == druhaHodnota) {
                    Zasobnik.getZasobnik().vloz("TRUE");
                } else {
                    Zasobnik.getZasobnik().vloz("FALSE");
                }
            }

            if ((!prveJeCislo) && (!druheJeCislo)) {
                if (prvaHodnota == druhaHodnota) {
                    Zasobnik.getZasobnik().vloz("TRUE");
                } else {
                    Zasobnik.getZasobnik().vloz("FALSE");
                }
            }

        } catch (ZasobnikException ex) {
            System.out.println(ex);
        }





    }

    @Override
    String regexp() {
        return "EQ";
    }

    @Override
    Boolean platnost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

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
public class Neg extends Instrukcia {

    String vysledok;

    @Override
    void vykonaj(String instrukcia) {
        try {
            if (!Zasobnik.getZasobnik().jeCislo()) {
                String hodnota = Zasobnik.getZasobnik().vyber();
                if (hodnota == "tt") {
                    vysledok = "ff";
                } else {
                    vysledok = "tt";
                }
            }
            Zasobnik.getZasobnik().vloz(vysledok);
        } catch (ZasobnikException ex) {
            System.out.println(ex);
        }
    }

    @Override
    String regexp() {
        return "NEG";
    }

    @Override
    Boolean platnost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

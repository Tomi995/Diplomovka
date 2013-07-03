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
public class Add extends Instrukcia {

    /**
     * Vykonanie add funkcie
     *
     * @author Tomi
     */
    @Override
    void vykonaj(String instrukcia) {

        int prveCislo = 0;
        int druheCislo = 0;
        int vysledok;

        try {
            if (Zasobnik.getZasobnik().jeCislo()) {
                prveCislo = Integer.parseInt(Zasobnik.getZasobnik().vyber());
            } else {
                throw new ZasobnikException("Zla hodnota v zasobniku");
            }
            if (Zasobnik.getZasobnik().jeCislo()) {
                druheCislo = Integer.parseInt(Zasobnik.getZasobnik().vyber());
            } else {
                throw new ZasobnikException("Zla hodnota v zasobniku");
            }
            vysledok = prveCislo + druheCislo;
            Zasobnik.getZasobnik().vloz(vysledok);
        } catch (ZasobnikException ex) {
            System.out.println(ex);
        }

    }

    /**
     * regularny vyraz pre add funkciu
     *
     * @author Tomi
     */
    @Override
    String regexp() {
        return "ADD";
    }

    @Override
    Boolean platnost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
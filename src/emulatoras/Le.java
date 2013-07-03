/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

/**
 *
 * @author Tomi
 */
public class Le extends Instrukcia {

    @Override
    void vykonaj(String instrukcia) {
        int prveCislo = 0;
        int druheCislo = 0;

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
            if (prveCislo <= druheCislo) {
                Zasobnik.getZasobnik().vloz("TRUE");
            } else {
                Zasobnik.getZasobnik().vloz("FALSE");
            }

        } catch (ZasobnikException ex) {
            System.out.println(ex);
        }
    }

    @Override
    String regexp() {
        return "LE";
    }

    @Override
    Boolean platnost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

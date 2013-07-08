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
        int prveCislo = 0;      //premenna pre prvu hodnotu cisla
        int druheCislo = 0;     //premenna pre druhu hodnotu zasobnika

        try {
            if (Zasobnik.getZasobnik().jeCislo()) {                             //vyberie prve cislo zo zasobnika a vlozi ho do premennej
                prveCislo = Integer.parseInt(Zasobnik.getZasobnik().vyber());
            } else {
                throw new ZasobnikException("Zla hodnota v zasobniku");
            }
            if (Zasobnik.getZasobnik().jeCislo()) {                             //vyberie druhe cislo zo zasobnika a vlozi ho do premennej
                druheCislo = Integer.parseInt(Zasobnik.getZasobnik().vyber());
            } else {
                throw new ZasobnikException("Zla hodnota v zasobniku");
            }
            if (prveCislo <= druheCislo) {                                      //porovna cisla a vysledok vlozi do zasobnika
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
        return "^LE$";
    }

    @Override
    Boolean platnost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

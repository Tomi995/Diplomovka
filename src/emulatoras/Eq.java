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
        Boolean prveJeCislo = false;                                            //premenna na urcenie ci je prve cislo v zasobniku cislo alebo Bool hodnota
        Boolean druheJeCislo = false;                                           //premenna na urcenie ci je druhe cislo v zasobniku cislo alebo Bool hodnota

        try {
            if (Zasobnik.getZasobnik().jeCislo()) {                             //zistenie ci je prve cislo cislo alebo hodnota a pridelenie do premennej
                prveJeCislo = true;
            }
            String prvaHodnota = Zasobnik.getZasobnik().vyber();                //vybratie prveho cisla zo zasobnika aby sa dalo overit druhe
            if (Zasobnik.getZasobnik().jeCislo()) {
                druheJeCislo = true;                                            //zistenie ci je prve cislo cislo alebo hodnota a pridelenie do premennej
            }
            String druhaHodnota = Zasobnik.getZasobnik().vyber();               //vybratie druhej hodnoty zo zasobnika

            if (prveJeCislo && druheJeCislo) {                                  //ak su obe hodnoty cisla porovna ich a vlozi vysledok do zasobnika
                if (prvaHodnota.equals(druhaHodnota)) {
                    Zasobnik.getZasobnik().vloz("TRUE");
                } else {
                    Zasobnik.getZasobnik().vloz("FALSE");
                }
            } else if ((!prveJeCislo) && (!druheJeCislo)) {                            //ak su obe hodnoty Bool tak ich porovna a vysledok vlozi do zasobnika
                if (prvaHodnota.equals(druhaHodnota)) {
                    Zasobnik.getZasobnik().vloz("TRUE");
                } else {
                    Zasobnik.getZasobnik().vloz("FALSE");
                }
            } else {
                throw new ZasobnikException("Zle hodnoty v zasobniku");             //exception ak su v zasobniku rozdielne typy hodnot (int bool)
            }

        } catch (ZasobnikException ex) {                                        //zachytenie exceptionu
            System.out.println(ex);
        }

    }

    @Override
    String regexp() {
        return "^EQ$";
    }

    @Override
    Boolean platnost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

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
public class Le extends Instrukcia {

    /**
     * Vykonanie inštrukcie LE.
     * @param instrukcia
     * @throws MyParserException 
     */
    @Override
    public void vykonaj(String instrukcia) throws MyParserException {
        int prveCislo = 0;      //premenna pre prvu hodnotu cisla
        int druheCislo = 0;     //premenna pre druhu hodnotu zasobnika

        if (Zasobnik.getZasobnik().jeCislo()) {                             //vyberie prve cislo zo zasobnika a vlozi ho do premennej
            prveCislo = Integer.parseInt(Zasobnik.getZasobnik().vyber());
        } else {
            throw new ZasobnikException("Zla hodnota v zasobniku pre instrukciu LE");
        }
        if (Zasobnik.getZasobnik().jeCislo()) {                             //vyberie druhe cislo zo zasobnika a vlozi ho do premennej
            druheCislo = Integer.parseInt(Zasobnik.getZasobnik().vyber());
        } else {
            throw new ZasobnikException("Zla hodnota v zasobniku pre instrukciu LE");
        }
        if (prveCislo <= druheCislo) {                                      //porovna cisla a vysledok vlozi do zasobnika
            Zasobnik.getZasobnik().vloz("TRUE");
        } else {
            Zasobnik.getZasobnik().vloz("FALSE");
        }
    }

    /**
     * Regulárny výraz pre funkciu LE.
     * @return 
     */
    @Override
    public String regexp() {
        return "^LE$";
    }
}

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
public class Sub extends Instrukcia {

    /**
     * Vykonanie inštrukcie SUB.
     *
     * @param instrukcia
     */
    @Override
    public void vykonaj(String instrukcia) throws MyParserException {
        int prveCislo = 0;                                                         //premenna pre prve cislo
        int druheCislo = 0;                                                     //premenna pre druhe cislo
        int vysledok;                                                           //premenna pre vysledok

        if (Zasobnik.getZasobnik().jeCislo()) {                             //zisti ci je cislo v zasobniku cislo, vyberie ho a vlozi do premennej
            prveCislo = Integer.parseInt(Zasobnik.getZasobnik().vyber());
        } else {
            throw new ZasobnikException("Zla hodnota v zasobniku pre instrukciu SUB");
        }
        if (Zasobnik.getZasobnik().jeCislo()) {                             //zisti ci ej druhe cislo v zasobniku cislo,vyberie ho a vlozi do premennej
            druheCislo = Integer.parseInt(Zasobnik.getZasobnik().vyber());
        } else {
            throw new ZasobnikException("Zla hodnota v zasobniku pre instrukciu SUB");
        }
        vysledok = prveCislo - druheCislo;                                  //vypocita a vysledok vlozi do zasobnika
        Zasobnik.getZasobnik().vloz(vysledok);
    }

    /**
     * Regulárny výraz pre funkciu SUB.
     * @return 
     */
    @Override
    public String regexp() {
        return "^SUB$";
    }
}

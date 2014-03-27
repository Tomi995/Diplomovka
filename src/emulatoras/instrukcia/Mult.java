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
public class Mult extends Instrukcia {

    /**
     * Vykonanie inštrukcie MULT.
     *
     * @param instrukcia
     */
    @Override
    public void vykonaj(String instrukcia) throws MyParserException {
        int prveCislo = 0;                                                      //premenna pre prvu hodnotu
        int druheCislo = 0;                                                     //premenna pre druhu hodnotu
        int vysledok;                                                           //vysledok

        if (Zasobnik.getZasobnik().jeCislo()) {                             //overi ci je prve cislo v zasobniku cislo, priradi ho do premennej a vyhodi zo zasobnika
            prveCislo = Integer.parseInt(Zasobnik.getZasobnik().vyber());
        } else {
            throw new ZasobnikException("Zla hodnota v zasobniku pre instrukciu MULT");
        }
        if (Zasobnik.getZasobnik().jeCislo()) {                             //overi ci je druhe cislo v zasobniku cislo, prideli ho do premennej a vyberie zo zasobnika
            druheCislo = Integer.parseInt(Zasobnik.getZasobnik().vyber());
        } else {
            throw new ZasobnikException("Zla hodnota v zasobniku pre instrukciu MULT");
        }
        vysledok = prveCislo * druheCislo;                                  //vypocita vysledok a vlozi ho do zasobnika
        Zasobnik.getZasobnik().vloz(vysledok);
    }

    /**
     * Regulárny výraz pre funkciu MUL.
     * @return 
     */
    @Override
    public String regexp() {
        return "^MULT$";
    }
}

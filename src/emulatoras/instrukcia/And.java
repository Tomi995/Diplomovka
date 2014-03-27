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
public class And extends Instrukcia {

    /**
     * Vykonanie inštrukcie AND.
     *
     * @param instrukcia
     */
    @Override
    public void vykonaj(String instrukcia) throws MyParserException {
        String prvaHodnota;                             //premenna pre prvu hodnotu
        String druhaHodnota;                            //premenna pre druhu hodnotu
        String vysledok;                                //premenna pre vysledok

        if (!Zasobnik.getZasobnik().jeCislo()) {                            //overenie ci nie je prve cislo v zasobniku cislo
            prvaHodnota = Zasobnik.getZasobnik().vyber();                   //priradenie hodnoty do premennej a vybratie zo zasobnika (deje sa v zasobniku)
        } else {
            throw new ZasobnikException("Zla hodnota v zasobniku pre instrukciu AND");
        }
        if (!Zasobnik.getZasobnik().jeCislo()) {                            //overenie ci nie je druhe cislo v zasobniku cislo
            druhaHodnota = Zasobnik.getZasobnik().vyber();                  //priradenie hodnoty do premennej a vybratie zo zasobnika (deje sa v zasobniku)
        } else {
            throw new ZasobnikException("Zla hodnota v zasobniku pre instrukciu AND");
        }
        if ("tt".equals(prvaHodnota) && "tt".equals(druhaHodnota)) //vyhodnotenie 
        {
            vysledok = "TRUE";
        } else {
            vysledok = "FALSE";
        }

        Zasobnik.getZasobnik().vloz(vysledok);                              //vlozenie do zasobnika
    }

    /**
     * Regulárny výraz pre funkciu AND.
     * @return
     */
    @Override
    public String regexp() {
        return "^AND$";
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras.instrukcia;

import emulatoras.Instrukcia;
import emulatoras.MyParserException;
import emulatoras.Zasobnik;
import emulatoras.ZasobnikException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Neg extends Instrukcia {

    /**
     * Vykonanie inštrukcie NEG.
     * @param instrukcia
     * @throws MyParserException 
     */
    @Override
    public void vykonaj(String instrukcia) throws MyParserException {
        String vysledok = "";                                                   //premenna pre vysledok
        if (!Zasobnik.getZasobnik().jeCislo()) {                            //zisti ci hodnota v zasobniku nie jecislo a vlozi ju do premennej
            String hodnota = Zasobnik.getZasobnik().vyber();
            if (hodnota == "tt") {                                          //zisti aka je hodnota v premennej a vrati jej negaciu
                vysledok = "FALSE";
            } else {
                vysledok = "TRUE";
            }
             Zasobnik.getZasobnik().vloz(vysledok);                         //vlozi vysledok do zasobnika
        }
        else throw new ZasobnikException("Zla hodnota v zasobniku pre instrukciu NEG");
                                     
    }

    /**
     * Regulárny výraz pre funkciu NEG.
     * @return 
     */
    @Override
    public String regexp() {
        return "^NEG$";
    }
}

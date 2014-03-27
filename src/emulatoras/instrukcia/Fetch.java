/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras.instrukcia;

import emulatoras.Instrukcia;
import emulatoras.MyParserException;
import emulatoras.Stav;
import emulatoras.StavException;
import emulatoras.Zasobnik;
import emulatoras.ZasobnikException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Tomi
 */
public class Fetch extends Instrukcia {

    /**
     * Vykonanie inštrukcie FETCH.
     * @param instrukcia
     * @throws MyParserException 
     */
    @Override
    public void vykonaj(String instrukcia) throws MyParserException {
        String premenna;

        instrukcia = instrukcia.replaceAll("\\s", "");
        instrukcia = instrukcia.toUpperCase();

        Pattern pattern = Pattern.compile(regexp());                            //pattern pre regex
        Matcher match = pattern.matcher(instrukcia);

        if (match.find()) {
            premenna = match.group(1);                                  //zistenie premennej

            Stav stav = new Stav();
            Zasobnik.getZasobnik().vloz(stav.vratHodnotu(premenna));            //vyberie zo stavu hodnotu premennej a vlozi do zasobnika
        } else {
            throw new MyParserException("Chybny prikaz " + instrukcia);
        }

    }

    /**
     * Regulárny výraz pre funkciu FETCH.
     * @return 
     */
    @Override
    public String regexp() {
        return "^FETCH-(([A-Z])+)$";
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.emulatoras.instrukcia;

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

    @Override
    public void vykonaj(String instrukcia) {
        String premenna;

        instrukcia = instrukcia.replaceAll("\\s", "");
        instrukcia = instrukcia.toUpperCase();

        Pattern pattern = Pattern.compile(regexp());                            //pattern pre regex
        Matcher match = pattern.matcher(instrukcia);

        if (match.find()) {
            premenna = match.group(1);                                  //zistenie premennej
           
            Stav stav = new Stav();
            try {
                Zasobnik.getZasobnik().vloz(stav.vratHodnotu(premenna));            //vyberie zo stavu hodnotu premennej a vlozi do zasobnika

            } catch (StavException  | ZasobnikException ex)  {
            }
        } else {
            try {
                throw new MyParserException("Chybny prikaz " + instrukcia);
            } catch (MyParserException ex) {
                Logger.getLogger(Fetch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public String regexp() {
        return "^FETCH-(([A-Z])+)$";
    }


    @Override
    public String platnost() {
    return "^FETCH-(([A-Z])+)$";
    }
}

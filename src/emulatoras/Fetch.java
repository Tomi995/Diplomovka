/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

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
    void vykonaj(String instrukcia) {
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
    String regexp() {
        return "^FETCH-(([A-Z])+)$";
    }

    @Override
    Boolean platnost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Tomi
 */
public class Loop extends Instrukcia {

    @Override
    void vykonaj(String instrukcia) {
        System.out.println(instrukcia);
        Parser parser = new Parser();

        String prvyPrikaz;
        String druhyPrikaz;
        
        instrukcia = instrukcia.replaceAll("\\s", "");                          //odstranenie bielych znakov
        instrukcia = instrukcia.toUpperCase();                                  //zmena na velke pismena

        Pattern pattern = Pattern.compile(regexp());                            //pattern pre regularny vyraz
        Matcher match = pattern.matcher(instrukcia);

        if(match.find()){
        
            prvyPrikaz = match.group(1);                                            //priradenie prvej casti
            druhyPrikaz = match.group(2);                                           //priradenie druhej casti
            System.out.println(prvyPrikaz + ":COND(" + druhyPrikaz + ":" + instrukcia + ",EMPTYOP)");
         parser.parse(prvyPrikaz + ":COND(" + druhyPrikaz + ":" + instrukcia + ",EMPTYOP)");     //upravenie kodu ktory sa zacne znovu parsovat
        }
    }

    @Override
    String regexp() {
        return "^LOOP[(](.*),(.*)[)]$";
    }

    @Override
    Boolean platnost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

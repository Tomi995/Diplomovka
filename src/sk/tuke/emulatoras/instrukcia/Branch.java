/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.emulatoras.instrukcia;

import emulatoras.Instrukcia;
import emulatoras.MyParserException;
import emulatoras.Parser;
import emulatoras.Zasobnik;
import emulatoras.ZasobnikException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Tomi
 */
public class Branch extends Instrukcia {

    @Override
    public void vykonaj(String instrukcia) throws MyParserException {

        Parser parser = new Parser();                                              //vytvorenie parsera

        String rozhodnutiePravdivosti = "";                                     //premenna pre pravdivostnu hodnotu v zasobniku
        String prvyPrikaz;
        String druhyPrikaz;

        instrukcia = instrukcia.replaceAll("\\s", "");                          //odstranenie bielych znakov
        instrukcia = instrukcia.toUpperCase();                                  //zmena na velke pismena

        if (!Zasobnik.getZasobnik().jeCislo()) {                            //zistenie ci je v zasobniku bool hodnota
            rozhodnutiePravdivosti = Zasobnik.getZasobnik().vyber();        //vyberie hodnotu zo zasobnika a vlozi do premennej
        }
        
        Pattern pattern = Pattern.compile(regexp());                            //pattern pre regularny vyraz
        Matcher match = pattern.matcher(instrukcia);

        if (match.find()) {
            prvyPrikaz = match.group(1);                                            //priradenie prvej casti
            druhyPrikaz = match.group(2);                                           //priradenie druhej casti

            if (rozhodnutiePravdivosti.equals("tt")) {                          //rozhodnutie true alebo false a zavolanie parsera na danu cast kodu
                parser.parse(prvyPrikaz);
            } else {
                parser.parse(druhyPrikaz);
            }
        }
    }

    @Override
    public String regexp() {
        return "^BRANCH[(](.*),(.*)[)]$";
    }

    @Override
    public String platnost() {

        return "^BRANCH[(](.*),(.*)[)]$";


    }
}

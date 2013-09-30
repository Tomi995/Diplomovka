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
public class Push extends Instrukcia {

    /**
     * vykonanie funkcie PUSH
     *
     * @param instrukcia
     */
    @Override
    void vykonaj(String instrukcia) {
        int index = 0;                                                          //premenna pre index v pocte znamienok
        int pocetMinus = 0;                                                     //pocet minusov pred vyrazom 
        int hodnota;                                                            //vysledok

        instrukcia = instrukcia.replaceAll("\\s", "");                          //nahradenie vsetkych medzier v hodnote
        instrukcia = instrukcia.toUpperCase();
        
        Pattern pattern = Pattern.compile(regexp());                            //pattern pre regex
        Matcher match = pattern.matcher(instrukcia);

        if (match.find()) {
            hodnota = Integer.parseInt(match.group(3));                         //vyparsovanie hodnoty (int) zo stringu
            String znamienka = match.group(1);                                  //vlozenie stringu so znamienkami do premennej

            while (index != znamienka.length()) {                               //cyklus na spocitanie vsetkych minusov
                if (znamienka.charAt(index) == '-') {
                    pocetMinus++;
                }
                index++;
            }

            while (pocetMinus > 1) {                                            //cyklus na zistenie ci bude hodnota kladna alebo zaporna
                pocetMinus = pocetMinus - 2;
            }
            try{
          if (pocetMinus == 1) {                                              //priradi vyslednej hodote znamienko a vlozi do zasobnika
                Zasobnik.getZasobnik().vloz(-hodnota);
            } else {
                Zasobnik.getZasobnik().vloz(hodnota);
            }
            }catch(ZasobnikException ex){}
        }else
        {
            try {
                throw new MyParserException("Chybna instrukcia "+ instrukcia);
            } catch (MyParserException ex) {
                Logger.getLogger(Push.class.getName()).log(Level.SEVERE, null, ex);
            }
}
    }

    @Override
    String regexp() {
        return "^PUSH-[(]*(([-]|[+])*)([0-9]+)[)]*$";
    }


    @Override
    String platnost() {
         return "^PUSH-[(]*(([-]|[+])*)([0-9]+)[)]*$";
   }
}

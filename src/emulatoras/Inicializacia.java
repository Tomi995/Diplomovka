/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Tomi
 */
public class Inicializacia {

    public String iniciiuj(String text) throws MyParserException {

        if (kontrola(text)) {                                   // pe vyhladanie syntaktickych chyb....bude treba funkciu ako v parsery
            hladaj(text);
            System.out.println("preslo parserom");             //text na zmazanie
        }
        return null;

    }

    /**
     * vyhlada v zadanom kode vsetky premenne (fetch, store) a vytvori z nich
     * list
     *
     * @param text
     * @return
     */
    public String hladaj(String text) {

        String vstupnytext = text.toUpperCase();
        List<String> vsetky_premenne = new ArrayList<>();         // list do ktoreho sa ulozia vsetky premenne


        Pattern pattern = Pattern.compile("(FETCH-|STORE-)([A-Z])+");   //regex pre vyhladavanie
        Matcher match = pattern.matcher(vstupnytext);

        while (!match.hitEnd()) {
            if (match.find()) {

                int index = 6;
                String premenna = "";
                while (index != match.group().length()) {
                    premenna = premenna + match.group().charAt(index);              // vlozenie slovnej premenne nie iba pismenko
                    index++;
                }
                vsetky_premenne.add(premenna);

            }
        }
        
        System.out.println(vsetky_premenne);      //text na zmazanie
        return null;
    }

    /**
     * Zisti ci je vlozeny kod syntakticky spravny
     *
     * @param text
     * @return
     * @throws MyParserException
     */
    public Boolean kontrola(String text) throws MyParserException {        
        String vstupnytext = text.toUpperCase();                                // bude treba celu prerobit kedze nekurzija nefunguje

        Integer index = 0;

        String pomocny = "(ADD|MULT|SUB|TRUE|FALSE|EQ|LE|AND|NEG|EMPTYOP|PUSH-(-|[+])*[0-9]+|(FETCH-|STORE-[A-Z]+)|BRANCH[(]\\1,\\1[)]|LOOP[(],[)])+";
        String regex = "^(ADD|MULT|SUB|TRUE|FALSE|EQ|LE|AND|NEG|EMPTYOP|PUSH-(-|[+])*[0-9]+|(FETCH-|STORE-[A-Z]+)|BRANCH[(]" + pomocny + "," + pomocny + "[)]|LOOP[(]" + pomocny + "," + pomocny + "[)])+$";


        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(vstupnytext);

        if (match.find()) {
            return true;
        } else {
            throw new MyParserException("chybny kod!");
        }

    }

    /**
     * list premennych vlozi do stavu nula a priradi im pociatocne hodnoty
     *
     * @param vsetky_premenne
     * @return
     */
    public  String vlozDoStavu(List<String> vsetky_premenne) {
        Stav inicializacia = new Stav();
        Integer n = 0;
        while (vsetky_premenne.size() != n) {
            inicializacia.vlozPremennu(vsetky_premenne.get(n), null); // treba este vyriesit vlozenie hodnoty
            n++;
        }
        return null;

    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Tomi
 */
public class Inicializacia {

    public String iniciiuj(String text) throws MyParserException {

        if (kontrola(text)) {
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
        ArrayList<Character> vsetky_premenne = new ArrayList<Character>();


        Pattern pattern = Pattern.compile("(FETCH-|STORE-)[A-Z]");
        Matcher match = pattern.matcher(vstupnytext);

        while (!match.hitEnd()) {
            if (match.find()) {
                if (!vsetky_premenne.contains(match.group().charAt(match.group().length() - 1))) {
                    vsetky_premenne.add(match.group().charAt(match.group().length() - 1));
                }
            }
        }
        vlozDoStavu(vsetky_premenne);
        System.out.println(vlozDoStavu(vsetky_premenne));      //text na zmazanie
        return null;
    }

    public Boolean kontrola(String text) throws MyParserException {
        String vstupnytext = text.toUpperCase();

        Integer index = 0;
        
        String pomocny ="(ADD|MULT|SUB|TRUE|FALSE|EQ|LE|AND|NEG|EMPTYOP|PUSH-(-|[+])*[0-9]+|(FETCH-|STORE-[A-Z]+)|BRANCH[(]\\1,\\1[)]|LOOP[(],[)])+";
        String regex = "^(ADD|MULT|SUB|TRUE|FALSE|EQ|LE|AND|NEG|EMPTYOP|PUSH-(-|[+])*[0-9]+|(FETCH-|STORE-[A-Z]+)|BRANCH[(]"+pomocny+","+pomocny+"[)]|LOOP[(]"+pomocny+","+pomocny+"[)])+$";
        
        
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(vstupnytext);
        
        if (match.find()) {
            System.out.println(match.group());
            System.out.println(pattern.toString());
            return true;
        } else {
           throw new MyParserException( "chybny kod!");
        }

    }

    /**
     * list premennych vlozi do stavu nula a priradi im pociatocne hodnoty
     *
     * @param vsetky_premenne
     * @return
     */
    public String vlozDoStavu(ArrayList<Character> vsetky_premenne) {
        Stav inicializacia = new Stav();
        Integer n = 0;
        while (vsetky_premenne.size() != n) {
            inicializacia.vlozPremennu(vsetky_premenne.get(n).toString(), 4); // treba este vyriesit vlozenie hodnoty
            n++;
        }
        return null;

    }
}

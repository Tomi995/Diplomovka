/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

import java.util.Hashtable;

/**
 *
 * @author Tomi
 */
abstract public class Instrukcia {

    /**
     * vykonanie danej instrukcie
     *
     * @param instrukcia
     */
    public abstract void vykonaj(String instrukcia) throws MyParserException;

    /**
     * regularny vyraz pre danu instrukciu
     *
     * @return
     */
    public abstract String regexp();

    public abstract String platnost(); //v povodnom plane sluzilo na zistenie platnosti, asi to uz nevyuzije po zmene navrhu ale este to tu nechavam zmazem az na koniec
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

/**
 *
 * @author Tomi
 */
abstract public class Instrukcia {

 /**
 *vykonanie danej instrukcie 
 * @param instrukcia 
 */
    public abstract void vykonaj(String instrukcia);
/**
 * regularny vyraz pre danu instrukciu
 * @return 
 */
    public abstract String regexp();

    public abstract String platnost(); //v povodnom plane sluzilo na zistenie platnosti, asi to uz nevyuzije po zmene navrhu ale este to tu nechavam zmazem az na koniec
}

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

    abstract void vykonaj(String instrukcia);

    abstract String regexp();

    abstract Boolean platnost(); //domysliet 
}

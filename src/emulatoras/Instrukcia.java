/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

import java.util.Hashtable;

/**
 * Abstraktná trieda pre všetky inštrukcie.
 *
 * @author Tomi
 */
abstract public class Instrukcia {

    /**
     * Vykonanie danej inštrukcie.
     *
     * @param instrukcia
     */
    public abstract void vykonaj(String instrukcia) throws MyParserException;

    /**
     * Regularny výraz pre danú inštrukciu.
     *
     * @return
     */
    public abstract String regexp();
}

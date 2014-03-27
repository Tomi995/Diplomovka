/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras.instrukcia;

import emulatoras.Instrukcia;
import emulatoras.MyParserException;

/**
 *
 * @author Tomi
 */
public class EmptyOp extends Instrukcia {
    
    /**
     * Vykonanie inštrukcie EMPTYOP.
     * @param instrukcia
     * @throws MyParserException 
     */
    @Override
    public void vykonaj(String instrukcia) throws MyParserException {
        // prazdna operacia nic sa neudeje
    }
/**
 * Regulárny výraz pre funkciu EMPTYOP.
 * @return 
 */
    @Override
    public String regexp() {
        return "^EMPTYOP$";
    }
}

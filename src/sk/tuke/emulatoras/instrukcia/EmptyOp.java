/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.emulatoras.instrukcia;

import emulatoras.Instrukcia;

/**
 *
 * @author Tomi
 */
public class EmptyOp extends Instrukcia{

    @Override
    public void vykonaj(String instrukcia) {
                                                                                  // prazdna operacia nic sa neudeje
    }

    @Override
    public String regexp() {
   return "^EMPTYOP$";
    }

 

    @Override
    public String platnost() {
    return "^EMPTYOP$";
    }
    
}

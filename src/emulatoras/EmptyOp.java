/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

/**
 *
 * @author Tomi
 */
public class EmptyOp extends Instrukcia{

    @Override
    void vykonaj(String instrukcia) {
                                                                                  // prazdna operacia nic sa neudeje
    }

    @Override
    String regexp() {
   return "^EMPTYOP$";
    }

 

    @Override
    String platnost() {
    return "^EMPTYOP$";
    }
    
}

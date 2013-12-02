/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class StavException extends MyParserException {

    public StavException() {
    }

    public StavException(String sprava) {
        message = sprava;
        System.out.println("Stav exception: " + sprava);
    }
}

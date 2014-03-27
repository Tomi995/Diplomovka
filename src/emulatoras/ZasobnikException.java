/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

/**
 *
 * @author Tomi
 */
public class ZasobnikException extends MyParserException {

    private String message;

    public ZasobnikException() {
    }

    public ZasobnikException(String sprava) {
        message = sprava;
        System.out.println("ZásobníkException: " + sprava);
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
}

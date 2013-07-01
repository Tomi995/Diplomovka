/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

/**
 *
 * @author Tomi
 */
public class ZasobnikException extends Exception {

    public ZasobnikException() {
    }

    public ZasobnikException(String sprava) {
        System.out.println(sprava);
        System.exit(0);

    }
}

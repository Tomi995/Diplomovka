/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

/**
 *
 * @author Tomi
 */
public class MyParserException extends Exception{
    public MyParserException(){}
    
    public MyParserException(String chyba){
        System.out.println(chyba);
        System.exit(0);                         //v pripade chyby sa cely program zastavi, nema zmysel aby pokracoval
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.emulatoras.instrukcia;

import emulatoras.Instrukcia;
import emulatoras.Zasobnik;
import emulatoras.ZasobnikException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Neg extends Instrukcia {

    @Override
    public void vykonaj(String instrukcia) {
        String vysledok = "";                                                   //premenna pre vysledok
        try {                                                    
            if (!Zasobnik.getZasobnik().jeCislo()) {                            //zisti ci hodnota v zasobniku nie jecislo a vlozi ju do premennej
                String hodnota = Zasobnik.getZasobnik().vyber();
                if (hodnota == "tt") {                                          //zisti aka je hodnota v premennej a vrati jej negaciu
                    vysledok = "FALSE";
                } else {
                    vysledok = "TRUE";
                }
            }
            Zasobnik.getZasobnik().vloz(vysledok);                              //vlozi vysledok do zasobnika
        } catch (ZasobnikException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public String regexp() {
        return "^NEG$";
    }


    @Override
    public String platnost() {
    return "^NEG$"; 
    }
}
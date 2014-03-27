/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras.instrukcia;

import emulatoras.Instrukcia;
import emulatoras.MyParserException;
import emulatoras.Zasobnik;
import emulatoras.ZasobnikException;


/**
 *
 * @author Tomi
 */
public class Eq extends Instrukcia {

    /**
     * Vykonanie inštrukcie EQ.
     * @param instrukcia
     * @throws MyParserException 
     */
    @Override
    public void vykonaj(String instrukcia) throws MyParserException {
        Boolean prveJeCislo = false;                                            //premenna na urcenie ci je prve cislo v zasobniku cislo alebo Bool hodnota
        Boolean druheJeCislo = false;                                           //premenna na urcenie ci je druhe cislo v zasobniku cislo alebo Bool hodnota

        if (Zasobnik.getZasobnik().jeCislo()) {                             //zistenie ci je prve cislo cislo alebo hodnota a pridelenie do premennej
            prveJeCislo = true;
        }
        String prvaHodnota = Zasobnik.getZasobnik().vyber();                //vybratie prveho cisla zo zasobnika aby sa dalo overit druhe
        if (Zasobnik.getZasobnik().jeCislo()) {
            druheJeCislo = true;                                            //zistenie ci je prve cislo cislo alebo hodnota a pridelenie do premennej
        }
        String druhaHodnota = Zasobnik.getZasobnik().vyber();               //vybratie druhej hodnoty zo zasobnika

        if (prveJeCislo && druheJeCislo) {                                  //ak su obe hodnoty cisla porovna ich a vlozi vysledok do zasobnika
            if (prvaHodnota.equals(druhaHodnota)) {
                Zasobnik.getZasobnik().vloz("TRUE");
            } else {
                Zasobnik.getZasobnik().vloz("FALSE");
            }
        } else if ((!prveJeCislo) && (!druheJeCislo)) {                            //ak su obe hodnoty Bool tak ich porovna a vysledok vlozi do zasobnika
            if (prvaHodnota.equals(druhaHodnota)) {
                Zasobnik.getZasobnik().vloz("TRUE");
            } else {
                Zasobnik.getZasobnik().vloz("FALSE");
            }
        } else {
            throw new ZasobnikException("Zla hodnota v zasobniku pre instrukciu EQ");             //exception ak su v zasobniku rozdielne typy hodnot (int bool)
        }
        
    }
    /**
     * Regulárny výraz pre funkciu EQ.
     * @return 
     */
    @Override
    public String regexp() {
        return "^EQ$";
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.emulatoras.instrukcia;

import emulatoras.Instrukcia;
import emulatoras.Zasobnik;
import emulatoras.ZasobnikException;

/**
 *
 * @author Tomi
 */
public class And extends Instrukcia{
/**
 * vykonanie instrukcie AND
 * @param instrukcia 
 */
    @Override
    public void vykonaj(String instrukcia) {
        String prvaHodnota;                             //premenna pre prvu hodnotu
        String druhaHodnota;                            //premenna pre druhu hodnotu
        String vysledok;                                //premenna pre vysledok

        try {
            if (!Zasobnik.getZasobnik().jeCislo()) {                            //overenie ci nie je prve cislo v zasobniku cislo
                prvaHodnota = Zasobnik.getZasobnik().vyber();                   //priradenie hodnoty do premennej a vybratie zo zasobnika (deje sa v zasobniku)
            } else {
                throw new ZasobnikException("Zla hodnota v zasobniku");
            }
            if (!Zasobnik.getZasobnik().jeCislo()) {                            //overenie ci nie je druhe cislo v zasobniku cislo
                druhaHodnota = Zasobnik.getZasobnik().vyber();                  //priradenie hodnoty do premennej a vybratie zo zasobnika (deje sa v zasobniku)
            } else {
                throw new ZasobnikException("Zla hodnota v zasobniku");
            }
            if("tt".equals(prvaHodnota) && "tt".equals(druhaHodnota))                     //vyhodnotenie 
            {vysledok = "TRUE";
                    }
            else
            {vysledok = "FALSE";
            }
            
            Zasobnik.getZasobnik().vloz(vysledok);                              //vlozenie do zasobnika
        } catch (ZasobnikException ex) {                                        //zachytenie exceptionu
            System.out.println(ex);
        }   
    
    }

    @Override
    public String regexp() {
        return "^AND$";
    }

    @Override
    public String platnost() {
    return "^AND$";
    }

    
    
}

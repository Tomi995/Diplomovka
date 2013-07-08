/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

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
    void vykonaj(String instrukcia) {
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
    String regexp() {
        return "^AND$";
    }

    @Override
    Boolean platnost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

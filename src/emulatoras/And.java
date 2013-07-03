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

    @Override
    void vykonaj(String instrukcia) {
        String prvaHodnota;
        String druhaHodnota;
        String vysledok;

        try {
            if (!Zasobnik.getZasobnik().jeCislo()) {
                prvaHodnota = Zasobnik.getZasobnik().vyber();
            } else {
                throw new ZasobnikException("Zla hodnota v zasobniku");
            }
            if (!Zasobnik.getZasobnik().jeCislo()) {
                druhaHodnota = Zasobnik.getZasobnik().vyber();
            } else {
                throw new ZasobnikException("Zla hodnota v zasobniku");
            }
            if(prvaHodnota == "tt" && druhaHodnota == "tt") 
            {vysledok = "TRUE";
                    }
            else
            {vysledok = "FALSE";
            }
            
            Zasobnik.getZasobnik().vloz(vysledok);
        } catch (ZasobnikException ex) {
            System.out.println(ex);
        }   
    
    }

    @Override
    String regexp() {
        return "AND";
    }

    @Override
    Boolean platnost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

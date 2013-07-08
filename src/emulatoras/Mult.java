/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

/**
 *
 * @author Tomi
 */
public class Mult extends Instrukcia {

    /**
     * vykonanie instrukcie Mult
     *
     * @param instrukcia
     */
    @Override
    void vykonaj(String instrukcia) {
        int prveCislo = 0;                                                      //premenna pre prvu hodnotu
        int druheCislo = 0;                                                     //premenna pre druhu hodnotu
        int vysledok;                                                           //vysledok

        try {
            if (Zasobnik.getZasobnik().jeCislo()) {                             //overi ci je prve cislo v zasobniku cislo, priradi ho do premennej a vyhodi zo zasobnika
                prveCislo = Integer.parseInt(Zasobnik.getZasobnik().vyber());
            } else {
                throw new ZasobnikException("Zla hodnota v zasobniku");
            }
            if (Zasobnik.getZasobnik().jeCislo()) {                             //overi ci je druhe cislo v zasobniku cislo, prideli ho do premennej a vyberie zo zasobnika
                druheCislo = Integer.parseInt(Zasobnik.getZasobnik().vyber());
            } else {
                throw new ZasobnikException("Zla hodnota v zasobniku");
            }
            vysledok = prveCislo * druheCislo;                                  //vypocita vysledok a vlozi ho do zasobnika
            Zasobnik.getZasobnik().vloz(vysledok);
        } catch (ZasobnikException ex) {
            System.out.println(ex);
        }

    }

    @Override
    String regexp() {
        return "^MULT$";
    }

    @Override
    Boolean platnost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

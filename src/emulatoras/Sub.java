/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

/**
 *
 * @author Tomi
 */
public class Sub extends Instrukcia{
/**
 * vykonanie instrukcie SUB
 * @param instrukcia 
 */
    @Override
    void vykonaj(String instrukcia) {
     int prveCislo = 0;                                                         //premenna pre prve cislo
        int druheCislo = 0;                                                     //premenna pre druhe cislo
        int vysledok;                                                           //premenna pre vysledok

        try {
            if (Zasobnik.getZasobnik().jeCislo()) {                             //zisti ci je cislo v zasobniku cislo, vyberie ho a vlozi do premennej
                prveCislo = Integer.parseInt(Zasobnik.getZasobnik().vyber());
            } else {
                throw new ZasobnikException("Zla hodnota v zasobniku");
            }
            if (Zasobnik.getZasobnik().jeCislo()) {                             //zisti ci ej druhe cislo v zasobniku cislo,vyberie ho a vlozi do premennej
                druheCislo = Integer.parseInt(Zasobnik.getZasobnik().vyber());
            } else {
                throw new ZasobnikException("Zla hodnota v zasobniku");
            }
            vysledok = prveCislo - druheCislo;                                  //vypocita a vysledok vlozi do zasobnika
            Zasobnik.getZasobnik().vloz(vysledok);
        } catch (ZasobnikException ex) {
            System.out.println(ex);
        }

    }

    @Override
    String regexp() {
        return "^SUB$";
    }

    @Override
    Boolean platnost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

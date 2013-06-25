/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

import java.util.ArrayList;

/**
 *
 * @author Tomi
 */
public class Zasobnik {

    public static Zasobnik ref;
    ArrayList<String> zasobnik = new ArrayList<String>();

    private Zasobnik() {
    }

    /**
     * vytvori len jeden zasobnik ak nie je, ak existuje vrati nan odkaz
     *
     * @return
     */
    public static Zasobnik getZasobnik() {
        if (ref == null) {
            ref = new Zasobnik();
        }
        return ref;
    }

    /**
     * vyberie hodnotu na vrchole zasobnika a vymaze ju
     *
     * @return
     */
    public String vyber() {
        String navratova_hodnota;
        if (!zasobnik.isEmpty()) {

            navratova_hodnota = zasobnik.get(zasobnik.size() - 1);
            zasobnik.remove(zasobnik.size() - 1);
        } else {
            navratova_hodnota = null;
        }
        return navratova_hodnota;
    }

    /**
     * vlozi do zasobnika cislo
     *
     * @param cislo
     */
    public void vloz(Integer cislo) {
        zasobnik.add(cislo.toString());
    }

    /**
     * vlozi do zasobnika hodnotu true a false
     *
     * @param text
     */
    public void vloz(String text) {
        text = text.toUpperCase();
        if (text.equals("TRUE")) {
            zasobnik.add("tt");
        } else if (text.equals("FALSE")) {
            zasobnik.add("ff");
        } else {
            System.out.println("neplatna hodnota"); //osetrit co sa stane ak vlozim text ale nie bool hodnotu
        }
    }

    /**
     * zisti ci na vrchu zasobnika je cislo
     *
     * @return
     */
    public Boolean jeCislo() {
        String vrchZasobnika = zasobnik.get(zasobnik.size() - 1);
        try {
            Integer.parseInt(vrchZasobnika);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
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
    public String vyber() throws ZasobnikException {
        String navratova_hodnota;
        if (!zasobnik.isEmpty()) {

            navratova_hodnota = zasobnik.get(zasobnik.size() - 1);
            zasobnik.remove(zasobnik.size() - 1);
        } else {
            throw new ZasobnikException("Prazdny zasobnik");
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
    public void vloz(String text) throws ZasobnikException {
        text = text.toUpperCase();
        if (text.equals("TRUE")) {
            zasobnik.add("tt");
        } else if (text.equals("FALSE")) {
            zasobnik.add("ff");
        } else {
            throw new ZasobnikException("Hodnota je nepodporovana pre zasobnik");
        }
    }

    /**
     * zisti ci na vrchu zasobnika je cislo
     *
     * @return
     */
    public Boolean jeCislo() throws ZasobnikException, IndexOutOfBoundsException {

        try {
            String vrchZasobnika = zasobnik.get(zasobnik.size() - 1);

            try {
                Integer.parseInt(vrchZasobnika);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;

        } catch (IndexOutOfBoundsException e) {
            throw new ZasobnikException("Prazdny zasobnik");
        }

    }
}
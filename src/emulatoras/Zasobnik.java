/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

import java.util.ArrayList;

/**
 * Spravovanie zásobníka.
 * @author Tomi
 */
public class Zasobnik {

    public static Zasobnik ref;                                 //premenna pre referenciu
    ArrayList<String> zasobnik = new ArrayList<String>();       //list prezentujuci zasobnik

    
    private Zasobnik() {
    }

    /**
     * Vytvorí len jeden zásobník ak neexistuje, v opačnom prípade vráti odkaz.
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
     * Vyberie hodnotu na vrchole zásobníka a vymaže ju.
     *
     * @return
     */
    public String vyber() throws ZasobnikException {
        String navratova_hodnota;                                       //navratova hodnota
        if (!zasobnik.isEmpty()) {                                      //ak zasobnik nie je prazdny vrati hodnotu na vrchole zasobnika a vymaze ju odtial

            navratova_hodnota = zasobnik.get(zasobnik.size() - 1);
            zasobnik.remove(zasobnik.size() - 1);
        } else {
            throw new ZasobnikException("V zásobníku je málo hodnôt pre vykonanie");            //ak je zasobnik prazdny vytcori exception
        }
        return navratova_hodnota;
    }

    /**
     * Vloží na vrchol zásobníka číslo.
     *
     * @param cislo
     */
    public void vloz(Integer cislo) throws ZasobnikException {
        try {

            zasobnik.add(cislo.toString());                     //zmeni cislo na string a vlozi ho do zasobnika

        } catch (NullPointerException ex) {
            throw new ZasobnikException("Premenná neexistuje");
        }
    }

    /**
     * Vloží na vrchol zásobníka logickú hodnotu.
     *
     * @param text
     */
    public void vloz(String text) throws ZasobnikException {
        text = text.toUpperCase();
        if (text.equals("TRUE")) {                  //zisti ci je vlozena hodnota true a ak ano vlozi do zasobnika tt
            zasobnik.add("tt");
        } else if (text.equals("FALSE")) {          //zisti ci je vlozena hodnota false a ak ano vlozi do zasobnika ff
            zasobnik.add("ff");
        } else {
            throw new ZasobnikException("Hodnota je nepodporovaná pre zásobník");   // vytvori exception ak sa snazim vlozit nieco ine
        }
    }

    /**
     * Zistí, či na vrchole zásobníka je číslo
     *
     * @return
     */
    public Boolean jeCislo() throws ZasobnikException, IndexOutOfBoundsException {

        try {
            String vrchZasobnika = zasobnik.get(zasobnik.size() - 1);  //vlozi do premennej hodnotu na vrchole zasobnika

            try {
                Integer.parseInt(vrchZasobnika);    //pokusi sa string zmenit na integer ak je operacia uspesna vrati true ak nie vyvola exception a vrati false
            } catch (NumberFormatException e) {
                return false;
            }
            return true;

        } catch (IndexOutOfBoundsException e) {
            throw new ZasobnikException("Málo premenných v zásobníku");            //exception ak je prazdny zasobnik
        }

    }

    /**
     * Vymaže zásobník.
     */
    public void vymaz() {
        zasobnik.clear();
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author Tomi
 */
public class Vykonavanie {

    public static Vykonavanie ref;                                 //premenna pre referenciu
    private List<Krok> kroky = new ArrayList<Krok>();

    private Vykonavanie() {
    }

    /**
     * vytvori
     *
     * @return
     */
    public static Vykonavanie getInstance() {
        if (ref == null) {
            ref = new Vykonavanie();
        }
        return ref;
    }

    public void addKrok(String name, int cislo_stavu, String[] premenne, String[] zasobnik) {
        Krok krok = new Krok();
        krok.setName(name);
        krok.setPremenne(premenne);
        krok.setStav(cislo_stavu);
        krok.setZasobnik(zasobnik);
        kroky.add(krok);
    }

    /**
     * @return the kroky
     */
    public List<Krok> getKroky() {
        return kroky;
    }

    public void clear() {
        kroky.clear();
    }
}

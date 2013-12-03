/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

/**
 *
 * @author Lenovo
 */
public class Krok {

    private String name;
    private String[] zasobnik;
    private String[] premenne;
    private int stav;


    @Override
    public String toString() {
        return getName();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the zasobnik
     */
    public String[] getZasobnik() {
        return zasobnik;
    }

    /**
     * @param zasobnik the zasobnik to set
     */
    public void setZasobnik(String[] zasobnik) {
        this.zasobnik = zasobnik;
    }

    /**
     * @return the premenne
     */
    public String[] getPremenne() {
        return premenne;
    }

    /**
     * @param premenne the premenne to set
     */
    public void setPremenne(String[] premenne) {
        this.premenne = premenne;
    }

    /**
     * @return the stav
     */
    public int getStav() {
        return stav;
    }

    /**
     * @param stav the stav to set
     */
    public void setStav(int stav) {
        this.stav = stav;
    }
}

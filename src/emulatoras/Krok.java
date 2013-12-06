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
    private String vypis;
    private Boolean inicializovanyStavNula;

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
    
    public String[] stringPreVypis(int index,Boolean inicializovanyStavNula){
        setInicializovanyStavNula(inicializovanyStavNula);
        String[] pole = new String[8];
        String vypis = "" ;
        pole[7]="";
        pole[6]="";
        
        if (index == 0) {
            for (Krok krok : Vykonavanie.getInstance().getKroky()) {
                vypis += krok.getName() + ":";
            }

            vypis = (String) vypis.subSequence(0, vypis.length() - 10);
            pole[7] = vypis;
            pole[6]="---------------------------------------------------------------";
        }
       Krok krok = Vykonavanie.getInstance().getKroky().get(index);
        pole[5] = krok.getName();
       
        if(inicializovanyStavNula){
        pole[4] = "Číslo stavu : s" + (krok.getStav()-1);
        }else{
        pole[4] = "Číslo stavu : s" + krok.getStav();
        }
        
        
        vypis = "Zaobnik pred vykonanim: ";
        String[] z = krok.getZasobnik();
        if (!z.equals("")) {
            int i = z.length;
            for (String zasobnik : z) {
                vypis += zasobnik + "; ";
                --i;
            }
        } else {
            vypis += "Prazdny zasobnik";
        }

        pole[3] = vypis;

        vypis = "Zasobnik po vykonani: ";
        if(index != Vykonavanie.getInstance().getKroky().size()-1){
        z = Vykonavanie.getInstance().getKroky().get(index + 1).getZasobnik();
        if (!z.equals("")) {
            int i = z.length;
            for (String zasobnik : z) {
                vypis += zasobnik + "; ";
                --i;
            }
        } else {
            vypis += "Prazdny zasobnik";
        }
        }else{
        z = Vykonavanie.getInstance().getKroky().get(index).getZasobnik();
        if (!z.equals("")) {
            int i = z.length;
            for (String zasobnik : z) {
                vypis += zasobnik + "; ";
                --i;
            }
        } else {
            vypis += "Prazdny zasobnik";
        }}

        pole[2] = vypis;

        vypis = "Premenne v stave: ";

        if (!krok.getPremenne().equals("")) {
            int i = 0;
            for (String premenna : krok.getPremenne()) {
                vypis +="[" + premenna+"]" + "; ";
                i++;
            }
        } else {
            vypis += "Ziadne premenne v danom stave";
        }

        pole[1] = vypis;
        pole[0] = "---------------------------------------------------------------";

        return pole;
    }

    /**
     * @return the inicializovanyStavNula
     */
    public Boolean getInicializovanyStavNula() {
        return inicializovanyStavNula;
    }

    /**
     * @param inicializovanyStavNula the inicializovanyStavNula to set
     */
    public void setInicializovanyStavNula(Boolean inicializovanyStavNula) {
        this.inicializovanyStavNula = inicializovanyStavNula;
    }
}

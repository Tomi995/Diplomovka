/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

import emulatoras.instrukcia.Push;
import emulatoras.instrukcia.Sub;
import emulatoras.instrukcia.Branch;
import emulatoras.instrukcia.Mult;
import emulatoras.instrukcia.Store;
import emulatoras.instrukcia.False;
import emulatoras.instrukcia.EmptyOp;
import emulatoras.instrukcia.Eq;
import emulatoras.instrukcia.Fetch;
import emulatoras.instrukcia.Loop;
import emulatoras.instrukcia.Neg;
import emulatoras.instrukcia.True;
import emulatoras.instrukcia.And;
import emulatoras.instrukcia.Le;
import emulatoras.instrukcia.Add;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Rozdelí vstupný kód na úseky medzi ":" a vykoná jednotlivé inštrukcie
 *
 * @author Tomi
 */
public class Parser  {

    private List<Instrukcia> instrukcie = new ArrayList<Instrukcia>();
    private Boolean inicializaciaStavov;
    final String sipka = " \u21A6 ";
    
    public Parser() {
        instrukcie.add(new Add());           //vlozenie vsetkych regexp do listu
        instrukcie.add(new And());
        instrukcie.add(new Branch());
        instrukcie.add(new EmptyOp());
        instrukcie.add(new Eq());
        instrukcie.add(new False());
        instrukcie.add(new Fetch());
        instrukcie.add(new Le());
        instrukcie.add(new Mult());
        instrukcie.add(new Neg());
        instrukcie.add(new Push());
        instrukcie.add(new Store());
        instrukcie.add(new Sub());
        instrukcie.add(new True());
        instrukcie.add(new Loop());
       
    }
/**
 * Rozdelí vstupný kód a vykoná ho.
 * @param kod
 * @throws MyParserException 
 */
    public void parse(String kod) throws MyParserException {

        kod = kod.replaceAll("\\s", "");          //nahradi vsetky biele miesta
        kod = kod.toUpperCase();                 //zmeni male pismena na velke

        String prikaz = "";                     //prikaz na spracovanie
        char c = ' ';                           //nacitany znak kodu
        int index = 0;                          //aktualny index znaku v kode
        int lavaZatvorka = 0;                   //pocet lavych zatvoriek
        int pravaZatvorka = 0;                  //pocet pravych zatvoriek

        while (!kod.isEmpty()) {                    //cyklus na prejdenie celeho kodu
            if (index < kod.length()) {             // osetrenie ukoncenia kodu, je to bez : treba zabezpecit ukoncenie cyklu a vykonanie
                c = kod.charAt(index);
                if (c == ':') {                     //nacitanie : znamena vykonanie prikazu
                    vykonaj(prikaz);
                    prikaz = "";
                    index++;
                } else {
                    if (c == '(') {                 //nacitanie ( spusti cyklus na nacitanie parametra medzi ()
                        prikaz = prikaz + c;
                        lavaZatvorka++;
                        index++;
                        try {
                            while (lavaZatvorka != pravaZatvorka) {             //cyklus nacitania parametra medzi zatvorkami, pocet lavych a pravych zatvoriek musi sediet v opacnom pripade exception
                                c = kod.charAt(index);

                                if (c == '(') {                             //pripocitanie lavej zatvorky
                                    lavaZatvorka++;
                                    prikaz = prikaz + c;
                                    index++;
                                } else {
                                    if (c == ')') {                         //pripocitanie pravej zatvorky
                                        pravaZatvorka++;
                                        prikaz = prikaz + c;
                                        index++;
                                    } else {                                 // ak sa nacita znak
                                        prikaz = prikaz + c;
                                        index++;
                                    }
                                }
                            }
                        } catch (Exception e) {                               //exception ak su zle zadane zatvorky
                            throw new MyParserException("Zle ozátvorkované: " + prikaz);
                        }
                    } else {                                                 //nacitanie znaku kodu a pridanie do prikazu
                        prikaz = prikaz + c;
                        index++;
                    }
                }
            } else {                                                         //vykonanie posledneho prikazu kodu
                vykonaj(prikaz);
                break;
            }
        }
    }

    /**
     * 
     * @param prikaz
     * @throws MyParserException 
     */
    public void vykonaj(String prikaz) throws MyParserException {                            //vykonanie prikazu
        prikaz = prikaz.toUpperCase();                              //potrebujem dorobit......
        prikaz = prikaz.replaceAll("\\s", "");

        for (Instrukcia instr : instrukcie) {
            Pattern pattern = Pattern.compile(instr.regexp());                            //pattern pre regex
            Matcher match = pattern.matcher(prikaz);

            if (match.find()) {
                log(prikaz);
                // tu sa prikaz vykona
                instr.vykonaj(prikaz);
                
            }
        }
    }

    
    public void log(String prikaz) {
        // ulozime si data PO
        Vykonavanie vykonavanie = Vykonavanie.getInstance();
        Zasobnik z = Zasobnik.getZasobnik();
        Stav s = new Stav();
        int i;

        String[] zasobnik_po = {"Prázdny zásobník"};
        if (!z.zasobnik.isEmpty()) {
            zasobnik_po = new String[z.zasobnik.size()];
            i = z.zasobnik.size();
            for (String zasobnik : z.zasobnik) {
                zasobnik_po[--i] = zasobnik;
            }
        }
        
        
         int stav_po = s.stavy.size();
         
         String[] premenne_po = {"Žiadne premenné"};
         

     //   if (stav_po > 0) {
          if (!s.stavy.isEmpty()) {
            Hashtable<String, Integer> premenne = s.stavy.get(stav_po - 1);
            premenne_po = new String[premenne.size()];
            i = 0;
            for (String key : premenne.keySet()) {
                premenne_po[i++] = key + sipka + premenne.get(key);
            }
        }

        vykonavanie.addKrok(prikaz, stav_po, premenne_po, zasobnik_po);
    }

    /**
     * @return the inicializaciaStavov
     */
    public Boolean getInicializaciaStavov() {
        return inicializaciaStavov;
    }

    /**
     * @param inicializaciaStavov the inicializaciaStavov to set
     */
    public void setInicializaciaStavov(Boolean inicializaciaStavov) {
        this.inicializaciaStavov = inicializaciaStavov;
    }
}

/*
 * 
 * push-1:push-2:false:cond(push-0:push-2:store-c:pu
sh-1:push-1,push-100:push-10000)
 */
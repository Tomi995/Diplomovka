/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

import sk.tuke.emulatoras.instrukcia.Push;
import sk.tuke.emulatoras.instrukcia.Sub;
import sk.tuke.emulatoras.instrukcia.Branch;
import sk.tuke.emulatoras.instrukcia.Mul;
import sk.tuke.emulatoras.instrukcia.Store;
import sk.tuke.emulatoras.instrukcia.False;
import sk.tuke.emulatoras.instrukcia.EmptyOp;
import sk.tuke.emulatoras.instrukcia.Eq;
import sk.tuke.emulatoras.instrukcia.Fetch;
import sk.tuke.emulatoras.instrukcia.Loop;
import sk.tuke.emulatoras.instrukcia.Neg;
import sk.tuke.emulatoras.instrukcia.True;
import sk.tuke.emulatoras.instrukcia.And;
import sk.tuke.emulatoras.instrukcia.Le;
import sk.tuke.emulatoras.instrukcia.Add;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Amalyzuje vstupný kód, zistí lexikálne chyby a vyhľadá všetky premenné
 * použité vo vstupnom kóde.
 *
 * @author Tomi
 */
public class Analyza {

    // zoznam vsetkych instrukcii
    private List<Instrukcia> instrukcie = new ArrayList<Instrukcia>();
    // list vsetkych premennych
    private List<String> vsetky_premenne = new ArrayList<>();
    private Stav inicializacia = new Stav();

    public Analyza() {
        instrukcie.add(new Add());                  //vlozenie vsetkych regexp do listu
        instrukcie.add(new And());
        instrukcie.add(new Branch());
        instrukcie.add(new EmptyOp());
        instrukcie.add(new Eq());
        instrukcie.add(new False());
        instrukcie.add(new Fetch());
        instrukcie.add(new Le());
        instrukcie.add(new Mul());
        instrukcie.add(new Neg());
        instrukcie.add(new Push());
        instrukcie.add(new Store());
        instrukcie.add(new Sub());
        instrukcie.add(new True());
        instrukcie.add(new Loop());
    }

    /**
     * Po úspešnom vykonaní syntaktickej kontroly spustí vyhľadávanie
     * premenných.
     *
     * @param text
     * @throws MyParserException
     */
    public void iniciuj(String text) throws MyParserException {
        if (kontrola(text)) {
            hladaj(text);
        }
    }

    /**
     * Vyhľadá vo vstupnom kóde všetky premenné (fetch-x, store-x) a vytvorí z
     * nich list
     *
     * @param text
     * @return
     */
    public void hladaj(String text) {
        String vstupnytext = text.toUpperCase();
        Pattern pattern = Pattern.compile("(FETCH-|STORE-)(([A-Z])+)");   //regex pre vyhladavanie
        Matcher match = pattern.matcher(vstupnytext);

        while (!match.hitEnd()) {
            if (match.find()) {
                String premenna = match.group(2);
                if (!vsetky_premenne.contains(premenna)) {
                    getVsetky_premenne().add(premenna);
                }
            }
        }
    }

    /**
     * Zistí, či je vložený kód syntakticky správny.
     *
     * @param text
     * @return
     * @throws MyParserException
     */
    public Boolean kontrola(String kod) throws MyParserException {
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
                    skontroluj(prikaz);
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
                            throw new MyParserException("Zle ozatvorkovane :" + prikaz);
                        }
                    } else {                                                 //nacitanie znaku kodu a pridanie do prikazu
                        prikaz = prikaz + c;
                        index++;
                    }
                }
            } else {                                                         //vykonanie posledneho prikazu kodu
                skontroluj(prikaz);
                break;
            }
        }

        return true;
    }

    /**
     * List premenných vloží do stavu nula a priradí im počiatočné hodnoty.
     *
     * @param vsetkypremenne
     * @return
     */
    public void vlozDoStavu(String premenna, int hodnota) {
        getInicializacia().vlozPremennu(premenna, hodnota);
    }

    /**
     * Otestuje každý vložený príkaz, či je syntakticky správny.
     *
     * @param prikaz
     * @throws MyParserException
     */
    private void skontroluj(String prikaz) throws MyParserException {

        prikaz = prikaz.toUpperCase();
        prikaz = prikaz.replaceAll("\\s", "");
        Boolean skontrolovane = false;                                              //premenna ci sa dany prikaz vykona

        for (Instrukcia instr : instrukcie) {
            Pattern pattern = Pattern.compile(instr.regexp());                            //pattern pre regex každej inštrukcie
            Matcher match = pattern.matcher(prikaz);

            if (match.find()) {
                if (instr.regexp().startsWith("^COND") || instr.regexp().startsWith("^LOOP")) {     // tieto prikazy obsahuju postupnost dalsych tak treba skontrolovat aj tie
                    if (!(kontrola(match.group(1)) && kontrola(match.group(2)))) {
                        throw new MyParserException("chyba v prikaze");
                    }
                }
                System.out.println("kontrola  " + prikaz);
                skontrolovane = true;
            }
        }
        if (!skontrolovane) {
            throw new MyParserException("Syntakticka chyba : " + prikaz);
        }
    }

    /**
     * Vráti všetky premenné.
     *
     * @return the vsetky_premenne
     */
    public List<String> getVsetky_premenne() {
        return vsetky_premenne;
    }

    /**
     * Vymaže všetky premenné.
     */
    public void resetVsetky_premenne() {
        this.vsetky_premenne.clear();
    }

    /**
     * Vrati inicializačný stav.
     *
     * @return the inicializacia
     */
    public Stav getInicializacia() {
        return inicializacia;
    }
}

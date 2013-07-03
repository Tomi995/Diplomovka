/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

import java.util.ArrayList;
import java.util.List;

/**
 *rozparsuje prikazy na useky pedzi : ale ponecha vsetky parametre za rikazom ako napr loop-(add:sub,store-x)
 * @author Tomi
 */
public class Parser {

    public Parser() {
    }

    public void parse(String kod) {
       kod = kod.replaceAll("\\s","");          //nahradi vsetky biele miesta
        
        String prikaz = "";                     //prikaz na spracovanie
        char c = ' ';                           //nacitany znak kodu
        int index = 0;                          //aktualny index znaku v kode
        int lavaZatvorka = 0;                   //pocet lavych zatvoriek
        int pravaZatvorka = 0;                  //pocet pravych zatvoriek



        try {
            while (!kod.isEmpty()) {                    //cyklus na prejdenie celeho kodu
                if (index < kod.length()) {             // osetrenie ukoncenia kodu, je to bez : treba zabezpecit ukoncenie cyklu a vykonanie
                    c = kod.charAt(index);
                    if (c == ':') {                     //nacitanie : znamena vykonanie prikazu
                        System.out.println("vykonanie kodu: " + prikaz);
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
                    System.out.println("vykonanie kodu: " + prikaz);
                    break;
                }
            }
        } catch (MyParserException e) {                                          //zachytenie exceptionu 
        }


    }
}

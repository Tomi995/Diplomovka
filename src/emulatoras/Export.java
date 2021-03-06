/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Export krokovaného programu do samostatného súboru.
 *
 * @author Tomi
 */
public class Export {

    private String adresa;

     public Export(String vstupny_text) throws MyParserException{
         if( "".equals(vstupny_text.trim()) )
             throw new MyParserException("Prázdny projekt");
     };
    
    public void ExportObycajny(Boolean inicializovaneStavy) throws IOException {
        Krok krok = new Krok();

       

        JFileChooser saveFile = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text file (*.txt)", "txt");
        saveFile.setFileFilter(filter);
        saveFile.showSaveDialog(null);
        adresa = saveFile.getSelectedFile().getAbsoluteFile().toString();
        if (!kontrolaPripony(adresa)) {
            adresa += ".txt";
        }
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(getAdresa()));
            for (int index = 0; index < Vykonavanie.getInstance().getKroky().size(); index++) {
                String[] slova = krok.stringPreVypis(index, inicializovaneStavy);
                String slovo;
                int posunVypisu = 0;
                if (index != 0) {
                    posunVypisu = 2;
                }
                for (int i = (slova.length - 1) - posunVypisu; i > -1; i--) {
                    slovo = slova[i];
                    writer.write(slovo);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
       
        } finally {

            if (writer != null) {
                writer.close();
            }
        }
    }

    /**
     * Vráti adresu súboru.
     *
     * @return the adresa
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Nastaví adresu súboru.
     *
     * @param adresa the adresa to set
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /**
     * Skontroluje príponu v názve súboru. Zabráni duplikácii.
     *
     * @param nazov
     * @return
     */
    private Boolean kontrolaPripony(String nazov) {
        String regexp = ".txt$";
        Pattern pattern = Pattern.compile(regexp);
        Matcher match = pattern.matcher(nazov);
        if (match.find()) {
            return true;
        }
        return false;
    }
    
     public void ExportPoRiadkoch(Boolean inicializovaneStavy) throws IOException {
        Krok krok = new Krok();

       

        JFileChooser saveFile = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text file (*.txt)", "txt");
        saveFile.setFileFilter(filter);
        saveFile.showSaveDialog(null);
        adresa = saveFile.getSelectedFile().getAbsoluteFile().toString();
        if (!kontrolaPripony(adresa)) {
            adresa += ".txt";
        }
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(getAdresa()));
            for (int index = 0; index < Vykonavanie.getInstance().getKroky().size(); index++) {
                String[] slova = krok.stringPreVypis(index, inicializovaneStavy);
                String slovo;
                int posunVypisu = 0;
                if (index != 0) {
                    posunVypisu = 2;
                }
                
                for (int i = (slova.length - 1) - posunVypisu; i > -1; i--) {
                   if(i == 7){
                    if(index == 0){
                   
                       for(int z = 0; z < slova[7].length();z++){
                           writer.write(slova[7].charAt(z));
                           if(slova[7].charAt(z) == ':' || slova[7].charAt(z) =='(' || slova[7].charAt(z) == ','){
                               writer.newLine();
                           } 
                       }writer.newLine();
                    }
                   }
                    if(i != 7){
                    slovo = slova[i];
                    writer.write(slovo);
                    writer.newLine();
                }
                }
            }
        } catch (IOException e) {
        } finally {

            if (writer != null) {
                writer.close();
            }
        }
    }
    
}

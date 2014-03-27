/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;

/**
 *Uloženie projektu.
 * @author Tomi
 */
public class Save {

    private String adresa = "";

    public Save() {
    }

    /**
     * Ulozenie projektu do znamej adresy.
     * @param text
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void save(String text) throws FileNotFoundException, IOException {
        text = text.toUpperCase();
        text = text.replaceAll("\\s", "");
        if (getAdresa().equalsIgnoreCase("")) {
            JFileChooser saveFile = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Abstract Machine (*.txt)", "txt");
            saveFile.setFileFilter(filter);
            saveFile.showSaveDialog(null);
            adresa = saveFile.getSelectedFile().getAbsoluteFile().toString() + ".txt";
            this.setAdresa(adresa);
        }
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(getAdresa()));
            writer.write(text);
        } catch (IOException e) {
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
    /**
     * Uloženie projektu s možnoťou výberu umietnenia a vyberu nazvu.
     * @param text
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void saveAs(String text) throws FileNotFoundException, IOException {
        text = text.toUpperCase();
        text = text.replaceAll("\\s", "");
        JFileChooser saveFile = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Abstract Machine (*.txt)","txt");
        saveFile.setFileFilter(filter);
        saveFile.showSaveDialog(null);
        adresa = saveFile.getSelectedFile().getAbsoluteFile().toString();
        if (!kontrolaPripony(adresa)){
            adresa += ".txt";
        }
        
        this.setAdresa(adresa);
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(adresa));
            writer.write(text);
        } catch (IOException e) {
        } finally {

            if (writer != null) {
                writer.close();
            }
        }
    }

    /**
     * Vrati adresu ulozenia.
     * @return the adresa
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Nastaví adresu uloženia.
     * @param adresa the adresa to set
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    
    /**
     * Skontroluje priponu ukladaného súboru.
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
}
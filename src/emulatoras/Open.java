/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Otvorenie uloženého projektu.
 *
 * @author Tomi
 */
public class Open {

    private String kod;
    private String adresa;

    /**
     * Otvorí súbor zo zvoleného adresára.
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @throws NullPointerException
     */
    public Open() throws FileNotFoundException, IOException, NullPointerException {

        JFileChooser openFile = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Abstract Machine (*.txt)", "txt");
        openFile.setFileFilter(filter);
        openFile.showOpenDialog(null);
        FileReader reader;
        setAdresa(openFile.getSelectedFile().getAbsolutePath().toString());
        reader = new FileReader(getAdresa());
        BufferedReader br = new BufferedReader(reader);
        setKod(br.readLine());

    }

    /**
     * Vráti kód.
     *
     * @return the kod
     */
    public String getKod() {
        return kod;
    }

    /**
     * Nastaví kód.
     *
     * @param kod the kod to set
     */
    public void setKod(String kod) {
        this.kod = kod;
    }

    /**
     * vráti adresu otváraného súboru.
     *
     * @return
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Uloží adresu otváraného súboru.
     *
     * @param adresa the adresa to set
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}

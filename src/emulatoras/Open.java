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
 *
 * @author Tomi
 */
public class Open {

    private String kod;
    private String adresa;

    public Open() throws FileNotFoundException, IOException, NullPointerException {

        JFileChooser openFile = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Abstract Machine (*.am*.txt)", "am","txt");
        openFile.setFileFilter(filter);
        openFile.showOpenDialog(null);
        FileReader reader;
        setAdresa(openFile.getSelectedFile().getAbsolutePath().toString());
        reader = new FileReader(getAdresa());
        BufferedReader br = new BufferedReader(reader);
        setKod(br.readLine());

    }

    /**
     * @return the kod
     */
    public String getKod() {
        return kod;
    }

    /**
     * @param kod the kod to set
     */
    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getAdresa() {
        return adresa;
    }

    /**
     * @param adresa the adresa to set
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Tomi
 */
public class Export {
    
    public Export() throws IOException{
        Krok krok = new Krok();
        
        System.out.println();
    
        JFileChooser saveFile = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text file (*.txt)", "txt");
        saveFile.setFileFilter(filter);
        saveFile.showSaveDialog(null);
        String adresa = saveFile.getSelectedFile().getAbsoluteFile().toString() + ".txt";
       
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(adresa));
            
            
            for(int index = 0; index < Vykonavanie.getInstance().getKroky().size();index ++){
            
            String[] slova = krok.stringPreVypis(index); 
            for (String slovo : slova) {
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
    
    
}

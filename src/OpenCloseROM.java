import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.filechooser.*;
import java.util.ArrayList;
import java.io.File;

public class OpenCloseROM {

  byte[] OpenedRom;

  public void openROM(){
    String romPath;

    try{
            JFileChooser fc = new JFileChooser();

            FileNameExtensionFilter gbaFilter = new FileNameExtensionFilter("GBA File", "gba");
            fc.setFileFilter(gbaFilter);
            //only shows files with ".gba" suffix

            int returnVal = fc.showOpenDialog(null);
            if (returnVal==JFileChooser.APPROVE_OPTION){
                File romFile = fc.getSelectedFile();


                //get data from selected save file
                romPath = romFile.getAbsolutePath();
                FileInputStream ist = new FileInputStream(romPath);

                OpenedRom = new byte[ist.available()];
                ist.read(OpenedRom,0,ist.available());
                ist.close();
                //TODO Add a "loading..." message so user knows program isn't frozen
            }
        } catch (java.lang.StringIndexOutOfBoundsException jsioobe){
            JOptionPane.showMessageDialog(null,"Error reading file!");
        } catch (NullPointerException npe){
            JOptionPane.showMessageDialog(null,"No filename given!\n"+npe);
        } catch (FileNotFoundException fnfe){
            JOptionPane.showMessageDialog(null,"ROM could not be read!");
        } catch (IOException ioe){
            JOptionPane.showMessageDialog(null,"I/O problem! : "+ioe);
        }
}

  public void saveROM() {

    // create an object of JFileChooser class
    JFileChooser fc = new JFileChooser();

    FileNameExtensionFilter gbaFilter = new FileNameExtensionFilter("GBA File", "gba");
    fc.addChoosableFileFilter(gbaFilter);
    fc.setFileFilter(gbaFilter);

    // invoke the showsSaveDialog function to show the save dialog
    int r = fc.showSaveDialog(null);

    // if the user selects a file
    if (r == JFileChooser.APPROVE_OPTION)
    {
        String filePath = fc.getSelectedFile().getAbsolutePath();
        if(!filePath.endsWith(".gba")){
            filePath += ".gba";
        }

        System.out.println(filePath);


        try {
            FileOutputStream os = new FileOutputStream(filePath);
            os.write(OpenedRom);
            os.close();
            JOptionPane.showMessageDialog(null, "File saved successfully!");
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "There was an error while saving:\n" + ioe);
        }
    }
}
  
}
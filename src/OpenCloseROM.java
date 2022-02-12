import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;

import javax.swing.filechooser.*;

public class OpenCloseROM {

  private byte[] OpenedRom;
  boolean correcthash;


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
              //checking hash value of the FireRed Pokemon file and adjust the labels in "ROM Information"
                checkFireRedHash();
                ist.close();
                
              

               
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

      EditRom ed = new EditRom(OpenedRom);
      TrainerPokemon tP = new TrainerPokemon(ed);
      tP.randomizeAllTrainerPokemon("All");

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
//checking the hash on Fire Red Pokemon Version file
	 private void checkFireRedHash(){
	        try{
	        	
	            MessageDigest file_breakdown = MessageDigest.getInstance("MD5");
	            file_breakdown.update(OpenedRom, 0, OpenedRom.length);
	            String hash = new java.math.BigInteger(1,file_breakdown.digest()).toString(16);

	            if (!hash.equals("e26ee0d44e809351c8ce2d73c7400cdd")){
	                JOptionPane.showMessageDialog(null, "WARNING: The base ROM does not match the target ROM "+
	                        "this program was intended for!\n\nMD5: " + hash + "\nExpected: "+
	                        "e26ee0d44e809351c8ce2d73c7400cdd","Invalid base ROM!",JOptionPane.WARNING_MESSAGE);
	            }else {
	            	correcthash = true;
	            }
	        } catch (java.security.NoSuchAlgorithmException nsae){
	            JOptionPane.showMessageDialog(null, "Error loading Hash type!","Hash Error",JOptionPane.ERROR_MESSAGE);
	        }
	    }
  
}

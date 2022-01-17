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

public class OpenROMTest {

    public static void main(String[] args) {
        testFrame tf = new testFrame();

    }
}

class testFrame extends JFrame {
    
    private Container container;
    private JButton btnOpen;
    private JButton btnSave;
    byte[] OpenedRom;

    public testFrame() {

    // Set up frame
    setTitle("Pokemon Randomizer");
    setBounds(300, 90, 600, 400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);

    container = getContentPane();
    container.setLayout(null);

    btnOpen = new JButton(new AbstractAction("Open") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //code

                // // create an object of JFileChooser class
                // JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    
                // // invoke the showsOpenDialog function to show the save dialog
                // int r = j.showOpenDialog(null);
                
                // File file = j.getSelectedFile();
                // readFile(file);

                openROM();
                String strROM = OpenedRom.toString();

                StringBuilder sb = new StringBuilder();
                for (byte b : OpenedRom) {
                    sb.append(String.format("%02X ", b));
                }
                System.out.println(sb.toString());

                // for (byte b : OpenedRom) {
                //     System.out.println(b);
                // }
            }   
        });
        btnOpen.setFont(new Font("Century Gothic", Font.BOLD, 15));
        btnOpen.setSize(125, 20);
        btnOpen.setLocation(100, 250);
        container.add(btnOpen);


    btnSave = new JButton(new AbstractAction("Save") {
        @Override
        public void actionPerformed(ActionEvent e) {
            //code
            saveROM();
        }   
    });
    btnSave.setFont(new Font("Century Gothic", Font.BOLD, 15));
    btnSave.setSize(125, 20);
    btnSave.setLocation(400, 250);
    container.add(btnSave);

    // set frame to visible
    setVisible(true);
    }


public void readFile(File fileName) {
    try {

        Scanner inputFile = new Scanner(fileName);
        ArrayList<String> text = new ArrayList<>();

        while(inputFile.hasNext()) {
            int i = 1;
            String info = inputFile.nextLine();
            text.add(info);
            System.out.println(i);
            i++;
        }

        for (String str : text) {
            System.out.println(str);
        }
        

    } catch (IOException e) {
        e.printStackTrace();
    }
}

public void openROM(){
    String romPath;

    try{
            JFileChooser fc = new JFileChooser();
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

                FileNameExtensionFilter gbaFilter = new FileNameExtensionFilter("GBA File", "*.gba");
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
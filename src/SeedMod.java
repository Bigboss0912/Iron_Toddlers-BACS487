import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeedMod implements ActionListener {
	JFrame frmseedmod = new JFrame();
	JButton DoneButton;
	private JTextField SeedField;
	Randomizer parentClass;
	
	SeedMod(Randomizer parentClass){
		this.parentClass = parentClass;
		//Forms Initiation
		frmseedmod.setTitle("Seed Modification");
		frmseedmod.setSize(710, 275);
		frmseedmod.setVisible(true);
		frmseedmod.getContentPane().setLayout(null);
		
		
		DoneButton = new JButton("Done");
		DoneButton.setBounds(538, 185, 94, 23);
		DoneButton.addActionListener(this);
		frmseedmod.getContentPane().add(DoneButton);
		
		
		JLabel InfoLabel = new JLabel("Enter a Seed value shared from a friend below. Value must be a number.");
		InfoLabel.setBounds(24, 22, 710, 23);
		frmseedmod.getContentPane().add(InfoLabel);
		
		JLabel RandomLabel = new JLabel("Random Seed:");
		RandomLabel.setBounds(34, 64, 117, 23);
		frmseedmod.getContentPane().add(RandomLabel);
		
		SeedField = new JTextField();
		SeedField.setBackground(Color.WHITE);
		SeedField.setEditable(true);
		SeedField.setBounds(161, 65, 471, 20);
		frmseedmod.getContentPane().add(SeedField);
		SeedField.setColumns(10);
	
		
		
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		//Done Buttons
		if(event.getSource()==DoneButton) {
			Randomizer.FinalRandomSeed = Long.parseLong(SeedField.getText());
			System.out.println(Double.parseDouble(SeedField.getText()));
			this.parentClass.addToSumTextField("Current Randomization Seed: " + Randomizer.FinalRandomSeed + "\n");
			frmseedmod.dispose();
			
		}
		
	}
}

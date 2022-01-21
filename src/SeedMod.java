import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeedMod implements ActionListener {
	JFrame frmseedmod = new JFrame();
	JButton DoneButton;
	private JTextField SeedField;
	private JTextField ConfigField;
	
	SeedMod(){
		
		//Forms Initiation
		frmseedmod.setTitle("Seed Modification");
		frmseedmod.setSize(710, 275);
		frmseedmod.setVisible(true);
		frmseedmod.getContentPane().setLayout(null);
		
		
		DoneButton = new JButton("Done");
		DoneButton.setBounds(538, 185, 94, 23);
		DoneButton.addActionListener(this);
		frmseedmod.getContentPane().add(DoneButton);
		
		JButton LoadButton = new JButton("Load File");
		LoadButton.setBounds(82, 185, 163, 23);
		frmseedmod.getContentPane().add(LoadButton);
		
		JLabel InfoLabel = new JLabel(" Below are the setting to produce the same randomization product that you did! Share it with friends!");
		InfoLabel.setBounds(24, 22, 710, 23);
		frmseedmod.getContentPane().add(InfoLabel);
		
		JLabel RandomLabel = new JLabel("Random Seed:");
		RandomLabel.setBounds(34, 64, 117, 23);
		frmseedmod.getContentPane().add(RandomLabel);
		
		JLabel ConfigLabel = new JLabel("File Config String:");
		ConfigLabel.setBounds(24, 103, 127, 23);
		frmseedmod.getContentPane().add(ConfigLabel);
		
		SeedField = new JTextField();
		SeedField.setBackground(Color.WHITE);
		SeedField.setEditable(false);
		SeedField.setBounds(161, 65, 471, 20);
		frmseedmod.getContentPane().add(SeedField);
		SeedField.setColumns(10);
		
		
		ConfigField = new JTextField();
		ConfigField.setBackground(Color.WHITE);
		ConfigField.setEditable(false);
		ConfigField.setColumns(10);
		ConfigField.setBounds(161, 104, 471, 20);
		frmseedmod.getContentPane().add(ConfigField);
		
		JLabel OrLabel = new JLabel("Or you can load your current randomized file!");
		OrLabel.setBounds(24, 141, 482, 23);
		frmseedmod.getContentPane().add(OrLabel);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		//Done Buttons
		if(event.getSource()==DoneButton) {
			frmseedmod.dispose();
		}
		
	}
}

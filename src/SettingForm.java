
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingForm implements ActionListener {
	ButtonGroup buttonGroup = new ButtonGroup();
	JFrame frmsetting = new JFrame();
	JButton CancelButton,OK_Button;
	JCheckBox DefaultCheck,DarkCheck;
	
	SettingForm(){
		
		//Forms Initiation
		frmsetting.setTitle("Setting");
		frmsetting.setSize(500, 500);
		frmsetting.setVisible(true);
		frmsetting.getContentPane().setLayout(null);
		
		JPanel themePanel = new JPanel();
		themePanel.setBorder(new LineBorder(Color.BLACK));
		themePanel.setBounds(25, 33, 430, 85);
		frmsetting.getContentPane().add(themePanel);
		themePanel.setLayout(null);
		
		JLabel ThemeLabel = new JLabel("Theme:");
		ThemeLabel.setBounds(10, 11, 77, 14);
		ThemeLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		themePanel.add(ThemeLabel);
		
		DefaultCheck = new JCheckBox("Default  (Light)");
		buttonGroup.add(DefaultCheck);
		DefaultCheck.setBounds(20, 32, 121, 23);
		DefaultCheck.addActionListener(this);
		themePanel.add(DefaultCheck);
		
		DarkCheck = new JCheckBox("Dark");
		buttonGroup.add(DarkCheck);
		DarkCheck.setBounds(165, 32, 99, 23);
		DarkCheck.addActionListener(this);
		themePanel.add(DarkCheck);
		
		OK_Button = new JButton("OK");
		OK_Button.setBounds(293, 22, 115, 33);
		OK_Button.addActionListener(this);
		themePanel.add(OK_Button);
		
		CancelButton = new JButton("Cancel");
		CancelButton.setBounds(366, 405, 89, 31);
		CancelButton.addActionListener(this);
		frmsetting.add(CancelButton);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		//Cancel Buttons
		if(event.getSource()==CancelButton) {
			frmsetting.dispose();
		}
//		else if (event.getSource()==OK_Button) {
//			if (DarkCheck.isSelected() == true){
//				//theme is at dark
//
//
//				
//			}
//			else{
//				//theme is at default
//			}
//		}
		
	}
}
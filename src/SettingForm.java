
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;

public class SettingForm {
	ButtonGroup buttonGroup = new ButtonGroup();
	JFrame frmsetting = new JFrame();
	JButton CancelButton;
	JCheckBox DefaultCheck, DarkCheck;
	JFrame randomizer_frame;




	SettingForm(JFrame randomizer_theme) {
		this.randomizer_frame = randomizer_theme;

	}

	public void initialize_setting(){
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

		DefaultCheck = new JCheckBox("Default");
		buttonGroup.add(DefaultCheck);
		DefaultCheck.setBounds(20, 32, 121, 23);
		themePanel.add(DefaultCheck);

		DarkCheck = new JCheckBox("Dark");
		buttonGroup.add(DarkCheck);
		DarkCheck.setBounds(165, 32, 99, 23);
		themePanel.add(DarkCheck);


		CancelButton = new JButton(new AbstractAction("Cancel") {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmsetting.dispose();

			}
		});
		CancelButton.setBounds(366, 405, 89, 31);
		frmsetting.add(CancelButton);

		JButton OK_Button = new JButton(new AbstractAction("OK") {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (DarkCheck.isSelected() == true) {
					//theme is at dark
					randomizer_frame.getContentPane().setBackground(Color.lightGray);

				}
				if (DefaultCheck.isSelected() == true) {
					//theme is at default
					randomizer_frame.getContentPane().setBackground(new Color(238,238,238));
				}

			}
		});
		OK_Button.setBounds(293, 22, 115, 33);
		themePanel.add(OK_Button);

	}
}


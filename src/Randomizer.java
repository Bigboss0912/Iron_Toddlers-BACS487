import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import java.security.MessageDigest;


public class Randomizer {

	OpenCloseROM openCloseROM = new OpenCloseROM();
	private JFrame frmPokemon;

	public JLabel StatusValue, ROMValue;

	/**
	 * Create the application.
	 */
	public Randomizer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmPokemon = new JFrame();
		frmPokemon.setTitle("Pokemon Randomizer");
		frmPokemon.setSize(1000, 800);
		frmPokemon.setVisible(true);
		frmPokemon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * Action Panel Component
		 */
		JPanel ActionPanel = new JPanel();
		ActionPanel.setBorder(new LineBorder(Color.BLACK));
		

		// Open Button
		JButton OpenButton = new JButton(new AbstractAction("Open ROM File") {
			@Override
			public void actionPerformed(ActionEvent e) {
					//code
					openCloseROM.openROM();
					//checking hash value of file
					if (openCloseROM.correcthash == true) {
		            	ROMValue.setText("Pokemon-FireRed Version (USA)");
		            	StatusValue.setText("Success!!!");
		            	 //TODO Add a "loading..." message so user knows program isn't frozen
		                JOptionPane.showMessageDialog(null, "ROM Loaded Successfully!");
					}
			}   
	});

		//Close Button
		JButton SaveButton = new JButton(new AbstractAction("Save ROM File") {
			@Override
			public void actionPerformed(ActionEvent e) {
					//code
					openCloseROM.saveROM();
			}   
	});
		
		
		JButton SeedButton = new JButton("Seed Modification");

    
		JButton SettingButton = new JButton("Setting");
		JLabel ActionLabel = new JLabel("Actions:");
		ActionLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		ActionLabel.setBounds(10, 18, 68, 14);
		
		GroupLayout gl_ActionPanel = new GroupLayout(ActionPanel);
		gl_ActionPanel.setHorizontalGroup(
			gl_ActionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ActionPanel.createSequentialGroup()
					.addGroup(gl_ActionPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ActionPanel.createSequentialGroup()
							.addGap(23)
							.addComponent(ActionLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_ActionPanel.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_ActionPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(OpenButton, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
								.addComponent(SaveButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(SeedButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(SettingButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(31))
		);
		gl_ActionPanel.setVerticalGroup(
			gl_ActionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ActionPanel.createSequentialGroup()
					.addGap(27)
					.addComponent(ActionLabel)
					.addGap(18)
					.addComponent(OpenButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(SaveButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(SeedButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(SettingButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(61, Short.MAX_VALUE))
		);
		
		/**
		 * ROM Panel Component
		 */
		JPanel ROMPanel = new JPanel();
		ROMPanel.setBorder(new LineBorder(Color.BLACK));
	
		JLabel FileLabel = new JLabel("ROM File:");
		ROMValue = new JLabel("NONE LOADED");
		JLabel StatusLabel = new JLabel("Status:");
		StatusValue = new JLabel("Not Detected");
		JLabel FileInfoLabel = new JLabel("ROM File Information:");
		FileInfoLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		GroupLayout gl_ROMPanel = new GroupLayout(ROMPanel);
		gl_ROMPanel.setHorizontalGroup(
				gl_ROMPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_ROMPanel.createSequentialGroup()
						.addGap(23)
						.addGroup(gl_ROMPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_ROMPanel.createSequentialGroup()
								.addComponent(FileInfoLabel)
								.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE))
							.addGroup(gl_ROMPanel.createSequentialGroup()
								.addComponent(StatusLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(StatusValue, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
							.addGroup(gl_ROMPanel.createSequentialGroup()
								.addComponent(FileLabel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(ROMValue, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)))
						.addGap(22))
		);
		gl_ROMPanel.setVerticalGroup(
			gl_ROMPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ROMPanel.createSequentialGroup()
					.addGap(27)
					.addComponent(FileInfoLabel)
					.addGap(18)
					.addGroup(gl_ROMPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(FileLabel)
						.addComponent(ROMValue))
					.addGap(33)
					.addGroup(gl_ROMPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(StatusLabel)
						.addComponent(StatusValue))
					.addContainerGap(140, Short.MAX_VALUE))
		);
		
		
		/**
		 * Picture Label (Charmander)
		 */
		JLabel CharImgLabel = new JLabel();
		ImageIcon CharImg = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Charmander.png")));
		Image newImg = CharImg.getImage();
		Image setImg = newImg.getScaledInstance(240,240, Image.SCALE_SMOOTH);
		ImageIcon scaledImg = new ImageIcon(setImg);
		CharImgLabel.setIcon(scaledImg);
		
		//Tab component
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		/**
		 * Layout Component
		 */
		
		GroupLayout groupLayout = new GroupLayout(frmPokemon.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(tabbedPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 931, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(ActionPanel, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
							.addGap(32)
							.addComponent(ROMPanel, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(CharImgLabel, GroupLayout.PREFERRED_SIZE, 231, Short.MAX_VALUE)))
					.addGap(25))
		);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(30)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(ROMPanel, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
							.addComponent(CharImgLabel, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
							.addComponent(ActionPanel, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(30, Short.MAX_VALUE))
		);
		
		JPanel StarterTab = new JPanel();
		StarterTab.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Starter Pokemon", null, StarterTab, null);
		
		JPanel WildTab = new JPanel();
		WildTab.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Wild Pokemon", null, WildTab, null);
		
		JPanel FieldTab = new JPanel();
		FieldTab.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Field Items", null, FieldTab, null);
		
		JPanel StatsTabs = new JPanel();
		StatsTabs.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Pokemon Stats", null, StatsTabs, null);
		
		JPanel CompMovesTab = new JPanel();
		CompMovesTab.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Compatability & Moves", null, CompMovesTab, null);
		
		JPanel SummaryTab = new JPanel();
		SummaryTab.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Summary", null, SummaryTab, null);

		ROMPanel.setLayout(gl_ROMPanel);
		ActionPanel.setLayout(gl_ActionPanel);
		frmPokemon.getContentPane().setLayout(groupLayout);
		
		//Setting Button Action
		SettingButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SettingForm();
			}
		});
//		//Seed Modification Action
		SeedButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			new SeedMod();
		}
	});

	}
}
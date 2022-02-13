import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;


public class Randomizer {

	OpenCloseROM openCloseROM = new OpenCloseROM();
	private JFrame frmPokemon;
<<<<<<< Updated upstream
=======
	public JLabel StatusValue, ROMValue;
	private JTextField txtBoundFrom;
	private JTextField txtBoundTo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
>>>>>>> Stashed changes

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
		
		/**
		 * Frame configuration
		 */
		
		frmPokemon = new JFrame();
		frmPokemon.setTitle("Pokemon Randomizer");
		frmPokemon.setSize(1000, 800);
		frmPokemon.setVisible(true);
		frmPokemon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		/**
		 * Tab Panel
		 */
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		/**
		 * Starter and its component
		 */
		
		JPanel StarterTab = new JPanel();
		StarterTab.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Starter Pokemon", null, StarterTab, null);
		StarterTab.setLayout(null);
		
		JPanel RandomizePanel = new JPanel();
		RandomizePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		RandomizePanel.setBounds(25, 25, 411, 256);
		StarterTab.add(RandomizePanel);
		RandomizePanel.setLayout(null);
		
		JToggleButton tglButtonNoChange = new JToggleButton("No Change");
		buttonGroup.add(tglButtonNoChange);
		tglButtonNoChange.setBounds(105, 58, 161, 36);
		tglButtonNoChange.setToolTipText("No randomization will be made");
		RandomizePanel.add(tglButtonNoChange);
		
		JToggleButton tglButtonFul_Rand = new JToggleButton("Fully Randomized");
		buttonGroup.add(tglButtonFul_Rand);
		tglButtonFul_Rand.setBounds(105, 105, 161, 36);
		tglButtonFul_Rand.setToolTipText("Completely randomize the starter pokemon to be any possible pokemon");
		RandomizePanel.add(tglButtonFul_Rand);
		
		JToggleButton tglButtonThreeStg = new JToggleButton("Three Stage");
		buttonGroup.add(tglButtonThreeStg);
		tglButtonThreeStg.setBounds(105, 152, 161, 36);
		tglButtonThreeStg.setToolTipText("Randomize the starters to be any one of the first stage pokemon in a \n three stage evolution (ex. Geodude but not Graveler or Golem)");
		RandomizePanel.add(tglButtonThreeStg);
		
		JLabel StarterRandLabel = new JLabel("Press Buttons to Randomize your Option");
		StarterRandLabel.setBounds(10, 11, 380, 36);
		StarterRandLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		RandomizePanel.add(StarterRandLabel);
		
		JToggleButton exLegendButton = new JToggleButton("Exclude Legendaries");
		buttonGroup.add(exLegendButton);
		exLegendButton.setToolTipText("TBD");
		exLegendButton.setBounds(105, 199, 161, 36);
		RandomizePanel.add(exLegendButton);
		
		/**
		 * Starter Tab Level Panel
		 */
		
		JPanel LevelPanel = new JPanel();
		LevelPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		LevelPanel.setBounds(472, 25, 411, 256);
		StarterTab.add(LevelPanel);
		LevelPanel.setLayout(null);
		
		JLabel Boundlbl = new JLabel("Randomization Bound");
		Boundlbl.setBounds(20, 76, 161, 14);
		LevelPanel.add(Boundlbl);
		Boundlbl.setEnabled(false);
		
		JCheckBox ChckBxLevelRandom = new JCheckBox("Enable Level Randomization");
		ChckBxLevelRandom.setHorizontalAlignment(SwingConstants.LEFT);
		ChckBxLevelRandom.setBounds(20, 27, 262, 23);
		LevelPanel.add(ChckBxLevelRandom);
		ChckBxLevelRandom.setEnabled(false);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setBounds(177, 76, 37, 14);
		LevelPanel.add(lblFrom);
		lblFrom.setEnabled(false);
		
		
		txtBoundFrom = new JTextField();
		txtBoundFrom.setBounds(217, 73, 65, 20);
		LevelPanel.add(txtBoundFrom);
		txtBoundFrom.setEditable(false);
		txtBoundFrom.setColumns(10);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(290, 76, 30, 14);
		LevelPanel.add(lblTo);
		lblTo.setEnabled(false);
		
		txtBoundTo = new JTextField();
		txtBoundTo.setBounds(313, 73, 65, 20);
		LevelPanel.add(txtBoundTo);
		txtBoundTo.setEditable(false);
		txtBoundTo.setColumns(10);
		
		JToggleButton tglButtonLevelRandomization = new JToggleButton(new AbstractAction("Level Randomization") {
			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
                boolean selected = abstractButton.getModel().isSelected();
	            // if selected print selected in console
	            if (selected) {	            	
	            	try {
		            	String fromtext = txtBoundFrom.getText();
		            	String totext = txtBoundTo.getText();
		            	int fromnum = Integer.parseInt(fromtext);
		            	int tonum = Integer.parseInt(totext);
		            	
		            	txtBoundFrom.setEditable(false);
		            	txtBoundTo.setEditable(false);
		            	
		            	if (tonum <= fromnum) {
		            		throw new ArithmeticException(); 
		            	}
		            	
	            	}catch (NumberFormatException ex){
	            		txtBoundFrom.setText("");
		            	txtBoundTo.setText("");
		            	abstractButton.setSelected(false);
	            		JOptionPane.showMessageDialog (null, "Please enter only numbers");
	            	}
	            	catch (ArithmeticException e1){
	            		txtBoundFrom.setText("");
		            	txtBoundTo.setText("");
		            	txtBoundFrom.setEditable(true);
		            	txtBoundTo.setEditable(true);
		            	abstractButton.setSelected(false);
	            		JOptionPane.showMessageDialog (null, "'To' number is greater or equal to 'From' number");
	            	}
	            }
	            else {
            		txtBoundFrom.setEditable(true);
	            	txtBoundTo.setEditable(true);
	            	txtBoundTo.setText("");
	            	txtBoundFrom.setText("");
	            	
	            }
			}
		});
		
		tglButtonLevelRandomization.setBounds(217, 120, 161, 36);
		LevelPanel.add(tglButtonLevelRandomization);
		tglButtonLevelRandomization.setToolTipText("Randomize the starters initial level");
    	tglButtonLevelRandomization.setEnabled(false);
		
		JLabel LevelLabel = new JLabel("Press Button to Activate");
		LevelLabel.setBounds(20, 130, 161, 14);
		LevelLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		LevelPanel.add(LevelLabel);
		LevelLabel.setEnabled(false);
			
		
		/**
		 * Wild Tab 
		 */
		
		
		
		JPanel WildTab = new JPanel();
		WildTab.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Wild Pokemon", null, WildTab, null);
		
		/**
		 * Trainer Tab 
		 */
		
		JPanel TrainerPanel = new JPanel();
		TrainerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Trainer Teams", null, TrainerPanel, null);
		
		/**
		 * Field items Tab 
		 */
		
		JPanel FieldTab = new JPanel();
		FieldTab.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Field Items", null, FieldTab, null);
		
		/**
		 * Statistic Tab 
		 */
		JPanel StatsTabs = new JPanel();
		StatsTabs.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Pokemon Stats", null, StatsTabs, null);
		
		/**
		 * Moves Tab 
		 */
		
		JPanel CompMovesTab = new JPanel();
		CompMovesTab.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Compatability & Moves", null, CompMovesTab, null);
		
		/**
		 * Summary Tab 
		 */
		
		JPanel SummaryTab = new JPanel();
		SummaryTab.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Summary", null, SummaryTab, null);
		
		
		/**
		 * Action Panel Component
		 */
		
		JPanel ActionPanel = new JPanel();
		ActionPanel.setBorder(new LineBorder(Color.BLACK));
		
		JLabel ActionLabel = new JLabel("Actions:");
		ActionLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		ActionLabel.setBounds(10, 18, 68, 14);
		
		//Action Panel Buttons
		
		JButton SeedButton = new JButton(new AbstractAction("Seed Modification") {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (openCloseROM.correcthash == true){
					new SeedMod();
					}
				}   
		});
		SeedButton.setEnabled(false);
		
		JButton SettingButton = new JButton(new AbstractAction("Setting") {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (openCloseROM.correcthash == true){
					new SettingForm();
					}
				}   
		});
		SettingButton.setEnabled(false);
		
		//Save Button
		JButton SaveButton = new JButton(new AbstractAction("Randomize ROM File") {
			@Override
			public void actionPerformed(ActionEvent e) {
					//code
					openCloseROM.saveROM();
				}   
		});
		SaveButton.setEnabled(false);
		
		
		
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
		
		
		
		
		
		//StarterTab- RandomizePanel disabled unless hash value is correct
		
		Component [] RandomizePanel_list = RandomizePanel.getComponents();
		for (int i = 0; i < RandomizePanel_list.length; i++) {
			RandomizePanel_list[i].setEnabled(false);
		}
		
		// Open Button
		JButton OpenButton = new JButton(new AbstractAction("Open ROM File") {
			@Override
			public void actionPerformed(ActionEvent e) {
					//code
					openCloseROM.openROM();
<<<<<<< Updated upstream
			}   
=======
					if (openCloseROM.correcthash == true) {
		            	ROMValue.setText("Pokemon-FireRed Version (USA)");
		            	StatusValue.setText("Success!!!");
		            	//TODO Add a "loading..." message so user knows program isn't frozen
		                JOptionPane.showMessageDialog(null, "ROM Loaded Successfully!");
		                //enabling action panel
		                SeedButton.setEnabled(true);
						SaveButton.setEnabled(true);
						SettingButton.setEnabled(true);
						
						//enable starter tab randomize panel
						for (int i = 0; i < RandomizePanel_list.length; i++) {
							RandomizePanel_list[i].setEnabled(true);
						}
						//enabling starter tab level panel
						Boundlbl.setEnabled(true);
						ChckBxLevelRandom.setEnabled(true);
						lblFrom.setEnabled(true);
						lblTo.setEnabled(true);
						LevelLabel.setEnabled(true);
						
						
					}
				}  
>>>>>>> Stashed changes
	});

		/**
		 * Picture Label (Charmander)
		 */
		
		JLabel CharImgLabel = new JLabel();
		ImageIcon CharImg = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Charmander.png")));
		Image newImg = CharImg.getImage();
		Image setImg = newImg.getScaledInstance(240,240, Image.SCALE_SMOOTH);
		ImageIcon scaledImg = new ImageIcon(setImg);
		CharImgLabel.setIcon(scaledImg);
		
		
		
		
		ChckBxLevelRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ChckBxLevelRandom.isSelected()) {
	            	txtBoundFrom.setEditable(true);
	            	txtBoundTo.setEditable(true);
	            	tglButtonLevelRandomization.setEnabled(true);
				}
				else {
					txtBoundFrom.setText("");
					txtBoundTo.setText("");
					txtBoundFrom.setEditable(false);
	            	txtBoundTo.setEditable(false);
	            	tglButtonLevelRandomization.setSelected(false);
	            	tglButtonLevelRandomization.setEnabled(false);
				}
				
			}
		});
		
		/**
		 * All Layout component and configurations
		 */
		
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
		
<<<<<<< Updated upstream
		/**
		 * ROM Panel Component
		 */
		JPanel ROMPanel = new JPanel();
		ROMPanel.setBorder(new LineBorder(Color.BLACK));
	
		JLabel FileLabel = new JLabel("ROM File:");
		JLabel ROMValue = new JLabel("NONE LOADED");
		JLabel StatusLabel = new JLabel("Status:");
		JLabel StatusValue = new JLabel("Not Detected");
		JLabel FileInfoLabel = new JLabel("ROM File Information:");
		FileInfoLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
=======
>>>>>>> Stashed changes
		
		GroupLayout gl_ROMPanel = new GroupLayout(ROMPanel);
		gl_ROMPanel.setHorizontalGroup(
			gl_ROMPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ROMPanel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_ROMPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ROMPanel.createSequentialGroup()
							.addComponent(FileInfoLabel)
<<<<<<< Updated upstream
							.addPreferredGap(ComponentPlacement.RELATED, 136, Short.MAX_VALUE))
						.addGroup(gl_ROMPanel.createSequentialGroup()
							.addGroup(gl_ROMPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(FileLabel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addComponent(StatusLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_ROMPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(StatusValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(ROMValue, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))))
=======
							.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE))
						.addGroup(gl_ROMPanel.createSequentialGroup()
							.addComponent(StatusLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(StatusValue, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
						.addGroup(gl_ROMPanel.createSequentialGroup()
							.addComponent(FileLabel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ROMValue, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)))
>>>>>>> Stashed changes
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
		
		
<<<<<<< Updated upstream
		/**
		 * Picture Label (Charmander)
		 */
		JLabel CharImgLabel = new JLabel();
		ImageIcon CharImg = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Charmander.png")));
		Image newImg = CharImg.getImage();
		Image setImg = newImg.getScaledInstance(240,240, Image.SCALE_SMOOTH);
		ImageIcon scaledImg = new ImageIcon(setImg);
		CharImgLabel.setIcon(scaledImg);
		/**
		 * Layout Component
		 */
		
=======
>>>>>>> Stashed changes
		GroupLayout groupLayout = new GroupLayout(frmPokemon.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(ActionPanel, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
					.addGap(32)
					.addComponent(ROMPanel, GroupLayout.PREFERRED_SIZE, 289, Short.MAX_VALUE)
					.addGap(52)
					.addComponent(CharImgLabel, GroupLayout.PREFERRED_SIZE, 231, Short.MAX_VALUE)
					.addGap(25))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
<<<<<<< Updated upstream
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(CharImgLabel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(ROMPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
							.addComponent(ActionPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)))
					.addContainerGap(471, Short.MAX_VALUE))
		);

=======
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(ROMPanel, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
						.addComponent(CharImgLabel, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addComponent(ActionPanel, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		
		/**
		 * Adding panels to layout accordingly
		 */
>>>>>>> Stashed changes
		ROMPanel.setLayout(gl_ROMPanel);
		ActionPanel.setLayout(gl_ActionPanel);
		frmPokemon.getContentPane().setLayout(groupLayout);
		

	}
}
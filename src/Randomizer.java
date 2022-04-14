import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;



public class Randomizer {

	public JFrame frmPokemon;
	public JLabel StatusValue, ROMValue;
	private JTextField txtBoundFrom;
	private JTextField txtBoundTo;
	private final ButtonGroup Trainer_MainBtngrp = new ButtonGroup();
	private final ButtonGroup FieldItem_MainOptBtnGrp = new ButtonGroup();
	private final ButtonGroup MartBtngrp = new ButtonGroup();
	private final ButtonGroup Starter_MainBtngrp = new ButtonGroup();
	private final ButtonGroup Wild_MainBtngrp = new ButtonGroup();
	private final ButtonGroup StatTab_MainOptBtnGrp = new ButtonGroup();
	private final ButtonGroup StatTab_ExceptionBtnGrp = new ButtonGroup();
	
	



	private byte[] openedRom;

	

	OpenCloseROM openCloseROM = new OpenCloseROM();
	EditRom editRom = new EditRom();
	TrainerPokemon trainersPokemon = new TrainerPokemon();
	ItemModule itemModule = new ItemModule(editRom);
	StatsModule statsModule = new StatsModule();
	private JTextField delta_input;
	private JTextArea Sum_txtField;





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
		frmPokemon.setTitle("Pokemon Randomizer: Pokemon-FireRed Version (USA)");
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
		tglButtonNoChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Sum_txtField.append("Starter Tab: No Change\n");
			}
		});
		Starter_MainBtngrp.add(tglButtonNoChange);
		tglButtonNoChange.setBounds(105, 58, 161, 36);
		tglButtonNoChange.setToolTipText("No randomization will be made");
		RandomizePanel.add(tglButtonNoChange);

		JToggleButton tglButtonFul_Rand = new JToggleButton("Fully Randomized");
		tglButtonFul_Rand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Sum_txtField.append("Starter Tab: Fully Randomized\n");
			}
		});
		Starter_MainBtngrp.add(tglButtonFul_Rand);
		tglButtonFul_Rand.setBounds(105, 105, 161, 36);
		tglButtonFul_Rand.setToolTipText("Completely randomize the starter pokemon to be any possible pokemon");
		RandomizePanel.add(tglButtonFul_Rand);

		JToggleButton tglButtonThreeStg = new JToggleButton("Three Stage");
		tglButtonThreeStg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Sum_txtField.append("Starter Tab: Three Stage\n");
			}
		});
		Starter_MainBtngrp.add(tglButtonThreeStg);
		tglButtonThreeStg.setBounds(105, 152, 161, 36);
		tglButtonThreeStg.setToolTipText("Randomize the starters to be any one of the first stage pokemon in a \n three stage evolution (ex. Geodude but not Graveler or Golem)");
		RandomizePanel.add(tglButtonThreeStg);

		JLabel StarterRandLabel = new JLabel("Press Buttons to Randomize your Option");
		StarterRandLabel.setBounds(10, 11, 380, 36);
		StarterRandLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		RandomizePanel.add(StarterRandLabel);

		JToggleButton exLegendButton = new JToggleButton("Exclude Legendaries");
		exLegendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Sum_txtField.append("Starter Tab: Exclude Legendaries\n");
			}
		});
		Starter_MainBtngrp.add(exLegendButton);
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

		JToggleButton tglButtonLevelRandomization = new JToggleButton(new AbstractAction("Verify Levels") {
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

						if (tonum < fromnum) {
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
						JOptionPane.showMessageDialog (null, "'To' number is greater than 'From' number");
					}
				}
				else {
					txtBoundFrom.setEditable(true);
					txtBoundTo.setEditable(true);
					

				}
			}
		});

		tglButtonLevelRandomization.setBounds(217, 120, 161, 36);
		LevelPanel.add(tglButtonLevelRandomization);
		tglButtonLevelRandomization.setToolTipText("Randomize the starters initial level");
		tglButtonLevelRandomization.setEnabled(false);

		JLabel LevelLabel = new JLabel("Press Button to Activate");
		LevelLabel.setBounds(20, 130, 194, 14);
		LevelLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		LevelPanel.add(LevelLabel);
		LevelLabel.setEnabled(false);


		/**
		 * Wild Tab 
		 */



		JPanel WildTab = new JPanel();
		WildTab.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Wild Pokemon", null, WildTab, null);

		WildTab.setLayout(null);
		
		JLabel Openinglbl_Wild = new JLabel("Main Options:");
		Openinglbl_Wild.setFont(new Font("Tahoma", Font.BOLD, 16));
		Openinglbl_Wild.setBounds(33, 38, 112, 22);
		Openinglbl_Wild.setEnabled(false);
		WildTab.add(Openinglbl_Wild);
		
		
		JPanel MainOptPanel_Wild = new JPanel();
		MainOptPanel_Wild.setLayout(null);
		MainOptPanel_Wild.setBorder(new LineBorder(new Color(0, 0, 0)));
		MainOptPanel_Wild.setBounds(170, 38, 630, 308);
		WildTab.add(MainOptPanel_Wild);
		
		JPanel OneTo1panel = new JPanel();
		OneTo1panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		OneTo1panel.setBounds(23, 134, 544, 110);
		MainOptPanel_Wild.add(OneTo1panel);
		OneTo1panel.setLayout(null);
		
		JCheckBox chckbxBasedOnCondition = new JCheckBox("Based on 1-1 Area/Pokemon");
		chckbxBasedOnCondition.setBounds(318, 67, 220, 23);
		OneTo1panel.add(chckbxBasedOnCondition);
		chckbxBasedOnCondition.setEnabled(false);
		
		JToggleButton tglBtnWild_NoChg_ = new JToggleButton("No Change");
		tglBtnWild_NoChg_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Sum_txtField.append("Wild Pokemon Tab: No Change\n");
					AbstractButton abstractButton = (AbstractButton) e.getSource();
	                boolean selected = abstractButton.getModel().isSelected();
	                if (selected) {
	                	chckbxBasedOnCondition.setEnabled(false);
	                	chckbxBasedOnCondition.setSelected(false);
	                }
					
			}
		});
		Wild_MainBtngrp.add(tglBtnWild_NoChg_);
		tglBtnWild_NoChg_.setToolTipText("No randomization will be made");
		tglBtnWild_NoChg_.setBounds(23, 25, 294, 40);
		MainOptPanel_Wild.add(tglBtnWild_NoChg_);

		JToggleButton tglBtnWild_AllRandom = new JToggleButton("Complete Randomization");
		tglBtnWild_AllRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sum_txtField.append("Wild Pokemon Tab: Complete Randomization\n");
				AbstractButton abstractButton = (AbstractButton) e.getSource();
                boolean selected = abstractButton.getModel().isSelected();
                if (selected) {
                	chckbxBasedOnCondition.setEnabled(false);
                	chckbxBasedOnCondition.setSelected(false);
                }
			}
		});

		Wild_MainBtngrp.add(tglBtnWild_AllRandom);
		tglBtnWild_AllRandom.setToolTipText("Every random encounter slot will be fully randomized.");
		tglBtnWild_AllRandom.setBounds(23, 83, 294, 40);
		MainOptPanel_Wild.add(tglBtnWild_AllRandom);

		JToggleButton tglbtn1to1AreaRandz = new JToggleButton("1-to-1 Area Randomization");
		tglbtn1to1AreaRandz.setBounds(10, 7, 284, 40);
		OneTo1panel.add(tglbtn1to1AreaRandz);
		tglbtn1to1AreaRandz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sum_txtField.append("Wild Pokemon Tab: 1-to-1 Area Randomization\n");
				AbstractButton abstractButton = (AbstractButton) e.getSource();
                boolean selected = abstractButton.getModel().isSelected();
                if (selected) {
                	chckbxBasedOnCondition.setEnabled(true);
                }
					
			}
		});
		Wild_MainBtngrp.add(tglbtn1to1AreaRandz);
		tglbtn1to1AreaRandz.setEnabled(false);
		tglbtn1to1AreaRandz.setToolTipText("To be implemented");
		
		JToggleButton tglbtn1to1PokemonRandomization = new JToggleButton("1-to-1 Pokemon Randomization");
		tglbtn1to1PokemonRandomization.setBounds(10, 58, 284, 40);
		OneTo1panel.add(tglbtn1to1PokemonRandomization);
		tglbtn1to1PokemonRandomization.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Sum_txtField.append("Wild Pokemon Tab: 1-to-1 Pokemon Randomization\n");
					
					AbstractButton abstractButton = (AbstractButton) e.getSource();
	                boolean selected = abstractButton.getModel().isSelected();
	                if (selected) {
	                	chckbxBasedOnCondition.setEnabled(true);
	                }
					
			}
		});
		tglbtn1to1PokemonRandomization.setEnabled(false);
		tglbtn1to1PokemonRandomization.setToolTipText("to be implemented");
		Wild_MainBtngrp.add(tglbtn1to1PokemonRandomization);
		
		JCheckBox chckbxWhenever = new JCheckBox("Can be selected whenever");
		chckbxWhenever.setBounds(23, 261, 294, 23);
		MainOptPanel_Wild.add(chckbxWhenever);
		
		
		/**
		 * Trainer Tab 
		 */

		JPanel TrainerPanel = new JPanel();
		TrainerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Trainer Teams", null, TrainerPanel, null);
		TrainerPanel.setLayout(null);

		JPanel OpeningPanel = new JPanel();
		OpeningPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		OpeningPanel.setBounds(29, 27, 791, 344);
		TrainerPanel.add(OpeningPanel);
		OpeningPanel.setLayout(null);

		JLabel OpeningLabel = new JLabel("Main Options:");
		OpeningLabel.setBounds(10, 19, 112, 22);
		OpeningLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		OpeningPanel.add(OpeningLabel);

		
		JToggleButton tglButtonTrainer_NoChg = new JToggleButton("No Change");
		tglButtonTrainer_NoChg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sum_txtField.append("Trainer Tab: No Change\n");
			}
		});
		Trainer_MainBtngrp.add(tglButtonTrainer_NoChg);
		tglButtonTrainer_NoChg.setToolTipText("No randomization will be made");
		tglButtonTrainer_NoChg.setBounds(37, 54, 232, 42);
		OpeningPanel.add(tglButtonTrainer_NoChg);
		
		JToggleButton tglButtonFul_Rand_Trainer = new JToggleButton("Fully Randomized Teams");
		tglButtonFul_Rand_Trainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sum_txtField.append("Trainer Tab: Fully Randomized Teams\n");
			}
		});
		Trainer_MainBtngrp.add(tglButtonFul_Rand_Trainer);
		tglButtonFul_Rand_Trainer.setToolTipText("Trainers teams will be completely random\r\n"
				+ "");
		tglButtonFul_Rand_Trainer.setBounds(37, 110, 232, 42);
		OpeningPanel.add(tglButtonFul_Rand_Trainer);

		JComboBox combx_type = new JComboBox();
		combx_type.setModel(new DefaultComboBoxModel(new String[] {"N/A", "Bug", "Dark", "Dragon", "Electric", "Fighting", "Fire", "Ghost", "Gorund", "Grass", "Ground", "Ice", "Normal", "Poison", "Psychic", "Rock","Steel",
				"Water"}));
		combx_type.setBounds(114, 235, 155, 22);
		OpeningPanel.add(combx_type);

		JLabel lbltype = new JLabel("Types:");
		lbltype.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbltype.setBounds(56, 238, 66, 14);
		OpeningPanel.add(lbltype);

		
		JCheckBox chckbxKeepGymLeader = new JCheckBox("  Keep Gym Leader Type Theme");
		
		chckbxKeepGymLeader.setBounds(315, 235, 232, 23);
		OpeningPanel.add(chckbxKeepGymLeader);
		
		JCheckBox chckbxExcludeLegendaries = new JCheckBox("  Exclude legendaries");
		chckbxExcludeLegendaries.setBounds(570, 235, 201, 23);
		OpeningPanel.add(chckbxExcludeLegendaries);
		

		JCheckBox chckbxEnableTypeThemes = new JCheckBox("Enable Type Themes Randomization");
		chckbxEnableTypeThemes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sum_txtField.append("Trainer Tab: Enable Type Themes Randomization\n");
			}
		});
		chckbxEnableTypeThemes.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxEnableTypeThemes.setBounds(37, 186, 262, 23);
		OpeningPanel.add(chckbxEnableTypeThemes);

		
		JToggleButton tglButtonFul_Rand_Trainer_Type = new JToggleButton("Randomized with Type Themes");
		tglButtonFul_Rand_Trainer_Type.setToolTipText("Select a type theme for trainers to have when randomizing (Pairs with Keep Gym Leader Type Theme)\r\n"+ "");
		tglButtonFul_Rand_Trainer_Type.setBounds(37, 277, 232, 42);
		OpeningPanel.add(tglButtonFul_Rand_Trainer_Type);
		
		/*
		 * /StarterTab- RandomizePanel disabled unless hash value is correct
		 */
		
		Component [] RandomizePanel_list = RandomizePanel.getComponents();
		for (int i = 0; i < RandomizePanel_list.length; i++) {
			RandomizePanel_list[i].setEnabled(false);
		}
		
		/*
		 * /TrainerTab- TrainerPanel disabled unless hash value is correct
		 */
		
		Component [] OpeningPanel_list = OpeningPanel.getComponents();
		for (int i = 0; i < OpeningPanel_list.length; i++) {
			OpeningPanel_list[i].setEnabled(false);
		}
		
		/*
		 * /WildTab- WildPanel disabled unless hash value is correct
		 */
		
		Component [] MainOptPanel_Wild_list = MainOptPanel_Wild.getComponents();
		for (int i = 0; i < MainOptPanel_Wild_list.length; i++) {
			MainOptPanel_Wild_list[i].setEnabled(false);
		}
		
		/*
		 * Trainer Tab Button logic/
		 */
		
		tglButtonFul_Rand_Trainer_Type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
                boolean selected = abstractButton.getModel().isSelected();
	            // if selected print selected in console
	            if (selected) {	
	            	
	            	combx_type.setEnabled(false);
	            	chckbxKeepGymLeader.setEnabled(false);
	            	chckbxExcludeLegendaries.setEnabled(false);
	            }
	            else {
	            	combx_type.setEnabled(true);
	            	chckbxKeepGymLeader.setEnabled(true);
	            	chckbxExcludeLegendaries.setEnabled(true);
	            }
			}
		});
		
		
		/**
		 * Field items Tab
		 */

		JPanel FieldTab = new JPanel();
		FieldTab.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Field Items", null, FieldTab, null);
		FieldTab.setLayout(null);

		
		JPanel FieldMainPanel = new JPanel();
		FieldMainPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		FieldMainPanel.setBounds(25, 23, 893, 341);
		FieldTab.add(FieldMainPanel);
		FieldMainPanel.setLayout(null);
		
		JLabel Openinglbl_FieldItem = new JLabel("Main Options:");
		Openinglbl_FieldItem.setFont(new Font("Tahoma", Font.BOLD, 16));
		Openinglbl_FieldItem.setBounds(21, 22, 112, 22);
		FieldMainPanel.add(Openinglbl_FieldItem);
		
		JPanel MartsPanel = new JPanel();
		MartsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		MartsPanel.setBounds(421, 22, 449, 294);
		FieldMainPanel.add(MartsPanel);
		MartsPanel.setLayout(null);
		
		JCheckBox chckbxEnablePokeMart = new JCheckBox(" Enable Poke Marts Items");
		chckbxEnablePokeMart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sum_txtField.append("Field Items Tab: Enable Poke Marts Items\n");
			}
		});
		chckbxEnablePokeMart.setToolTipText("Randomize the items sold in Pokemarts");
		chckbxEnablePokeMart.setBounds(6, 18, 171, 23);
		MartsPanel.add(chckbxEnablePokeMart);
		chckbxEnablePokeMart.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel CityPanel = new JPanel();
		CityPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		CityPanel.setBounds(179, 11, 260, 272);
		MartsPanel.add(CityPanel);
		CityPanel.setLayout(null);
		

		JToggleButton tglBtnPickCity = new JToggleButton("Choose Cities");
		tglBtnPickCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sum_txtField.append("Field Items Tab/Poke Mart: A City was chosen\n");
			}
		});
		MartBtngrp.add(tglBtnPickCity);
		tglBtnPickCity.setBounds(17, 66, 152, 36);
		MartsPanel.add(tglBtnPickCity);
		tglBtnPickCity.setToolTipText("Pick the cities whose marts will be randomized ");		
		
		
		JRadioButton rdbtnViridian = new JRadioButton("Viridian City");
		rdbtnViridian.setBounds(6, 7, 136, 23);
		CityPanel.add(rdbtnViridian);
		
		JRadioButton rdbtnPewter = new JRadioButton("Pewter City");
		rdbtnPewter.setBounds(6, 33, 136, 23);
		CityPanel.add(rdbtnPewter);
		
		JRadioButton rdbtnCerulean = new JRadioButton("Cerulean City");
		rdbtnCerulean.setBounds(6, 59, 136, 23);
		CityPanel.add(rdbtnCerulean);
		
		JRadioButton rdbtnVermilion = new JRadioButton("Vermilion City");
		rdbtnVermilion.setBounds(6, 85, 136, 23);
		CityPanel.add(rdbtnVermilion);
		
		JRadioButton rdbtnLavender = new JRadioButton("Lavender Town");
		rdbtnLavender.setBounds(6, 111, 136, 23);
		CityPanel.add(rdbtnLavender);
		
		JRadioButton rdbtnSaffron = new JRadioButton("Saffron City");
		rdbtnSaffron.setBounds(6, 137, 136, 23);
		CityPanel.add(rdbtnSaffron);
		
		JRadioButton rdbtnFuchsia = new JRadioButton("Fuchsia City");
		rdbtnFuchsia.setBounds(6, 163, 136, 23);
		CityPanel.add(rdbtnFuchsia);
		
		JRadioButton rdbtnCinnabarIsland = new JRadioButton("Cinnabar Island");
		rdbtnCinnabarIsland.setBounds(6, 215, 136, 23);
		CityPanel.add(rdbtnCinnabarIsland);
		
		JRadioButton rdbtnPokemonLeague = new JRadioButton("Pokemon League");
		rdbtnPokemonLeague.setBounds(6, 189, 136, 23);
		CityPanel.add(rdbtnPokemonLeague);
		
		JRadioButton rdbtnCeladonCityDepartment = new JRadioButton("Celadon City Department Store");
		rdbtnCeladonCityDepartment.setBounds(6, 242, 222, 23);
		CityPanel.add(rdbtnCeladonCityDepartment);
		
		JRadioButton rdbtnThreeIsland = new JRadioButton("Three Island");
		rdbtnThreeIsland.setBounds(144, 7, 109, 23);
		CityPanel.add(rdbtnThreeIsland);
		
		JRadioButton rdbtnFourIsland = new JRadioButton("Four Island");
		rdbtnFourIsland.setBounds(144, 33, 109, 23);
		CityPanel.add(rdbtnFourIsland);
		
		JRadioButton rdbtnSixIsland = new JRadioButton("Six Island ");
		rdbtnSixIsland.setBounds(144, 59, 109, 23);
		CityPanel.add(rdbtnSixIsland);
		
		JRadioButton rdbtnSevenIsland = new JRadioButton("Seven Island");
		rdbtnSevenIsland.setBounds(144, 85, 109, 23);
		CityPanel.add(rdbtnSevenIsland);
		
		JRadioButton rdbtnTrainerTower = new JRadioButton("Trainer Tower");
		rdbtnTrainerTower.setBounds(144, 111, 109, 23);
		CityPanel.add(rdbtnTrainerTower);
		
		JToggleButton tglbtnRandomizeAllCities = new JToggleButton("Randomize all Cities");
		tglbtnRandomizeAllCities.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sum_txtField.append("Field Items Tab/Poke Mart: Randomize all Cities\n");
			}
		});
		MartBtngrp.add(tglbtnRandomizeAllCities);
		tglbtnRandomizeAllCities.setToolTipText("Randomize all cities Pokemarts");
		tglbtnRandomizeAllCities.setBounds(16, 113, 153, 36);
		MartsPanel.add(tglbtnRandomizeAllCities);
		
		JToggleButton btnMartNone = new JToggleButton("None");
		btnMartNone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sum_txtField.append("Field Items Tab/Poke Mart: No cities option was chosen\n");
			}
		});
		btnMartNone.setBounds(17, 160, 152, 36);
		MartBtngrp.add(btnMartNone);
		btnMartNone.setEnabled(false);
		MartsPanel.add(btnMartNone);
		
		JPanel MainOptPanel = new JPanel();
		MainOptPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		MainOptPanel.setBounds(143, 22, 258, 123);
		FieldMainPanel.add(MainOptPanel);
		MainOptPanel.setLayout(null);
		
		JToggleButton tglButtonFieldItem_NoChg = new JToggleButton("No Change");
		tglButtonFieldItem_NoChg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sum_txtField.append("Field Items Tab: No Change\n");
			}
		});

		FieldItem_MainOptBtnGrp.add(tglButtonFieldItem_NoChg);
		tglButtonFieldItem_NoChg.setBounds(23, 11, 213, 42);
		MainOptPanel.add(tglButtonFieldItem_NoChg);
		tglButtonFieldItem_NoChg.setToolTipText("No randomization will be made");
		
		JCheckBox chckbxGroundItems = new JCheckBox("   Ground Item Randomization");
		chckbxGroundItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sum_txtField.append("Field Items Tab: Ground Item Randomization\n");
			}
		});

		chckbxGroundItems.setBounds(23, 71, 213, 30);
		MainOptPanel.add(chckbxGroundItems);
		FieldItem_MainOptBtnGrp.add(chckbxGroundItems);
		chckbxGroundItems.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxGroundItems.setToolTipText("Randomizes all items found on the ground in the overworld\r\n"
				+ "");
		
		JPanel subOptPanel = new JPanel();
		subOptPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		subOptPanel.setBounds(143, 195, 258, 75);
		FieldMainPanel.add(subOptPanel);
		subOptPanel.setLayout(null);
		
		JCheckBox chckbxExcludeKeyItem = new JCheckBox("  Exclude Key Items");
		chckbxExcludeKeyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sum_txtField.append("Field Items Tab: Exclude Key Items Selected\n");
			}
		});
		chckbxExcludeKeyItem.setToolTipText("Exclude key items from the possible items being randomized ");
		chckbxExcludeKeyItem.setBounds(6, 7, 167, 23);
		subOptPanel.add(chckbxExcludeKeyItem);
		
		JCheckBox chckbxEarlyBike = new JCheckBox("  Early Bike");
		chckbxEarlyBike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sum_txtField.append("Field Items Tab: Early Bike Selected\n");
			}
		});
		chckbxEarlyBike.setBounds(6, 38, 110, 23);
		subOptPanel.add(chckbxEarlyBike);
		
		JLabel SubOptlbl_FieldItem = new JLabel("Sub Options:");
		SubOptlbl_FieldItem.setFont(new Font("Tahoma", Font.BOLD, 16));
		SubOptlbl_FieldItem.setBounds(21, 195, 112, 22);
		FieldMainPanel.add(SubOptlbl_FieldItem);
		
		/*
		 * /Field Item Tab- TrainerPanel disabled unless hash value is correct
		 */
		
		Component [] FieldMainPanel_list = FieldMainPanel.getComponents();
		for (int i = 0; i < FieldMainPanel_list.length; i++) {
			FieldMainPanel_list[i].setEnabled(false);
		}
		// Sub Panel of Field Item Tab
		Component [] MartsPanel_list = MartsPanel.getComponents();
		for (int i = 0; i < MartsPanel_list.length; i++) {
			MartsPanel_list[i].setEnabled(false);
		}
		// Sub Panel of Field Item Tab
		Component [] MainOptPanel_list = MainOptPanel.getComponents();
		for (int i = 0; i < MainOptPanel_list.length; i++) {
			MainOptPanel_list[i].setEnabled(false);
		}
		// Sub Panel of Field Item Tab
		Component [] subOptPanel_list = subOptPanel.getComponents();
		for (int i = 0; i < subOptPanel_list.length; i++) {
			subOptPanel_list[i].setEnabled(false);
		}
		
		// Sub Panel of Field Item Tab
		Component [] CityPanel_list = CityPanel.getComponents();
		for (int i = 0; i < CityPanel_list.length; i++) {
			CityPanel_list[i].setEnabled(false);
		}
				
		/*
		 * Field Item Button logic/
		 */
		tglBtnPickCity.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			AbstractButton abstractButton = (AbstractButton) e.getSource();
            boolean selected = abstractButton.getModel().isSelected();
            // if selected print selected in console
            if (selected) {
            	for (int i = 0; i < CityPanel_list.length; i++) {
        			CityPanel_list[i].setEnabled(true);
            	}
            }
		}
	});
		tglbtnRandomizeAllCities.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
	            boolean selected = abstractButton.getModel().isSelected();
	            // if selected print selected in console
	            if (selected) {	
	            	for (int i = 0; i < CityPanel_list.length; i++) {
	            		rdbtnViridian.setSelected(false);
	            		rdbtnPewter.setSelected(false);
	            		rdbtnCerulean.setSelected(false);
	            		rdbtnVermilion.setSelected(false);
	            		rdbtnLavender.setSelected(false);
	            		rdbtnSaffron.setSelected(false);
	            		rdbtnFuchsia.setSelected(false);
	            		rdbtnCinnabarIsland.setSelected(false);
	            		rdbtnPokemonLeague.setSelected(false);
	            		rdbtnThreeIsland.setSelected(false);
	            		rdbtnCeladonCityDepartment.setSelected(false);
	            		rdbtnFourIsland.setSelected(false);
	            		rdbtnSixIsland.setSelected(false);
	            		rdbtnSevenIsland.setSelected(false);
	            		rdbtnTrainerTower.setSelected(false);
	        			CityPanel_list[i].setEnabled(false);
	            	}
	            }
			}
		});
		btnMartNone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
	            boolean selected = abstractButton.getModel().isSelected();
	            // if selected print selected in console
	            if (selected) {	
	            	for (int i = 0; i < CityPanel_list.length; i++) {
	            		rdbtnViridian.setSelected(false);
	            		rdbtnPewter.setSelected(false);
	            		rdbtnCerulean.setSelected(false);
	            		rdbtnVermilion.setSelected(false);
	            		rdbtnLavender.setSelected(false);
	            		rdbtnSaffron.setSelected(false);
	            		rdbtnFuchsia.setSelected(false);
	            		rdbtnCinnabarIsland.setSelected(false);
	            		rdbtnPokemonLeague.setSelected(false);
	            		rdbtnThreeIsland.setSelected(false);
	            		rdbtnCeladonCityDepartment.setSelected(false);
	            		rdbtnFourIsland.setSelected(false);
	            		rdbtnSixIsland.setSelected(false);
	            		rdbtnSevenIsland.setSelected(false);
	            		rdbtnTrainerTower.setSelected(false);
	        			CityPanel_list[i].setEnabled(false);
	            	}
	            }
			}
		});
	

		/**
		 * Statistic Tab
		 */
		
		JPanel StatsTabs = new JPanel();
		StatsTabs.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Pokemon Moves and Stats", null, StatsTabs, null);
		StatsTabs.setLayout(null);
		
		JLabel MainOptlbl_stats = new JLabel("Main Options:");
		MainOptlbl_stats.setFont(new Font("Tahoma", Font.BOLD, 16));
		MainOptlbl_stats.setBounds(26, 47, 112, 22);
		MainOptlbl_stats.setEnabled(false);
		StatsTabs.add(MainOptlbl_stats);
		
		JPanel MainOptPanel_stats = new JPanel();
		MainOptPanel_stats.setLayout(null);
		MainOptPanel_stats.setBorder(new LineBorder(new Color(0, 0, 0)));
		MainOptPanel_stats.setBounds(148, 47, 258, 337);
		StatsTabs.add(MainOptPanel_stats);
		
		JToggleButton tglButtonStatsTab_NoChg = new JToggleButton("No Change");
		tglButtonStatsTab_NoChg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sum_txtField.append("Moves and Stats Items Tab: No Change\n");
			}
		});
		StatTab_MainOptBtnGrp.add(tglButtonStatsTab_NoChg);
		tglButtonStatsTab_NoChg.setToolTipText("No randomization will be made");
		tglButtonStatsTab_NoChg.setBounds(23, 24, 213, 42);
		tglButtonStatsTab_NoChg.setEnabled(false);
		MainOptPanel_stats.add(tglButtonStatsTab_NoChg);
		
		JToggleButton tglbtnFullStatRandomization = new JToggleButton("Full Stat Randomization");
		tglbtnFullStatRandomization.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sum_txtField.append("Moves and Stats Items Tab: Full Stat Randomization\n");
			}
		});
		StatTab_MainOptBtnGrp.add(tglbtnFullStatRandomization);
		tglbtnFullStatRandomization.setToolTipText("Completely Randomize all pokemons stats ");
		tglbtnFullStatRandomization.setBounds(23, 77, 213, 42);
		tglbtnFullStatRandomization.setEnabled(false);
		MainOptPanel_stats.add(tglbtnFullStatRandomization);
		
		JToggleButton tglbtnVerify_DeltaRandomization = new JToggleButton("Verify Delta Randomization");
		StatTab_ExceptionBtnGrp.add(tglbtnVerify_DeltaRandomization);
		tglbtnVerify_DeltaRandomization.setToolTipText("Randomize stats based on a given value (if you enter 5, each stat will change from between -5 to +5) ");
		tglbtnVerify_DeltaRandomization.setBounds(23, 232, 213, 42);
		tglbtnVerify_DeltaRandomization.setEnabled(false);
		MainOptPanel_stats.add(tglbtnVerify_DeltaRandomization);
		
		
		JLabel deltaValuelbl = new JLabel("Enter Delta Value (1-9):");
		deltaValuelbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		deltaValuelbl.setBounds(23, 188, 155, 20);
		deltaValuelbl.setEnabled(false);
		MainOptPanel_stats.add(deltaValuelbl);
		
		delta_input = new JTextField();
		delta_input.setHorizontalAlignment(SwingConstants.RIGHT);
		delta_input.setBounds(184, 189, 52, 20);
		delta_input.setEnabled(false);
		MainOptPanel_stats.add(delta_input);
		delta_input.setColumns(10);
		
		JCheckBox chckbxEnableDeltaRand = new JCheckBox("Enable Delta Randomization");
		chckbxEnableDeltaRand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sum_txtField.append("Moves and Stats Items Tab: Enable Delta Randomization\n");
			}
		});
		chckbxEnableDeltaRand.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxEnableDeltaRand.setBounds(23, 146, 213, 23);
		chckbxEnableDeltaRand.setEnabled(false);
		StatTab_MainOptBtnGrp.add(chckbxEnableDeltaRand);
		MainOptPanel_stats.add(chckbxEnableDeltaRand);
		
		JToggleButton tglBtnStatsTab_ReSelect = new JToggleButton("Enter an Integer Value");
		StatTab_ExceptionBtnGrp.add(tglBtnStatsTab_ReSelect);
		tglBtnStatsTab_ReSelect.setToolTipText("No randomization will be made");
		tglBtnStatsTab_ReSelect.setBounds(23, 284, 213, 42);
		tglBtnStatsTab_ReSelect.setEnabled(false);
		MainOptPanel_stats.add(tglBtnStatsTab_ReSelect);
		
		JLabel SubOptlbl_stats = new JLabel("Sub Options:");
		SubOptlbl_stats.setFont(new Font("Tahoma", Font.BOLD, 16));
		SubOptlbl_stats.setBounds(466, 47, 112, 22);
		SubOptlbl_stats.setEnabled(false);
		StatsTabs.add(SubOptlbl_stats);
		
		JPanel SubOptPanel_stats = new JPanel();
		SubOptPanel_stats.setBorder(new LineBorder(new Color(0, 0, 0)));
		SubOptPanel_stats.setBounds(588, 47, 258, 160);
		StatsTabs.add(SubOptPanel_stats);
		SubOptPanel_stats.setLayout(null);
		
		JCheckBox chckbxEnable_stat = new JCheckBox("Enable TM/HM Compatibility");
		chckbxEnable_stat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sum_txtField.append("Moves and Stats Items Tab: Enable TM/HM Compatibility\n");
			}
		});
		chckbxEnable_stat.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxEnable_stat.setBounds(22, 25, 218, 31);
		chckbxEnable_stat.setEnabled(false);
		SubOptPanel_stats.add(chckbxEnable_stat);
		
		JCheckBox chckbxTMComp = new JCheckBox("Change TM Compatibility");
		chckbxTMComp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sum_txtField.append("Moves and Stats Items Tab: Change TM Compatibility selected\n");
			}
		});
		chckbxTMComp.setBounds(43, 69, 178, 23);
		chckbxTMComp.setEnabled(false);
		SubOptPanel_stats.add(chckbxTMComp);
		
		JCheckBox chckbxHM_Comp = new JCheckBox("Change HM Compatibility");
		chckbxHM_Comp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sum_txtField.append("Moves and Stats Items Tab: Change HM Compatibility selected\n");
			}
		});
		chckbxHM_Comp.setToolTipText("Make all HMs compatible with any pokemon");
		chckbxHM_Comp.setBounds(43, 95, 178, 23);
		chckbxHM_Comp.setEnabled(false);
		SubOptPanel_stats.add(chckbxHM_Comp);

		/**
		 * Summary Tab
		 */

		JPanel UserLogTab = new JPanel();
		UserLogTab.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("User Log", null, UserLogTab, null);
		UserLogTab.setLayout(null);
		
		JLabel Summarylbl = new JLabel("Summary of your Randomization");
		Summarylbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		Summarylbl.setBounds(36, 31, 516, 22);
		UserLogTab.add(Summarylbl);
		
		Sum_txtField = new JTextArea();
		Sum_txtField.setLineWrap(true);
		Sum_txtField.setEditable(false);
		Sum_txtField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		
		JScrollPane scroll = new JScrollPane(Sum_txtField);
        scroll.setSize(700, 500);
        scroll.setBounds(36, 65, 632, 301);
        UserLogTab.add(scroll);
        
        
		JButton btnClear = new JButton(new AbstractAction("Clear") {
			@Override
			public void actionPerformed(ActionEvent e) {
				Sum_txtField.setText("");
			}
		});
        btnClear.setBounds(699, 325, 193, 41);
        UserLogTab.add(btnClear);
        
  
      
		/**
		 * Action Panel Component
		 */

		JPanel ActionPanel = new JPanel();
		ActionPanel.setBorder(new LineBorder(Color.BLACK));

		JLabel ActionLabel = new JLabel("Actions:");
		ActionLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		ActionLabel.setBounds(10, 18, 68, 14);




		//Save Button
		JButton SaveButton = new JButton(new AbstractAction("Save New ROM File") {
			@Override
			public void actionPerformed(ActionEvent e) {
				//code
				
				// Code for Trainers Teams
				if(tglButtonFul_Rand_Trainer.isSelected()) {
					String pokemonSetType;

					if (chckbxExcludeLegendaries.isSelected()) {
						pokemonSetType = "No Legendary";
					} else {
						pokemonSetType = "All";
					}
					trainersPokemon.randomizeAllTrainerPokemon(pokemonSetType);

					if(chckbxEnableTypeThemes.isSelected()) {
						String trainerPartyType;
						trainerPartyType = (String) combx_type.getSelectedItem();

						if(tglButtonFul_Rand_Trainer_Type.isSelected()) {
							trainersPokemon.randomizeAllTrainerPokemonByType(pokemonSetType, trainerPartyType);
						}

						if (chckbxKeepGymLeader.isSelected()) {
							trainersPokemon.randomizeGymLeadersByTheirType(pokemonSetType);
						}
					}
				} else if (chckbxEnableTypeThemes.isSelected() && !tglButtonTrainer_NoChg.isSelected() &&
						!tglButtonFul_Rand_Trainer.isSelected() && !tglButtonFul_Rand_Trainer_Type.isSelected()) {
					String pokemonSetType;
					if (chckbxExcludeLegendaries.isSelected()) {
						pokemonSetType = "No Legendary";
					} else {
						pokemonSetType = "All";
					}
					if (chckbxKeepGymLeader.isSelected()) {
						trainersPokemon.randomizeGymLeadersByTheirType(pokemonSetType);
					}
				} else if (chckbxEnableTypeThemes.isSelected() && !tglButtonFul_Rand_Trainer.isSelected() &&
						tglButtonFul_Rand_Trainer_Type.isSelected() && !tglButtonTrainer_NoChg.isSelected()) {
					String pokemonSetType;

					if (chckbxExcludeLegendaries.isSelected()) {
						pokemonSetType = "No Legendary";
					} else {
						pokemonSetType = "All";
					}

					String trainerPartyType;
					trainerPartyType = (String) combx_type.getSelectedItem();

					trainersPokemon.randomizeAllTrainerPokemonByType(pokemonSetType, trainerPartyType);

					if (chckbxKeepGymLeader.isSelected()) {
						trainersPokemon.randomizeGymLeadersByTheirType(pokemonSetType);
					}
				}else if (tglButtonTrainer_NoChg.isSelected()) {

				} // End Pokemon Trainers Teams Module

				//Starter Pokemon Module
				StarterModule starterMod;
				if(ChckBxLevelRandom.isSelected()){
					starterMod = new StarterModule(editRom, Integer.parseInt(txtBoundFrom.getText()), Integer.parseInt(txtBoundTo.getText()));
				}
				else{
					starterMod = new StarterModule(editRom);
				}
				if(tglButtonFul_Rand.isSelected()){
					starterMod.randomizeStartersAllPokemon();
				}
				else if(tglButtonThreeStg.isSelected()){
					starterMod.randomizeStarterThreeStage();
				}
				else if(exLegendButton.isSelected()){
					starterMod.randomizeStartersAllPokemonNoLegendary();
				}
				//end StarterPokemon Module

				// item module
				if (chckbxEarlyBike.isSelected()) {
					itemModule.get_Bike_Early();
				}
				if (chckbxGroundItems.isSelected()) {
					itemModule.randomize_Ground_Items();
				}
				if (chckbxEnablePokeMart.isSelected()) {
					itemModule.randomize_All_Cities();
				}
				// end Item Module

				//start Wild Encounter module

				boolean allowWildEncounterLegendary = true;
				boolean allowOneAppearanceWildEncounter = true;
				EncounterModule encounterModule = new EncounterModule(editRom, allowWildEncounterLegendary, allowOneAppearanceWildEncounter);
        
				if(tglBtnWild_AllRandom.isSelected()){
					encounterModule.randomizeEncounters();
				}
				if(tglbtn1to1AreaRandz.isSelected()){
					encounterModule.randomizeEncountersByArea();
				}
				if(tglbtn1to1PokemonRandomization.isSelected()){
					encounterModule.randomizeEncountersByPokemon();
				}
				//end Wild Encounter Module

				// Start Stats Module
				if (tglbtnFullStatRandomization.isSelected()) {
					statsModule.randomizePokemonBaseStats();
					statsModule.randomizePokemonMiscStats();
					statsModule.randomizePokemonCatchRateAndBaseExp();
				} else if (chckbxEnableDeltaRand.isSelected()) {
					String deltaStr = delta_input.getText();
					int delta = Integer.parseInt(deltaStr);
					statsModule.randomizeBaseStatsByDelta(delta);
				} // End Stats Module


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

		/*
		/Action Panel Buttons
		 */

		//Seed button logic
		JButton SeedButton = new JButton(new AbstractAction("Seed Modification") {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (openCloseROM.correcthash == true){
					new SeedMod();
				}
			}
		});
		SeedButton.setEnabled(false);

		//setting button logic
		JButton SettingButton = new JButton(new AbstractAction("Setting") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SettingForm setting_theme = new SettingForm(frmPokemon);
				setting_theme.initialize_setting();


			}
		});
		SettingButton.setEnabled(false);

		// Open Button
		JButton OpenButton = new JButton(new AbstractAction("Open ROM File") {
			@Override
			public void actionPerformed(ActionEvent e) {

				//code
				openCloseROM.openROM();
				if (openCloseROM.correcthash == true) {
					ROMValue.setText("Pokemon-FireRed Version (USA)");
					StatusValue.setText("Success!!!");
					//TODO Add a "loading..." message so user knows program isn't frozen
					JOptionPane.showMessageDialog(null, "ROM Loaded Successfully!");
					//enabling action panel
					SeedButton.setEnabled(true);
					SaveButton.setEnabled(true);
					SettingButton.setEnabled(true);

					openedRom = openCloseROM.getRom();
					editRom.setRom(openedRom);
					trainersPokemon.setEditRom(editRom);
					statsModule.setEditRom(editRom);

					//enable starter tab randomize panel
					for (int i = 0; i < RandomizePanel_list.length; i++) {
						RandomizePanel_list[i].setEnabled(true);
					}

					//Exception enabling starter tab level panel
					Boundlbl.setEnabled(true);
					ChckBxLevelRandom.setEnabled(true);
					lblFrom.setEnabled(true);
					lblTo.setEnabled(true);
					LevelLabel.setEnabled(true);
					
					/*
					 * Wild Pokemon area enable function/
					 */
					tglbtn1to1AreaRandz.setEnabled(true);
					tglbtn1to1PokemonRandomization.setEnabled(true);


					/*
					 * /enable trainer tab randomize panel
					 */

					for (int i = 0; i < OpeningPanel_list.length; i++) {
						OpeningPanel_list[i].setEnabled(true);
					}
					//Exception for the Trainer Pokemon theme subtasks
					combx_type.setEnabled(false);
					lbltype.setEnabled(false);
					chckbxKeepGymLeader.setEnabled(false);
					chckbxExcludeLegendaries.setEnabled(false);
					tglButtonFul_Rand_Trainer_Type.setEnabled(false);

					/*
					 * /enable Field item tab randomize panel
					 */
					for (int i = 0; i < FieldMainPanel_list.length; i++) {
						FieldMainPanel_list[i].setEnabled(true);
					}
					//enable Field item tab randomize sub panel
					for (int i = 0; i < MainOptPanel_list.length; i++) {
						MainOptPanel_list[i].setEnabled(true);
					}
					//enable Field item tab randomize sub panel
					for (int i = 0; i < subOptPanel_list.length; i++) {
						subOptPanel_list[i].setEnabled(true);
					}
					chckbxEnablePokeMart.setEnabled(true);
					//enable wild item tab randomize sub panel
					for (int i = 0; i < MainOptPanel_Wild_list.length; i++) {
						MainOptPanel_Wild_list[i].setEnabled(true);
					}
					Openinglbl_Wild.setEnabled(true);
					
					//enable components for stat tab
					chckbxEnable_stat.setEnabled(true);
					SubOptlbl_stats.setEnabled(true);
					chckbxEnableDeltaRand.setEnabled(true);
					tglbtnFullStatRandomization.setEnabled(true);
					tglButtonStatsTab_NoChg.setEnabled(true);
					MainOptlbl_stats.setEnabled(true);
					
					chckbxWhenever.setEnabled(true);

				}
				//Incorrect ROM file loaded
				if (openCloseROM.correcthash == false) {
					JOptionPane.showMessageDialog(null, "Not Valid!! Please, reload the correct ROM file");
					ROMValue.setText("");
					StatusValue.setText("");

				}
				//Exception for the Trainer Pokemon theme subtasks
				combx_type.setEnabled(false);
				lbltype.setEnabled(false);
				chckbxKeepGymLeader.setEnabled(false);
				chckbxExcludeLegendaries.setEnabled(false);
				tglButtonFul_Rand_Trainer_Type.setEnabled(false);

				//enabling starter tab level panel
				Boundlbl.setEnabled(true);
				ChckBxLevelRandom.setEnabled(true);
				lblFrom.setEnabled(true);
				lblTo.setEnabled(true);
				LevelLabel.setEnabled(true);
			}
			}
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

		
		
		
		/**
		 * Action Logic Configuration in each tab
		 */
		
		/*
		 * / Wild Pokemon Sub Tasks enable checkbox
		 */

		ChckBxLevelRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ChckBxLevelRandom.isSelected()) {
					txtBoundFrom.setEditable(true);
					txtBoundTo.setEditable(true);
					tglButtonLevelRandomization.setEnabled(true);
					Sum_txtField.append("Starter Tab: Level Random || ENABLED \n");
					
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
		
		

		/*
		 * / Trainer Pokemon Sub tasks enable checkbox
		 */

		chckbxEnableTypeThemes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxEnableTypeThemes.isSelected()) {
					combx_type.setEnabled(true);
	            	lbltype.setEnabled(true);
	            	chckbxKeepGymLeader.setEnabled(true);
	            	chckbxExcludeLegendaries.setEnabled(true);
	            	tglButtonFul_Rand_Trainer_Type.setEnabled(true);

				}
				else {
					combx_type.setSelectedItem("N/A");
					combx_type.setEnabled(false);

	            	lbltype.setEnabled(false);
	            	chckbxKeepGymLeader.setEnabled(false);
	            	chckbxExcludeLegendaries.setEnabled(false);
	            	tglButtonFul_Rand_Trainer_Type.setEnabled(false);
	            	
	            	chckbxExcludeLegendaries.setSelected(false);
	            	chckbxKeepGymLeader.setSelected(false);
	            	tglButtonFul_Rand_Trainer_Type.setSelected(false);
				}
				
			}
		});
		/*
		 * / Field Items Pokemon Sub tasks enable checkbox
		 */
		
		
		chckbxEnablePokeMart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxEnablePokeMart.isSelected()) {
					tglbtnRandomizeAllCities.setEnabled(true);
					tglBtnPickCity.setEnabled(true);
					btnMartNone.setEnabled(true);
					
					
				}
				else {					
						tglbtnRandomizeAllCities.setSelected(false);
						tglBtnPickCity.setSelected(false);
						tglbtnRandomizeAllCities.setEnabled(false);
						tglBtnPickCity.setEnabled(false);
						btnMartNone.setEnabled(false);
						btnMartNone.setSelected(true);
						for (int i = 0; i < CityPanel_list.length; i++) {
		            		rdbtnViridian.setSelected(false);
		            		rdbtnPewter.setSelected(false);
		            		rdbtnCerulean.setSelected(false);
		            		rdbtnVermilion.setSelected(false);
		            		rdbtnLavender.setSelected(false);
		            		rdbtnSaffron.setSelected(false);
		            		rdbtnFuchsia.setSelected(false);
		            		rdbtnCinnabarIsland.setSelected(false);
		            		rdbtnPokemonLeague.setSelected(false);
		            		rdbtnThreeIsland.setSelected(false);
		            		rdbtnCeladonCityDepartment.setSelected(false);
		            		rdbtnFourIsland.setSelected(false);
		            		rdbtnSixIsland.setSelected(false);
		            		rdbtnSevenIsland.setSelected(false);
		            		rdbtnTrainerTower.setSelected(false);
		        			CityPanel_list[i].setEnabled(false);
		            	}
					
				}
			}
		});
		
		/*
		 * / Moves and Stats Tab -----------------------------------
		 */
		
		//Delta exception verification and Main Opt Exceptions handling
		
		chckbxEnableDeltaRand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxEnableDeltaRand.isSelected()) {
					tglbtnVerify_DeltaRandomization.setEnabled(true);
					deltaValuelbl.setEnabled(true);
					delta_input.setEnabled(true);
					
					
				}
				else if (!chckbxEnableDeltaRand.isSelected()) {
					tglbtnVerify_DeltaRandomization.setEnabled(false);
					tglbtnVerify_DeltaRandomization.setSelected(false);
					tglBtnStatsTab_ReSelect.setSelected(false);
					deltaValuelbl.setEnabled(false);
					delta_input.setEnabled(false);
					delta_input.setText("");
				}
			}
		});
		
		
		tglbtnVerify_DeltaRandomization.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				String str_delta = delta_input.getText();
				try {
					int num_delta = Integer.parseInt(str_delta);
					if (num_delta < 1 || num_delta > 9) {
						tglBtnStatsTab_ReSelect.setSelected(true);
						throw new Exception();
					}
				}catch (NumberFormatException ex) {
					delta_input.setText("");
					tglBtnStatsTab_ReSelect.setSelected(true);
					JOptionPane.showMessageDialog(null, "Please enter a number NOT letters");
					
				} catch (Exception e1) {
					delta_input.setText("");
					tglBtnStatsTab_ReSelect.setSelected(true);
					JOptionPane.showMessageDialog(null, "Please enter a number from 1 to 9!!!");
				}
				
			}
		});
		
		tglButtonStatsTab_NoChg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglButtonStatsTab_NoChg.isSelected()) {
					tglbtnVerify_DeltaRandomization.setEnabled(false);
					deltaValuelbl.setEnabled(false);
					delta_input.setText("");
					delta_input.setEnabled(false);
					tglbtnVerify_DeltaRandomization.setSelected(false);
					chckbxEnableDeltaRand.setSelected(false);
					tglBtnStatsTab_ReSelect.setSelected(true);
					
				}
			}
		});
		tglbtnFullStatRandomization.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnFullStatRandomization.isSelected()) {
					tglbtnVerify_DeltaRandomization.setEnabled(false);
					deltaValuelbl.setEnabled(false);
					delta_input.setText("");
					delta_input.setEnabled(false);
					tglbtnVerify_DeltaRandomization.setSelected(false);
					chckbxEnableDeltaRand.setSelected(false);
					tglBtnStatsTab_ReSelect.setSelected(true);
				}
			}
		});
		
		/*
		 * Sub Option of Stats and Moves
		 */
		
		chckbxEnable_stat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxEnable_stat.isSelected()) {
					chckbxTMComp.setEnabled(true);
					chckbxHM_Comp.setEnabled(true);
					
				}
				else if (!chckbxEnable_stat.isSelected()) {
					chckbxTMComp.setEnabled(false);
					chckbxTMComp.setSelected(false);
					chckbxHM_Comp.setEnabled(false);
					chckbxHM_Comp.setSelected(false);
					
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


		GroupLayout groupLayout = new GroupLayout(frmPokemon.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 931, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(ActionPanel, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
							.addGap(32)
							.addComponent(ROMPanel, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(CharImgLabel, GroupLayout.PREFERRED_SIZE, 231, Short.MAX_VALUE)
							.addGap(25))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(ROMPanel, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addComponent(CharImgLabel, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addComponent(ActionPanel, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))

		);

		/**
		 * Adding panels to layout accordingly
		 */
		ROMPanel.setLayout(gl_ROMPanel);
		ActionPanel.setLayout(gl_ActionPanel);
		frmPokemon.getContentPane().setLayout(groupLayout);

		}
	}




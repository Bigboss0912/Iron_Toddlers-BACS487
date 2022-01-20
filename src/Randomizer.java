import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class Randomizer {

	OpenCloseROM openCloseROM = new OpenCloseROM();
	private JFrame frmPokemon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				try {
					Randomizer window = new Randomizer();
					window.frmPokemon.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the application.
	 */
	public Randomizer() {
		initialize();
	}
	 

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPokemon = new JFrame();
		frmPokemon.setTitle("Pokemon Randomizer");
		frmPokemon.setBounds(100, 100, 733, 473);
		frmPokemon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Action Component
		JLabel ActionLabel = new JLabel("Actions:");
		ActionLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		// Open Button
		JButton OpenButton = new JButton(new AbstractAction("Open ROM File") {
			@Override
			public void actionPerformed(ActionEvent e) {
					//code
					openCloseROM.openROM();
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
		
		 
		
		//Using GroupLayout for resizable property of the subcomponent
		
		GroupLayout groupLayout = new GroupLayout(frmPokemon.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(SettingButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(SeedButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(SaveButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(OpenButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
					.addGap(538))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(ActionLabel, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
					.addGap(635))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addComponent(ActionLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(OpenButton)
					.addGap(4)
					.addComponent(SaveButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(SeedButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(SettingButton)
					.addContainerGap(288, Short.MAX_VALUE))
		);
		frmPokemon.getContentPane().setLayout(groupLayout);

	}
}
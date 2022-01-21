import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;


public class Randomizer {

	private JFrame frmPokemon;

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
		
		JButton OpenButton = new JButton("Open ROM File");
		JButton SaveButton = new JButton("Save ROM File");
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
		JLabel ROMValue = new JLabel("NONE LOADED");
		JLabel StatusLabel = new JLabel("Status:");
		JLabel StatusValue = new JLabel("Not Detected");
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
							.addPreferredGap(ComponentPlacement.RELATED, 136, Short.MAX_VALUE))
						.addGroup(gl_ROMPanel.createSequentialGroup()
							.addGroup(gl_ROMPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(FileLabel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addComponent(StatusLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_ROMPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(StatusValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(ROMValue, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))))
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
		/**
		 * Layout Component
		 */
		
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
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(CharImgLabel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(ROMPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
							.addComponent(ActionPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)))
					.addContainerGap(471, Short.MAX_VALUE))
		);

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

	}
}
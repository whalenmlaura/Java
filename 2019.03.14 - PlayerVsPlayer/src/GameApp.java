import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class GameApp {

	// ARRAYS / VARIABLES / TIMER
	private JFrame frame;
	@SuppressWarnings("rawtypes")
	private JList lstPlayerSelect;
	private JPanel pnlPlayerSelect;
	private JPanel pnlStartPage;
	private JPanel pnlArmoury;
	private JPanel pnlBattle;
	private JPanel pnlWinner;
	private JLabel lblPlayerImage;
	private JLabel lblPlayerImage2;
	private JLabel lblBattlePlayer;
	private JLabel lblStrength;
	private JLabel lblAgility;
	private JLabel lblGold;
	private JLabel lblArmour;
	private JLabel lblEnemy;
	private JLabel lblStrength1;
	private JLabel lblAgility1;
	private JLabel lblCost1;
	private JLabel lblGold3;
	private JLabel lblPlayerStats;
	private JLabel lblEnemyStats;
	private JButton btnPurchase;
	private JButton btnNext;
	private JLabel lblError;
	private JTextArea txtBattleArea;
	private JLabel lblWinnerPic;
	private JButton btnStartBattle;
	private JScrollPane JScrollBattle;
	private JButton btnNextWinner;
	private JButton btnGotoWinner;
	String player;
	
	private ImageIcon[] playerPicArray = new ImageIcon[2];
	private ImageIcon[] armourPicArray = new ImageIcon[5];
	ArrayList<Player> characters = new ArrayList<>();
	ArrayList<Gear> gear = new ArrayList<>();
	Timer timer;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameApp window = new GameApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout());


// ADD PLAYER AND GEAR IMAGES TO ARRAYS ------------------------------------------------------------------------------------
		
		playerPicArray[0] = new ImageIcon(GameApp.class.getResource("/GamePics/WileE.jpg"));
		playerPicArray[1] = new ImageIcon(GameApp.class.getResource("/GamePics/RoadRunner.jpg"));
		armourPicArray[0] = new ImageIcon(GameApp.class.getResource("/GamePics/Runners.jpg"));
		armourPicArray[1] = new ImageIcon(GameApp.class.getResource("/GamePics/Shield.jpg"));
		armourPicArray[2] = new ImageIcon(GameApp.class.getResource("/GamePics/Rocket.jpg"));
		armourPicArray[3] = new ImageIcon(GameApp.class.getResource("/GamePics/Harpoon.jpg"));
		armourPicArray[4] = new ImageIcon(GameApp.class.getResource("/GamePics/Pistol.jpg"));
		
		characters.add((Player)new WileECoyote()); // (Player) to show that is an explicit up-cast!! 
		characters.add((Player)new RoadRunner());
		gear.add(new Gear(5, 20, 70)); //strengthMod, agilityMod, cost
		gear.add(new Gear(20, 5, 80));
		gear.add(new Gear(30, 10, 90));
		gear.add(new Gear(40, 10, 150));
		gear.add(new Gear(60, 10, 200));		
		
// START PANEL ------------------------------------------------------------------------------------------------------------

		pnlStartPage = new JPanel();
		frame.getContentPane().add(pnlStartPage, "name_2287143160316");
		pnlStartPage.setLayout(null);
		
		JButton btnStart = new JButton("START");
		btnStart.setBackground(new Color(51, 153, 102));
		btnStart.setForeground(Color.WHITE);
		btnStart.setBounds(514, 331, 110, 44);
		btnStart.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btnStart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// SET PANELS VISIBLE
				pnlPlayerSelect.setVisible(true);
				pnlStartPage.setVisible(false);
				pnlArmoury.setVisible(false);
				pnlBattle.setVisible(false);
				pnlWinner.setVisible(false);
			}
		});
		pnlStartPage.setLayout(null);
		pnlStartPage.add(btnStart);
		
		JLabel lblStartBackground = new JLabel("");
		lblStartBackground.setIcon(new ImageIcon(GameApp.class.getResource("/GamePics/Background.jpg")));
		lblStartBackground.setBounds(0, 0, 634, 386);
		pnlStartPage.add(lblStartBackground);
		
// PLAYER SELECT PANEL -----------------------------------------------------------------------------------------------------

		pnlPlayerSelect = new JPanel();
		frame.getContentPane().add(pnlPlayerSelect, "name_2287143160316");
		pnlPlayerSelect.setLayout(null);
		
		JLabel lblSelectPlayer = new JLabel("SELECT YOUR PLAYER");
		lblSelectPlayer.setForeground(Color.BLACK);
		lblSelectPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectPlayer.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));
		lblSelectPlayer.setBounds(139, 11, 347, 45);
		pnlPlayerSelect.add(lblSelectPlayer);
		
		lstPlayerSelect = new JList();
		lstPlayerSelect.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				btnNext.setEnabled(true);
				if(lstPlayerSelect.getSelectedIndex() == 0) {
					player = "Wile E. Coyote";
					lblPlayerImage.setIcon(playerPicArray[0]);
					lblPlayerImage2.setIcon(playerPicArray[0]);
					lblBattlePlayer.setIcon(playerPicArray[0]);
					lblEnemy.setIcon(playerPicArray[1]);
				}
				else {
					player = "Road Runner";
					lblPlayerImage.setIcon(playerPicArray[1]);
					lblPlayerImage2.setIcon(playerPicArray[1]);
					lblBattlePlayer.setIcon(playerPicArray[1]);
					lblEnemy.setIcon(playerPicArray[0]);
				}				
				
				// DISPLAYER PLAYER STATS
				lblStrength.setText("Strength :  "+ characters.get(lstPlayerSelect.getSelectedIndex()).getBeforeStregth());
				lblAgility.setText("Agility     :  "+ characters.get(lstPlayerSelect.getSelectedIndex()).getAgility());
				lblGold.setText("Gold       :  "+ characters.get(lstPlayerSelect.getSelectedIndex()).getGold());
				lblGold3.setText("Available gold :  "+ characters.get(lstPlayerSelect.getSelectedIndex()).getGold());
				lblPlayerStats.setText("Health : "+characters.get(lstPlayerSelect.getSelectedIndex()).getMaxHealth());
				lblEnemyStats.setText("Health : "+characters.get(lstPlayerSelect.getSelectedIndex()).getMaxHealth());
			}
		});
				
		lstPlayerSelect.setBackground(Color.WHITE);
		lstPlayerSelect.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lstPlayerSelect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lstPlayerSelect.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lstPlayerSelect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstPlayerSelect.setModel(new AbstractListModel() {
			String[] values = new String[] {"Wile E. Coyote", "Road Runner"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		lstPlayerSelect.setBounds(141, 94, 135, 48);
		pnlPlayerSelect.add(lstPlayerSelect);
		
		lblPlayerImage = new JLabel("");
		lblPlayerImage.setIcon(null);
		lblPlayerImage.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblPlayerImage.setBounds(315, 67, 180, 250);
		pnlPlayerSelect.add(lblPlayerImage);
		
		JLabel lblStats = new JLabel("STATS");
		lblStats.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblStats.setBounds(141, 164, 135, 23);
		pnlPlayerSelect.add(lblStats);
		
		lblStrength = new JLabel("");
		lblStrength.setBorder(null);
		lblStrength.setVerticalAlignment(SwingConstants.TOP);
		lblStrength.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblStrength.setBounds(141, 198, 135, 28);
		pnlPlayerSelect.add(lblStrength);
		
		lblAgility = new JLabel("");
		lblAgility.setBorder(null);
		lblAgility.setVerticalAlignment(SwingConstants.TOP);
		lblAgility.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblAgility.setBounds(141, 224, 135, 28);
		pnlPlayerSelect.add(lblAgility);
		
		lblGold = new JLabel("");
		lblGold.setBorder(null);
		lblGold.setVerticalAlignment(SwingConstants.TOP);
		lblGold.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblGold.setBounds(141, 252, 135, 28);
		pnlPlayerSelect.add(lblGold);
		
		btnNext = new JButton("NEXT");
		btnNext.setEnabled(false);
		btnNext.setForeground(Color.WHITE);
		btnNext.setBackground(new Color(51, 153, 102));
		btnNext.setPreferredSize(new Dimension(65, 23));
		btnNext.setMinimumSize(new Dimension(65, 23));
		btnNext.setMaximumSize(new Dimension(65, 23));
		btnNext.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btnNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlArmoury.setVisible(true);
				pnlPlayerSelect.setVisible(false);
				pnlStartPage.setVisible(false);
				pnlBattle.setVisible(false);
				pnlWinner.setVisible(false);
			}
		});
		btnNext.setBounds(514, 331, 110, 44);
		pnlPlayerSelect.add(btnNext);
		
		JLabel lblPlayerSelectBackground = new JLabel("");
		lblPlayerSelectBackground.setIcon(new ImageIcon(GameApp.class.getResource("/GamePics/Background1.jpg")));
		lblPlayerSelectBackground.setBounds(0, 0, 634, 386);
		pnlPlayerSelect.add(lblPlayerSelectBackground);
		
// ARMOURY PANEL --------------------------------------------------------------------------------------------------------

		pnlArmoury = new JPanel();
		frame.getContentPane().add(pnlArmoury, "name_2287143160316");
		pnlArmoury.setLayout(null);

		JLabel lblArmoury = new JLabel("ARMOURY");
		lblArmoury.setHorizontalAlignment(SwingConstants.CENTER);
		lblArmoury.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));
		lblArmoury.setBounds(153, 11, 347, 45);
		pnlArmoury.add(lblArmoury);
		
		lblPlayerImage2 = new JLabel("");
		lblPlayerImage2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblPlayerImage2.setBounds(48, 53, 180, 250);
		pnlArmoury.add(lblPlayerImage2);
		
		JList lstGear = new JList();
		lstGear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lstGear.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				btnPurchase.setEnabled(true);
				// DISPLAY GEAR PROPERTIES
				lblArmour.setIcon(armourPicArray[lstGear.getSelectedIndex()]);
				characters.get(0).setGear(gear.get(lstGear.getSelectedIndex()));
				characters.get(1).setGear(gear.get(lstGear.getSelectedIndex()));
				lblStrength1.setText("Strength :  "+ gear.get(lstGear.getSelectedIndex()).getStrengthMod());
				lblAgility1.setText("Agility     :  "+ gear.get(lstGear.getSelectedIndex()).getAgilityMod());
				lblCost1.setText("Cost        :  "+ gear.get(lstGear.getSelectedIndex()).getCost());
			}
		});
		lstGear.setModel(new AbstractListModel() {
			String[] values = new String[] {"Runners", "Shield", "Rocket", "Harpoon Gun", "Disintegrating Pistol"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		lstGear.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstGear.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lstGear.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lstGear.setBackground(Color.WHITE);
		lstGear.setBounds(260, 67, 135, 114);
		pnlArmoury.add(lstGear);
		
		lblArmour = new JLabel("");
		lblArmour.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblArmour.setBounds(430, 53, 150, 150);
		pnlArmoury.add(lblArmour);
		
		JLabel lblProperties = new JLabel("PROPERTIES");
		lblProperties.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblProperties.setBounds(430, 209, 101, 23);
		pnlArmoury.add(lblProperties);
		
		lblStrength1 = new JLabel("");
		lblStrength1.setBorder(null);
		lblStrength1.setVerticalAlignment(SwingConstants.TOP);
		lblStrength1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblStrength1.setBounds(430, 235, 150, 29);
		pnlArmoury.add(lblStrength1);
		
		lblGold3 = new JLabel("");
		lblGold3.setBorder(null);
		lblGold3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblGold3.setHorizontalAlignment(SwingConstants.CENTER);
		lblGold3.setVerticalAlignment(SwingConstants.TOP);
		lblGold3.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lblGold3.setBounds(48, 308, 180, 29);
		pnlArmoury.add(lblGold3);
		
		JButton btnEnd = new JButton("END GAME");
		btnEnd.setVisible(false);
		btnEnd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// END GAME / CLOSE WINDOW BUTTON
				frame.dispose();
				System.exit(0);
			}
		});
		btnEnd.setPreferredSize(new Dimension(65, 23));
		btnEnd.setMinimumSize(new Dimension(65, 23));
		btnEnd.setMaximumSize(new Dimension(65, 23));
		btnEnd.setForeground(Color.WHITE);
		btnEnd.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btnEnd.setBackground(new Color(147, 57, 4));
		btnEnd.setBounds(260, 331, 171, 44);
		pnlArmoury.add(btnEnd);
		
		btnPurchase = new JButton("PURCHASE");
		btnPurchase.setEnabled(false);
		btnPurchase.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				int playerGold = characters.get(lstPlayerSelect.getSelectedIndex()).getGold();
				int itemGold = gear.get(lstGear.getSelectedIndex()).getCost();
				if(playerGold >= itemGold) {
					characters.get(lstPlayerSelect.getSelectedIndex()).subtractGold(itemGold);
					lblGold3.setText("Available gold :  "+ characters.get(lstPlayerSelect.getSelectedIndex()).getGold());
					btnPurchase.setEnabled(true);
					pnlBattle.setVisible(true);
					pnlPlayerSelect.setVisible(false);
					pnlStartPage.setVisible(false);
					pnlArmoury.setVisible(false);
					pnlWinner.setVisible(false);
					btnEnd.setVisible(true);
					lblGold3.setForeground(Color.black);
					lblEnemyStats.setForeground(Color.black);
					lblPlayerStats.setForeground(Color.black);
					lblError.setVisible(false);
					txtBattleArea.setText("");
					btnStartBattle.setEnabled(true);
					btnGotoWinner.setVisible(false);
					btnStartBattle.setVisible(true);
				}
				else {
					// IF NOT ENOUGH GOLD, CHANGE COLOR TO RED / ERROR MSG
					lblGold3.setForeground(Color.red);
					lblError.setVisible(true);
				}
			}
		});
		btnPurchase.setPreferredSize(new Dimension(65, 23));
		btnPurchase.setMinimumSize(new Dimension(65, 23));
		btnPurchase.setMaximumSize(new Dimension(65, 23));
		btnPurchase.setForeground(Color.WHITE);
		btnPurchase.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btnPurchase.setBackground(new Color(51, 153, 102));
		btnPurchase.setBounds(452, 331, 172, 44);
		pnlArmoury.add(btnPurchase);
		
		lblAgility1 = new JLabel("");
		lblAgility1.setVerticalAlignment(SwingConstants.TOP);
		lblAgility1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblAgility1.setBorder(null);
		lblAgility1.setBounds(430, 262, 150, 29);
		pnlArmoury.add(lblAgility1);
		
		lblCost1 = new JLabel("");
		lblCost1.setVerticalAlignment(SwingConstants.TOP);
		lblCost1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblCost1.setBorder(null);
		lblCost1.setBounds(430, 291, 150, 29);
		pnlArmoury.add(lblCost1);
		
		lblError = new JLabel("NOT ENOUGH GOLD");
		lblError.setVisible(false);
		lblError.setForeground(Color.RED);
		lblError.setVerticalAlignment(SwingConstants.TOP);
		lblError.setHorizontalTextPosition(SwingConstants.CENTER);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lblError.setBorder(null);
		lblError.setBounds(48, 331, 180, 29);
		pnlArmoury.add(lblError);
		
		JLabel lblArmoury1Background = new JLabel("");
		lblArmoury1Background.setIcon(new ImageIcon(GameApp.class.getResource("/GamePics/Background1.jpg")));
		lblArmoury1Background.setBounds(0, 0, 634, 386);
		pnlArmoury.add(lblArmoury1Background);

// BATTLE PANEL -----------------------------------------------------------------------------------------------------------

		pnlBattle = new JPanel();
		frame.getContentPane().add(pnlBattle, "name_2287143160316");
		pnlBattle.setLayout(null);
		
		JLabel lblRun = new JLabel("RUN!");
		lblRun.setHorizontalAlignment(SwingConstants.CENTER);
		lblRun.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));
		lblRun.setBounds(256, 11, 123, 45);
		pnlBattle.add(lblRun);
		
		lblBattlePlayer = new JLabel("");
		lblBattlePlayer.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblBattlePlayer.setBounds(10, 47, 180, 250);
		pnlBattle.add(lblBattlePlayer);
		
		lblEnemy = new JLabel("");
		lblEnemy.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblEnemy.setBounds(444, 47, 180, 250);
		pnlBattle.add(lblEnemy);
		
		lblPlayerStats = new JLabel("");
		lblPlayerStats.setBorder(null);
		lblPlayerStats.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPlayerStats.setVerticalAlignment(SwingConstants.TOP);
		lblPlayerStats.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lblPlayerStats.setBounds(73, 308, 117, 37);
		pnlBattle.add(lblPlayerStats);
		
		lblEnemyStats = new JLabel("");
		lblEnemyStats.setHorizontalTextPosition(SwingConstants.LEADING);
		lblEnemyStats.setBorder(null);
		lblEnemyStats.setVerticalAlignment(SwingConstants.TOP);
		lblEnemyStats.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lblEnemyStats.setBounds(444, 308, 117, 37);
		pnlBattle.add(lblEnemyStats);
		
		btnStartBattle = new JButton("START BATTLE");
		btnStartBattle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStartBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// START THE TIMER
				timer.start();
				btnStartBattle.setEnabled(false);


			}
		});
		btnStartBattle.setPreferredSize(new Dimension(65, 23));
		btnStartBattle.setMinimumSize(new Dimension(65, 23));
		btnStartBattle.setMaximumSize(new Dimension(65, 23));
		btnStartBattle.setForeground(Color.WHITE);
		btnStartBattle.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btnStartBattle.setBackground(new Color(51, 153, 102));
		btnStartBattle.setBounds(232, 308, 170, 44);
		pnlBattle.add(btnStartBattle);
		
		txtBattleArea = new JTextArea();
		txtBattleArea.setEditable(false);
		txtBattleArea.setDisabledTextColor(Color.BLACK);
		txtBattleArea.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		txtBattleArea.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtBattleArea.setBorder(null);
		txtBattleArea.setBounds(200, 84, 234, 213);
		txtBattleArea.setBackground(new Color(146, 227, 255));
		
		JScrollBattle = new JScrollPane(txtBattleArea);
		JScrollBattle.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JScrollBattle.setBackground(new Color(146, 227, 255));
		JScrollBattle.setForeground(new Color(146, 227, 255));
		JScrollBattle.setFont(new Font("Yu Gothic UI", Font.PLAIN, 5));
		JScrollBattle.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		JScrollBattle.setBounds(200, 56, 234, 241);
		JScrollBattle.setBorder(null);
		pnlBattle.add(JScrollBattle);
		
		btnGotoWinner = new JButton("NEXT");
		btnGotoWinner.setVisible(false);
		btnGotoWinner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// GO TO WINNER PANEL
				pnlBattle.setVisible(false);
				pnlPlayerSelect.setVisible(false);
				pnlStartPage.setVisible(false);
				pnlArmoury.setVisible(false);
				pnlWinner.setVisible(true);
				characters.get(0).resetHealth();
				characters.get(1).resetHealth();
				lblPlayerStats.setText("Health : "+characters.get(lstPlayerSelect.getSelectedIndex()).getCurrentHealth());
				lblEnemyStats.setText("Health : "+characters.get(lstPlayerSelect.getSelectedIndex()).getCurrentHealth());
			}
		});
		btnGotoWinner.setPreferredSize(new Dimension(65, 23));
		btnGotoWinner.setMinimumSize(new Dimension(65, 23));
		btnGotoWinner.setMaximumSize(new Dimension(65, 23));
		btnGotoWinner.setForeground(Color.WHITE);
		btnGotoWinner.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btnGotoWinner.setBackground(new Color(51, 153, 102));
		btnGotoWinner.setBounds(232, 308, 170, 44);
		pnlBattle.add(btnGotoWinner);
		
		JLabel lblBattleBackground = new JLabel("");
		lblBattleBackground.setIcon(new ImageIcon(GameApp.class.getResource("/GamePics/Background1.jpg")));
		lblBattleBackground.setBounds(0, 0, 634, 386);
		pnlBattle.add(lblBattleBackground);
		
		// TIMER
		timer = new Timer(2000, new BattleHandler());
		
// WINNER PANEL -----------------------------------------------------------------------------------------------------------		

		pnlWinner = new JPanel();
		frame.getContentPane().add(pnlWinner, "name_2287143160316");
		pnlWinner.setLayout(null);
		
		JLabel lblWinner = new JLabel("WINNER!!");
		lblWinner.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinner.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));
		lblWinner.setBounds(144, 24, 347, 45);
		pnlWinner.add(lblWinner);
		
		lblWinnerPic = new JLabel("");
		lblWinnerPic.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));     
		lblWinnerPic.setBounds(233, 80, 180, 250);
		pnlWinner.add(lblWinnerPic);		
		
		btnNextWinner = new JButton("NEXT");
		btnNextWinner.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNextWinner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblArmour.setIcon(null);
				btnPurchase.setText("BATTLE AGAIN");				
				btnPurchase.setEnabled(false);
				pnlBattle.setVisible(false);
				pnlPlayerSelect.setVisible(false);
				pnlStartPage.setVisible(false);
				pnlArmoury.setVisible(true);
				pnlWinner.setVisible(false);
			}
		});  
			   
		btnNextWinner.setMinimumSize(new Dimension(65, 23));
		btnNextWinner.setMaximumSize(new Dimension(65, 23));
		btnNextWinner.setForeground(Color.WHITE);
		btnNextWinner.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btnNextWinner.setBackground(new Color(147, 57, 4));
		btnNextWinner.setBounds(514, 331, 110, 44);
		pnlWinner.add(btnNextWinner);
		
		JLabel lblWinnerBackground = new JLabel("");
		lblWinnerBackground.setIcon(new ImageIcon(GameApp.class.getResource("/GamePics/Background.jpg")));
		lblWinnerBackground.setBounds(0, 0, 634, 386);
		pnlWinner.add(lblWinnerBackground);
	}
	
// END OF GUI / BATTLE METHOD-------------------------------------------------------------------------------------------------
		
	private void battle() {
		int damage;
		
		//ROLL TWO NUMBERS
		int playerRoll = (int)(Math.random() * 6 + 1);
		int enemyRoll = (int)(Math.random() * 6 + 1);

		//COMPARE NUMBERS / CALL ATTACK METHOD / OUTPUT TO TEXTBOX
		if(playerRoll >= enemyRoll) {
			switch(player) {
			case "Wile E. Coyote":
				damage = characters.get(0).attack();
				characters.get(1).dealDamage(damage);
				txtBattleArea.append("\n---------------------------------------------------"
						+ "\n Wile E caught Road Runner for "+damage+" HP!"
						+ "\n---------------------------------------------------");
				lblEnemyStats.setText("Health : "+characters.get(1).getCurrentHealth());
				if(characters.get(1).getCurrentHealth() == 0)
					lblEnemyStats.setForeground(Color.red);
				break;
			case "Road Runner":
				damage = characters.get(1).attack();
				characters.get(0).dealDamage(damage);
				txtBattleArea.append("\n---------------------------------------------------"
						+ "\n Wile E. fell off a cliff! Minus "+damage+" HP!"
						+ "\n---------------------------------------------------");
				lblEnemyStats.setText("Health : "+characters.get(0).getCurrentHealth());
				if(characters.get(0).getCurrentHealth() == 0)
					lblEnemyStats.setForeground(Color.red);
				break;
			}
		} else {
			switch(player) {
			case "Wile E. Coyote":
				damage = characters.get(1).attack();
				characters.get(0).dealDamage(damage);
				txtBattleArea.append("\n---------------------------------------------------"
						+ "\n Road Runner out ran Wile E. for "+damage+" HP!"
						+ "\n---------------------------------------------------");
				lblPlayerStats.setText("Health : "+characters.get(0).getCurrentHealth());
				if(characters.get(0).getCurrentHealth() == 0)
					lblPlayerStats.setForeground(Color.red);
				break;
			case "Road Runner":
				damage = characters.get(0).attack();
				characters.get(1).dealDamage(damage);
				txtBattleArea.append("\n---------------------------------------------------"
						+ "\n Road Runner tripped! Minus "+damage+" HP!"
						+"\n---------------------------------------------------");
				lblPlayerStats.setText("Health : "+characters.get(1).getCurrentHealth());
				if(characters.get(1).getCurrentHealth() == 0)
					lblPlayerStats.setForeground(Color.red);
				break;
			}			
		}
			
		// CHECK IF ANYONE IS DEAD
		if(characters.get(0).getCurrentHealth() <= 0 || characters.get(1).getCurrentHealth() <= 0) {
			
			// STOP TIMER / SLEEP FOR 3.5 SECONDS
			timer.stop();
			
			// SET WINNER PICTURE
			if(characters.get(0).getCurrentHealth() > 0) {
				lblWinnerPic.setIcon(playerPicArray[0]);
			}
			else if(characters.get(1).getCurrentHealth() > 0) {
				lblWinnerPic.setIcon(playerPicArray[1]);
			}
			
			// GIVE THE PLAYERS GOLD
			switch(player) {
			case "Wile E. Coyote":
				if(characters.get(0).getCurrentHealth() <= 0) {
					characters.get(0).addGold(0);
					lblGold3.setText("Available gold :  "+ characters.get(0).getGold());
				}
				else {
					characters.get(0).addGold((int)(Math.random() * 130 + 60));
					lblGold3.setText("Available gold :  "+ characters.get(0).getGold());					
				}
				break;
			case "Road Runner":
				if(characters.get(1).getCurrentHealth() <= 0) {
					characters.get(1).addGold(0);
					lblGold3.setText("Available gold :  "+ characters.get(1).getGold());
				}
				else {
					characters.get(1).addGold((int)(Math.random() * 130 + 60));
					lblGold3.setText("Available gold :  "+ characters.get(1).getGold());					
				}
				break;
			}
			
			btnGotoWinner.setVisible(true);
			btnStartBattle.setVisible(false);
	
		}		
	}
	
	public class BattleHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			battle();
		}	
	}
}

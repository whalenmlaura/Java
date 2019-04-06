//Author: Laura Whalen

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.border.TitledBorder;

public class AppWindow {

	private JFrame frame;
	private JPanel AppPanel;
	private JPanel ReportPanel;
	private JTextField WeightText;
	private JTextField GPSText;
	private JTextField SpotsText;
	private JTextField BPText;
	private JButton AddButton;
	private JButton ReportButton;
	private JButton ExitButton;
	private JLabel PictureLabel;
	private JLabel SexLabel;
	private JLabel WeightLabel;
	private JLabel GPSLabel;
	private JLabel BPLabel;
	private JLabel SpotsLabel;
	private JLabel DentalHealthLabel;
	private JLabel BackgroundLabel;
	private JLabel lblNewLabel;
	private JLabel AnimalReportButton;
	private JTextArea ReportArea;
	private JScrollPane scrollPane;
	@SuppressWarnings("rawtypes")
	private JList DentalList;
	@SuppressWarnings("rawtypes")
	private JList AnimalList;
	@SuppressWarnings("rawtypes")
	private JList SexList;
	
	private String sex = "";
	private String species = "";
	private double weight = 0;
	private String gps = "";
	private double BP = 0;
	public String dental = "";
	public int numSpots = 0;
	private String finalReport = "";
	private ImageIcon[] AnimalPicArray = new ImageIcon[3];
	private ControllerReport controllerReport = new ControllerReport();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindow window = new AppWindow();
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
	public AppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
// ADD ANIMAL IMAGES ---------------------------------------------------------------------------------
		AnimalPicArray[0] = new ImageIcon(AppWindow.class.getResource("/Pictures/Penguin.jpg"));
		AnimalPicArray[1] = new ImageIcon(AppWindow.class.getResource("/Pictures/SeaLion.jpg"));
		AnimalPicArray[2] = new ImageIcon(AppWindow.class.getResource("/Pictures/Walrus.jpg"));

// MAIN PANEL ----------------------------------------------------------------------------------------		
		AppPanel = new JPanel();
		AppPanel.setAutoscrolls(true);
		frame.getContentPane().add(AppPanel, "name_49582423213070");
		AppPanel.setLayout(null);
						
		DentalList = new JList();
		DentalList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		DentalList.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		DentalList.setVisible(false);
		DentalList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Good", "Average", "Poor"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		DentalList.setBounds(482, 200, 142, 61);
		AppPanel.add(DentalList);

// SETTING WHAT IS VISIBLE WHEN SPECIES ARE SELECTED --------------------------------------------------		
		AnimalList = new JList();
		AnimalList.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		AnimalList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		AnimalList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(AnimalList.getSelectedIndex() == 0) {
					resetDisplay(); //if new animal selected, reset display
					PictureLabel.setIcon(AnimalPicArray[0]);
					BPText.setVisible(true);
					BPLabel.setVisible(true);
					SpotsText.setVisible(false);
					SpotsLabel.setVisible(false);
					DentalList.setVisible(false);
					DentalHealthLabel.setVisible(false);
					AddButton.setEnabled(true);
				}
				else if(AnimalList.getSelectedIndex() == 1) {
					resetDisplay();
					PictureLabel.setIcon(AnimalPicArray[1]);
					BPText.setVisible(false);
					BPLabel.setVisible(false);
					SpotsText.setVisible(true);
					SpotsLabel.setVisible(true);
					DentalList.setVisible(false);
					DentalHealthLabel.setVisible(false);
					AddButton.setEnabled(true);
				}	
				else if (AnimalList.getSelectedIndex() == 2) {
					resetDisplay();
					PictureLabel.setIcon(AnimalPicArray[2]);
					BPText.setVisible(false);
					BPLabel.setVisible(false);
					SpotsText.setVisible(false);
					SpotsLabel.setVisible(false);
					DentalList.setVisible(true);
					DentalHealthLabel.setVisible(true);
					AddButton.setEnabled(true);
				}
				else {
					AddButton.setEnabled(false);
				}
			}});
		
		AnimalList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Penquin", "Sea Lion", "Walrus"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		AnimalList.setBounds(10, 48, 134, 55);
		AppPanel.add(AnimalList);
		
		PictureLabel = new JLabel("");
		PictureLabel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		PictureLabel.setBounds(10, 129, 284, 184);
		AppPanel.add(PictureLabel);
		
		AddButton = new JButton("ADD");
		AddButton.setFont(new Font("Century Gothic", Font.BOLD, 18));
		AddButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		AddButton.setBackground(new Color(84,123,188));
		AddButton.setForeground(Color.WHITE);
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Validation(); //when add button is clicked, call the validation method
			}
		});
		AddButton.setEnabled(false);
		AddButton.setBounds(512, 272, 112, 41);
		AppPanel.add(AddButton);
		
		ReportButton = new JButton("REPORT");
		ReportButton.setFont(new Font("Century Gothic", Font.BOLD, 18));
		ReportButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ReportButton.setBackground(new Color(84,123,188));
		ReportButton.setForeground(Color.WHITE);
		ReportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//when report button is clicked, call the write method,
				//switch panels, and call read method to display report
				controllerReport.writeReport();
				finalReport = controllerReport.readReport("AnimalReport.txt");
				ReportArea.setText(finalReport);
				AppPanel.setVisible(false);
				ReportPanel.setVisible(true);	
			}
		});
		ReportButton.setEnabled(false);
		ReportButton.setBounds(354, 272, 112, 41);
		AppPanel.add(ReportButton);
		
		WeightText = new JTextField();
		WeightText.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		WeightText.setColumns(10);
		WeightText.setBounds(450, 120, 174, 29);
		AppPanel.add(WeightText);
		
		GPSText = new JTextField();
		GPSText.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		GPSText.setColumns(10);
		GPSText.setBounds(450, 160, 174, 29);
		AppPanel.add(GPSText);
		
		SpotsText = new JTextField();
		SpotsText.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		SpotsText.setVisible(false);
		SpotsText.setColumns(10);
		SpotsText.setBounds(450, 200, 174, 29);
		AppPanel.add(SpotsText);
		
		BPText = new JTextField();
		BPText.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		BPText.setVisible(false);
		BPText.setColumns(10);
		BPText.setBounds(490, 200, 134, 29);
		AppPanel.add(BPText);
		
		SexLabel = new JLabel("Sex");
		SexLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		SexLabel.setBounds(354, 68, 50, 41);
		AppPanel.add(SexLabel);
		
		WeightLabel = new JLabel("Weight (kg)");
		WeightLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		WeightLabel.setBounds(354, 120, 112, 29);
		AppPanel.add(WeightLabel);
		
		GPSLabel = new JLabel("GPS");
		GPSLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		GPSLabel.setBounds(354, 160, 50, 29);
		AppPanel.add(GPSLabel);
		
		BPLabel = new JLabel("Blood Pressure");
		BPLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		BPLabel.setVisible(false);
		BPLabel.setBounds(354, 200, 142, 29);
		AppPanel.add(BPLabel);
		
		SpotsLabel = new JLabel("Spots");
		SpotsLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		SpotsLabel.setVisible(false);
		SpotsLabel.setBounds(354, 200, 86, 29);
		AppPanel.add(SpotsLabel);
		
		DentalHealthLabel = new JLabel("Dental Health");
		DentalHealthLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		DentalHealthLabel.setVisible(false);
		DentalHealthLabel.setBounds(354, 200, 142, 29);
		AppPanel.add(DentalHealthLabel);

		SexList = new JList();
		SexList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SexList.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		SexList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Male", "Female"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		SexList.setBounds(450, 68, 174, 41);
		AppPanel.add(SexList);
		
		BackgroundLabel = new JLabel("");
		BackgroundLabel.setIcon(new ImageIcon(AppWindow.class.getResource("/Pictures/Background.jpg")));
		BackgroundLabel.setBounds(0, 0, 634, 326);
		AppPanel.add(BackgroundLabel);
		
		ReportPanel = new JPanel();
		frame.getContentPane().add(ReportPanel, "name_8732603187088");
		ReportPanel.setLayout(null);
		
		ExitButton = new JButton("EXIT");
		ExitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//when exit is clicked, close the program
				frame.dispose();
				System.exit(0);
			}
		});
		ExitButton.setFont(new Font("Century Gothic", Font.BOLD, 18));
		ExitButton.setForeground(Color.WHITE);
		ExitButton.setBackground(new Color(84,123,188));
		ExitButton.setBounds(512, 274, 112, 41);
		ReportPanel.add(ExitButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 614, 190);
		ReportPanel.add(scrollPane);
		
		ReportArea = new JTextArea();
		ReportArea.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		ReportArea.setBorder(null);
		scrollPane.setViewportView(ReportArea);
		
		AnimalReportButton = new JLabel("ANIMAL REPORT");
		AnimalReportButton.setForeground(Color.WHITE);
		AnimalReportButton.setFont(new Font("Century Gothic", Font.BOLD, 34));
		AnimalReportButton.setHorizontalTextPosition(SwingConstants.CENTER);
		AnimalReportButton.setHorizontalAlignment(SwingConstants.CENTER);
		AnimalReportButton.setBounds(157, 23, 316, 46);
		ReportPanel.add(AnimalReportButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AppWindow.class.getResource("/Pictures/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 634, 326);
		ReportPanel.add(lblNewLabel);
	}
	
// RESET DISPLAY METHOD ----------------------------------------------------------------------------------
	
	public void resetDisplay() {
		//set the borders back to black, text boxes to "", and clear selection of lists
		SexList.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		SexList.clearSelection();
		WeightText.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		WeightText.setText("");
		GPSText.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		GPSText.setText("");
		BPText.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		BPText.setText("");
		SpotsText.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		SpotsText.setText("");
		DentalList.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		DentalList.clearSelection();
	}	
	
// VALIDATION METHOD -------------------------------------------------------------------------------------	
	
	public void Validation() {
		boolean valid = true; //default set to valid unless there is an error
			
		//SEX VALIDATION ----------------------------------------------------------------
		if(SexList.getSelectedIndex() == 0) {
			sex = "Male";
			SexList.setBorder(BorderFactory.createLineBorder(new Color(0, 204, 51), 2)); //GREEN COLOR
		}
		else if(SexList.getSelectedIndex() == 1) {
			sex = "Female";
			SexList.setBorder(BorderFactory.createLineBorder(new Color(0, 204, 51), 2));
		}
		else {
			valid = false; //error, therefore valid = false
			SexList.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		}
		 
		//WEIGHT VALIDATION -------------------------------------------------------------
		if(WeightText.getText().matches("[0-9]*\\.?[0-9]{1,2}+")) { //optional decimal with maximum of 2 decimal places
			WeightText.setBorder(BorderFactory.createLineBorder(new Color(0, 204, 51), 2));
			weight = Double.parseDouble(WeightText.getText());
		}
		else {
			valid = false;
			WeightText.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		}
		
		//GPS VALIDATION ---------------------------------------------------------------
		if(GPSText.getText().matches("^-?([1-8]?\\d(\\.\\d{6,8})?|90\\.\\d{6,8})\\s-?(180(\\.\\d{6,8})?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d{6,8})?)$")) { 
			//GPS REGEX - https://stackoverflow.com/questions/3518504/regular-expression-for-matching-latitude-longitude-coordinates
			//(-)90-90 with 6-8 decimal places, (-)180-180 with 6-8 decimal places
			GPSText.setBorder(BorderFactory.createLineBorder(new Color(0, 204, 51), 2));
			gps = (GPSText.getText());
		}
		else {
			valid = false;
			GPSText.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		}
		
		
		//ANIMAL VALIDATION VALIDATION ---------------------------------------------------
		if(AnimalList.getSelectedIndex() == 0)
			species = "Penguin";	
		else if(AnimalList.getSelectedIndex() == 1)
			species = "Sea Lion";	
		else if(AnimalList.getSelectedIndex() == 2)
			species = "Walrus";	
		else {
			valid = false;
			AnimalList.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		}
		
		//SPICIES SPECIFIC (SO THEY GET A BOARDER IF OTHERS PROPERTIES ARE NOT VALID) -----
		if(BPText.getText().matches("[0-9]*\\.?[0-9]{1,2}+")) //optional decimal with maximum of 2 decimal places
			BPText.setBorder(BorderFactory.createLineBorder(new Color(0, 204, 51), 2));
		else
			BPText.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		if(SpotsText.getText().matches("^\\d+$")) //any digits, no decimal places
			SpotsText.setBorder(BorderFactory.createLineBorder(new Color(0, 204, 51), 2));
		else
			SpotsText.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		if(DentalList.getSelectedIndex() == 0)
			DentalList.setBorder(BorderFactory.createLineBorder(new Color(0, 204, 51), 2));
		else if(DentalList.getSelectedIndex() == 1)
			DentalList.setBorder(BorderFactory.createLineBorder(new Color(0, 204, 51), 2));
		else if(DentalList.getSelectedIndex() == 2)
			DentalList.setBorder(BorderFactory.createLineBorder(new Color(0, 204, 51), 2));
		else 
			DentalList.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		
		//IF EVERYTHING ABOVE IS VALID -------------------------------------------------
		if(valid) {			
			//IF PENQUIN IS SELECTION --------------------------------------------------
			if(AnimalList.getSelectedIndex() == 0) {
				//CHECK BLOOD PRESSURE ------------------------------------
				if(BPText.getText().matches("[0-9]*\\.?[0-9]{1,2}+")) {
					BP = Double.parseDouble(BPText.getText()); //convert String to double
					JOptionPane.showMessageDialog(frame, "Penguin successfully added");
					//CALL OVERLOAD ADDANIMAL METHOD 
					controllerReport.addAnimal(species, sex, weight, gps, BP);
					ReportButton.setEnabled(true);
					resetDisplay();
				}
				else
					BPText.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			}
						
			//IF SEA LION ------------------------------------------------
			else if(AnimalList.getSelectedIndex() == 1){
				//CHECK SPOTS --------------------------------------------
				if(SpotsText.getText().matches("^\\d+$")) {
					numSpots = Integer.parseInt(SpotsText.getText()); //convert String to int
					JOptionPane.showMessageDialog(frame, "Sea Lion successfully added");
					controllerReport.addAnimal(species, sex, weight, gps, numSpots);
					ReportButton.setEnabled(true);
					resetDisplay();
				}
				else
					SpotsText.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			}
			
			//IF WALRUS --------------------------------------------------
			else if(AnimalList.getSelectedIndex() == 2) {
				//CHECK DENTAL -------------------------------------------
				if(DentalList.getSelectedIndex() == 0) {
					dental = "Good";	
					JOptionPane.showMessageDialog(frame, "Walrus successfully added");
					controllerReport.addAnimal(species, sex, weight, gps, dental);
					ReportButton.setEnabled(true);
					resetDisplay();
				}
				else if(DentalList.getSelectedIndex() == 1) {
					dental = "Average";
					JOptionPane.showMessageDialog(frame, "Walrus successfully added");
					controllerReport.addAnimal(species, sex, weight, gps, dental);
					ReportButton.setEnabled(true);
					resetDisplay();
				}	
				else if(DentalList.getSelectedIndex() == 2){
					dental = "Poor";
					JOptionPane.showMessageDialog(frame, "Walrus successfully added");
					controllerReport.addAnimal(species, sex, weight, gps, dental);
					ReportButton.setEnabled(true);
					resetDisplay();
				}
				else
					DentalList.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			}
		}

	}
}	



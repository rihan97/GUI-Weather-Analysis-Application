import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIReal extends JFrame {
	
	WA w = new WA();
	
	
	private JPanel contentPane;
	private JTextField txtWeatherAnalysis;
	private JCheckBox chckbxBradford;
	private JCheckBox chckbxBraemar;
	private JCheckBox chckbxCamborne;
	private JCheckBox chckbxEastbourne;
	private JCheckBox chckbxSheffieldcsv;
	private JCheckBox chckbxSheffieldtxt;
	private JLabel lblSelectDataType;
	private JCheckBox chckbxTemMax;
	private JCheckBox chckbxTemMin;
	private JCheckBox chckbxAirForest;
	private JCheckBox chckbxRainfall;
	private JCheckBox chckbxSun;
	private JLabel lblSelectTheRegion;

	String CheckBoxSelection;

	static String line;
	private JLabel lblAve;
	private JLabel lblMin;

	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIReal frame = new GUIReal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//main function calling the appropriate functions
	
	

	/**
	 * Create the frame.
	 */
	public GUIReal() {
		setTitle("Rayhan Alam - Assignment 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 25, 807, 63);
		contentPane.add(panel);

		txtWeatherAnalysis = new JTextField();
		txtWeatherAnalysis.setForeground(Color.WHITE);
		txtWeatherAnalysis.setBackground(Color.BLACK);
		txtWeatherAnalysis.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 52));
		txtWeatherAnalysis.setText("Weather Analysis");
		panel.add(txtWeatherAnalysis);
		txtWeatherAnalysis.setColumns(10);

		JButton BtnCreateGraph = new JButton("Create Graph");
		BtnCreateGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BtnCreateGraph.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// code to read and plot the data from checkboxes onto the graph.. need to create a graph class to link with this

				if(chckbxSheffieldcsv.isSelected() && (chckbxTemMax.isSelected())) {
					w.ChartTempMax();		//Function responsible for creating chart
					w.sheffieldcsvTMax();	//Read data from file, perform analysis and display the results				
				}
				
				
				if(chckbxSheffieldcsv.isSelected() && (chckbxTemMin.isSelected())) {
					w.sheffieldcsvTmin();
					w.ChartTempMin();
				}


				if(chckbxSheffieldcsv.isSelected() && (chckbxAirForest.isSelected())) {
					w.sheffieldcsvAirForest();
					w.ChartAirForest();
					
				}

				


				if(chckbxSheffieldcsv.isSelected() && (chckbxRainfall.isSelected())) {
					w.sheffieldcsvRain();	
					w.ChartRain();
				}


				if(chckbxSheffieldcsv.isSelected() && (chckbxSun.isSelected())) {
					w.ChartSun();
					w.sheffieldcsvSun();
				}
				
				
				if(chckbxBradford.isSelected() && (chckbxTemMax.isSelected())) {
					w.bradfordTmax();
					w.ChartTempMax();
				}



				if(chckbxBradford.isSelected() && (chckbxTemMin.isSelected())) {
					w.bradfordTmin();
					w.ChartTempMin();
				}


				if(chckbxBradford.isSelected() && (chckbxAirForest.isSelected())) {
					w.bradfordAirForest();
					w.ChartAirForest();
				}
				

				if(chckbxBradford.isSelected() && (chckbxRainfall.isSelected())) {
					w.bradfordRain();
					w.ChartRain();
				}


				if(chckbxBradford.isSelected() && (chckbxSun.isSelected())) {
					w.bradfordSun();
					w.ChartSun();
				}


				if(chckbxBraemar.isSelected()  && (chckbxTemMax.isSelected())) {
					w.braemarTmax();
					w.ChartTempMax();
				}



				if(chckbxBraemar.isSelected()  && (chckbxTemMin.isSelected())) {
					w.braemarTmin();
					w.ChartTempMin();
				}



				if(chckbxBraemar.isSelected()  && (chckbxAirForest.isSelected())) {
					w.braemarAirForest();
					w.ChartAirForest();
				}


				if(chckbxBraemar.isSelected()  && (chckbxRainfall.isSelected())) {
					w.braemarRain();
					w.ChartRain();
				}


				if(chckbxBraemar.isSelected()  && (chckbxSun.isSelected())) {
					w.braemarSun();
					w.ChartSun();
				}



				if(chckbxCamborne.isSelected() && (chckbxTemMax.isSelected())) {
					w.camborneTmax();
					w.ChartTempMax();
				}



				if(chckbxCamborne.isSelected() && (chckbxTemMin.isSelected())) {
					w.camborneTmin();
					w.ChartTempMin();
				}


				if(chckbxCamborne.isSelected() && (chckbxAirForest.isSelected())) {
					w.camborneAirForest();
					w.ChartAirForest();
				}



				if(chckbxCamborne.isSelected() && (chckbxRainfall.isSelected())) {
					w.camborneRain();
					w.ChartRain();
				}


				if(chckbxCamborne.isSelected() && (chckbxSun.isSelected())) {
					w.camborneSun();
					w.ChartSun();
				}


				if(chckbxEastbourne.isSelected() && (chckbxTemMax.isSelected())) {
					w.eastbourneTmax();
					w.ChartTempMax();
				}



				if(chckbxEastbourne.isSelected() && (chckbxTemMin.isSelected())) {
					w.eastbourneTmin();
					w.ChartTempMin();
				}


				if(chckbxEastbourne.isSelected() && (chckbxAirForest.isSelected())) {
					w.eastbourneAirForest();
					w.ChartAirForest();
				}



				if(chckbxEastbourne.isSelected() && (chckbxRainfall.isSelected())) {
					w.eastbourneRain();
					w.ChartRain();
				}

				
				if(chckbxEastbourne.isSelected() && (chckbxSun.isSelected())) {
					w.eastbourneSun();
					w.ChartSun();
				}


				if(chckbxSheffieldtxt.isSelected() && (chckbxTemMax.isSelected())) {
					w.sheffieldtxtTmax();
					w.ChartTempMax();
				}

				
				if(chckbxSheffieldtxt.isSelected() && (chckbxTemMin.isSelected())) {
					w.sheffieldtxtTmin();
					w.ChartTempMin();
				}


				if(chckbxSheffieldtxt.isSelected() && (chckbxAirForest.isSelected())) {
					w.sheffieldtxtAirForest();
					w.ChartAirForest();
				}

				
				if(chckbxSheffieldtxt.isSelected() && (chckbxRainfall.isSelected())) {
					w.sheffieldtxtRain();
					w.ChartRain();
				}

				if(chckbxSheffieldtxt.isSelected() && (chckbxSun.isSelected())) {
					w.sheffieldcsvSun();
					w.ChartSun();
				}

				
			}
				
		});
		BtnCreateGraph.setFont(new Font("Tahoma", Font.BOLD, 16));
		BtnCreateGraph.setBounds(288, 465, 176, 52);
		contentPane.add(BtnCreateGraph);

		JLabel lblKey = new JLabel("KEY");
		lblKey.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblKey.setHorizontalAlignment(SwingConstants.CENTER);
		lblKey.setBounds(605, 131, 98, 27);
		contentPane.add(lblKey);

		JPanel panelKeyBckGrnd = new JPanel();
		panelKeyBckGrnd.setBackground(Color.GRAY);
		panelKeyBckGrnd.setBounds(533, 171, 262, 304);
		contentPane.add(panelKeyBckGrnd);
		panelKeyBckGrnd.setLayout(null);
		
		JLabel lblMax = new JLabel("Maximum");
		lblMax.setBounds(66, 5, 130, 25);
		lblMax.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblMax.setForeground(Color.GREEN);
		lblMax.setBackground(Color.WHITE);
		panelKeyBckGrnd.add(lblMax);
		
		lblAve = new JLabel("Average ");
		lblAve.setForeground(Color.BLUE);
		lblAve.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblAve.setHorizontalAlignment(SwingConstants.CENTER);
		lblAve.setBounds(55, 92, 130, 35);
		panelKeyBckGrnd.add(lblAve);
		
		lblMin = new JLabel("Minimum");
		lblMin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblMin.setForeground(Color.RED);
		lblMin.setBounds(79, 188, 130, 35);
		panelKeyBckGrnd.add(lblMin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		panel_1.setForeground(Color.GREEN);
		panel_1.setBounds(55, 43, 154, 35);
		panelKeyBckGrnd.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.BLUE);
		panel_2.setBackground(Color.BLUE);
		panel_2.setBounds(55, 140, 154, 35);
		panelKeyBckGrnd.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.RED);
		panel_3.setBackground(Color.RED);
		panel_3.setBounds(55, 236, 154, 35);
		panelKeyBckGrnd.add(panel_3);



		chckbxBradford = new JCheckBox("Bradford Data");
		chckbxBradford.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxBradford.setBounds(8, 147, 125, 25);
		contentPane.add(chckbxBradford);

		chckbxBraemar = new JCheckBox("Braemar Data");
		chckbxBraemar.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxBraemar.setBounds(8, 193, 125, 25);
		contentPane.add(chckbxBraemar);

		chckbxCamborne = new JCheckBox("Camborne Data");
		chckbxCamborne.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxCamborne.setBounds(8, 244, 133, 25);
		contentPane.add(chckbxCamborne);

		chckbxEastbourne = new JCheckBox("Eastbourne Data");
		chckbxEastbourne.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxEastbourne.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxEastbourne.setBounds(8, 297, 144, 25);
		contentPane.add(chckbxEastbourne);

		chckbxSheffieldcsv = new JCheckBox("Sheffield CSV Data");
		chckbxSheffieldcsv.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxSheffieldcsv.setBounds(8, 401, 155, 25);
		contentPane.add(chckbxSheffieldcsv);

		chckbxSheffieldtxt = new JCheckBox("Sheffield txt Data");
		chckbxSheffieldtxt.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxSheffieldtxt.setBounds(8, 348, 144, 25);
		contentPane.add(chckbxSheffieldtxt);

		lblSelectTheRegion = new JLabel("Select the region for the weather analysis:");
		lblSelectTheRegion.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSelectTheRegion.setBounds(8, 115, 375, 16);
		contentPane.add(lblSelectTheRegion);

		lblSelectDataType = new JLabel("Select data type to be read:");
		lblSelectDataType.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSelectDataType.setBounds(243, 181, 244, 16);
		contentPane.add(lblSelectDataType);

		chckbxTemMax = new JCheckBox("Temperature Maximum (DegC)");
		chckbxTemMax.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxTemMax.setBounds(243, 218, 232, 25);
		contentPane.add(chckbxTemMax);

		chckbxTemMin = new JCheckBox("Temperature Minimum (DegC)");
		chckbxTemMin.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxTemMin.setBounds(243, 264, 221, 25);
		contentPane.add(chckbxTemMin);

		chckbxAirForest = new JCheckBox("Air Forest (Days)");
		chckbxAirForest.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxAirForest.setBounds(243, 309, 140, 25);
		contentPane.add(chckbxAirForest);

		chckbxRainfall = new JCheckBox("Rainfall (MM)");
		chckbxRainfall.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxRainfall.setBounds(243, 348, 113, 27);
		contentPane.add(chckbxRainfall);

		chckbxSun = new JCheckBox("Sun (Hours)");
		chckbxSun.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxSun.setBounds(243, 390, 113, 25);
		contentPane.add(chckbxSun);


		evente e = new evente();
		chckbxBradford.addItemListener(e);
		chckbxBraemar.addItemListener(e);
		chckbxCamborne.addItemListener(e);
		chckbxEastbourne.addItemListener(e);
		chckbxSheffieldcsv.addItemListener(e);
		chckbxSheffieldtxt.addItemListener(e);

		eventj j = new eventj();
		chckbxTemMax.addItemListener(j);
		chckbxTemMin.addItemListener(j);
		chckbxAirForest.addItemListener(j);
		chckbxRainfall.addItemListener(j);
		chckbxSun.addItemListener(j);
	}


	public class evente implements  ItemListener{
		public void itemStateChanged(ItemEvent e){
			String Bradforddata = "raw/bradforddata.txt";
		
				if(chckbxBradford.isSelected()) {
					CheckBoxSelection= Bradforddata;
					chckbxBraemar.setSelected(false);
					chckbxCamborne.setSelected(false);
					chckbxEastbourne.setSelected(false);
					chckbxSheffieldcsv.setSelected(false);
					chckbxSheffieldtxt.setSelected(false);
					System.out.println("Bradford Data is selected");
				}
				


				String Braemardata = "raw/braemardata.csv";
				if(chckbxBraemar.isSelected()) {
					CheckBoxSelection= Braemardata;
					chckbxBradford.setSelected(false);
					chckbxCamborne.setSelected(false);
					chckbxEastbourne.setSelected(false);
					chckbxSheffieldcsv.setSelected(false);
					chckbxSheffieldtxt.setSelected(false);
					System.out.println("Bradford Data is selected");
				}
				


				String Cambornedata = "raw/cambornedata.txt";
				if(chckbxCamborne.isSelected()) {
					CheckBoxSelection= Cambornedata;
					chckbxBradford.setSelected(false);
					chckbxBraemar.setSelected(false);
					chckbxEastbourne.setSelected(false);
					chckbxSheffieldcsv.setSelected(false);
					chckbxSheffieldtxt.setSelected(false);
					System.out.println("Camborne Data is selected");
				}
				



				String Eastbournedata = "raw/eastbournedata.txt";
				if(chckbxEastbourne.isSelected()) {
					CheckBoxSelection= Eastbournedata;
					chckbxBradford.setSelected(false);
					chckbxBraemar.setSelected(false);
					chckbxCamborne.setSelected(false);
					chckbxSheffieldcsv.setSelected(false);
					chckbxSheffieldtxt.setSelected(false);
					System.out.println("Eastbourne Data is selected");
				}
				



				String Sheffieldcsvdata = "raw/sheffieldcsvdata.csv";
				if (chckbxSheffieldcsv.isSelected()) {
					CheckBoxSelection= Sheffieldcsvdata;
					chckbxBradford.setSelected(false);
					chckbxBraemar.setSelected(false);
					chckbxCamborne.setSelected(false);
					chckbxEastbourne.setSelected(false);
					chckbxSheffieldtxt.setSelected(false);
					System.out.println("Sheffield Data csv file is selected");
				}
				




				String Sheffielddatatxt = "raw/sheffielddata.txt";
				if(chckbxSheffieldtxt.isSelected()) {
					CheckBoxSelection= Sheffielddatatxt;
					chckbxBradford.setSelected(false);
					chckbxBraemar.setSelected(false);
					chckbxCamborne.setSelected(false);
					chckbxEastbourne.setSelected(false);
					chckbxSheffieldcsv.setSelected(false);
					System.out.println("Sheffield Data text file is selected");
				}
			
		}
	}
	

	public class eventj implements  ItemListener{
		public void itemStateChanged(ItemEvent j){
			if (chckbxTemMax.isSelected()){
				chckbxTemMin.setSelected(false);
				chckbxAirForest.setSelected(false);
				chckbxRainfall.setSelected(false);
				chckbxSun.setSelected(false);
				System.out.println("Temperature maximum data type is selected");
			}


		
			if (chckbxTemMin.isSelected()){
				chckbxTemMax.setSelected(false);
				chckbxAirForest.setSelected(false);
				chckbxRainfall.setSelected(false);
				chckbxSun.setSelected(false);
				System.out.println("Temperature minimum data type is selected");
			}
			

			if (chckbxAirForest.isSelected()){
				chckbxTemMax.setSelected(false);
				chckbxTemMin.setSelected(false);
				chckbxRainfall.setSelected(false);
				chckbxSun.setSelected(false);
				System.out.println("Air forest data type is selected");
			}

			

			if (chckbxRainfall.isSelected()){
				chckbxTemMax.setSelected(false);
				chckbxTemMin.setSelected(false);
				chckbxAirForest.setSelected(false);
				chckbxSun.setSelected(false);
				System.out.println("Rainfall data type is selected");
			}

			

			if (chckbxSun.isSelected()){
				chckbxTemMax.setSelected(false);
				chckbxTemMin.setSelected(false);
				chckbxAirForest.setSelected(false);
				chckbxRainfall.setSelected(false);
				System.out.println("Sun data type is selected");
			}

		
		}
	}
}


	



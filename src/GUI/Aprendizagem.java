package GUI;

import java.awt.EventQueue;
import java.awt.FileDialog;

import Tipos_de_dados.Amostra;
import Tipos_de_dados.BN;
import Tipos_de_dados.DGraph;
import Tipos_de_dados.WGraph;
import Tipos_de_dados.Weights;

import javax.swing.JFrame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;



public class Aprendizagem {

	private JFrame frame;
	private JTextField textField;
	
	private String selecteddatabase;
	private String choosenparameter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aprendizagem window = new Aprendizagem();
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
	public Aprendizagem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		
		frame = new JFrame();
		frame.setBounds(300, 300, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnChooseFile = new JButton("Choose file");
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FileDialog fd = new FileDialog(frame, "Select a file", FileDialog.LOAD);
				frame.getContentPane().setLayout(null);

				fd.setDirectory("C:\\");
				fd.setFile("*.csv");
				fd.setVisible(true);
				String filename = fd.getFile();
				if (filename == null)
					System.out.println("Cancelled");
				else 
					System.out.println("File selected: " + filename);
				selecteddatabase=fd.getDirectory()+filename;
				textField.setText(filename);
			}
		});
		btnChooseFile.setBounds(15, 40, 115, 30);
		frame.getContentPane().add(btnChooseFile);
		
		textField = new JTextField();
		textField.setBounds(145, 40, 270, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblChooseParameter = new JLabel("Choose parameter");
		lblChooseParameter.setBounds(480, 40, 140, 20);
		frame.getContentPane().add(lblChooseParameter);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Breast Cancer");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choosenparameter="Breast Cancer";
			}
		});
		rdbtnNewRadioButton.setBounds(490, 85, 155, 30);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Diabetes");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choosenparameter="Diabetes";
			}
		});
		rdbtnNewRadioButton_1.setBounds(490, 135, 155, 30);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Hepatitis");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choosenparameter="Hepatitis";
			}
		});
		rdbtnNewRadioButton_2.setBounds(490, 185, 155, 30);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Parkisons");
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choosenparameter="Parkinsons";
			}
		});
		rdbtnNewRadioButton_3.setBounds(490, 235, 155, 30);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Thyroid");
		rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choosenparameter="Thyroid";
			}
		});
		rdbtnNewRadioButton_4.setBounds(490, 285, 155, 30);
		frame.getContentPane().add(rdbtnNewRadioButton_4);
		
		ButtonGroup group = new ButtonGroup(); 
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_3);
		group.add(rdbtnNewRadioButton_4);
		
		JButton btnTeachMe = new JButton("Teach me!");
		btnTeachMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(selecteddatabase);//só para ver que ele trás até aqui
				System.out.println(choosenparameter);//a base de dados e o tipo da mesma
				
//				int[][] Domainoptions= {{10,10,10,10,2},{5,5,5,5,4},{1,2,3,4,5},{5,4,3,2,1},{2,4,6,8,10}};
//				int[] Domains=null;
//				switch(choosenparameter) {
//				case("Breast Cancer"):{ Domains= Domainoptions[0];
//				break;}
//				case("Diabetes"): { Domains= Domainoptions[1];
//				break;}
//				case("Hepatitis"): { Domains= Domainoptions[2];
//				break;}
//				case("Parkinsons"): { Domains= Domainoptions[3];
//				break;}
//				case("Thyroid"): { Domains= Domainoptions[4];
//				break;}
//				}
//
//				Amostra amostra=new Amostra(Domains);
//				
//				try {
//					FileReader fr=new FileReader(selecteddatabase);
//					BufferedReader br=new BufferedReader(fr);
//					
//					String CurrentLine;
//					String[] line;
//					int[] dataentry=new int[Domains.length];
//					while((CurrentLine=br.readLine())!=null) {
//						line=CurrentLine.split(",");
//						for(int pos=0;pos<line.length;pos++) {
//							dataentry[pos]=Integer.parseInt(line[pos]);
//						}
//						amostra.add(dataentry);
//					}
//					br.close();
//					fr.close();
//				} catch (FileNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//				
//				WGraph WG=new WGraph(Domains.length-1);
//				for(int i=0;i<WG.dim();i++) {
//					for(int j=0;j<WG.dim();j++) {
//						double w=Weights.weight(i, j, amostra);
//						WG.add_edge(i, j, w);
//					}
//				}
//				
//				DGraph DG=WG.MST(0);
//				
//				BN net=new BN(DG,amostra,0.5);
//				
				
				JFileChooser f = new JFileChooser();
		        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
		        f.showSaveDialog(null);
		        
		        System.out.println(f.getCurrentDirectory()+"/"+choosenparameter+".BN");
				
//				try {
//					FileOutputStream fos=new FileOutputStream(f.getCurrentDirectory()+"/"+choosenparameter+".BN");
//					ObjectOutputStream oos=new ObjectOutputStream(fos);
//					oos.writeObject(net);
//					oos.close();
//				} catch (FileNotFoundException e3) {
//					// TODO Auto-generated catch block
//					e3.printStackTrace();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//Falta ter a certeza de que forma estão escritos os ficheiros, mas tenho quase a 
//certeza que serão .csv, pelo que fiz aqui foi pensando assim

			}
		});
		btnTeachMe.setBounds(15, 335, 115, 30);
		frame.getContentPane().add(btnTeachMe);
	}
}
	

	
		
	


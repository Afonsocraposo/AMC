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
import java.util.ArrayList;
import java.util.Scanner;

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
		frame.setTitle("Medicine for Dummies");
		
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
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Thyroid");
		rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choosenparameter="Thyroid";
			}
		});
		rdbtnNewRadioButton_4.setBounds(490, 235, 155, 30);
		frame.getContentPane().add(rdbtnNewRadioButton_4);
		
		ButtonGroup group = new ButtonGroup(); 
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_4);
		
		JButton btnTeachMe = new JButton("Teach me!");
		btnTeachMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(selecteddatabase);//só para ver que ele trás até aqui
				System.out.println(choosenparameter);//a base de dados e o tipo da mesma
				
				int[][] Domainoptions= {{10,10,10,10,10,10,10,10,10,10,2},{10,10,10,10,10,10,10,10,2},{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,2},{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,2}};
				int[] Domains=null;
				switch(choosenparameter) {
				case("Breast Cancer"):{ Domains= Domainoptions[0];
				break;}
				case("Diabetes"): { Domains= Domainoptions[1];
				break;}
				case("Hepatitis"): { Domains= Domainoptions[2];
				break;}
				case("Thyroid"): { Domains= Domainoptions[3];
				break;}
				}

				Amostra amostra=new Amostra(Domains);
				int[][] dataentry=new int[683][Domains.length];
				try {
					FileReader fr=new FileReader(selecteddatabase);
					BufferedReader br=new BufferedReader(fr);
					
					String CurrentLine;
					String[] line; 
					ArrayList<int[]> data=new ArrayList<int[]>();
					for(int i=0;i<683;i++) {
						try {
							CurrentLine=br.readLine();
							line=CurrentLine.split(",");
							for(int pos=0;pos<line.length;pos++) {
								dataentry[i][pos]=Integer.parseInt(line[pos]);
							}
						}
						catch(Exception e3) {
							break;
						}
					}
					br.close();
					fr.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int k=0;k<dataentry.length;k++) {
					amostra.add(dataentry[k]);
				}
				
				WGraph WG=new WGraph(Domains.length-1);
				for(int i=0;i<WG.dim();i++) {
					for(int j=i+1;j<WG.dim();j++) {
						double w=Weights.weight(i, j, amostra);
						WG.add_edge(i, j, w);
					}
				}
				
				DGraph DG=WG.MST(0);
				
				BN net=new BN(DG,amostra,0.5);
//				
				
				JFileChooser f = new JFileChooser();
		        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
		        f.showSaveDialog(null);
		        
		        System.out.println(f.getCurrentDirectory()+"/"+choosenparameter+".BN");
				
				try {
					FileOutputStream fos=new FileOutputStream(f.getCurrentDirectory()+"/"+choosenparameter+".BN");
					ObjectOutputStream oos=new ObjectOutputStream(fos);
					oos.writeObject(net);
					oos.close();
				} catch (FileNotFoundException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//Falta ter a certeza de que forma estão escritos os ficheiros, mas tenho quase a 
//certeza que serão .csv, pelo que fiz aqui foi pensando assim

			}
		});
		btnTeachMe.setBounds(15, 335, 115, 30);
		frame.getContentPane().add(btnTeachMe);
	}
}
	

	
		
	


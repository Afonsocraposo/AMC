package GUI;

import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
//import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Tipos_de_dados.Amostra;
import Tipos_de_dados.BN;
import Tipos_de_dados.DGraph;
import Tipos_de_dados.WGraph;
import Tipos_de_dados.Weights;

public class teste {

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
					teste window = new teste();
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
	public teste() {
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
				
				
//Primeira leitura, define domínios e determina as dimensões dos dados (entradas para  amostra e número de variaveis)				
				int nlines=0;
				int[] Domains=null;

				try {
					FileReader fr=new FileReader(selecteddatabase);
					BufferedReader br=new BufferedReader(fr);
					
					String CurrentLine=br.readLine();
					String[] line=CurrentLine.split(",");
					Domains=new int[line.length];
					nlines++;
					for(int pos=0;pos<line.length;pos++) {
						int x=Integer.parseInt(line[pos]);
						if(Domains[pos]<x)Domains[pos]=x;
					}
					while ((CurrentLine=br.readLine())!=null){
							nlines++;
							line=CurrentLine.split(",");
							for(int pos=0;pos<line.length;pos++) {
								int x=Integer.parseInt(line[pos]);
								if(Domains[pos]<x)Domains[pos]=x;
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
				
				for(int i=0;i<Domains.length;i++) {
					Domains[i]++;
				}
				
				
//Segunda leitura, copia os dados para a matriz dataentry				
				Amostra amostra;
				int[][] dataentry=new int[nlines][Domains.length];
				
				try {
					FileReader fr=new FileReader(selecteddatabase);
					BufferedReader br=new BufferedReader(fr);
					
					String CurrentLine;
					String[] line;
					for(int i=0;i<nlines;i++){
						CurrentLine=br.readLine();
						line=CurrentLine.split(",");
						for(int j=0;j<line.length;j++) {
							dataentry[i][j]=Integer.parseInt(line[j]);
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
				
//Formação da amostra
				amostra=new Amostra(Domains);
				
				
				for(int k=0;k<dataentry.length;k++) {
					amostra.add(dataentry[k]);
				}
				
			//	System.out.println(Weights.weight(1,3,amostra));
//Criação dos grafo pesado completo
				
		//	double[][] WG = new [amostra.length()][];	
						
	 		WGraph WG=new WGraph(Domains.length-1);
				for(int i=0;i<WG.dim();i++) {
					for(int j=i+1;j<WG.dim();j++) {
						double w=Weights.weight(i, j, amostra);
						WG.add_edge(i, j, w);
					}
				}
				
			DGraph DG=WG.MST(0);
				
			BN net=new BN(DG,amostra,0.5);
			
				
				JFileChooser f = new JFileChooser();
		        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
		        f.showSaveDialog(null);
		        
		       // System.out.println(f.getCurrentDirectory()+"/"+choosenparameter+".BN");
				
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
				
				System.out.println("All goody, m8!");
				


			}
		});
		btnTeachMe.setBounds(15, 335, 115, 30);
		frame.getContentPane().add(btnTeachMe); 
	}
}
	

	
		
	


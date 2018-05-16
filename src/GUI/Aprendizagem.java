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
import java.awt.event.ComponentAdapter;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;



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
		frame.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		frame.setBounds(300, 300, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Medicine for Dummies");
		
		
		JLabel lblInfo = new JLabel("");
		lblInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblInfo.setOpaque(true);
		lblInfo.setVerticalAlignment(SwingConstants.TOP);
		lblInfo.setBackground(Color.WHITE);
		lblInfo.setBounds(60, 327, 582, 94);
		
		
		JButton btnChooseFile = new JButton("Choose file");
		btnChooseFile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnChooseFile.setBounds(15, 40, 141, 31);
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblInfo.setText("");
				
				FileDialog fd = new FileDialog(frame, "Select a file", FileDialog.LOAD);
				frame.getContentPane().setLayout(null);

				fd.setDirectory("C:\\");
				fd.setFile("*.csv");
				fd.setVisible(true);
				String filename = fd.getFile();
				if (filename == null)
					lblInfo.setText("Select a valid file");
				else 
					lblInfo.setText("File selected: " + filename);
				selecteddatabase=fd.getDirectory()+filename;
				textField.setText(filename);
			}
		});
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(171, 41, 156, 28);
		textField.addComponentListener(new ComponentAdapter() {
			
		});
		textField.setColumns(10);
		
		JLabel lblChooseParameter = new JLabel("Choose parameter");
		lblChooseParameter.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblChooseParameter.setBounds(480, 40, 143, 22);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Breast Cancer");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton.setBounds(490, 85, 141, 31);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choosenparameter="Breast_Cancer";
			}
		});
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Diabetes");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton_1.setBounds(490, 135, 99, 31);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choosenparameter="Diabetes";
			}
		});
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Hepatitis");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton_2.setBounds(490, 185, 101, 31);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choosenparameter="Hepatitis";
			}
		});
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Thyroid");
		rdbtnNewRadioButton_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton_4.setBounds(490, 235, 93, 31);
		rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choosenparameter="Thyroid";
			}
		});
		
		ButtonGroup group = new ButtonGroup(); 
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_4);
		

		
		JButton btnTeachMe = new JButton("Teach me!");
		btnTeachMe.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnTeachMe.setBounds(77, 135, 213, 106);
		btnTeachMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblInfo.setText("LEARNING...");
				
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
				
				
//Criação dos grafo pesado completo
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
		        				
				try {
					FileOutputStream fos=new FileOutputStream(f.getCurrentDirectory()+"/"+choosenparameter+".BN");
					ObjectOutputStream oos=new ObjectOutputStream(fos);
					oos.writeObject(net);
					oos.close();
					lblInfo.setText("Bayesian net successfully generated and saved as ''"+f.getCurrentDirectory()+"/"+choosenparameter+".BN''");
					
				} catch (FileNotFoundException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
					lblInfo.setText(e3.getMessage());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblInfo.setText(e1.getMessage());
				}
//Falta ter a certeza de que forma estão escritos os ficheiros, mas tenho quase a 
//certeza que serão .csv, pelo que fiz aqui foi pensando assim

			}
		});

		frame.getContentPane().setLayout(null);
		
		
		
		
		
		
		frame.getContentPane().add(lblInfo);
		frame.getContentPane().add(rdbtnNewRadioButton);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		frame.getContentPane().add(btnChooseFile);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(btnTeachMe);
		frame.getContentPane().add(rdbtnNewRadioButton_4);
		frame.getContentPane().add(lblChooseParameter);

	}
}
	

	
		
	


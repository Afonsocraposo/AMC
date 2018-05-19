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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import java.awt.event.ComponentAdapter;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.awt.Color;



public class Aprendizagem {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField1;

	private String selecteddatabase;
	private String choosenparameter;
	static ImageIcon img=new ImageIcon("images/logo.png");
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
		frame.getContentPane().setBackground(new Color(240,250,255));
		frame.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		frame.setBounds(300, 300, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(img.getImage());
		frame.setTitle("Medicine for Dummies - Learning");

		frame.setResizable(false);
		
		frame.setLocationRelativeTo(null);




		JTextArea lblInfo = new JTextArea("");
		lblInfo.setWrapStyleWord(true);
		lblInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblInfo.setOpaque(true);
		lblInfo.setBorder(BorderFactory.createLineBorder(new Color(100,155,175)));
		lblInfo.setBackground(Color.WHITE);
		lblInfo.setBounds(31, 290, 491, 80);


		RoundedButton btnChooseFile = new RoundedButton("Choose file");
		btnChooseFile.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnChooseFile.setBounds(15, 40, 141, 31);
		btnChooseFile.setBackground(new Color(100,155,175));
		btnChooseFile.setForeground(Color.WHITE);


		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(171, 41, 156, 28);
		textField.setBorder(BorderFactory.createLineBorder(new Color(100,155,175)));

		textField.addComponentListener(new ComponentAdapter() {

		});
		textField.setColumns(10);

		JLabel lblChooseParameter = new JLabel("Choose exam:");
		lblChooseParameter.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChooseParameter.setBounds(370, 79, 181, 22);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Breast Cancer");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBounds(370, 103, 156, 31);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choosenparameter="Breast_Cancer";
			}
		});

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Diabetes");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_1.setBounds(370, 133, 141, 31);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choosenparameter="Diabetes";
			}
		});

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Hepatitis");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_2.setBounds(370, 163, 141, 31);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choosenparameter="Hepatitis";
			}
		});

		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Thyroid Disease");
		rdbtnNewRadioButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_4.setBounds(370, 193, 220, 31);
		rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choosenparameter="Thyroid";
			}
		});

		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Other Diseases");
		rdbtnNewRadioButton_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_5.setBounds(370, 223, 220, 31);
		rdbtnNewRadioButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choosenparameter="other";
			}
		});

		textField1 = new JTextField();
		textField1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField1.setBounds(380, 255, 142, 31);
		textField1.setBorder(BorderFactory.createLineBorder(new Color(100,155,175)));

		textField1.addComponentListener(new ComponentAdapter() {

		});
		textField1.setColumns(10);


		ButtonGroup group = new ButtonGroup(); 
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_4);
		group.add(rdbtnNewRadioButton_5);

		try {
			BufferedImage logo;
			logo = ImageIO.read(new File("images/logo50px.png"));
			JLabel picLabel = new JLabel(new ImageIcon(logo));
			picLabel.setLocation(475, 15);
			picLabel.setSize(50, 50);
			frame.getContentPane().add(picLabel);
		} catch (IOException e1) {
		}


		RoundedButton btnTeachMe = new RoundedButton("Teach me!");
		btnTeachMe.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnTeachMe.setBounds(59, 124, 246, 100);
		btnTeachMe.setBackground(new Color(100,155,175));
		btnTeachMe.setForeground(Color.WHITE);
		btnTeachMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selecteddatabase==null) lblInfo.setText("PLEASE SELECT A VALID .CVS FILE");
				else {
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


					if(rdbtnNewRadioButton_5.isSelected()) choosenparameter=textField1.getText();
					try {
						FileOutputStream fos=new FileOutputStream(f.getCurrentDirectory()+"/"+choosenparameter+".BN");
						ObjectOutputStream oos=new ObjectOutputStream(fos);
						oos.writeObject(net);
						oos.close();
						lblInfo.setText("Bayesian net successfully generated and saved as: \n''"+f.getCurrentDirectory()+"/"+choosenparameter+".BN''");

					} catch (FileNotFoundException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
						lblInfo.setText(e3.getMessage());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						lblInfo.setText(e1.getMessage());
					}
				}
			}
		});



		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblInfo.setText("");

				FileDialog fd = new FileDialog(frame, "Select a file", FileDialog.LOAD);
				frame.getContentPane().setLayout(null);

				fd.setDirectory("C:\\");
				fd.setFile("*.csv");
				fd.setVisible(true);
				String filename = fd.getFile();
				if (filename == null || !filename.matches(".*.csv"))
					lblInfo.setText("Select a valid file");
				else {
					lblInfo.setText("File selected: " + filename);
					selecteddatabase=fd.getDirectory()+filename;
					textField.setText(filename);
					btnTeachMe.setEnabled(true);
				}
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
		frame.getContentPane().add(rdbtnNewRadioButton_5);
		frame.getContentPane().add(textField1);
	}
}







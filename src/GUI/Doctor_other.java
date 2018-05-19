package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import PDF.ScreenImage;

import javax.swing.JLabel;

import java.awt.Font;

import Tipos_de_dados.BN;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;

import java.awt.Color;
import java.awt.FileDialog;

import javax.swing.JTextArea;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;


@SuppressWarnings("serial")
public class Doctor_other extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */


	private int[] parameters;
	private int[] domain;
	private String selectedBN;
	private String filename;
	private BN bayesnet;
	private FileInputStream fis; 
	private ObjectInputStream ois; 
	private double[] classes;

	public Doctor_other(Doctor_on parent) {
		Locale.setDefault(Locale.US);
		setBackground(Color.WHITE);
		setLayout(null);

		setSize(1000,480);

		JLabel Jlabel_1 = new JLabel("Incorrect number of parameters.");
		Jlabel_1.setForeground(Color.RED);
		Jlabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Jlabel_1.setBounds(25, 264, 489, 20);
		add(Jlabel_1);

		JLabel Jlabel_2 = new JLabel("Invalid parameter value. Verify domain.");
		Jlabel_2.setForeground(Color.RED);
		Jlabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Jlabel_2.setBounds(25, 264, 489, 20);
		add(Jlabel_2);

		Jlabel_1.setVisible(false);
		Jlabel_2.setVisible(false);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(25, 226, 459, 26);
		add(textField);
		textField.setBorder(BorderFactory.createLineBorder(new Color(100,155,175)));
		textField.setColumns(10);


		
		JTextArea textArea = new JTextArea ("");

		JScrollPane res = new JScrollPane (textArea, 
		   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		res.setLocation(739, 55);
		res.setSize(190,320);
		res.setVisible(false);
		add(res);

		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				List<String> list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));

				if(list.size()!=domain.length-1) {
					Jlabel_1.setVisible(true);
					Jlabel_2.setVisible(false);
				}else {
					if(list.contains("")) {
						Jlabel_1.setVisible(true);
						Jlabel_2.setVisible(false);
					}else {
						Jlabel_1.setVisible(false);
						Jlabel_2.setVisible(false);


						list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
						for(int j=0;j<domain.length-1;j++) {
							int number = Integer.parseInt(list.get(j));
							if(number>=0 && number<domain[j]) {
								parameters[j]=number;
							}else {
								Jlabel_1.setVisible(false);
								Jlabel_2.setVisible(true);
							}



						}
						
						textField.setText(Arrays.toString(Arrays.copyOfRange(parameters, 0, domain.length-1)));
						
					}}
			}
		});

		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));

				if(list.size()!=domain.length-1) {
					Jlabel_1.setVisible(true);
					Jlabel_2.setVisible(false);
				}else {
					if(list.contains("")) {
						Jlabel_1.setVisible(true);
						Jlabel_2.setVisible(false);
					}else {
						Jlabel_1.setVisible(false);
						Jlabel_2.setVisible(false);


						list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
						for(int j=0;j<domain.length-1;j++) {
							int number = Integer.parseInt(list.get(j));
							if(number>=0 && number<domain[j]) {
								parameters[j]=number;
							}else {
								Jlabel_1.setVisible(false);
								Jlabel_2.setVisible(true);
							}



						}
						
						textField.setText(Arrays.toString(Arrays.copyOfRange(parameters, 0, domain.length-1)));
						
					}}
			}
		});

		JTextArea textObs = new JTextArea();
		textObs.setBounds(15, 407, 530, 46);
		textObs.setBorder(BorderFactory.createLineBorder(new Color(100,155,175)));
		add(textObs);

		RoundedButton btnDiagnose = new RoundedButton("Diagnose");
		btnDiagnose.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDiagnose.setBounds(562, 407, 162, 46);
		btnDiagnose.setBackground(new Color(100,155,175));
		btnDiagnose.setForeground(Color.WHITE);
		add(btnDiagnose);

		JLabel lblInsertParametersIn = new JLabel("Insert parameters in array form:");
		lblInsertParametersIn.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblInsertParametersIn.setForeground(new Color(100,155,175));
		lblInsertParametersIn.setBounds(25, 188, 358, 26);
		add(lblInsertParametersIn);

		JLabel lblComment = new JLabel("Comment:");
		lblComment.setBounds(15, 379, 358, 16);
		add(lblComment);

		JLabel lblBNSel = new JLabel("");
		lblBNSel.setBounds(193, 70, 290, 16);
		add(lblBNSel);

		RoundedButton roundedButton = new RoundedButton("Select BN");
		roundedButton.setBounds(25, 55, 162, 46);
		roundedButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		roundedButton.setBackground(new Color(100,155,175));
		roundedButton.setForeground(Color.WHITE);
		add(roundedButton);
		
		JLabel lblResults = new JLabel("Results:");
		lblResults.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblResults.setBounds(739, 27, 100, 16);
		lblResults.setForeground(new Color(100,155,175));
		add(lblResults);
		
		roundedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textArea.setText("");
				lblBNSel.setText("");
				textField.setText("");
				
				FileDialog fd = new FileDialog(Doctor_on.getFrames()[0], "Select a file", FileDialog.LOAD);

				fd.setDirectory("C:\\");
				fd.setFile("*.BN");
				fd.setVisible(true);
				filename = fd.getFile();
				if (filename == null || !filename.matches(".*.BN")) {
					lblBNSel.setForeground(Color.RED);
					lblBNSel.setText("Please select a valid .BN file.");
					selectedBN=null;
				} else {
					selectedBN=fd.getDirectory()+filename;
					roundedButton.setEnabled(true);
					lblBNSel.setForeground(Color.BLACK);
					lblBNSel.setText("Selected BN: "+filename);
	
				}

				try { 


					fis=new FileInputStream(selectedBN); 
					ois=new ObjectInputStream(fis); 
					bayesnet=(BN)ois.readObject(); 
					ois.close(); 
					fis.close();
					
					
					domain=bayesnet.domains();
					
					parameters= new int[domain.length];
					classes = new double[domain[domain.length-1]];
					
					textField.setText(Arrays.toString(Arrays.copyOfRange(parameters, 0, domain.length-1)));

				}catch(Exception e2) {

				}
			}
		});

		btnDiagnose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (filename == null || !filename.matches(".*.BN")) {
					lblBNSel.setForeground(Color.RED);
					lblBNSel.setText("Please select a valid .BN file.");
					selectedBN=null;
				}
				else {

					res.setVisible(false);

					List<String> list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));

					if(list.size()!=domain.length) {
						Jlabel_1.setVisible(true);
						Jlabel_2.setVisible(false);
					}else {
						if(list.contains("")) {
							Jlabel_1.setVisible(true);
							Jlabel_2.setVisible(false);
						}else {
							Jlabel_1.setVisible(false);
							Jlabel_2.setVisible(false);


							list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
							for(int j=0;j<domain.length-1;j++) {
								int number = Integer.parseInt(list.get(j));
								if(number>=0 && number<domain[j]) {
									parameters[j]=number;
								}else {
									Jlabel_1.setVisible(false);
									Jlabel_2.setVisible(true);
								}



							}

							textField.setText(Arrays.toString(Arrays.copyOfRange(parameters, 0, domain.length-1)));

						}}

					ArrayList<Integer> signsParameters = new ArrayList<Integer>();

					for(int i=0; i<domain.length-1; i++) {
						signsParameters.add(parameters[i]);
					}

					parent.patient.signs = signsParameters;
					parent.patient.exam = "";
					parent.patient.comments = textObs.getText();


					Jlabel_1.setVisible(false);
					Jlabel_2.setVisible(false);

					try { 

						double total = 0;
						double[] probs = new double[classes.length];

						for(int i = 0; i<classes.length; i++) {
							parameters[domain.length-1]=i;
							classes[i]=bayesnet.prob(parameters); 
							total+=classes[i];
						} 

						String print = "";

						for(int i = 0; i<classes.length; i++) {
							probs[i]=classes[i]*100/total;
							print+= " Class " + i + ": " + String.format( "%.2f",probs[i]) + " %\n";
						}

						textArea.setText(print);

						res.setVisible(true);


						BufferedImage plot_pic = ScreenImage.createImage(res);
						parent.patient.picture = plot_pic;

						parent.patient.result = "UNKNOWN";
						parent.patient.exam = "UNKNOWN";



					} catch(Exception e3) {

					}

				}

			}
		});


	}
}

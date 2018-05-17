package GUI;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import PDF.ScreenImage;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import Tipos_de_dados.BN;

@SuppressWarnings("serial")
public class Doctor_diabetes extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	
	// 8 parâmetros
	
	int [] parameters = new int[9];
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Doctor_diabetes(Doctor_on parent) {
		Locale.setDefault(Locale.US);
		setBackground(Color.WHITE);
		setLayout(null);

		setSize(1000,480);
		
		JLabel Jlabel_1 = new JLabel("Incorrect number of parameters. Please insert 10 parameters.");
		Jlabel_1.setForeground(Color.RED);
		Jlabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Jlabel_1.setBounds(253, 347, 489, 20);
		add(Jlabel_1);
		
		JLabel Jlabel_2 = new JLabel("Invalid parameter value. Verify domain.");
		Jlabel_2.setForeground(Color.RED);
		Jlabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Jlabel_2.setBounds(253, 347, 489, 20);
		add(Jlabel_2);
		
		Jlabel_1.setVisible(false);
		Jlabel_2.setVisible(false);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(15, 345, 222, 26);
		textField.setText(Arrays.toString(Arrays.copyOf(parameters, 8)));
		add(textField);
		textField.setBorder(BorderFactory.createLineBorder(new Color(100,155,175)));
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem(0);
		comboBox.addItem(1);
		comboBox.setBounds(84, 69, 60, 25);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem(0);
		comboBox_1.setBounds(84, 119, 60, 25);
		add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addItem(0);
		comboBox_2.addItem(1);
		comboBox_2.addItem(2);
		comboBox_2.setBounds(84, 169, 60, 25);
		add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.addItem(0);
		comboBox_3.addItem(1);
		comboBox_3.addItem(2);
		comboBox_3.addItem(3);
		comboBox_3.setBounds(84, 219, 60, 25);
		add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.addItem(0);
		comboBox_4.addItem(1);
		comboBox_4.addItem(2);
		comboBox_4.setBounds(84, 269, 60, 25);
		add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.addItem(0);
		comboBox_5.addItem(1);
		comboBox_5.setBounds(235, 69, 60, 25);
		add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.addItem(0);
		comboBox_6.addItem(1);
		comboBox_6.setBounds(235, 119, 60, 25);
		add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.addItem(0);
		comboBox_7.addItem(1);
		comboBox_7.setBounds(235, 169, 60, 25);
		add(comboBox_7);

		
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				List<String> list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
				
				if(list.size()!=8) {
					Jlabel_1.setVisible(true);
					Jlabel_2.setVisible(false);
				}else {
					if(list.contains("")) {
						Jlabel_1.setVisible(true);
						Jlabel_2.setVisible(false);
					}else {
					Jlabel_1.setVisible(false);
					Jlabel_2.setVisible(false);
					
				
				for(int i=0; i<8; i++) {
					if(parameters[i]!=Integer.parseInt(list.get(i))) {
						switch (i) {
				        case 0:  
				        	try{comboBox.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 1:  
				        	try{comboBox_1.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_1.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 2:  
				        	try{comboBox_2.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_2.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 3:  
				        	try{comboBox_3.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_3.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 4: 
				        	try{comboBox_4.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_4.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 5:  
				        	try{comboBox_5.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_5.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 6:  
				        	try{comboBox_6.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_6.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 7:  
				        	try{comboBox_7.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_7.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        default: break;
				    }
					}
					
				}
				
				list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
				for(int j=0;j<8;j++) {
					parameters[j]=Integer.parseInt(list.get(j));
				}
				
				
				}
			}}
		});
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
				
				if(list.size()!=8) {
					Jlabel_1.setVisible(true);
					Jlabel_2.setVisible(false);
				}else {
					if(list.contains("")) {
						Jlabel_1.setVisible(true);
						Jlabel_2.setVisible(false);
					}else {
					Jlabel_1.setVisible(false);
					Jlabel_2.setVisible(false);
					
				
				for(int i=0; i<8; i++) {
					if(parameters[i]!=Integer.parseInt(list.get(i))) {
						switch (i) {
				        case 0:  
				        	try{comboBox.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 1:  
				        	try{comboBox_1.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_1.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 2:  
				        	try{comboBox_2.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_2.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 3:  
				        	try{comboBox_3.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_3.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 4: 
				        	try{comboBox_4.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_4.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 5:  
				        	try{comboBox_5.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_5.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 6:  
				        	try{comboBox_6.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_6.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 7:  
				        	try{comboBox_7.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_7.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        default: break;
				    }
					}
					
				}
				
				list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
				for(int j=0;j<8;j++) {
					parameters[j]=Integer.parseInt(list.get(j));
				}
				
				
				}
			}}
		});
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[0] = comboBox.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 8)));
				
			}
		});
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[1] = comboBox_1.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 8)));
				
			}
		});
		
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[2] = comboBox_2.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 8)));
				
			}
		});

		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[3] = comboBox_3.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 8)));
				
			}
		});
		
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[4] = comboBox_4.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 8)));
				
			}
		});

		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[5] = comboBox_5.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 8)));
				
			}
		});
		
		comboBox_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[6] = comboBox_6.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 8)));
				
			}
		});

		comboBox_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[7] = comboBox_7.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 8)));
				
			}
		});

		
		JLabel lblParmetro = new JLabel("Parameter 1");
		lblParmetro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblParmetro.setBounds(15, 69, 105, 20);
		add(lblParmetro);
		
		JLabel label = new JLabel("Parameter 2");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(15, 119, 105, 20);
		add(label);
		
		
		JLabel label_2 = new JLabel("Parameter 3");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(15, 169, 105, 20);
		add(label_2);
		
		JLabel label_3 = new JLabel("Parameter 4");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(15, 219, 105, 20);
		add(label_3);
		
		JLabel label_4 = new JLabel("Parameter 5");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(15, 269, 105, 20);
		add(label_4);
		
		JLabel label_1 = new JLabel("Parameter 6");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(156, 69, 105, 20);
		add(label_1);
		
		JLabel label_5 = new JLabel("Parameter 7");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBounds(156, 119, 105, 20);
		add(label_5);
		
		JLabel label_6 = new JLabel("Parameter 8");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_6.setBounds(156, 169, 105, 20);
		add(label_6);
		
		
		JLabel lblSelectValuesFor1 = new JLabel("Select values for each parameter:");
		lblSelectValuesFor1.setForeground(new Color(100,155,175));
		lblSelectValuesFor1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelectValuesFor1.setBounds(17, 31, 281, 20);
		add(lblSelectValuesFor1);
		
		JTextArea textObs = new JTextArea();
		textObs.setBounds(15, 407, 530, 46);
		textObs.setBorder(BorderFactory.createLineBorder(new Color(100,155,175)));
		add(textObs);
			
		JPanel plot = new JPanel();
		plot.setBackground(Color.WHITE);
		plot.setLocation(500, 30);
		plot.setSize(400,300);
		plot.setVisible(false);;
		
		JLabel lblResults = new JLabel("Results:");
		lblResults.setForeground(new Color(100, 155, 175));
		lblResults.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblResults.setBounds(30, 30, 66, 20);
		plot.setLayout(null);
		plot.add(lblResults);
		
		JLabel NegativeB = new JLabel("");
		NegativeB.setBackground(new Color(0, 100, 0));
		NegativeB.setOpaque(true);
		NegativeB.setBounds(30, 62, 171, 46);
		plot.add(NegativeB);
		
		JLabel PositiveB = new JLabel("");
		PositiveB.setOpaque(true);
		PositiveB.setBackground(new Color(255, 0, 0));
		PositiveB.setBounds(202, 62, 171, 46);
		plot.add(PositiveB);
		
		JLabel lblLabel = new JLabel("Label:");
		lblLabel.setForeground(new Color(100, 155, 175));
		lblLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLabel.setBounds(30, 115, 100, 63);
		plot.add(lblLabel);
		
		JLabel lblNegative = new JLabel("");
		lblNegative.setForeground(new Color(0, 100, 0));
		lblNegative.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNegative.setBounds(30, 164, 279, 35);
		plot.add(lblNegative);
		
		JLabel lblPositive = new JLabel("");
		lblPositive.setForeground(new Color(255, 0, 0));
		lblPositive.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPositive.setBounds(30, 211, 279, 35);
		plot.add(lblPositive);


		RoundedButton btnDiagnose = new RoundedButton("Diagnose");
		btnDiagnose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
List<String> list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
				
				if(list.size()!=8) {
					Jlabel_1.setVisible(true);
					Jlabel_2.setVisible(false);
				}else {
					if(list.contains("")) {
						Jlabel_1.setVisible(true);
						Jlabel_2.setVisible(false);
					}else {
					Jlabel_1.setVisible(false);
					Jlabel_2.setVisible(false);
					
				
				for(int i=0; i<8; i++) {
					if(parameters[i]!=Integer.parseInt(list.get(i))) {
						switch (i) {
				        case 0:  
				        	try{comboBox.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 1:  
				        	try{comboBox_1.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_1.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 2:  
				        	try{comboBox_2.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_2.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 3:  
				        	try{comboBox_3.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_3.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 4: 
				        	try{comboBox_4.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_4.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 5:  
				        	try{comboBox_5.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_5.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 6:  
				        	try{comboBox_6.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_6.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 7:  
				        	try{comboBox_7.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_7.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        default: break;
				    }
					}
					
				}
				
				list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
				for(int j=0;j<8;j++) {
					parameters[j]=Integer.parseInt(list.get(j));
				}
				}
				}
				
				
				
				
				ArrayList<Integer> signsParameters = new ArrayList<Integer>();
				
				for(int i=0; i<8; i++) {
					signsParameters.add(parameters[i]);
				}
								
				parent.patient.signs = signsParameters;
				parent.patient.exam = "DIABETES";
				parent.patient.comments = textObs.getText();

				
				Jlabel_1.setVisible(false);
				Jlabel_2.setVisible(false);
				
				BN bayesnet; 

				String filename="Diabetes.BN"; 
				FileInputStream fis; 
				ObjectInputStream ois; 
				try { 
					try {
						fis=new FileInputStream(parent.doctorPanel.modelsource+"/"+filename); 
						} catch(FileNotFoundException e1) {
							fis=new FileInputStream("trained_models/"+filename); 
						}
					ois=new ObjectInputStream(fis); 
					bayesnet=(BN)ois.readObject(); 
					ois.close(); 
					fis.close(); 

					parameters[8]=1; 
					double negative=bayesnet.prob(parameters); 
					parameters[8]=0; 
					double positive=bayesnet.prob(parameters);
					
					double total=negative+positive;
					
					double probN=negative/total;
					double probP=positive/total;
					
					lblResults.setVisible(true);
					
					int width = 350;
					
					NegativeB.setBounds(NegativeB.getX(), NegativeB.getY(), (int)(width*probN), NegativeB.getHeight());
					NegativeB.setVisible(true);
					
					PositiveB.setBounds(NegativeB.getX()+NegativeB.getWidth(), PositiveB.getY(), (int)(width*probP), PositiveB.getHeight());
					PositiveB.setVisible(true);
					
					lblPositive.setText("(1) Diabetic: "+ String.format( "%.2f",probP*100) +"%");
					lblNegative.setText("(0) Healthy: "+ String.format( "%.2f",probN*100) +"%");
					
					plot.setVisible(true);
					
					lblResults.setForeground(Color.BLACK);
					lblLabel.setForeground(Color.BLACK);
					lblResults.setFont(new Font("Helvetica", Font.BOLD, 16));
					lblLabel.setFont(new Font("Helvetica", Font.BOLD, 16));
					lblPositive.setFont(new Font("Helvetica", Font.BOLD, 16));
					lblNegative.setFont(new Font("Helvetica", Font.BOLD, 16));

					
					BufferedImage plot_pic = ScreenImage.createImage(plot);
					parent.patient.picture = plot_pic;
					
					lblResults.setForeground(new Color(100, 155, 175));
					lblLabel.setForeground(new Color(100, 155, 175));
					lblResults.setFont(new Font("Tahoma", Font.BOLD, 16));
					lblLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
					lblPositive.setFont(new Font("Tahoma", Font.BOLD, 16));
					lblNegative.setFont(new Font("Tahoma", Font.BOLD, 16));
					
					if(probN>probP) {
						parent.patient.result="NEGATIVE";
					} else {
						parent.patient.result="POSITIVE";
					}
					

					
				} 

				catch(IOException e2) { 
				}  
				catch (ClassNotFoundException e3) {
				}
				
			}
		});
		
		btnDiagnose.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDiagnose.setBounds(562, 407, 162, 46);
		btnDiagnose.setBackground(new Color(100,155,175));
		btnDiagnose.setForeground(Color.WHITE);
		add(btnDiagnose);
		
		JLabel lblInsertParametersIn = new JLabel("Insert parameters in array form:");
		lblInsertParametersIn.setBounds(15, 317, 358, 16);
		add(lblInsertParametersIn);
		
		JLabel lblComment = new JLabel("Comment:");
		lblComment.setBounds(15, 379, 358, 16);
		add(lblComment);
		
		add(plot);
		
	}

}

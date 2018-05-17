package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import Tipos_de_dados.BN;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


@SuppressWarnings("serial")
public class Doctor_cancer extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	
	// 10 parâmetros
	
	int [] parameters = new int[11];
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Doctor_cancer(Doctor_on parent) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		setSize(1000,480);
				
		JLabel Jlabel_1 = new JLabel("Incorrect number of parameters. Please insert 10 parameters.");
		Jlabel_1.setForeground(Color.RED);
		Jlabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Jlabel_1.setBounds(253, 347, 489, 20);
		add(Jlabel_1);
		
		JLabel Jlabel_2 = new JLabel("Invalid parameter value. Verify domain.");
		Jlabel_2.setForeground(Color.RED);
		Jlabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Jlabel_2.setBounds(253, 347, 489, 20);
		add(Jlabel_2);
		
		Jlabel_1.setVisible(false);
		Jlabel_2.setVisible(false);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(15, 345, 222, 26);
		textField.setText(Arrays.toString(Arrays.copyOf(parameters, 10)));
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
		comboBox_5.setBounds(227, 69, 60, 25);
		add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.addItem(0);
		comboBox_6.addItem(1);
		comboBox_6.setBounds(227, 119, 60, 25);
		add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.addItem(0);
		comboBox_7.addItem(1);
		comboBox_7.addItem(2);
		comboBox_7.setBounds(227, 169, 60, 25);
		add(comboBox_7);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.addItem(0);
		comboBox_8.addItem(1);
		comboBox_8.setBounds(227, 219, 60, 25);
		add(comboBox_8);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.addItem(0);
		comboBox_9.addItem(1);
		comboBox_9.setBounds(227, 269, 60, 25);
		add(comboBox_9);
		
		
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				List<String> list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
				
				if(list.size()!=10) {
					Jlabel_1.setVisible(true);
					Jlabel_2.setVisible(false);
				}else {
					if(list.contains("")) {
						Jlabel_1.setVisible(true);
						Jlabel_2.setVisible(false);
					}else {
					Jlabel_1.setVisible(false);
					Jlabel_2.setVisible(false);
					
				
				for(int i=0; i<10; i++) {
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
				        case 8:  
				        	try{comboBox_8.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_8.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 9: 
				        	try{comboBox_9.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_9.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;

				        default: break;
				    }
					}
					
				}
				
				list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
				for(int j=0;j<10;j++) {
					parameters[j]=Integer.parseInt(list.get(j));
				}
				
				
				}
			}
			}
		});
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
				
				if(list.size()!=10) {
					Jlabel_1.setVisible(true);
					Jlabel_2.setVisible(false);
				}else {
					if(list.contains("")) {
						Jlabel_1.setVisible(true);
						Jlabel_2.setVisible(false);
					}else {
					Jlabel_1.setVisible(false);
					Jlabel_2.setVisible(false);
					
				
				for(int i=0; i<10; i++) {
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
				        case 8:  
				        	try{comboBox_8.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_8.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 9: 
				        	try{comboBox_9.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_9.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;

				        default: break;
				    }
					}
					
				}
				
				list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
				for(int j=0;j<10;j++) {
					parameters[j]=Integer.parseInt(list.get(j));
				}
				
				
				}
			}}
		});
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[0] = comboBox.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 10)));
				
			}
		});
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[1] = comboBox_1.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 10)));
				
			}
		});
		
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[2] = comboBox_2.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 10)));
				
			}
		});

		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[3] = comboBox_3.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 10)));
				
			}
		});
		
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[4] = comboBox_4.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 10)));
				
			}
		});

		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[5] = comboBox_5.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 10)));
				
			}
		});
		
		comboBox_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[6] = comboBox_6.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 10)));
				
			}
		});

		comboBox_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[7] = comboBox_7.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 10)));
				
			}
		});
		
		comboBox_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[8] = comboBox_8.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 10)));
				
			}
		});

		comboBox_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[9] = comboBox_9.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 10)));
				
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
		
		JLabel label_7 = new JLabel("Parameter 9");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_7.setBounds(156, 219, 105, 20);
		add(label_7);
		
		JLabel label_8 = new JLabel("Parameter 10");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_8.setBounds(156, 269, 105, 20);
		add(label_8);
		
		JLabel lblSelectValuesFor1 = new JLabel("Select values for each parameter:");
		lblSelectValuesFor1.setForeground(new Color(100,155,175));
		lblSelectValuesFor1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelectValuesFor1.setBounds(17, 31, 281, 20);
		add(lblSelectValuesFor1);
		
		JTextArea textObs = new JTextArea();
		textObs.setBounds(15, 407, 530, 46);
		textObs.setBorder(BorderFactory.createLineBorder(new Color(100,155,175)));
		add(textObs);


		JLabel lblResults = new JLabel("Results:");
		lblResults.setForeground(new Color(100, 155, 175));
		lblResults.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblResults.setBounds(556, 79, 281, 20);
		lblResults.setVisible(false);
		add(lblResults);
		
		JLabel BenignB = new JLabel("");
		BenignB.setBackground(new Color(0, 100, 0));
		BenignB.setOpaque(true);
		BenignB.setBounds(556, 119, 171, 46);
		BenignB.setVisible(false);
		add(BenignB);
		
		JLabel MalignB = new JLabel("");
		MalignB.setOpaque(true);
		MalignB.setBackground(new Color(255, 0, 0));
		MalignB.setBounds(726, 119, 171, 46);
		MalignB.setVisible(false);
		add(MalignB);
		
		JLabel lblLabel = new JLabel("Label:");
		lblLabel.setForeground(new Color(100, 155, 175));
		lblLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLabel.setBounds(556, 195, 281, 20);
		lblLabel.setVisible(false);
		add(lblLabel);
		
		JLabel lblBenign = new JLabel("Benign: ");
		lblBenign.setForeground(new Color(0, 100, 0));
		lblBenign.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBenign.setBounds(566, 231, 331, 20);
		lblBenign.setVisible(false);
		add(lblBenign);
		
		JLabel lblMalign = new JLabel("Malign:");
		lblMalign.setForeground(new Color(255, 0, 0));
		lblMalign.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMalign.setBounds(566, 267, 331, 20);
		lblMalign.setVisible(false);
		add(lblMalign);

		RoundedButton btnDiagnose = new RoundedButton("Diagnose");
		btnDiagnose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					List<String> list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
					
					if(list.size()!=10) {
						Jlabel_1.setVisible(true);
						Jlabel_2.setVisible(false);
					}else {
						if(list.contains("")) {
							Jlabel_1.setVisible(true);
							Jlabel_2.setVisible(false);
						}else {
						Jlabel_1.setVisible(false);
						Jlabel_2.setVisible(false);
						
					
					for(int i=0; i<10; i++) {
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
					        case 8:  
					        	try{comboBox_8.setSelectedIndex(Integer.parseInt(list.get(i)));}
					        	catch(Exception e1) {
					        		comboBox_8.setSelectedIndex(0);
					        		Jlabel_2.setVisible(true);
					        	}
					        	break;
					        case 9: 
					        	try{comboBox_9.setSelectedIndex(Integer.parseInt(list.get(i)));}
					        	catch(Exception e1) {
					        		comboBox_9.setSelectedIndex(0);
					        		Jlabel_2.setVisible(true);
					        	}
					        	break;

					        default: break;
					    }
						}
						
					}
					
					list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
					for(int j=0;j<10;j++) {
						parameters[j]=Integer.parseInt(list.get(j));
					}
					
					
					}
					}
				
				ArrayList<Integer> signsParameters = new ArrayList<Integer>();
				
				for(int i=0; i<10; i++) {
					signsParameters.add(parameters[i]);
				}
								
				parent.patient.signs = signsParameters;
				parent.patient.exam = "BREAST CANCER";
				parent.patient.comments = textObs.getText();


				Jlabel_1.setVisible(false);
				Jlabel_2.setVisible(false);


				BN bayesnet; 
				
				String filename="Breast_Cancer.BN"; 
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

					parameters[10]=0; 
					double Benign=bayesnet.prob(parameters); 
					parameters[10]=1; 
					double Malign=bayesnet.prob(parameters); 
					
					double total=Benign+Malign;
					
					double probM=Malign/total;
					double probB=Benign/total;
					
					lblResults.setVisible(true);
					
					int width = 350;
					
					BenignB.setBounds(BenignB.getX(), BenignB.getY(), (int)(width*probB), BenignB.getHeight());
					BenignB.setVisible(true);
					
					MalignB.setBounds(BenignB.getX()+BenignB.getWidth(), MalignB.getY(), (int)(width*probM), MalignB.getHeight());
					MalignB.setVisible(true);
					
					lblLabel.setVisible(true);
					lblBenign.setText("Benign: "+(new DecimalFormat("##.##").format(probB*100))+"%");
					lblBenign.setVisible(true);
					lblMalign.setText("Malign: "+(new DecimalFormat("##.##").format(probM*100))+"%");
					lblMalign.setVisible(true);
					
					
					System.out.println(probB +", "+ probM);
					
					if(probB>probM) {
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
		

		
			

		
	}
}

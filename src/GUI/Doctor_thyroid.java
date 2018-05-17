package GUI;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import Tipos_de_dados.BN;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings("serial")
public class Doctor_thyroid extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	
	// 20 parâmetros
	
	int [] parameters = new int[21];

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Doctor_thyroid(Doctor_on parent) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		setSize(1000,480);
		
		JLabel Jlabel_1 = new JLabel("Incorrect number of parameters. Please insert 10 parameters.");
		Jlabel_1.setForeground(Color.RED);
		Jlabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Jlabel_1.setBounds(359, 347, 489, 20);
		add(Jlabel_1);
		
		JLabel Jlabel_2 = new JLabel("Invalid parameter value. Verify domain.");
		Jlabel_2.setForeground(Color.RED);
		Jlabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Jlabel_2.setBounds(359, 347, 489, 20);
		add(Jlabel_2);
		
		Jlabel_1.setVisible(false);
		Jlabel_2.setVisible(false);
		
		textField = new JTextField();
		
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(15, 345, 332, 26);
		textField.setText(Arrays.toString(Arrays.copyOf(parameters, 20)));
		add(textField);
		textField.setBorder(BorderFactory.createLineBorder(new Color(100,155,175)));
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem(0);
		comboBox.addItem(1);
		comboBox.setBounds(84, 69, 60, 25);
		comboBox.addItem(2);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem(0);
		comboBox_1.addItem(1);		
		comboBox_1.setBounds(84, 119, 60, 25);
		add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addItem(0);
		comboBox_2.addItem(1);
		comboBox_2.setBounds(84, 169, 60, 25);
		add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.addItem(0);
		comboBox_3.addItem(1);
		comboBox_3.setBounds(84, 219, 60, 25);
		add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.addItem(0);
		comboBox_4.addItem(1);
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

		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.addItem(0);
		comboBox_10.addItem(1);
		comboBox_11.setBounds(388, 119, 60, 25);
		add(comboBox_10);
		
		JComboBox comboBox_11 = new JComboBox();
		comboBox_11.addItem(0);
		comboBox_11.addItem(1);
		comboBox_11.setBounds(372, 119, 60, 25);
		add(comboBox_11);
		
		JComboBox comboBox_12 = new JComboBox();
		comboBox_12.addItem(0);
		comboBox_12.addItem(1);
		comboBox_12.setBounds(388, 169, 60, 25);
		add(comboBox_12);
		
		JComboBox comboBox_13 = new JComboBox();
		comboBox_13.addItem(0);
		comboBox_13.addItem(1);
		comboBox_13.setBounds(388, 219, 60, 25);
		add(comboBox_13);
		
		JComboBox comboBox_14 = new JComboBox();
		comboBox_14.addItem(0);
		comboBox_14.addItem(1);
		comboBox_14.setBounds(388, 269, 60, 25);
		add(comboBox_14);
		
		JComboBox comboBox_15 = new JComboBox();
		comboBox_15.addItem(0);
		comboBox_15.addItem(1);
		comboBox_15.setBounds(542, 69, 60, 25);
		add(comboBox_15);
		
		JComboBox comboBox_16 = new JComboBox();
		comboBox_16.addItem(0);
		comboBox_16.addItem(1);
		comboBox_16.setBounds(542, 119, 60, 25);
		add(comboBox_16);
		
		JComboBox comboBox_17 = new JComboBox();
		comboBox_17.addItem(0);
		comboBox_17.addItem(1);
		comboBox_17.setBounds(542, 169, 60, 25);
		add(comboBox_17);
		
		JComboBox comboBox_18 = new JComboBox();
		comboBox_18.addItem(0);
		comboBox_18.addItem(1);
		comboBox_18.addItem(2);
		comboBox_18.addItem(3);
		comboBox_18.setBounds(542, 219, 60, 25);
		add(comboBox_18);
		
		JComboBox comboBox_19 = new JComboBox();
		comboBox_19.addItem(0);
		comboBox_19.addItem(1);
		comboBox_19.addItem(2);
		comboBox_19.addItem(3);
		comboBox_19.addItem(4);
		comboBox_19.setBounds(516, 269, 60, 25);
		add(comboBox_19);
		
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				List<String> list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
				
				if(list.size()!=20) {
					Jlabel_1.setVisible(true);
					Jlabel_2.setVisible(false);
				}else {
					if(list.contains("")) {
						Jlabel_1.setVisible(true);
						Jlabel_2.setVisible(false);
					}else {
					Jlabel_1.setVisible(false);
					Jlabel_2.setVisible(false);
					
				
				for(int i=0; i<20; i++) {
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
				        case 10:  
				        	try{comboBox_10.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_10.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 11:  
				        	try{comboBox_11.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_11.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 12:  
				        	try{comboBox_12.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_12.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 13:  
				        	try{comboBox_13.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_13.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 14: 
				        	try{comboBox_14.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_14.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 15:  
				        	try{comboBox_15.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_15.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 16:  
				        	try{comboBox_16.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_16.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 17:  
				        	try{comboBox_17.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_7.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 18:  
				        	try{comboBox_18.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_18.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 19:  
				        	try{comboBox_19.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_19.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;


				        default: break;
				    }
					}
					
				}
				
				list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
				for(int j=0;j<20;j++) {
					parameters[j]=Integer.parseInt(list.get(j));
				}
				
				
				}
			}
		}
		});
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
				
				if(list.size()!=20) {
					Jlabel_1.setVisible(true);
					Jlabel_2.setVisible(false);
				}else {
					if(list.contains("")) {
						Jlabel_1.setVisible(true);
						Jlabel_2.setVisible(false);
					}else {
					Jlabel_1.setVisible(false);
					Jlabel_2.setVisible(false);
					
				
				for(int i=0; i<20; i++) {
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
				        case 10:  
				        	try{comboBox_10.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_10.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 11:  
				        	try{comboBox_11.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_11.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 12:  
				        	try{comboBox_12.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_12.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 13:  
				        	try{comboBox_13.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_13.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 14: 
				        	try{comboBox_14.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_14.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 15:  
				        	try{comboBox_15.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_15.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 16:  
				        	try{comboBox_16.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_16.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 17:  
				        	try{comboBox_17.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_7.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 18:  
				        	try{comboBox_18.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_18.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;
				        case 19:  
				        	try{comboBox_19.setSelectedIndex(Integer.parseInt(list.get(i)));}
				        	catch(Exception e1) {
				        		comboBox_19.setSelectedIndex(0);
				        		Jlabel_2.setVisible(true);
				        	}
				        	break;


				        default: break;
				    }
					}
					
				}
				
				list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
				for(int j=0;j<20;j++) {
					parameters[j]=Integer.parseInt(list.get(j));
				}
				
				
				}
			}}
		});
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[0] = comboBox.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 20)));
				
			}
		});
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[1] = comboBox_1.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 20)));
				
			}
		});
		
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[2] = comboBox_2.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 20)));
				
			}
		});

		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[3] = comboBox_3.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 20)));
				
			}
		});
		
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[4] = comboBox_4.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 20)));
				
			}
		});

		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[5] = comboBox_5.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 20)));
				
			}
		});
		
		comboBox_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[6] = comboBox_6.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 20)));
				
			}
		});

		comboBox_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[7] = comboBox_7.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 20)));
				
			}
		});
		
		comboBox_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[8] = comboBox_8.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 20)));
				
			}
		});

		comboBox_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[9] = comboBox_9.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 20)));
				
			}
		});

		comboBox_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[10] = comboBox_10.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 20)));
				
			}
		});
		
		comboBox_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[11] = comboBox_11.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 20)));
				
			}
		});

		comboBox_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[12] = comboBox_12.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 20)));
				
			}
		});
		
		comboBox_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[13] = comboBox_13.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 20)));
				
			}
		});

		comboBox_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[14] = comboBox_14.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 20)));
				
			}
		});
		
		comboBox_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[15] = comboBox_15.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 20)));
				
			}
		});

		comboBox_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[16] = comboBox_16.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 20)));
				
			}
		});
		
		comboBox_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[17] = comboBox_17.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 20)));
				
			}
		});

		comboBox_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[18] = comboBox_18.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 20)));
				
			}
		});
		
		comboBox_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters[19] = comboBox_19.getSelectedIndex();
				textField.setText(Arrays.toString(Arrays.copyOf(parameters, 20)));
				
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


		RoundedButton btnDiagnose = new RoundedButton("Diagnose");
		btnDiagnose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
					List<String> list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
					
					if(list.size()!=20) {
						Jlabel_1.setVisible(true);
						Jlabel_2.setVisible(false);
					}else {
						if(list.contains("")) {
							Jlabel_1.setVisible(true);
							Jlabel_2.setVisible(false);
						}else {
						Jlabel_1.setVisible(false);
						Jlabel_2.setVisible(false);
						
					
					for(int i=0; i<20; i++) {
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
					        case 10:  
					        	try{comboBox_10.setSelectedIndex(Integer.parseInt(list.get(i)));}
					        	catch(Exception e1) {
					        		comboBox_10.setSelectedIndex(0);
					        		Jlabel_2.setVisible(true);
					        	}
					        	break;
					        case 11:  
					        	try{comboBox_11.setSelectedIndex(Integer.parseInt(list.get(i)));}
					        	catch(Exception e1) {
					        		comboBox_11.setSelectedIndex(0);
					        		Jlabel_2.setVisible(true);
					        	}
					        	break;
					        case 12:  
					        	try{comboBox_12.setSelectedIndex(Integer.parseInt(list.get(i)));}
					        	catch(Exception e1) {
					        		comboBox_12.setSelectedIndex(0);
					        		Jlabel_2.setVisible(true);
					        	}
					        	break;
					        case 13:  
					        	try{comboBox_13.setSelectedIndex(Integer.parseInt(list.get(i)));}
					        	catch(Exception e1) {
					        		comboBox_13.setSelectedIndex(0);
					        		Jlabel_2.setVisible(true);
					        	}
					        	break;
					        case 14: 
					        	try{comboBox_14.setSelectedIndex(Integer.parseInt(list.get(i)));}
					        	catch(Exception e1) {
					        		comboBox_14.setSelectedIndex(0);
					        		Jlabel_2.setVisible(true);
					        	}
					        	break;
					        case 15:  
					        	try{comboBox_15.setSelectedIndex(Integer.parseInt(list.get(i)));}
					        	catch(Exception e1) {
					        		comboBox_15.setSelectedIndex(0);
					        		Jlabel_2.setVisible(true);
					        	}
					        	break;
					        case 16:  
					        	try{comboBox_16.setSelectedIndex(Integer.parseInt(list.get(i)));}
					        	catch(Exception e1) {
					        		comboBox_16.setSelectedIndex(0);
					        		Jlabel_2.setVisible(true);
					        	}
					        	break;
					        case 17:  
					        	try{comboBox_17.setSelectedIndex(Integer.parseInt(list.get(i)));}
					        	catch(Exception e1) {
					        		comboBox_7.setSelectedIndex(0);
					        		Jlabel_2.setVisible(true);
					        	}
					        	break;
					        case 18:  
					        	try{comboBox_18.setSelectedIndex(Integer.parseInt(list.get(i)));}
					        	catch(Exception e1) {
					        		comboBox_18.setSelectedIndex(0);
					        		Jlabel_2.setVisible(true);
					        	}
					        	break;
					        case 19:  
					        	try{comboBox_19.setSelectedIndex(Integer.parseInt(list.get(i)));}
					        	catch(Exception e1) {
					        		comboBox_19.setSelectedIndex(0);
					        		Jlabel_2.setVisible(true);
					        	}
					        	break;


					        default: break;
					    }
						}
						
					}
					
					list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
					for(int j=0;j<20;j++) {
						parameters[j]=Integer.parseInt(list.get(j));
					}
					
					
					}
				}
				
				ArrayList<Integer> signsParameters = new ArrayList<Integer>();
				
				for(int i=0; i<20; i++) {
					signsParameters.add(parameters[i]);
				}
								
				parent.patient.signs = signsParameters;
				parent.patient.exam = "THYROID DISEASE";
				parent.patient.comments = textObs.getText();

				Jlabel_1.setVisible(false);
				
				BN bayesnet; 

				String filename="Thyroid.BN"; 
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

					parameters[20]=0; 
					double Normal=bayesnet.prob(parameters); 
					parameters[20]=1; 
					double Hiper=bayesnet.prob(parameters); 
					
					double total=Normal+Hiper;
					
					double probN=Normal/total;
					double probH=Hiper/total;
					
					System.out.println(probN +", "+ probH);

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
		
		JLabel label_9 = new JLabel("Parameter 11");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_9.setBounds(299, 69, 105, 20);
		add(label_9);
		
		JLabel label_10 = new JLabel("Parameter 12");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_10.setBounds(299, 119, 105, 20);
		add(label_10);
		
		JLabel label_11 = new JLabel("Parameter 13");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_11.setBounds(299, 169, 105, 20);
		add(label_11);
		
		JLabel label_12 = new JLabel("Parameter 14");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_12.setBounds(299, 219, 105, 20);
		add(label_12);
		
		JLabel label_13 = new JLabel("Parameter 15");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_13.setBounds(299, 269, 105, 20);
		add(label_13);
		
		JLabel label_14 = new JLabel("Parameter 16");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_14.setBounds(444, 69, 105, 20);
		add(label_14);
		
		JLabel label_15 = new JLabel("Parameter 17");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_15.setBounds(444, 119, 105, 20);
		add(label_15);
		
		JLabel label_16 = new JLabel("Parameter 18");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_16.setBounds(444, 169, 105, 20);
		add(label_16);
		
		JLabel label_17 = new JLabel("Parameter 19");
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_17.setBounds(444, 219, 105, 20);
		add(label_17);
		
		JLabel label_18 = new JLabel("Parameter 20");
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_18.setBounds(444, 269, 105, 20);
		add(label_18);



	}

}

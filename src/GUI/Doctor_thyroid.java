package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

import javax.swing.SwingConstants;

import Tipos_de_dados.BN;

public class Doctor_thyroid extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	
	// 20 parâmetros
	
	public Doctor_thyroid(Doctor_on parent) {
		setLayout(null);
		
setSize(1000,600);
		
		
		JLabel lblSelectValuesFor = new JLabel("Insert parameters (use ',' to separate the values):");
		lblSelectValuesFor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectValuesFor.setBounds(15, 53, 442, 20);
		add(lblSelectValuesFor);
		
		JLabel Jlabel_1 = new JLabel("Incorrect number of parameters. Please insert 20 parameters.");
		Jlabel_1.setForeground(Color.RED);
		Jlabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Jlabel_1.setBounds(326, 98, 489, 20);
		add(Jlabel_1);
		
		Jlabel_1.setVisible(false);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(15, 95, 296, 26);
		add(textField);
		textField.setColumns(10);
		

		JButton btnDiagnose = new JButton("Diagnose");
		btnDiagnose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String[] param = textField.getText().split(",");	
				int[] parameters = new int[param.length+1]; // J� inclui uma entrada para pormos a classe mais tarde
				if(param.length!=19) {
					Jlabel_1.setVisible(true);
				}
					else {
						Jlabel_1.setVisible(false);
					for(int i=0; i<param.length; i++)
						parameters[i] = Integer.parseInt(param[i]);
					System.out.println(Arrays.toString(parameters));
					}
				
				BN bayesnet; 

				String filename="Thyroid.BN"; 
				FileInputStream fis; 
				ObjectInputStream ois; 
				try { 
					fis=new FileInputStream(parent.doctorPanel.modelsource+filename); 
					ois=new ObjectInputStream(fis); 
					bayesnet=(BN)ois.readObject(); 
					ois.close(); 
					fis.close(); 

					parameters[20]=0; 
					double Normal=bayesnet.prob(parameters); 
					parameters[20]=1; 
					double Hiper=bayesnet.prob(parameters); 
				} 
				catch(FileNotFoundException e1) { 

				} 
				catch(IOException e2) { 
				}  
				catch (ClassNotFoundException e3) {
				}
			}
		});
		btnDiagnose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDiagnose.setBounds(15, 274, 115, 29);
		add(btnDiagnose);


	}

}

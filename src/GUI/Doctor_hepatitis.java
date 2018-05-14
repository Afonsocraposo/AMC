package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Doctor_hepatitis extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	
	// 19 par√¢metros
	
	public Doctor_hepatitis() {
		setLayout(null);

		setSize(1000,600);
		
		
		JLabel lblSelectValuesFor = new JLabel("Insert parameters (use ',' to separate the values):");
		lblSelectValuesFor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectValuesFor.setBounds(15, 53, 442, 20);
		add(lblSelectValuesFor);
		
		JLabel Jlabel_1 = new JLabel("Incorrect number of parameters. Please insert 10 parameters.");
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
				if(param.length!=19) {
					Jlabel_1.setVisible(true);
				}
					else {
						Jlabel_1.setVisible(false);
						int[] parameters = new int[param.length+1]; // J· inclui uma entrada para pormos a classe mais tarde
					for(int i=0; i<param.length; i++)
						parameters[i] = Integer.parseInt(param[i]);
					System.out.println(Arrays.toString(parameters));
					}
				
			}
		});
		btnDiagnose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDiagnose.setBounds(15, 274, 115, 29);
		add(btnDiagnose);

	}
}

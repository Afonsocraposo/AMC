package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Doctor_hepatitis extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;

	/**
	 * Create the panel.
	 */
	
	// 19 parâmetros
	
	public Doctor_hepatitis() {
		setLayout(null);

		setSize(1000,1000);
		
		
		JLabel lblSelectValuesFor = new JLabel("Introduce parameters' values:");
		lblSelectValuesFor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectValuesFor.setBounds(15, 53, 281, 20);
		add(lblSelectValuesFor);
		
	
		
		textField = new JTextField();
		textField.setBounds(15, 95, 394, 26);
		add(textField);
		textField.setColumns(10);
		

		JButton btnDiagnose = new JButton("Diagnose");
		btnDiagnose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String [] parameters = new String[20];
			

				System.out.println(Arrays.toString(parameters));
				
			}
		});
		btnDiagnose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDiagnose.setBounds(15, 274, 115, 29);
		add(btnDiagnose);

	}
}

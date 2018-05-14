package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Doctor_cancer extends JPanel {

	/**
	 * Create the panel.
	 */
	
	// 10 parâmetros
	
	public Doctor_cancer() {
		setLayout(null);
		
		setSize(1000,1000);
		JComboBox comboBox = new JComboBox();
		comboBox.addItem(0);
		comboBox.addItem(1);
		comboBox.setBounds(135, 102, 57, 26);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem(0);
		comboBox_1.setBounds(135, 152, 57, 26);
		add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addItem(0);
		comboBox_2.addItem(1);
		comboBox_2.addItem(2);
		comboBox_2.setBounds(135, 202, 57, 26);
		add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.addItem(0);
		comboBox_3.addItem(1);
		comboBox_3.addItem(2);
		comboBox_3.addItem(3);
		comboBox_3.setBounds(135, 252, 57, 26);
		add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.addItem(0);
		comboBox_4.addItem(1);
		comboBox_4.addItem(2);
		comboBox_4.setBounds(135, 302, 57, 26);
		add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.addItem(0);
		comboBox_5.addItem(1);
		comboBox_5.setBounds(342, 102, 57, 26);
		add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.addItem(0);
		comboBox_6.addItem(1);
		comboBox_6.setBounds(342, 152, 57, 26);
		add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.addItem(0);
		comboBox_7.addItem(1);
		comboBox_7.addItem(2);
		comboBox_7.setBounds(342, 202, 57, 26);
		add(comboBox_7);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.addItem(0);
		comboBox_8.addItem(1);
		comboBox_8.setBounds(342, 252, 57, 26);
		add(comboBox_8);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.addItem(0);
		comboBox_9.addItem(1);
		comboBox_9.setBounds(342, 302, 57, 26);
		add(comboBox_9);
		
		JLabel lblParmetro = new JLabel("Parameter 1");
		lblParmetro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblParmetro.setBounds(15, 105, 105, 20);
		add(lblParmetro);
		
		JLabel label = new JLabel("Parameter 2");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(15, 155, 105, 20);
		add(label);
		
		
		JLabel label_2 = new JLabel("Parameter 3");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(15, 205, 105, 20);
		add(label_2);
		
		JLabel label_3 = new JLabel("Parameter 4");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(15, 255, 105, 20);
		add(label_3);
		
		JLabel label_4 = new JLabel("Parameter 5");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(15, 305, 105, 20);
		add(label_4);
		
		JLabel label_1 = new JLabel("Parameter 6");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(222, 105, 105, 20);
		add(label_1);
		
		JLabel label_5 = new JLabel("Parameter 7");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_5.setBounds(222, 155, 105, 20);
		add(label_5);
		
		JLabel label_6 = new JLabel("Parameter 8");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_6.setBounds(222, 205, 105, 20);
		add(label_6);
		
		JLabel label_7 = new JLabel("Parameter 9");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_7.setBounds(222, 255, 105, 20);
		add(label_7);
		
		JLabel label_8 = new JLabel("Parameter 10");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_8.setBounds(222, 305, 105, 20);
		add(label_8);
		
		JLabel lblSelectValuesFor = new JLabel("Select values for each parameter:");
		lblSelectValuesFor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectValuesFor.setBounds(15, 53, 281, 20);
		add(lblSelectValuesFor);
		
		JButton btnDiagnose = new JButton("Diagnose");
		btnDiagnose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int [] parameters = new int[10];
				parameters[0] = comboBox.getSelectedIndex();
				parameters[1] = comboBox_1.getSelectedIndex();
				parameters[2] = comboBox_2.getSelectedIndex();
				parameters[3] = comboBox_3.getSelectedIndex();
				parameters[4] = comboBox_4.getSelectedIndex();
				parameters[5] = comboBox_5.getSelectedIndex();
				parameters[6] = comboBox_6.getSelectedIndex();
				parameters[7] = comboBox_7.getSelectedIndex();
				parameters[8] = comboBox_8.getSelectedIndex();
				parameters[9] = comboBox_9.getSelectedIndex();
				System.out.println(Arrays.toString(parameters));
				
			}
		});
		btnDiagnose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDiagnose.setBounds(165, 367, 115, 29);
		add(btnDiagnose);
	
	

	}
}

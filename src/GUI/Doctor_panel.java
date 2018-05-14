package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;

import com.itextpdf.text.DocumentException;

import PDF.PatientInfo;
import PDF.Report;
import Tipos_de_dados.BN;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Doctor_panel extends JPanel {
	
	private JTextField textName;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public File modelsource;

	/**
	 * Create the panel.
	 */
	public Doctor_panel(String username, Doctor_on parent) {
		setBackground(Color.WHITE);
		setSize(1000,120);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{32, 117, 63, 52, 171, 48, 39, 151, 246, 0, 0};
		gridBagLayout.rowHeights = new int[]{33, 16, 26, 16, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Patient's Name:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		textName = new JTextField();
		String default_val = textName.getText();
		GridBagConstraints gbc_textName = new GridBagConstraints();
		gbc_textName.anchor = GridBagConstraints.NORTH;
		gbc_textName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textName.insets = new Insets(0, 0, 5, 5);
		gbc_textName.gridwidth = 3;
		gbc_textName.gridx = 1;
		gbc_textName.gridy = 1;
		add(textName, gbc_textName);
		
		JLabel lblGender = new JLabel("Gender:");
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 5;
		gbc_lblGender.gridy = 1;
		add(lblGender, gbc_lblGender);
		
		JLabel lblNewLabel_1 = new JLabel("Dr. "+username);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 8;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblBirthday = new JLabel("Birthday:");
		GridBagConstraints gbc_lblBirthday = new GridBagConstraints();
		gbc_lblBirthday.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblBirthday.insets = new Insets(0, 0, 5, 5);
		gbc_lblBirthday.gridx = 1;
		gbc_lblBirthday.gridy = 2;
		add(lblBirthday, gbc_lblBirthday);
		
		JRadioButton rdbtnM = new JRadioButton("M");
		buttonGroup.add(rdbtnM);
		rdbtnM.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_rdbtnM = new GridBagConstraints();
		gbc_rdbtnM.anchor = GridBagConstraints.WEST;
		gbc_rdbtnM.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnM.gridx = 5;
		gbc_rdbtnM.gridy = 2;
		add(rdbtnM, gbc_rdbtnM);
		
		JRadioButton rdbtnF = new JRadioButton("F");
		buttonGroup.add(rdbtnF);
		GridBagConstraints gbc_rdbtnF = new GridBagConstraints();
		gbc_rdbtnF.anchor = GridBagConstraints.WEST;
		gbc_rdbtnF.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnF.gridx = 6;
		gbc_rdbtnF.gridy = 2;
		add(rdbtnF, gbc_rdbtnF);
		
		ArrayList<String> years_tmp = new ArrayList<String>();
		for(int years = Calendar.getInstance().get(Calendar.YEAR); years>=1900; years--) {
		    years_tmp.add(years+"");
		}
		
		ArrayList<String> months_tmp = new ArrayList<String>();
		for(int months = 1; months<=12; months++) {
		    months_tmp.add(months+"");
		}
		
		ArrayList<String> days_tmp = new ArrayList<String>();
		for(int days = 1; days<=31; days++) {
		    days_tmp.add(days+"");
		}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox comboBoxYear = new JComboBox(years_tmp.toArray());
		GridBagConstraints gbc_comboBoxYear = new GridBagConstraints();
		gbc_comboBoxYear.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxYear.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxYear.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxYear.gridx = 1;
		gbc_comboBoxYear.gridy = 3;
		add(comboBoxYear, gbc_comboBoxYear);
	
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox comboBoxMonth = new JComboBox(months_tmp.toArray());
		GridBagConstraints gbc_comboBoxMonth = new GridBagConstraints();
		gbc_comboBoxMonth.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxMonth.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxMonth.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxMonth.gridx = 2;
		gbc_comboBoxMonth.gridy = 3;
		add(comboBoxMonth, gbc_comboBoxMonth);

		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox comboBoxDay = new JComboBox(days_tmp.toArray());
		GridBagConstraints gbc_comboBoxDay = new GridBagConstraints();
		gbc_comboBoxDay.anchor = GridBagConstraints.NORTHWEST;
		gbc_comboBoxDay.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxDay.gridx = 3;
		gbc_comboBoxDay.gridy = 3;
		add(comboBoxDay, gbc_comboBoxDay);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String gender = null;
				String timeStampFile = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
				
				if(rdbtnM.isSelected()&&!rdbtnF.isSelected()) {
					gender = "M";
				}else if(!rdbtnM.isSelected()&&!rdbtnF.isSelected()) {
					gender = "F";
				}
				
	        	PatientInfo patient = new PatientInfo();

	        	if(!textName.getText().isEmpty()) {
	        		patient.name = textName.getText();
	        	}
	        	patient.gender = gender;
	        	patient.doctor = username;
	        	
	        	patient.birth_year = Integer.parseInt(comboBoxYear.getSelectedItem().toString());
	        	patient.birth_month = Integer.parseInt(comboBoxMonth.getSelectedItem().toString());
	        	patient.birth_day = Integer.parseInt(comboBoxDay.getSelectedItem().toString());
	        	
	        	String DEST = "results_pdf/Report-" + timeStampFile + ".pdf";
	            File file = new File(DEST);
	            file.getParentFile().mkdirs();
	        	try {
					new Report().createPdf(DEST, patient);
				} catch (DocumentException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        }
		});
		JButton btnSource = new JButton("Choose Model");
		btnSource.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser f = new JFileChooser();
		        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
		        f.showSaveDialog(null);
		        
		        modelsource= f.getCurrentDirectory();
		        System.out.println(f.getCurrentDirectory());
	        }
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.anchor = GridBagConstraints.EAST;
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 8;
		gbc_btnSave.gridy = 3;
		add(btnSave, gbc_btnSave);

	}
	public File modelsource() {
		return modelsource;
	}

}

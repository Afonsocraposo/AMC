package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;

import com.itextpdf.text.DocumentException;

import PDF.Report;

import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

@SuppressWarnings("serial")
public class Doctor_panel extends JPanel {
	
	private JTextField textName;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public File modelsource;

	/**
	 * Create the panel.
	 */
	public Doctor_panel(String username, Doctor_on parent) {
		setBackground(new Color(240,250,255));
		setPreferredSize(new Dimension(1000, 120));
		setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Patient's Name:");
		lblNewLabel.setBounds(6, 5, 97, 16);
		add(lblNewLabel);
		
		textName = new JTextField();
		textName.setBounds(6, 24, 280, 26);
		add(textName);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(296, 80, 48, 16);
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblGender);
		
		JRadioButton rdbtnM = new JRadioButton("M");
		rdbtnM.setBounds(349, 76, 43, 23);
		buttonGroup.add(rdbtnM);
		rdbtnM.setHorizontalAlignment(SwingConstants.RIGHT);
		add(rdbtnM);
		
		JRadioButton rdbtnF = new JRadioButton("F");
		rdbtnF.setBounds(397, 76, 39, 23);
		buttonGroup.add(rdbtnF);
		add(rdbtnF);
		
		JLabel lblNewLabel_1 = new JLabel("Dr. "+username);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_1.setBounds(632, 24, 283, 16);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNewLabel_1);
		
		JLabel lblBirthday = new JLabel("Birthday:");
		lblBirthday.setBounds(6, 59, 55, 16);
		add(lblBirthday);
		
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
		comboBoxYear.setBounds(6, 75, 90, 25);
		add(comboBoxYear);
	
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox comboBoxMonth = new JComboBox(months_tmp.toArray());
		comboBoxMonth.setBounds(102, 75, 70, 25);
		add(comboBoxMonth);

		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox comboBoxDay = new JComboBox(days_tmp.toArray());
		comboBoxDay.setBounds(163, 75, 70, 25);
		add(comboBoxDay);
		
				
				RoundedButton btnSource = new RoundedButton("Choose Models");
				btnSource.setBounds(632, 69, 136, 26);
				btnSource.setBackground(new Color(100,155,175));
				btnSource.setForeground(Color.WHITE);
				btnSource.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						JFileChooser f = new JFileChooser();
				        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
				        f.setDialogTitle("Choose folder containing models");
				        f.showOpenDialog(null);
				        
				        modelsource= f.getCurrentDirectory();
	        }
				});
				add(btnSource);
		
		RoundedButton btnSave = new RoundedButton("Save as PDF");
		btnSave.setBounds(800, 69, 115, 26);
		btnSave.setBackground(new Color(100,155,175));
		btnSave.setForeground(Color.WHITE);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String gender = null;
				String timeStampFile = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
				
				if(rdbtnM.isSelected()&&!rdbtnF.isSelected()) {
					gender = "M";
				}else if(!rdbtnM.isSelected()&&!rdbtnF.isSelected()) {
					gender = "F";
				}
				
	        	

	        	if(!textName.getText().isEmpty()) {
	        		parent.patient.name = textName.getText();
	        	}
	        	parent.patient.gender = gender;
	        	parent.patient.doctor = username;
	        	
	        	parent.patient.birth_year = Integer.parseInt(comboBoxYear.getSelectedItem().toString());
	        	parent.patient.birth_month = Integer.parseInt(comboBoxMonth.getSelectedItem().toString());
	        	parent.patient.birth_day = Integer.parseInt(comboBoxDay.getSelectedItem().toString());
	        	
	        	String DEST = "results_pdf/Report-" + timeStampFile + ".pdf";
	            File file = new File(DEST);
	            file.getParentFile().mkdirs();
	        	try {
					new Report().createPdf(DEST, parent.patient);
				} catch (DocumentException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        }
		});
		add(btnSave);

	}
}

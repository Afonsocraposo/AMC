package GUI;

import java.awt.EventQueue;
import java.awt.FileDialog;

import Tipos_de_dados.Weighted_Graphs;

import javax.swing.JFrame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;



public class Aprendizagem {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aprendizagem window = new Aprendizagem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Aprendizagem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 300, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnChooseFile = new JButton("Choose file");
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FileDialog fd = new FileDialog(frame, "Select a file", FileDialog.LOAD);
				frame.getContentPane().setLayout(null);
				
//				btnChooseFile.setBounds(15, 42, 115, 29);
//				frame.getContentPane().add(btnChooseFile);
				fd.setDirectory("C:\\");
				fd.setFile("*.txt");
				fd.setVisible(true);
				String filename = fd.getFile();
				if (filename == null)
					System.out.println("Cancelled");
				else 
					System.out.println("File selected: " + filename);
				
				File FILENAME = new File(fd.getDirectory()+filename);

				BufferedReader br = null;
				FileReader fr = null;
				LinkedList<String> la = new LinkedList<String>();

				try {

					//br = new BufferedReader(new FileReader(FILENAME));
					fr = new FileReader(FILENAME);
					br = new BufferedReader(fr);

					String sCurrentLine;

					while ((sCurrentLine = br.readLine()) != null) {
						la.add(sCurrentLine);
					}

				} catch (IOException a) {

					a.printStackTrace();

				} finally {

					try {

						if (br != null)
							br.close();

						if (fr != null)
							fr.close();
						
						System.out.println(la);

					} catch (IOException ex) {

						ex.printStackTrace();

					}
				}
				textField.setText(filename);
			}
		});
		btnChooseFile.setBounds(15, 42, 115, 29);
		frame.getContentPane().add(btnChooseFile);
		
		textField = new JTextField();
		textField.setBounds(145, 43, 268, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblChooseParameter = new JLabel("Choose parameter");
		lblChooseParameter.setBounds(478, 46, 136, 20);
		frame.getContentPane().add(lblChooseParameter);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Breast Cancer");
		rdbtnNewRadioButton.setBounds(488, 84, 155, 29);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Diabetes");
		rdbtnNewRadioButton_1.setBounds(488, 134, 155, 29);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Hepatitis");
		rdbtnNewRadioButton_2.setBounds(488, 187, 155, 29);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Parkisons");
		rdbtnNewRadioButton_3.setBounds(488, 238, 155, 29);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Thyroid");
		rdbtnNewRadioButton_4.setBounds(488, 290, 155, 29);
		frame.getContentPane().add(rdbtnNewRadioButton_4);
		
		ButtonGroup group = new ButtonGroup(); 
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_3);
		group.add(rdbtnNewRadioButton_4);
		
		JButton btnTeachMe = new JButton("Teach me!");
		btnTeachMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//      CENAS FIXES				
				
			}
		});
		btnTeachMe.setBounds(15, 327, 115, 29);
		frame.getContentPane().add(btnTeachMe);
	}
}
	

	
		
	


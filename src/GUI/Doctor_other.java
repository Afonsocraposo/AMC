package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;

import PDF.ScreenImage;

import javax.swing.JLabel;

import java.awt.Font;

import Tipos_de_dados.BN;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;


@SuppressWarnings("serial")
public class Doctor_other extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	
	
	private int [] parameters = new int[11];
	
	public Doctor_other(Doctor_on parent) {
		Locale.setDefault(Locale.US);
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
		
		JPanel plot = new JPanel();
		plot.setBackground(Color.WHITE);
		plot.setLocation(500, 30);
		plot.setSize(400,300);
		plot.setVisible(false);

		
		
		
		
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
				
				list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
				for(int j=0;j<10;j++) {
					parameters[j]=Integer.parseInt(list.get(j));
				}
				
				plot.setVisible(false);
				
				
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
					
				
			
				
				list = Arrays.asList(textField.getText().substring(1, textField.getText().length() - 1).split(", "));
				for(int j=0;j<10;j++) {
					parameters[j]=Integer.parseInt(list.get(j));
				}
				
				plot.setVisible(false);
				
				
				}
			}}
		});
		
		
		
		
	
		
		
		JTextArea textObs = new JTextArea();
		textObs.setBounds(15, 407, 530, 46);
		textObs.setBorder(BorderFactory.createLineBorder(new Color(100,155,175)));
		add(textObs);
	
		
		JLabel lblResults = new JLabel("Results:");
		lblResults.setForeground(new Color(100, 155, 175));
		lblResults.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblResults.setBounds(30, 30, 66, 20);
		plot.setLayout(null);
		plot.add(lblResults);
		
		JLabel BenignB = new JLabel("");
		BenignB.setBackground(new Color(0, 100, 0));
		BenignB.setOpaque(true);
		BenignB.setBounds(30, 62, 171, 46);
		plot.add(BenignB);
		
		JLabel MalignB = new JLabel("");
		MalignB.setOpaque(true);
		MalignB.setBackground(new Color(255, 0, 0));
		MalignB.setBounds(202, 62, 171, 46);
		plot.add(MalignB);
		
		JLabel lblLabel = new JLabel("Label:");
		lblLabel.setForeground(new Color(100, 155, 175));
		lblLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLabel.setBounds(30, 115, 100, 63);
		plot.add(lblLabel);
		
		JLabel lblBenign = new JLabel("");
		lblBenign.setForeground(new Color(0, 100, 0));
		lblBenign.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBenign.setBounds(30, 164, 279, 35);
		plot.add(lblBenign);
		
		JLabel lblMalign = new JLabel("");
		lblMalign.setForeground(new Color(255, 0, 0));
		lblMalign.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMalign.setBounds(30, 211, 279, 35);
		plot.add(lblMalign);
		
		JPanel healthy_panel = new JPanel();
		healthy_panel.setBounds(280, 140, 100, 101);
		healthy_panel.setBackground(Color.WHITE);;
		JPanel sick_panel = new JPanel();
		sick_panel.setBounds(280, 140, 100, 101);
		sick_panel.setBackground(Color.WHITE);;

		try {
			BufferedImage healthy_pic = ImageIO.read(new File("images/healthy.png"));
			BufferedImage sick_pic = ImageIO.read(new File("images/sick.png"));
			JLabel healthy = new JLabel(new ImageIcon(healthy_pic));
			JLabel sick = new JLabel(new ImageIcon(sick_pic));
			healthy.setLocation(0, 0);
			healthy.setSize(100, 100);
			healthy_panel.add(healthy);
			sick.setLocation(0, 0);
			sick.setSize(100, 100);
			sick_panel.add(sick);
			
			
		} catch (IOException e1) {
		}
		
		plot.add(healthy_panel);
		plot.add(sick_panel);
		

		RoundedButton btnDiagnose = new RoundedButton("Diagnose");
		btnDiagnose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					plot.setVisible(false);

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
					
					
					int width = 350;
					
					BenignB.setBounds(BenignB.getX(), BenignB.getY(), (int)(width*probB), BenignB.getHeight());
					
					MalignB.setBounds(BenignB.getX()+BenignB.getWidth(), MalignB.getY(), (int)(width*probM), MalignB.getHeight());
					
					lblBenign.setText("(0) Benign: "+ String.format( "%.2f",probB*100) +"%");
					lblMalign.setText("(1) Malign: "+ String.format( "%.2f",probM*100) +"%");
					

					if(probB>probM) {
						sick_panel.setVisible(false);
						healthy_panel.setVisible(true);
						parent.patient.result="NEGATIVE";
					} else {
						sick_panel.setVisible(true);
						healthy_panel.setVisible(false);
						parent.patient.result="POSITIVE";
					}
					
					plot.setVisible(true);
					
					lblResults.setForeground(Color.BLACK);
					lblLabel.setForeground(Color.BLACK);
					lblResults.setFont(new Font("Helvetica", Font.BOLD, 16));
					lblLabel.setFont(new Font("Helvetica", Font.BOLD, 16));
					lblBenign.setFont(new Font("Helvetica", Font.BOLD, 16));
					lblMalign.setFont(new Font("Helvetica", Font.BOLD, 16));

					
					BufferedImage plot_pic = ScreenImage.createImage(plot);
					parent.patient.picture = plot_pic;
					
					lblResults.setForeground(new Color(100, 155, 175));
					lblLabel.setForeground(new Color(100, 155, 175));
					lblResults.setFont(new Font("Tahoma", Font.BOLD, 16));
					lblLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
					lblBenign.setFont(new Font("Tahoma", Font.BOLD, 16));
					lblMalign.setFont(new Font("Tahoma", Font.BOLD, 16));


	
					
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

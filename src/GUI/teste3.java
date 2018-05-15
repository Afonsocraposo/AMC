package GUI;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;

import Tipos_de_dados.BN;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class teste3 {
	
	int[] signsParameters = {1,0,2,3,2,0,1,2,1,1,1};

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teste3 window = new teste3();
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
	public teste3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				BN bayesnet; 

				//String filename="Breast Cancer.BN"; 
				FileInputStream fis; 
				ObjectInputStream ois; 
				try { 
					fis=new FileInputStream("C:\\Users\\anaso\\Documents\\IST\\3ºAno_2ºSemestre\\Breast Cancer.BN"); 
					ois=new ObjectInputStream(fis); 
					bayesnet=(BN)ois.readObject(); 
					ois.close(); 
					fis.close(); 


					double Benign=bayesnet.prob(signsParameters); 
					double Malign=bayesnet.prob(signsParameters); 
					
					System.out.println(Benign +", "+ Malign);
					
				} 
				catch(FileNotFoundException e1) { 

				} 
				catch(IOException e2) { 
				}  
				catch (ClassNotFoundException e3) {
				}
			
			}
				
		});
		btnNewButton.setBounds(153, 89, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
	}

}

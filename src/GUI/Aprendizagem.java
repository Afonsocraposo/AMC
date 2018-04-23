package GUI;

import java.awt.EventQueue;
import java.awt.FileDialog;



import javax.swing.JFrame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.IOException;



public class Aprendizagem {

	private JFrame frame;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		FileDialog fd = new FileDialog(frame, "Select a file", FileDialog.LOAD);
		fd.setDirectory("C:\\");
		fd.setFile("*.txt");
		fd.setVisible(true);
		String filename = fd.getFile();
		if (filename == null)
			System.out.println("Cancelled");
		else
			System.out.println("File selected: " + filename);
		
//		File myFile = new File (".filename");
//		Scanner myScan = new Scanner(myFile);
//		while (myScan.hasNext()) {
//			String line = myScan.nextLine();
//			Scanner scanner = new Scanner(line);
//			scanner.useDelimiter(",");	
//		}
		
		Scanner fileScan = new Scanner(filename);
		LinkedList<String> la = new LinkedList<String>();
		while (fileScan.hasNext()) {
			String line = fileScan.nextLine();
			System.out.println(line);
			la.add(line);
		   }
		   fileScan.close();
		   System.out.println(la);

		
	}
}
	


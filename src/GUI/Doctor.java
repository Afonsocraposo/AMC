package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;


public class Doctor {

	private JFrame frame_login;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor window = new Doctor();
					window.frame_login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Doctor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame_login = new Doctor_login();
	}

}


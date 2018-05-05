package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Doctor_login extends JFrame {

	private JPanel contentPane;
	private JTextField textUsername;
	public JFrame frame_on;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_login frame = new Doctor_login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	private String username = "Unkown";
	
	public Doctor_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoctorsName = new JLabel("Doctor's name:");
		lblDoctorsName.setBounds(177, 95, 95, 16);
		contentPane.add(lblDoctorsName);
		
		textUsername = new JTextField();
		textUsername.setBounds(160, 116, 130, 26);
		textUsername.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==10) {
					username=textUsername.getText();
					frame_on = new Doctor_on(username);
					frame_on.setVisible(true);
					setVisible(false);
				}
			}
		});
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username=textUsername.getText();
				frame_on = new Doctor_on(username);
				frame_on.setVisible(true);
				setVisible(false);
			}
		});
		btnEnter.setBounds(187, 147, 76, 29);
		contentPane.add(btnEnter);
		setVisible(true);
	}

}

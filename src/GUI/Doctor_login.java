package GUI;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
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
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
				
		JLabel lblDoctorsName = new JLabel("Doctor's name:");
		lblDoctorsName.setForeground(new Color(100,155,175));
		lblDoctorsName.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorsName.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblDoctorsName.setBounds(160, 94, 130, 16);
		contentPane.add(lblDoctorsName);
		
		textUsername = new JTextField();
		textUsername.setBounds(160, 116, 130, 26);
		textUsername.setBorder(BorderFactory.createLineBorder(new Color(100,155,175)));
		textUsername.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==10) {
					if(!textUsername.getText().isEmpty()) {
						username=textUsername.getText();
					}
					frame_on = new Doctor_on(username);
					frame_on.setVisible(true);
					setVisible(false);
				}
			}
		});
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		RoundedButton btnEnter = new RoundedButton("Enter");
		btnEnter.setBackground(new Color(100,155,175));
		btnEnter.setForeground(Color.WHITE);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textUsername.getText().isEmpty()) {
					username=textUsername.getText();
				}
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

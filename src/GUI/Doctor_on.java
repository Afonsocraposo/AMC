package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;


public class Doctor_on extends JFrame {

	private JPanel contentPane;
	Doctor_cancer firstPanel;
	Doctor_diabetes secondPanel;
	Doctor_hepatitis thirdPanel;
	Doctor_thyroid forthPanel;
	Doctor_panel doctorPanel;
	
	JTabbedPane tabbedPane = new JTabbedPane();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_on frame = new Doctor_on("Unknown");
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
	public Doctor_on(String username) {
		firstPanel = new Doctor_cancer(this);
		secondPanel = new Doctor_diabetes(this);
		thirdPanel = new Doctor_hepatitis(this);
		forthPanel = new Doctor_thyroid(this);
		
		doctorPanel = new Doctor_panel(username, this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1000,600);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(doctorPanel, BorderLayout.NORTH);
		
		username = "Unknown";
		JLabel lbluser = new JLabel(username);
		lbluser.setBounds(0, 0, 970, 60);
		lbluser.setHorizontalAlignment(SwingConstants.RIGHT);
		lbluser.setFont(new Font("Dialog", Font.PLAIN, 18));
		getContentPane().add(lbluser);
		
		tabbedPane.add("Breast Cancer",firstPanel);
		tabbedPane.add("Diabetes",secondPanel);
		tabbedPane.add("Hepatitis",thirdPanel);
		tabbedPane.add("Thyroid Disease",forthPanel);
		
		contentPane.add(tabbedPane);
	}

}

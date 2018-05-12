package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import java.awt.GridBagConstraints;

public class Doctor_on extends JFrame {

	JPanel firstPanel = new Doctor_cancer();
	JPanel secondPanel = new Doctor_diabetes();
	JPanel thirdPanel = new Doctor_hepatitis();
	JPanel forthPanel = new Doctor_thyroid();
	
	JTabbedPane tabbedPane = new JTabbedPane();

	String username;
	
	public Doctor_on(String user){
		username = "Dr. " + user;
		JLabel lbluser = new JLabel(username);
		lbluser.setBounds(0, 0, 980, 50);
		lbluser.setHorizontalAlignment(SwingConstants.RIGHT);
		lbluser.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		getContentPane().add(lbluser);
		
		tabbedPane.add("Breast Cancer",firstPanel);
		tabbedPane.add("Diabetes",secondPanel);
		tabbedPane.add("Hepatitis",thirdPanel);
		tabbedPane.add("Thyroid Disease",forthPanel);
		getContentPane().add(tabbedPane);
		setSize(1000,600);
	}

	// in case no name is given
	public Doctor_on(){
		username = "Unknown";
		JLabel lbluser = new JLabel(username);
		lbluser.setBounds(0, 0, 980, 50);
		lbluser.setHorizontalAlignment(SwingConstants.RIGHT);
		lbluser.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		getContentPane().add(lbluser);
		
		tabbedPane.add("Breast Cancer",firstPanel);
		tabbedPane.add("Diabetes",secondPanel);
		tabbedPane.add("Hepatitis",thirdPanel);
		tabbedPane.add("Thyroid Disease",forthPanel);
		getContentPane().add(tabbedPane);
		setSize(1000,600);
	}
	
	public static void main(String[] args) {
		Doctor_on tp = new Doctor_on();
		tp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tp.setVisible(true);
	}
	
}

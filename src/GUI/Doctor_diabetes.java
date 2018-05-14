package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Doctor_diabetes extends JPanel {

	/**
	 * Create the panel.
	 */
	
	// 8 parâmetros
	public Doctor_diabetes() {
		setLayout(null);
		
		JLabel lblCancerSucls = new JLabel("Diabetes sucks");
		lblCancerSucls.setBounds(0, 0, 1000, 500);
		lblCancerSucls.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancerSucls.setFont(new Font("Lucida Grande", Font.PLAIN, 37));
		add(lblCancerSucls);

	}

}

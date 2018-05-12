package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Doctor_thyroid extends JPanel {

	/**
	 * Create the panel.
	 */
	
	// 20 parâmetros
	
	public Doctor_thyroid() {
		setLayout(null);
		setPreferredSize(new Dimension(1000	, 600));
		
		JLabel lblCancerSucls = new JLabel("Thyroid sucks");
		lblCancerSucls.setBounds(0, 0, 1000, 500);
		lblCancerSucls.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancerSucls.setFont(new Font("Lucida Grande", Font.PLAIN, 37));
		add(lblCancerSucls);

	}

}

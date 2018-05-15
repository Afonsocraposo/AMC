package GUI;

import java.awt.EventQueue;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class teste2 extends JFrame {
	public teste2() {
	}

	private JPanel contentPane;
	
	private void display() {
		JFrame frame = new JFrame("Snapshot Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.WHITE);
       
        JLabel label = new JLabel("This JLabel will display"
                        + " itself on the SNAPSHOT", JLabel.CENTER);
        contentPane.add(label);
        
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        makePanelImage(contentPane);
	}

	private void makePanelImage(Component panel) {
		
		Dimension size = panel.getSize();
        BufferedImage image = new BufferedImage(
                    size.width, size.height 
                              , BufferedImage.TYPE_INT_RGB);
        
        Graphics2D g2 = image.createGraphics();
        panel.paint(g2);
        try
        {
            ImageIO.write(image, "png", new File("snapshot.png"));
            System.out.println("Panel saved as Image.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
	}
	
//	JTabbedPane tabbedPane = new JTabbedPane();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		 SwingUtilities.invokeLater(new Runnable()
	        {
	            public void run()
	            {           
	                new teste2().display();
	            }
	        });
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teste2 frame = new teste2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
}


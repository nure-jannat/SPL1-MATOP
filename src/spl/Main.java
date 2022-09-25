
package spl;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static spl.MATOP.decimals;
import static spl.MATOP.nf;


public class Main {
    public static void main(String[] args) {
		JFrame frame = new JFrame("MATOP");
		frame.setSize(new Dimension(725, 200));
                ImageIcon icon = new ImageIcon("C:\\Users\\janna\\OneDrive\\Documents\\NetBeansProjects\\MATOP\\src\\matop\\images.png");
                frame.setIconImage(icon.getImage());
		MATOP app = new MATOP();

		Component contents = app.createComponents();
		frame.getContentPane().add(contents, BorderLayout.CENTER);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.pack();
		frame.setVisible(true);

		nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(1);
		nf.setMaximumFractionDigits(decimals);

	}
}

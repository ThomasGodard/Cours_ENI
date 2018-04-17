package fr.eni.demo_swing;

import javax.swing.SwingUtilities;

import fr.eni.demo_swing.ihm.FenetrePrincipale;

public class DemoSwing {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				FenetrePrincipale frame = new FenetrePrincipale();
				frame.setVisible(true);
			}
		});
	}

}

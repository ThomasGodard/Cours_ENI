package fr.eni.papeterie.test;

import javax.swing.SwingUtilities;

import fr.eni.papeterie.ihm.DetailFrame;

public class AppliTestIHM {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				DetailFrame frame = new DetailFrame();
				frame.setVisible(true);
			}
		});
	}

}

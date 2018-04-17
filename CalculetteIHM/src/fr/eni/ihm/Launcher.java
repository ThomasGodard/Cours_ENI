package fr.eni.ihm;
import javax.swing.SwingUtilities;

public class Launcher {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			new Fenetre().setVisible(true);
		});
	}

}

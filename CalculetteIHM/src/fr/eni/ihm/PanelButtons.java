package fr.eni.ihm;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;



public class PanelButtons extends JPanel {
	
	public interface PanelBouttonsListener {
		public void onButonClicked(String msg);
	}

	public PanelButtons(String nom[], PanelBouttonsListener listener) {
		for( String c : nom ) {
			JButton bouton = new JButton(c);
			bouton.addActionListener(e -> listener.onButonClicked(((JButton)e.getSource()).getText()));
			add(bouton);
		}
	}

	public PanelButtons(String nom[], PanelBouttonsListener listener, int axis) {
		this(nom, listener);
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(layout);
	}
}

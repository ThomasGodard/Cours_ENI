package fr.eni.demo_swing.ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelButtons extends JPanel {
	
	public interface PanelButtonsListener {
		void onButtonClicked(String msg);
	}
	
	private PanelButtonsListener listener;
	
	private JButton bttOk;
	private JButton bttAnnuler;
	
	//Pour bouton annuler//
	private ButtonListener buttonListener = new ButtonListener();
		
	//Pour info : création (et affectation) d'un object anonyme implémentant l'interface ActionListener
	/*
	private ActionListener myActionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	*/
	
	public PanelButtons(PanelButtonsListener listener) {
		this.listener = listener;
		
		BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
		setLayout(layout);
		
		setBackground(Color.PINK);
		
		add(getBttOk());
		add(getBttAnnuler());
	}

	public JButton getBttOk() {
		if(bttOk == null) {
			bttOk = new JButton("Ok");
			//Listener (classe anonyme)
			bttOk.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Ok");
					listener.onButtonClicked("Clic !!!");
				}
			});			
		}
		return bttOk;
	}

	public JButton getBttAnnuler() {
		if(bttAnnuler == null) {
			bttAnnuler = new JButton("Annuler");
			//Listener (classe interne)
			bttAnnuler.addActionListener(buttonListener);
		}
		return bttAnnuler;
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {			
			System.out.println("Clic Interne de " + e.getSource());
			if(e.getSource() == getBttOk()) {
				System.out.println("OK !!!");
			}
		}
		
	}

}

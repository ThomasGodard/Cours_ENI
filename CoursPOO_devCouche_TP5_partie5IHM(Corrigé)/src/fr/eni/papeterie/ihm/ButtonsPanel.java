package fr.eni.papeterie.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsPanel extends JPanel {

	public interface ButtonsPanelListener {
		void onButtonPrevious();
		void onButtonNew();
		void onButtonSave();
		void onButtonDelete();
		void onButtonNext();
	}
	
	private ButtonsPanelListener listener;
	
	private JButton bttPrevious;
	private JButton bttNew;
	private JButton bttSave;
	private JButton bttDelete;
	private JButton bttNext;
	
	public ButtonsPanel(ButtonsPanelListener listener) {
		this.listener = listener;
	
		add(getBttPrevious());
		add(getBttNew());
		add(getBttSave());
		add(getBttDelete());
		add(getBttNext());
	}

	private JButton getBttPrevious() {
		if(bttPrevious == null) {
			bttPrevious = new JButton(new ImageIcon(getClass().getResource("resources/Back24.gif")));
			bttPrevious.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.onButtonPrevious();
				}
			});
		}
		return bttPrevious;
	}
	private JButton getBttNew() {
		if(bttNew == null) {
			bttNew = new JButton(new ImageIcon(getClass().getResource("resources/New24.gif")));
			bttNew.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.onButtonNew();
				}
			});
		}
		return bttNew;
	}
	private JButton getBttSave() {
		if(bttSave == null) {
			bttSave = new JButton(new ImageIcon(getClass().getResource("resources/Save24.gif")));
			bttSave.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.onButtonSave();
				}
			});
		}
		return bttSave;
	}
	private JButton getBttDelete() {
		if(bttDelete == null) {
			bttDelete = new JButton(new ImageIcon(getClass().getResource("resources/Delete24.gif")));
			bttDelete.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.onButtonDelete();
				}
			});
		}
		return bttDelete;
	}
	private JButton getBttNext() {
		if(bttNext == null) {
			bttNext = new JButton(new ImageIcon(getClass().getResource("resources/Forward24.gif")));
			bttNext.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.onButtonNext();
				}
			});
		}
		return bttNext;
	}
}

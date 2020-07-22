package javachat2;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class ShowCard {

	public static void show(JPanel cards, String cardName) {
		CardLayout cl = (CardLayout) cards.getLayout();
		cl.show(cards, cardName);
	}
	
}

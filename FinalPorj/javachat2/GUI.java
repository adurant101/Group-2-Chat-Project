package javachat2;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GUI extends javax.swing.JFrame implements IntMessage {
	
	private Client client = null;
    private LoginPanel loginPanel;
    private JPanel cards;
    
	public GUI() {
        this.client = new Client(this);
        cards = new JPanel(new CardLayout());
        this.loginPanel = new LoginPanel(client, cards);
        cards.add(loginPanel, LoginPanel.class.getName());
        
        ChatPanel chatPanel = new ChatPanel(client, this.loginPanel);
        cards.add(chatPanel, ChatPanel.class.getName());
        
        Container pane = this.getContentPane();
        pane.add(cards);
        ShowCard.show(cards, LoginPanel.class.getName());
	}

	@Override
	public void setServerMessage(String m) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String args[]) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUI f = new GUI();
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				f.setLocationByPlatform(true);
				f.pack();
				f.setMinimumSize(f.getSize());
				f.setVisible(true);
            }
        });
	}

}

package javachat2;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class LoginPanel extends JPanel {

	private Client client;
	private JTextField userNameTextField;
	private JTextField hostnameTextField;
	private JTextField passwordTextField;
    private JLabel hostnameLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton btnConnect;
    private JPanel cards;
    
    public LoginPanel(Client client, JPanel cards) {
    	this.client = client;
    	this.cards = cards;
//    	this.setLayout(new SpringLayout());
    	initComponents();
    }
    
    public String getUsername() {
    	return this.userNameTextField.getText();
    }
    
    private void initComponents() {
    	hostnameLabel = new JLabel("Host:", JLabel.TRAILING);
    	add(hostnameLabel);
    	hostnameTextField = new JTextField(10);
    	hostnameLabel.setLabelFor(hostnameTextField);
    	add(hostnameTextField);
    	
        usernameLabel = new JLabel("User:", JLabel.TRAILING);
        add(usernameLabel);
        userNameTextField = new JTextField(10);
        usernameLabel.setLabelFor(userNameTextField);
        add(userNameTextField);
        
        passwordLabel = new JLabel("Password:", JLabel.TRAILING);
        add(passwordLabel);
        passwordTextField = new JTextField(10);
        passwordLabel.setLabelFor(passwordTextField);
        add(passwordTextField);
        
        btnConnect = new JButton();
        btnConnect.setText("Connect");
        btnConnect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdConnect(evt);
            }
        });
        add(btnConnect);
        
      //Lay out the panel.
//        SpringUtilities.makeCompactGrid(this,
//                4, 2, //rows, cols
//                6, 6,        //initX, initY
//                6, 6);   
    }
    
    private void cmdConnect(java.awt.event.MouseEvent evt) {                            
        // TODO add your handling code here:
        //client = new Client();
        try {
			client.connect(userNameTextField.getText(), passwordTextField.getText(), hostnameTextField.getText());
			client.start();
			ShowCard.show(cards, ChatPanel.class.getName());
		} catch (IOException e) {
			System.out.println("Error connecting to server");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
    } 
    
}

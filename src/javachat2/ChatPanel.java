package javachat2;

import javax.swing.JPanel;

public class ChatPanel extends JPanel {
	
	private Client client;
	private javax.swing.JButton btnFetch;
    private javax.swing.JButton btnSend;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField message;
    private javax.swing.JTextArea textMessages;
    private LoginPanel loginPanel;
    private StringBuilder messages = new StringBuilder("");
	
	public ChatPanel(Client client, LoginPanel loginPanel) {
		this.client = client;
		this.loginPanel = loginPanel;
		initComponents();
	}
	
	private void initComponents() {
		message = new javax.swing.JTextField(10);
        btnSend = new javax.swing.JButton("Send");
        btnFetch = new javax.swing.JButton("Fetch");
        textMessages = new javax.swing.JTextArea();
        textMessages.setColumns(25);
        textMessages.setRows(5);
        
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setViewportView(textMessages);
        
        btnSend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chatSend(evt);
            }
        });

        btnFetch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkMessages(evt);
            }
        });
        
        add(jScrollPane1);
        add(message);
        add(btnSend);
        add(btnFetch);
	}
	
	private void chatSend(java.awt.event.MouseEvent evt) {   
        String msg = message.getText();
        setServerMessage(this.loginPanel.getUsername() + ": " + msg);
        String t = client.sendMessage(msg);
        message.setText("");
        //msg += textMessages.getText() + "\n\r" + msg;
       // textMessages.setText(msg);
    }
	
	public void setServerMessage(String msg)
    {
        messages.append(msg);
        String t = textMessages.getText() + "\n" + msg;
        textMessages.setText(t);
    }
	
	private void checkMessages(java.awt.event.MouseEvent evt) {                               
        String msg = client.getMessages();
        String t = textMessages.getText() + "\n" + msg;
        textMessages.setText(t);
        // TODO add your handling code here:
    }  

}

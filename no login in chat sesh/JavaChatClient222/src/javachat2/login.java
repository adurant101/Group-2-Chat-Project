/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachat2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Hashtable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author pyaks
 */
public class login {
    // instance variable
    boolean check = false;
    
    public Hashtable<String, String> login(JFrame frame) {
    Hashtable<String, String> logininformation = new Hashtable<String, String>();

    JPanel panel = new JPanel(new BorderLayout(5, 5));

    JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
    label.add(new JLabel("Host", SwingConstants.RIGHT));
    label.add(new JLabel("User Name", SwingConstants.RIGHT));
    label.add(new JLabel("Password", SwingConstants.RIGHT));
    panel.add(label, BorderLayout.WEST);

    JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
    JTextField host = new JTextField();
    controls.add(host);
    JTextField username = new JTextField();
    controls.add(username);
    JPasswordField password = new JPasswordField();
    controls.add(password);
    panel.add(controls, BorderLayout.CENTER);

    JOptionPane.showMessageDialog(frame, panel, "login", JOptionPane.OK_CANCEL_OPTION);
//    JOptionPane.showConfirmDialog(
//            frame, panel, "login", JOptionPane.OK_CANCEL_OPTION);
    
  // logininformation.put("user", username.getText());
  // logininformation.put("pass", new String(password.getPassword()));
//
      
      logininformation.put("bob", "123");
       logininformation.put("abc", "123");
       logininformation.put("jeff", "123");
       logininformation.put("andre", "123");
       
       if (("localhost".equals(host.getText())) & (logininformation.containsKey(username.getText())) & (logininformation.containsValue(new String(password.getPassword())))){
           //System.out.println(logininformation);
           check = true;
       } 
       
       /// boolean blnExists = logininformation.contains(new String(password.getPassword()).contains(username.getText()));
        

        System.out.println(check);

    
    return logininformation;
}
    
}

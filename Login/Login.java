package Login;

import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener{

    HashMap<String, String> loginInfo  = new HashMap<String, String>();

    JFrame myFrame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton reseButton = new JButton("Reset");
    JTextField idField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel userIDJLabel = new JLabel("User ID");
    JLabel passwordLabel = new JLabel("Password");
    JLabel messageLabel = new JLabel();
    
    public Login(HashMap<String, String> loginInf){

        loginInfo = loginInf;

        userIDJLabel.setBounds(25,25,75,25);
        passwordLabel.setBounds(25,75,75,25);  

        messageLabel.setBounds(120,150,250,35);
        messageLabel.setForeground(Color.BLACK);
        messageLabel.setFont(new Font(null, Font.BOLD, 15));

        idField.setBounds(100,25,200,25);
        passwordField.setBounds(100,75,200,25);

        loginButton.setBounds(80,125,100,25);
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);

        reseButton.setBounds(180,125,100,25);
        reseButton.addActionListener(this);
        reseButton.setFocusable(false);


        myFrame.add(idField);
        myFrame.add(passwordField);
        myFrame.add(messageLabel);
        myFrame.add(userIDJLabel);
        myFrame.add(passwordLabel);
        myFrame.add(loginButton);
        myFrame.add(reseButton);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(350,250);
        myFrame.setLayout(null);
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
  
        if (e.getSource()==reseButton) {
            idField.setText("");
            passwordField.setText("");
        }

        if(e.getSource()==loginButton) {

            String id = idField.getText();
            String password = String.valueOf(passwordField.getPassword());
            if (loginInfo.containsKey(id)&&loginInfo.containsValue(password)) {

                
                messageLabel.setText("Login Successful");
                myFrame.getContentPane().setBackground(Color.GREEN);
                 new Welcome();
                 myFrame.dispose();
                 
                
            }else{
                messageLabel.setText("Login Failed");
                messageLabel.setForeground(Color.RED);

            }
        }
    }

}

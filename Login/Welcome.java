package Login;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Welcome extends JFrame {
    JLabel mJLabel;
    public Welcome(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500,500,500,500);
        this.getContentPane().setBackground(new Color(100,100,0));
        this.setTitle("Welcome");
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        mJLabel = new JLabel();
        mJLabel.setText("Welcome");
        mJLabel.setBounds(150,150,200,50);
        mJLabel.setForeground(Color.GREEN);
        mJLabel.setFont(new Font(null, Font.BOLD, 20));

        this.add(mJLabel);
        this.setVisible(true);
    }
}

package PongGame.PongGame;


import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {

    GamePanel gamePanel;

    GameFrame() {

        gamePanel = new GamePanel();
        this.add(gamePanel);
        this.setTitle("PONG GAME");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        
    }
    
}

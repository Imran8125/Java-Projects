package PongGame.PongGame;

import java.awt.*;




public class Score extends Rectangle{

    static int GAME_HEIGHT;
    static int GAME_WIDTH;
    int player1;
    int player2;

    Score(int GAME_WIDTH, int GAME_HEIGHT) {
        Score.GAME_HEIGHT = GAME_HEIGHT;
        Score.GAME_WIDTH = GAME_WIDTH;
        
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Consolas",Font.BOLD,50));
        g.drawString(Integer.toString(player1), GAME_WIDTH/2 - 100, 50);
        g.drawString(Integer.toString(player2), GAME_WIDTH/2 + 100, 50);
        g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);
        
    }
    
}

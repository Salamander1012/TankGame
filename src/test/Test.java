package test;
import java.awt.*;
import javax.swing.*;

public class Test {

    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tank Wars");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel primary = new JPanel();
        
        primary.setBackground(Color.GRAY);
        primary.setPreferredSize(new Dimension(1010, 700));
        
       
        Player player1 = new Player(1, new Projectile(1), "Player 1");
        Player player2 = new Player(2, new Projectile(2), "Player 2");
        
        Display d = new Display(player1, player2);
        Controls c = new Controls(d, player1, player2);
        
        primary.add(d);
        primary.add(c);
        
        frame.getContentPane().add(primary);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
}

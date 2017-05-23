package test;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Display extends JPanel {
    
    Player player1;
    Player player2;
    Terrain terrain = new Terrain();
    
    
    
    public Display(Player p1, Player p2) {
        setBackground(Color.white);
        setBackground(Color.getColor("light blue"));
        setPreferredSize(new Dimension(1000, 520));
        this.player1 = p1;
        this.player2 = p2;
    }
    
    @Override
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        
        page.setColor(Color.green);
        terrain.drawTerrain(page);
        
        
        page.setColor(Color.black);
        player1.getProjectile().drawProjectile(page);
        player2.getProjectile().drawProjectile(page);
        
        
        page.setColor(Color.BLUE);
        player1.drawTank(page);
        page.setColor(Color.red);
        player2.drawTank(page);
    }
    
    
   
    
}

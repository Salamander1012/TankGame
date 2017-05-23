
package test;
import java.awt.*;
import javax.swing.JOptionPane;
public class Player {
    private int number;
    private String name;
    private Projectile p;
    private int x;
    private int y;
    private int health = 100;

    
    
    public Player(int number, Projectile p, String name) {
        this.number = number;
        this.p = p;
        if(this.number ==2) {
            x = 870;
        } else {
            x = 50;
        }
        y = 499;
        this.name = name;
        reset();
   
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
            
    public void drawTank(Graphics page) {
        page.fillRect(x, y,  80, 30);
        page.fillRect(x+10, y-15, 60, 15);
        double xf = 50.0*Math.cos(p.getAngle());
        double yf = 50.0*Math.sin(p.getAngle());
        if (number==2) {
            page.drawLine(x+40, y-15, x + 40 - (int)xf, y-15-(int)yf);
        } else {
            page.drawLine(x+40, y-15, x+ 40 + (int)xf, y-15-(int)yf);
        }
        
        
        if (number==2) {
            page.drawString("Power: " + p.getV()+" ", 880, 50);
            page.drawString("angle: " + (int)Math.toDegrees(p.getAngle())+" degrees", 880, 70);
            page.drawString("health: " + getHealth() +" ", 880, 90);
        } else {
            page.drawString("Power: " + p.getV()+" ", 30, 50);
            page.drawString("angle: " + (int)Math.toDegrees(p.getAngle())+" degrees", 30, 70);
            page.drawString("health: " + getHealth() +" ", 30, 90);
        }
    }
    
    public void hit(Player otherPlayer, Display d) {
        if (p.getX() <= otherPlayer.getX()+80 && p.getX() >= otherPlayer.getX()) {
            otherPlayer.setHealth(otherPlayer.getHealth()-20);
            d.repaint();
        }
        if(otherPlayer.getHealth()<=0) {
            msgbox(otherPlayer.getName()+" has been killed!");
            otherPlayer.setHealth(100);
            setHealth(100);
            //reset();
        }
        
    }
    
    private void msgbox(String s){
        JOptionPane.showMessageDialog(null, s);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public void reset() {
        p.setX(x+30);
        p.setY(y-25);
        p.resetVelocity();
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int getPlayerNum() {
        return number;
    }
    
    public Projectile getProjectile() {
        return p;
    }
    
    
    
}

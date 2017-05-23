
package test;
import java.awt.*;

public class Projectile {
    
    private int playerNum;
    
    private double x = 0;
    private double y = 499;
    private double v = 11;
    private double angle = (Math.PI)/4;//angle must be in radians
    private double vx = v*Math.cos(angle);
    private double vy = -v*Math.cos(angle);
    private double ay = -0.25;
    private double ax = 0;

    public void drawProjectile(Graphics page) {
        page.fillOval((int)getX(), (int)getY(), 10, 10);
        
        
    }
    
    public double getV() {
        return v;
    }

    public void setV(double v) {
        this.v = v;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
    
    public void move() {
        incrementX();
        incrementY();
    }
    
    public void resetVelocity() {
        if (playerNum ==2) {
            vx = -v*Math.cos(angle);
        } else {
            vx = v*Math.cos(angle);
        }
        vy = -v*Math.sin(angle);
    }
    
    
    
    public void incrementX() {
        x = x+vx;
        vx = vx + ax;
    }
    public void incrementY() {
        y = y+vy;
        vy = vy - ay;
    }
    
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    
    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public double getAy() {
        return ay;
    }

    public void setAy(double ay) {
        this.ay = ay;
    }

    public double getAx() {
        return ax;
    }

    public void setAx(double ax) {
        this.ax = ax;
    }
    
    
    public Projectile(int playerNum){
     
        this.playerNum = playerNum; 
        if (this.playerNum ==2) {
            setX(980);
            setVx(-getVx());
        }
    }
    
    
}

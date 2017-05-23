
package test;
import java.awt.*;

public class hill {
    
    private final int GROUND = 520;
    private int diameter;
    private int radius;

    
    public hill(int diameter) {
        this.diameter = diameter;
        this.radius = diameter/2;
    }
    
    public void drawHill(int x, Graphics page) {
        page.fillOval(x, GROUND-radius, diameter, diameter);
    }
    
    
    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
}

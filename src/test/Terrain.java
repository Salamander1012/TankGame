
package test;

import java.awt.*;

public class Terrain {
    
    private final int l = 6;
    private int startPos = 200;
    hill h1 = new hill(200);
    hill h2 = new hill(100);
    hill h3 = new hill(347);
    
    public Terrain() {
        
    }
    
    public void drawTerrain(Graphics page) {
        h1.drawHill(startPos, page);
        h2.drawHill(startPos + h1.getDiameter(), page);
        h3.drawHill(startPos + h1.getDiameter()+ h2.getDiameter(), page);
    }
}

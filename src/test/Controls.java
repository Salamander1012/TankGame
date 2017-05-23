
package test;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Controls extends JPanel {

    public Controls(Display d, Player p1, Player p2) {
        setBackground(Color.white);
        setPreferredSize(new Dimension(1000, 200));
        
        ControlPanel right = new ControlPanel(d, p1, p2);
        ControlPanel left = new ControlPanel(d, p2, p1);
        
        add(right);
        add(left);
    }
}

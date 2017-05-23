package test;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.*;
import javax.swing.Timer;


public class ControlPanel extends JPanel {
    private JButton fire;
    private JSlider power;
    private JLabel powerLabel;
    private JSlider angle;
    private JLabel angleLabel;
    private JButton left;
    private JButton right;
    Display d;
    Player p;
    Player player2;
    
    public ControlPanel(Display j, Player p, Player player2) {
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        fire = new JButton("Fire");
        fire.setPreferredSize(new Dimension(450, 50));
        
        powerLabel = new JLabel("Power");
        power = new JSlider(5, 18, 11);
        power.addChangeListener(new powerListener());
        power.setMajorTickSpacing(2);
        power.setPaintTicks(true);
        
        angleLabel = new JLabel("Angle");
        angle = new JSlider(0, 180, 45);
        angle.addChangeListener(new angleListener());
        angle.setMajorTickSpacing(10);
        angle.setPaintTicks(true);
        
        left = new JButton("Left");
        left.setPreferredSize(new Dimension(100, 50));
        left.addActionListener(new moveTankLeft());
        
        right = new JButton("Right");
        right.setPreferredSize(new Dimension(100, 50));
        right.addActionListener(new moveTankRight());
        
        d = j;
        this.p = p;
        
        this.player2 = player2;
        
        if(this.p.getPlayerNum()==1) {
            FireP1 l = new FireP1();
            fire.addActionListener(l);
        } else {
            FireP2 l = new FireP2();
            fire.addActionListener(l);
            //this.p.getProjectile().setVix(this.p.getProjectile().getVix()*-1);
        }
        
  
        setPreferredSize(new Dimension(492, 170));
        setBackground(Color.LIGHT_GRAY);
        add(fire);
        add(powerLabel);
        add(power);
        add(angleLabel);
        add(angle);
        add(left);
        add(right);
        
    }
    
                 /*BUTTON CONTROL*/
    //left button
    private class FireP1 implements ActionListener {
        
        Timer timer = new Timer(10,this);
        
        public void actionPerformed(ActionEvent e) {
            //starts a timer that refreshes this function ever 20 miliseconds until you stop it
            
            timer.start();
            if(p.getProjectile().getY()<=500) {
                p.getProjectile().move();
                d.repaint();
            } else {
                p.hit(player2, d);
                p.reset(); 
                d.repaint();
                timer.stop();
            }
            
                
        }
            
    }
    
    //right button
    private class FireP2 implements ActionListener {
 
        Timer timer = new Timer(10,this);
        public void actionPerformed(ActionEvent e) {
            
            timer.start();
            if(p.getProjectile().getY()<=500) {
                p.getProjectile().move();
                d.repaint();
            } else {
                p.hit(player2, d);
                p.reset();
                d.repaint();
                timer.stop();
            }
                
        }
            
    }
    /////tank movement
    
    private class moveTankRight implements ActionListener {
        
        Timer timer = new Timer(10,this);
        Integer posCount = new Integer(0);
        public void actionPerformed(ActionEvent e) {
            timer.start();
            if(posCount<40) {
                p.setX(p.getX()+2);
                posCount+=2;
                p.reset();
                d.repaint();
            } else {
                
                p.reset();
                d.repaint();
                posCount = 0;
                timer.stop();
            }
          
        }
            
    }
    
    private class moveTankLeft implements ActionListener {
 
        Timer timer = new Timer(10,this);
        Integer posCount = new Integer(40);
        public void actionPerformed(ActionEvent e) {
            timer.start();
            if(posCount>0) {
                p.setX(p.getX()-2);
                posCount-=2;
                p.reset();
                d.repaint();
            } else {
                
                p.reset();
                d.repaint();
                posCount = 40;
                timer.stop();
            }
          
        }
            
    }
    
    private class powerListener implements ChangeListener {
        
        
        public void stateChanged(ChangeEvent e) {
          p.getProjectile().setV(power.getValue());
          p.reset();
          d.repaint();
          
        }
    }
    
    private class angleListener implements ChangeListener {
        
        
        public void stateChanged(ChangeEvent e) {
          p.getProjectile().setAngle(Math.toRadians(angle.getValue()));
          p.reset();
          d.repaint();
          
        }
    }
    
}
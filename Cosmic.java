import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Cosmic extends JPanel implements KeyListener{
 

    private Image RocketImage;
    private Image MountainImage;
    
    private int veloX;
    private int veloY;
    private int rocketX = (900/2)-(20);
    private int rocketY = (900/2)-(20);
    private int rocketFacing;
    private int possibleMovesX;
    private int possibleMovesY;
  
    
   //(1920/2)+(360/2);

    
    private int myWindowWidth = 900;
    private int myWindowHeight = 900;

    
    public Cosmic(){
        
        loadImages();
        Frame easel = new JFrame();      
        easel.setSize (myWindowWidth, myWindowHeight);
        easel.add (this);
       
        easel.setVisible (true);

        easel.addKeyListener(this);
       
        
       
        setVisible(true);
        
        for(int i=0; i<=5000; i++){
            
            
            
        }

       

}
public void keyTyped(KeyEvent e) {}


public void keyPressed(KeyEvent e) {

    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        System.out.println("Right key pressed");
        if(possibleMovesX>0){
            rocketX+=7;
            possibleMovesX--;
        }
        veloX++;
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        System.out.println("Left key pressed");
        if(possibleMovesX>0){
            rocketX-=7;
            possibleMovesX--;
        }
        veloX--;

    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        System.out.println("DOWN key pressed");
        if(possibleMovesY>0){
            rocketY+=7;
            possibleMovesY--;
        }
    }
    if (e.getKeyCode() == KeyEvent.VK_UP) {
        System.out.println("DOWN key pressed");
        if(possibleMovesY>0){
            rocketY-=7;
            possibleMovesY--;
        }
    }
    repaint();

}
private void delay(int ms) {
    try {
       Thread.sleep(ms);
    } catch (Exception ex) {
       ex.printStackTrace();
    }
 }

public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        System.out.println("Right key Released");
        rocketX+=7;
        possibleMovesX++;
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        System.out.println("Left key Released");
        
        rocketX-=7;
        possibleMovesX++;
    

    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        System.out.println("DOWN key pressed");
        
            rocketY+=7;
            possibleMovesY++;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP) {
        System.out.println("DOWN key pressed");
        
            rocketY-=7;
            possibleMovesY++;
    }
    repaint();
}

public void paintComponent (Graphics g) {
       super.paintComponent(g);
       g.setColor(Color.black);
       g.fillRect(0, 0, 10000, 10000);
        
        g.drawImage (RocketImage, rocketX, rocketY, 50, 50, this);
        
    }
        

private void loadImages(){
        String curDir = System.getProperty("user.dir");
        System.out.println(curDir);
        RocketImage = new ImageIcon(curDir + "/images/Rocket.png","").getImage ( );
        MountainImage = new ImageIcon(curDir + "/images/Box.png","").getImage ( );
        
    }

    
     





public static void main(String[] args) {
   new Cosmic();
}

}

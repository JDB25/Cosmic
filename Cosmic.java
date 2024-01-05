import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
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
    private boolean gameRunning = true;

  
    
   //(1920/2)+(360/2);

    
    private int myWindowWidth = 900;
    private int myWindowHeight = 900;
    ArrayList<Bot> bots = new ArrayList<Bot>();
    private Random randGen = new Random();

    
public Cosmic(){
        
        loadImages();
        Frame easel = new JFrame();      
        easel.setSize (myWindowWidth, myWindowHeight);
        easel.add (this);
       
        easel.setVisible (true);

        easel.addKeyListener(this);
        setVisible(true);
       runGame(); 

}
public void keyTyped(KeyEvent e) {}
public void keyPressed(KeyEvent e) {

    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        
        if(possibleMovesX<100){
            rocketX+=7;
            possibleMovesX--;
        }
        veloX++;
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
       
        if(possibleMovesX<100){
            rocketX-=7;
            possibleMovesX--;
        }
        veloX--;

    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
       
        if(possibleMovesY<100){
            rocketY+=7;
            possibleMovesY--;
        }
    }
    if (e.getKeyCode() == KeyEvent.VK_UP) {
      
        if(possibleMovesY<100){
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
       
        rocketX+=7;
        possibleMovesX++;
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      
        
        rocketX-=7;
        possibleMovesX++;
    

    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      
        
            rocketY+=7;
            possibleMovesY++;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP) {
        
        
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
        drawBots(g);
    }        
private void loadImages(){
        String curDir = System.getProperty("user.dir");
        System.out.println(curDir);
        RocketImage = new ImageIcon(curDir + "/images/Rocket.png","").getImage ( );
        MountainImage = new ImageIcon(curDir + "/images/Box.png","").getImage ( );
        
    }
private void runGame(){
    Startprogress();

}
private int rando(){
    int i = randGen.nextInt(900);
    return i;
}
private void Startprogress(){
    
    while(gameRunning==true){
        int x = randGen.nextInt(900);
        int y = randGen.nextInt(900);
        System.out.println(x);
        System.out.println(y);

        bots.add(new Bot(x, y));
        System.out.println("AHHHHHHHH");
         repaint();
        delay(60);
       


       

    }

}
private void drawBots(Graphics g){
    for(int x = 0; x<bots.size(); x++){
        this.drawBot(bots.get(x), g);

     } 
}
private void drawBot(Bot bot, Graphics g){
    int BotX = bot.getX();
    int BotY = bot.getY();
    g.setColor(Color.white);
    g.fillOval(BotX, BotY, 20, 20);
    g.setColor(Color.red);
    g.drawOval(BotX, BotY, 20, 20);

}
    
     
public static void main(String[] args) {
   new Cosmic();
}

}

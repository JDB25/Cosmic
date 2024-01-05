import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.KeyEvent;

public class Cosmic extends JPanel implements KeyListener{
 

    private Image RocketImage;
    private Image EndImage;
    
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
        
        if(gameRunning){
            rocketX+=7;
            possibleMovesX--;
        }
        veloX++;
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
       
        if(gameRunning){
            rocketX-=7;
            possibleMovesX--;
        }
        veloX--;

    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
       
        if(gameRunning)
            rocketY+=7;
            possibleMovesY--;
       
    }
    if (e.getKeyCode() == KeyEvent.VK_UP) {
      
        if(gameRunning)
            rocketY-=7;
            possibleMovesY--;
        
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
       if(gameRunning)
        rocketX+=7;
        possibleMovesX++;
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      
    if(gameRunning)
        rocketX-=7;
        possibleMovesX++;
    

    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      
        if(gameRunning)
            rocketY+=7;
            possibleMovesY++;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP) {
        
        if(gameRunning)
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
        if(gameRunning==false){
            g.drawImage(EndImage, 40, 0, 800, 800, this);

        }
    }        
private void loadImages(){
        String curDir = System.getProperty("user.dir");
        System.out.println(curDir);
        RocketImage = new ImageIcon(curDir + "/images/Rocket.png","").getImage ( );
        EndImage = new ImageIcon(curDir + "/images/End.png","").getImage ( );
        
    }
private void runGame(){
    while(gameRunning==true){
    for(int d=0; d<10000; d++){
          if(gameRunning){  
            int x = rando();
            int y = rando();
            bots.add(new Bot(x, y));   
            repaint();
            delay(10);}
        
        for(int f=0; f<100; f++){
        if(gameRunning){
            delay(10);
            moveBots();}
        
        }
    }}

        
       


}
private int rando(){
    int i = randGen.nextInt(800);
    return i;
}



private void moveBots(){
    System.out.println("NOOOOO");
  
       for(int x = 0; x<bots.size(); x++){
        this.moveBot(bots.get(x));

     } 
     
    
}
private void moveBot(Bot bot){
    if(bot.getX()<rocketX&&bot.getY()<rocketY){
        bot.move(bot.getX()+1,bot.getY()+1);
        System.out.println("uga");
    }
    if(bot.getX()>rocketX&&bot.getY()<rocketY){
        bot.move(bot.getX()-1,bot.getY()+1);
        System.out.println("uga");
    }
    if(bot.getX()<rocketX&&bot.getY()>rocketY){
        bot.move(bot.getX()+1,bot.getY()-1);
        System.out.println("uga");
    }
    if(bot.getX()>rocketX&&bot.getY()>rocketY){
        bot.move(bot.getX()-1,bot.getY()-1);
        System.out.println("uga");
    }
    if(bot.getX()==rocketX&&bot.getY()==rocketY){
        gameRunning=false;
    }
    if(bot.getX()==rocketX&&bot.getY()>rocketY){
        bot.move(bot.getX(),bot.getY()-1);
        System.out.println("uga");
    }
    if(bot.getX()==rocketX&&bot.getY()<rocketY){
        bot.move(bot.getX(),bot.getY()+1);
        System.out.println("uga");
    }
    if(bot.getX()>rocketX&&bot.getY()==rocketY){
        bot.move(bot.getX()-1,bot.getY());
        System.out.println("uga");
    }
    if(bot.getX()<rocketX&&bot.getY()==rocketY){
        bot.move(bot.getX()+1,bot.getY()-1);
        System.out.println("uga");
    }

    repaint();

}
private void drawBots(Graphics g){
    for(int x = 0; x<bots.size(); x++){
        this.drawBot(bots.get(x), g);

     } 
}
private void drawBot(Bot bot, Graphics g){
    int BotX1 = bot.getX();
    int BotY1 = bot.getY();
    g.setColor(Color.white);
    g.fillOval(BotX1, BotY1, 20, 20);
    g.setColor(Color.red);
    g.drawOval(BotX1, BotY1, 20, 20);

}
    
     
public static void main(String[] args) {
   new Cosmic();
}

}

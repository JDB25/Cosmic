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
    private int botSpeed=100;
    private int botSpawnRate=100;
    private int gameLvl;

  
    
  

    
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
private void runGame(){

    while(gameRunning==true){
    for(int d=0; d<10000; d++){
          if(gameRunning){  
            int x = rando();
            int y = rando();
            bots.add(new Bot(x, y));
            rocketFloat();   
            repaint();
            delay(botSpawnRate);}
            if(gameRunning){
            gameLvl++;
        System.out.println(gameLvl);}
            if(gameLvl==10){
                botSpawnRate=8;
                botSpeed=8;
            }
            if(gameLvl==15){
                botSpawnRate=60;
                botSpeed=60;
            }
            if(gameLvl==20){
                botSpawnRate=50;
                botSpeed=50;
            }
            if(gameLvl==25){
                botSpawnRate=30;
                botSpeed=30;
            }
            if(gameLvl==30){
                botSpawnRate=20;
                botSpeed=20;
            }
             if(gameLvl==35){
                botSpawnRate=10;
                botSpeed=10;
            }
            
        
        for(int f=0; f<100; f++){
        if(gameRunning){
            delay(botSpeed);
            moveBots();}
        
        }}}}

private void delay(int ms) {
    try {
       Thread.sleep(ms);
    } catch (Exception ex) {
       ex.printStackTrace();
    }
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




private void rocketFloat(){
if (veloX==1);
rocketX++;

}
private void moveBots(){
   
  
       for(int x = 0; x<bots.size(); x++){
        this.moveBot(bots.get(x));

     } 
     
    
}
private void moveBot(Bot bot){
    if(bot.getX()<rocketX&&bot.getY()<rocketY){
        bot.move(bot.getX()+1,bot.getY()+1);
        
    }
    if(bot.getX()>rocketX&&bot.getY()<rocketY){
        bot.move(bot.getX()-1,bot.getY()+1);
       
    }
    if(bot.getX()<rocketX&&bot.getY()>rocketY){
        bot.move(bot.getX()+1,bot.getY()-1);
       
    }
    if(bot.getX()>rocketX&&bot.getY()>rocketY){
        bot.move(bot.getX()-1,bot.getY()-1);
       
    }
    if(bot.getX()==rocketX&&bot.getY()==rocketY){
        gameRunning=false;
    }
    if(bot.getX()==rocketX&&bot.getY()>rocketY){
        bot.move(bot.getX(),bot.getY()-1);
       
    }
    if(bot.getX()==rocketX&&bot.getY()<rocketY){
        bot.move(bot.getX(),bot.getY()+1);
       
    }
    if(bot.getX()>rocketX&&bot.getY()==rocketY){
        bot.move(bot.getX()-1,bot.getY());
       
    }
    if(bot.getX()<rocketX&&bot.getY()==rocketY){
        bot.move(bot.getX()+1,bot.getY()-1);
       
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



public void keyTyped(KeyEvent e) {}
public void keyPressed(KeyEvent e) {

    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        
        if(gameRunning){
            veloX++;
           
        }
        veloX++;
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
       
        if(gameRunning){
            rocketX-=7;
           
        }
        veloX--;

    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
       
        if(gameRunning)
            rocketY+=7;
           
       
    }
    if (e.getKeyCode() == KeyEvent.VK_UP) {
      
        if(gameRunning)
            rocketY-=7;
           
        
    }
    repaint();

}    
public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
       if(gameRunning)
        rocketX+=7;
        
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      
    if(gameRunning)
        rocketX-=7;
       
    

    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      
        if(gameRunning)
            rocketY+=7;
            
    }
    if (e.getKeyCode() == KeyEvent.VK_UP) {
        
        if(gameRunning)
            rocketY-=7;
          
    }
    repaint();
}     

private int rando(){
    int i = randGen.nextInt(800);
    return i;
}



public static void main(String[] args) {
   new Cosmic();
}

}

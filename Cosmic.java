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
    
    private int veloX=0;
    private int veloY=0;
    private int rocketX = (900/2)-(20);
    private int rocketY = (900/2)-(20);
    private boolean gameRunning = true;
    private int botSpeed=10;
    private int botSpawnRate=10;
    private int gameLvl=0;
    private int findingMid=13;
    private int offset = 1;
    private int difficulty = 1;

  
    
  

    
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
        delay(500);
        System.out.println(difficulty);
       runGame(difficulty);
       


}
private void runGame(int difficulty){

    while(gameRunning==true){
    for(int d=0; d<10000; d++){
          if(gameRunning){  
            int x = rando();
            int y = rando();
            bots.add(new Bot(x, y));
            if(gameRunning){
            rocketFloat(); } 
            repaint();
            delay(botSpawnRate);}
            
            if(gameRunning){
            gameLvl++;
        //System.out.println(gameLvl);
    }
            if(gameLvl==10){
                botSpawnRate=8;
                botSpeed=8;
            }
            if(gameLvl==15){
                botSpawnRate=6;
                botSpeed=6;
            }
            if(gameLvl==20){
                botSpawnRate=5;
                botSpeed=5;
            }
            if(gameLvl==25){
                botSpawnRate=3;
                botSpeed=3;
            }
            if(gameLvl==30){
                botSpawnRate=2;
                botSpeed=2;
            }
             if(gameLvl==35){
                botSpawnRate=1;
                botSpeed=1;
            }
            
        
        for(int f=0; f<100; f++){
        if(gameRunning){
            delay(botSpeed*difficulty);
            moveBots();}
            if(gameRunning){rocketFloat();}
        
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
if (veloX==1&&rocketX+72<900){
    rocketX++;
}
if (veloX==-1&&rocketX-2>0){
    rocketX--;
}
if (veloX==2&&rocketX+72<900){
    rocketX+=2;
}
if (veloX==-2&&rocketX-2>0){
    rocketX-=2;
}


if(veloY==1&&rocketY+82<900){
    rocketY++;
}
if(veloY==-1&&rocketY-2>0){
    rocketY--;
}

if(veloY==2&&rocketY+82<900){
    rocketY+=2;
}
if(veloY==-2&&rocketY-2>0){
    rocketY-=2;
}

if(rocketX+72==899||rocketX==1){
    veloX=0;
}
if(rocketY+82==900||rocketY-2==-1){
    veloY=0;
    
}


repaint();





}
private void moveBots(){
   
  
       for(int x = 0; x<bots.size(); x++){
        this.moveBot(bots.get(x));

     } 
     
    
}
private void moveBot(Bot bot){
    if(bot.getX()<rocketX+findingMid+offset&&bot.getY()<rocketY+findingMid){
        bot.move(bot.getX()+1,bot.getY()+1);
        
    }
    if(bot.getX()>rocketX+findingMid+offset&&bot.getY()<rocketY+findingMid){
        bot.move(bot.getX()-1,bot.getY()+1);
       
    }
    if(bot.getX()<rocketX+findingMid+offset&&bot.getY()>rocketY+findingMid){
        bot.move(bot.getX()+1,bot.getY()-1);
       
    }
    if(bot.getX()>rocketX+findingMid+offset&&bot.getY()>rocketY+findingMid){
        bot.move(bot.getX()-1,bot.getY()-1);
       
    }
    if((bot.getX()==rocketX+findingMid+offset&&bot.getY()==rocketY+findingMid)||(bot.getX()==rocketX+findingMid+offset+1&&bot.getY()==rocketY+findingMid)){
        gameRunning=false;
    }
    if(bot.getX()==rocketX+findingMid+offset&&bot.getY()>rocketY+findingMid){
        bot.move(bot.getX(),bot.getY()-1);
       
    }
    if(bot.getX()==rocketX+findingMid+offset&&bot.getY()<rocketY+findingMid){
        bot.move(bot.getX(),bot.getY()+1);
       
    }
    if(bot.getX()>rocketX+findingMid+offset&&bot.getY()==rocketY+findingMid){
        bot.move(bot.getX()-1,bot.getY());
       
    }
    if(bot.getX()<rocketX+findingMid+offset&&bot.getY()==rocketY+findingMid){
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
   if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        
        if(difficulty>1){
            difficulty--;
            System.out.println("diffdown");
           
        }
       
    }
    if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
        
        if(difficulty<5){
            difficulty++;
            System.out.println("diffUP");
           
        }
       
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        
        if(gameRunning&&(veloX<2)){
            veloX++;
           
        }
       
    }

    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        
        if(gameRunning&&(veloX<2)){
            veloX++;
           
        }
       
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
       
        if(gameRunning&&(veloX>-2)){
            veloX--;
           
        }
      

    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
       
        if(gameRunning&&(veloY<2))
            veloY++;
           
       
    }
    if (e.getKeyCode() == KeyEvent.VK_UP) {
      
        if(gameRunning&&(veloY>-2))
            veloY--;;
           
        
    }
    repaint();

}    
public void keyReleased(KeyEvent e) {
    // if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
       
        
    // }
    // if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      
   
       
    

    // }
    // if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      
    // }
    // if (e.getKeyCode() == KeyEvent.VK_UP) {}
        
       
          
    
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

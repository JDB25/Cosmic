import java.awt.*;
public class Bot {
    private int BotX;
    private int BotY;
    public Bot(int BotX, int BotY){
        this.BotX=BotX;
        this.BotY=BotY;
    }
public int getX(){
    return BotX;
}
public int getY(){
    return BotY;
}
public void move(int x, int y){
    BotX=x;
    BotY=y;

}
    
}

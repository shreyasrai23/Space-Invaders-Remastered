package spaceInvaders;
import apcs.Window;

public class Bullet {

    int x = Ship.x;
    int y = Ship.y - 20;
    
    public Bullet(Ship ship)
    {
        x = Ship.x;
        y = Ship.y - 20;
    }
    
    public void draw()
    {
        Window.out.color("red");
        Window.out.circle(x, y, 5);
    }
    
    public void move()
    {
        y = y-10;
    } 
}



package spaceInvaders;
import apcs.Window;

public class Ship {

    static int x = 500;
    static int y = 980;
    
    public void draw()
    {
        Window.out.color("green");
        Window.out.rectangle(x, y, 35, 25);
    }
    
    public void move()
    {
        if(Window.key.pressed("up"))
        {
            y -= 20;
        }
        
        if(Window.key.pressed("down"))
        {
            y += 20;
        }
        
        if(Window.key.pressed("left"))
        {
            x -= 20;
        }
        
        if(Window.key.pressed("right"))
        {
            x += 20;
        }
    }
    
    public boolean isTouching(Invader i)
    {
        int diffx = x - i.x;
        int diffy = y - i.y;
        
        if (Math.abs(diffx) < 40 && Math.abs(diffy) < 40)
        {
            return true;
        }
        
        return false;
    }
}

package spaceInvaders;
import apcs.Window;

public class Invader {

    int x = Window.random(50, 950);
    int y = 0;
    
    public void draw() 
    {
        Window.out.color("grey");
        Window.out.circle(x, y, 35);
    }
    
    public void move()
    {
        y += 2;
    }

    public boolean isTouching(Bullet b)
    {
        int diffx = x - b.x;
        int diffy = y - b.y;
        
        if (Math.abs(diffx) < 30 && Math.abs(diffy) < 30)
        {
            return true;
        }
        
        return false;
    }
    
    public boolean reachedEarth(Planet earth)
    {
        if(y > earth.getY())
        {
            return true;
        }
        return false;
    }
}
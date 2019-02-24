package spaceInvaders;
import apcs.Window;

public class InvaderBullet {

    int x;
    int y;
    
    public InvaderBullet(Invader i)
    {
        this.x = i.x;
        this.y = i.y + 20;
    }
    
    public void draw()
    {
        Window.out.color("orange");
        Window.out.circle(x, y, 5);
    }
    
    public void move()
    {
        y += 10;
    }
    
    public boolean isTouching()
    {
        return false;
    }
}

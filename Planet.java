package spaceInvaders;
import apcs.Window;

public class Planet {

    int x = 500;
    int y = 970;
    
    public void draw()
    {
        Window.out.color("blue");
        Window.out.rectangle(500, 970, 1000, 45);
    }

    public int getY() {
        return y;
    }
}

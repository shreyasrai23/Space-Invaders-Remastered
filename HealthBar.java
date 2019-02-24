package spaceInvaders;
import apcs.Window;

public class HealthBar {

    int width = 130;
    int height = 30;
    
    public void draw()
    {
        Window.out.color("green");
        Window.out.rectangle(870, 85, width, height);
    }
    
    public void decrease()
    {
        width -= 1;
    }
}

package spaceInvaders;
import java.util.Date;

import apcs.Window;
import java.util.ArrayList;


public class SpaceinvadersGame {
    
    
    public static void main(String[]args)
    {
        int invaderStopwatch = 10;
        int bulletStopwatch = 10;
        int invaderBulletSW = 25;
        Window.size(1000, 1000);
        Ship ship = new Ship();
        Planet earth = new Planet();
        HealthBar healthbar = new HealthBar();
        int score = 0;
        int waveCount = 0;
        int waveNum = 1;
        int difficulty = waveNum - 1;
        int health = 160;
        
        ArrayList<Invader> invaders = new ArrayList<Invader>();
        ArrayList<Bullet> bullets = new ArrayList<Bullet>();
        ArrayList<InvaderBullet> inBulls = new ArrayList<InvaderBullet>();
   
        while(true)
        {
            Window.frame();
            Window.out.color("white");
            Window.out.fontSize(50);
            Window.out.print(score, 50, 50);
            Window.out.print("Wave " + waveNum, 800, 50);
            earth.draw();
            Window.out.color("white");
            Window.out.fontSize(35);
            Window.out.print("EARTH", 460, 985);
            healthbar.draw();
            Window.out.color("white");
            Window.out.print("Health", 680, 95);
            Window.out.fontSize(20);
            Window.out.print(health + "/160", 837, 95);
            Window.out.color("green");
            ship.draw();
            ship.move();
            
            
            if(invaderStopwatch == 0)
            {
                Invader inv = new Invader();
                invaders.add(inv);
                waveCount++;
                invaderStopwatch = 10 - difficulty;
            }
            
            if (invaderStopwatch > 0)
            {
                invaderStopwatch--;
            }
            
            
            //Invader Loop
            for(int i = 0; i < invaders.size(); i++)
            {
                Invader bob = invaders.get(i);
                bob.draw();
                bob.move();
                
                if(invaderBulletSW == 0)
                {
                    InvaderBullet ibo = new InvaderBullet(bob);
                    inBulls.add(ibo);
                    invaderBulletSW = 25;
                }
                
                //Decrement the Invader bullet cool down
                if(invaderBulletSW > 0)
                {
                    invaderBulletSW--;
                }
                
                //Invader bullets loop
                for(int k = 0; k < inBulls.size(); k++)
                {
                    InvaderBullet ibo = inBulls.get(k);
                    ibo.draw();
                    ibo.move();
                    if(ibo.y > 1050)
                    {
                        inBulls.remove(k);
                    }
//                    try{
//                        Thread.sleep((int)(Math.random()*5));
//                    }
//                    catch(InterruptedException e){
//                        e.printStackTrace();
//                    }
                }
                //Check if a bullet is hitting an invader
                for(int x = 0; x < bullets.size(); x++)
                {
                    Bullet b = bullets.get(x);
                    if(bob.isTouching(b))
                    {
                        invaders.remove(bob);
                        bullets.remove(x);
                        score++;  
                    }
                }
                
                // Increase the wave number
                if (waveCount == 50)
                {
                    invaderStopwatch = 100;
                    waveNum++;
                    waveCount = 0;
                }
                
                for (int j = 0; j < invaders.size(); j++)
                {
                    if(ship.isTouching(bob))
                    {
                        health -= 0.000001;
                    }
                    
                    if(bob.reachedEarth(earth) || health == 0)
                    {
                        bullets.clear();
                        invaders.clear();
                        ship = null;
                        inBulls.clear();
                        Window.out.fontSize(100);
                        Window.out.color("red");
                        Window.out.print("Earth has been invaded.", 40, 500);
                        Window.out.print("SCORE: " + score, 300, 650);
                    }
                }
            }
            
            // Shoot a bullet if the space bar is pressed
            if (Window.key.pressed("space")) 
            {
                // If the stop watch is not yet started
                if (bulletStopwatch == 0) {
                    Bullet b = new Bullet(ship);
                    bullets.add(b);
                    bulletStopwatch = 10;
                }
            }
            
            
            
            if (bulletStopwatch > 0)
            {
                bulletStopwatch--;
            }
            
            for(int i = 0; i < bullets.size(); i++)
            {
                Bullet b = bullets.get(i);
                b.draw();
                b.move();
                if (b.y < -50) 
                {
                    bullets.remove(i);
                }
            }
        }
    }
}

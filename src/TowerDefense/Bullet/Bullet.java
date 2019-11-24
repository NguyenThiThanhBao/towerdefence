package TowerDefense.Bullet;

import TowerDefense.Begin.Config;
import TowerDefense.Begin.Handler;
import jaco.mp3.player.MP3Player;

import java.awt.*;
import java.awt.image.BufferedImage;

import static TowerDefense.Begin.Game.sound;

public abstract class Bullet {
    private  int x, y;

   private  BufferedImage texture;
   private  double directX;
   private double directY;
   protected Handler handler;
   private int damage;
   private long speed;
   private int mark=0;
   private int mark1=0;
    public Bullet(Handler handler,int x, int y,long speed, int damage,BufferedImage texture,double directX, double directY) {
        this.x = x;
        this.y = y;
        this.texture= texture;
        this.directX= directX;
        this.directY= directY;
        this.damage=damage;
        this.speed=speed;
        this.handler= handler;
      }
    public void render( Graphics g)
    {
        if (mark==0)
        {
            if (sound==true)
            {
                Config.mp3Player= new MP3Player(Config.gun);
                Config.mp3Player.play();
                mark=1;
            }
        }
        else
        {
            if (sound==false){
                Config.mp3Player.pause();
                mark1=1;
            }
            if (sound==true&&mark1==1)
            {
                Config.mp3Player.play();
                mark1=0;// de con chay tiep
            }
        }

        g.drawImage(texture,x,y,10,10,null);
    }

   public void move()
   {
       x-=speed*directX;
       y-=speed*directY;
   }

    public void setX(int xx) {
        this.x = xx;
    }

    public void setY(int yy) {
        this.y = yy;
    }

    public int getDamage() {
        return damage;
    }

    public long getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

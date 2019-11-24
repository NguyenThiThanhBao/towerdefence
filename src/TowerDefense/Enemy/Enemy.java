package TowerDefense.Enemy;

import TowerDefense.Begin.Config;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.logging.Handler;

import static TowerDefense.Art.Map.MAP;
import static TowerDefense.Begin.Game.heath_player;
import static TowerDefense.State.GameState.enemydie;
import TowerDefense.Begin.Config;
import TowerDefense.Image.Assets;

// khoi enemy chay theo  map  cua chinh no
public abstract class Enemy {
    protected Config config= new Config();
    private Handler handler;
    protected long  heath,reward,armor;
    protected double speed;
    protected BufferedImage[] texture;
    protected BufferedImage Bulletproof;

    public void setReward(long reward) {
        this.reward = reward;
    }

    public long getArmor() {
        return armor;
    }

    public void setArmor(long armor) {
        this.armor = armor;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
     private int x=0,y=64;

    public int getX() {
        return this.x;
    }

    public  int getY() {
        return  this.y;
    }

    public long getHeath() {
        return heath;
    }

    public void setHeath(long heath) {
        this.heath = heath;
    }

    public Enemy(Handler handler, long heath, long reward, double speed, long armor , BufferedImage[] texture) {
        this.handler= handler;
        this.heath = heath;
        this.reward= reward;
        this.speed = speed;
        this.armor= armor;
        this.texture = texture;
    }

    public double getSpeed() {
        return speed;
    }

    //thiet lap  duong di cho enemy
      private int loop=0;

    public long getReward() {
        return reward;
    }

    public int getLoop() {
        return loop;
    }

    public void setLoop(int loop) {
        this.loop = loop;
    }

    public  void setX(int x) {
        this.x=x;
    }

    public  void setY(int y) {
        this.y=y;
    }


    private int markk = 1;//di thang
    public void tick()
     {
         if (markk == 1)
         {
             setX((getX()+(int)getSpeed()));
         }
         else if (markk==2)
         {
             setY(getY()+(int)getSpeed());
         }
         else if (markk==3)
         {
             setX(getX()-(int)getSpeed());
         }
         else  setY(getY()-(int)getSpeed());
         setLoop(getLoop()+(int)getSpeed());
         if  (getLoop()==64)
         {
             int xx=getX()/64;
             int yy= getY()/64;

             if (yy==8&&xx==19)
             {
                 heath_player-=10;
                 enemydie++;
             }
             try
             {
                 markk= MAP[yy][xx];
             }
            catch (Exception e)
            {
                markk=1;
            }
             setLoop(0);
         }
     }
    public  void render(Graphics g)
    {
        if (markk==3)g.drawImage(texture[1],getX(),getY(),70,60,null);
        else g.drawImage(texture[0],getX(),getY(),70,60,null);
        if (getArmor()>=0) g.drawImage(Assets.Bulletproof,getX()+35,getY()+40,20,20,null);
    }
}



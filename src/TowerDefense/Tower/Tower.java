package TowerDefense.Tower;

import TowerDefense.Begin.Config;
import TowerDefense.Begin.Handler;
import TowerDefense.Bullet.Bullet;
import TowerDefense.UI.UIManager;
import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Tower {
    private int x, y;
    protected Handler handler;

    private double  range;
    protected Config config= new Config();
    protected BufferedImage texture;
    public ArrayList<Bullet> bullet= new ArrayList<>();
    public Tower(Handler handler,BufferedImage texture,double range, int x, int y) {
        this.handler = handler;
        this.texture= texture;
        this.x=x;
        this.y=y;
        this.range=range;
    }

    public void tick(){

    }
    public Handler getHandler() {
        return handler;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getRange() {
        return range;
    }

    public void render(Graphics g)
   {
       g.drawImage(texture,getX()-50,getY()-50,64,64,null);//-50 chi de ve cho dep
   }
}

package TowerDefense.Begin;

import TowerDefense.Display.Display;
import TowerDefense.Image.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Stack;

import TowerDefense.Input.MouseManager;
import TowerDefense.State.*;
import TowerDefense.Tower.Tower;
import jaco.mp3.player.MP3Player;

import static TowerDefense.State.GameState.*;


public class Game implements Runnable{
    private Display display;
    private int width, height;
    public String title;
    public static   boolean runningg=true;
    private Thread thread;
    private BufferStrategy bs;
    private Graphics g;
    public static State gameState;
    public static State menuState;
    private Handler handler;
    private MouseManager mouseManager;
    public static int heath_player=50;
    public static int gameover=500;
    public static int dem=0;
    public static boolean sound=true;
    public static int[] aa={1,0,0,0};
    public Game(String title,int width, int height) {
        this.width = width;
        this.height = height;
        this.title= title;
        mouseManager= new MouseManager();
        thread= new Thread(this);
        thread.start();
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public  void init() {
        display = new Display(title, width, height);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();
        // tao  ra 1 gamestate quan ly trang thai hien hanh cua game
        handler = new Handler(this);
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        State.setState(menuState);

    }

    public void tick()
     {
           if (State.getState()!=null)
            State.getState().tick();

    }
     public  void render()
     {
         bs= display.getCanvas().getBufferStrategy();
         if (bs==null)
         {
             display.getCanvas().createBufferStrategy(3);
             return;
         }
         g= bs.getDrawGraphics();
          g.clearRect(0,0,width,height);

         if (State.getState()!=null)
             State.getState().render(g);
          /// end drawing
   if (sound==true)
       g.drawImage(Assets.loud[0],10,10,50,50,null);
   else
       g.drawImage(Assets.loud[1],10,10,50,50,null);
         bs.show();
         g.dispose();
     }
     // noi chay chuong trinh
    @Override
    public void run() {
            init();
            int fps= 60;
            double timePerTick= 1000000000/fps;
            double delta=0;
            long now;
            long lastTime=System.nanoTime();
            while (runningg)
            {

                now =System.nanoTime();
                delta+=(now-lastTime)/timePerTick;
                lastTime=now;
                if(delta>=1) {
                    render();
                    tick();
                    delta--;
                }
                if (runningg==false)
                {
                    System.exit(0);
                }
                int mouseX=handler.getMouseManager().getMouseX();
                int mouseY=handler.getMouseManager().getMouseY();
                if (handler.getMouseManager().isRightPressed()==true||handler.getMouseManager().isLeftPressed()==true&&mouseX>=1100&&mouseX<=1100+50&&mouseY>=650&&mouseY<=650+50)
                {

                    if(play==true)
                    {
                        play=false;
                    }
                    else play= true;
                    handler.getMouseManager().setLeftPressed(false);
                    handler.getMouseManager().setLeftPressed(false);
                }
                if (handler.getMouseManager().isRightPressed()==true||handler.getMouseManager().isLeftPressed()==true&&mouseX>=1170&&mouseX<=1170+50&&mouseY>=650&&mouseY<=650+50)
                {
                    next=true;
                    dem=60;
                    handler.getMouseManager().setLeftPressed(false);
                    handler.getMouseManager().setLeftPressed(false);
                }
                if (handler.getMouseManager().isRightPressed()==true||handler.getMouseManager().isLeftPressed()==true&&mouseX>=10&&mouseX<=10+50&&mouseY>=10&&mouseY<=10+50)
                {
                    if(sound==true)
                    {
                        sound=false;

                    }
                    else {
                        sound=true;
                    }
                    handler.getMouseManager().setLeftPressed(false);
                    handler.getMouseManager().setLeftPressed(false);
                }

            }


        }


    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}

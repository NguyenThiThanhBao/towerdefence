package TowerDefense.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import TowerDefense.Begin.Config;
import TowerDefense.Begin.Game;
import TowerDefense.Bullet.Bullet;
import TowerDefense.Bullet.BulletMachineGun;
import TowerDefense.Bullet.BulletNomal;
import TowerDefense.Bullet.BulletSniper;
import TowerDefense.Enemy.EnemyManager.*;

import TowerDefense.Art.Map;
import TowerDefense.Enemy.*;
import TowerDefense.Image.Assets;
import TowerDefense.Image.Assets.*;
import TowerDefense.Tower.NormalTower;
import TowerDefense.Tower.SniperTower;
import TowerDefense.Tower.Tower;
import TowerDefense.Tower.TowerManager;
import TowerDefense.Tower.TowerManager.*;
import TowerDefense.Begin.Handler;
import jaco.mp3.player.MP3Player;

import static TowerDefense.Begin.Game.*;
import static TowerDefense.Enemy.EnemyManager.enemies;
import static TowerDefense.Tower.TowerManager.towers;
public class GameState extends State {
    private EnemyManager enemy;
    private Map map;
    private TowerManager tower;
    long times=0;
    public static int enemydie=0;
    public static long money=50;
    public static int numberEnemy=30;
    public static boolean play= true;
    public static  boolean next=false;
    private int mark=0;
    private int mark1=0;
    public GameState(Handler handler) {
        super(handler);
        enemy= new EnemyManager(handler);
        map= new Map(handler);
       tower= new TowerManager( handler);

    }
    @Override
    public void tick() {
        if (play==true)
        {
            enemy.tick();
            tower.tick();
            running();
        }
        if (next==true)
        {
            dem--;
            enemy.tick();
            tower.tick();
            running();
        }
        if (dem==0)
            next=false;
    }
    public void running()
    {

        times++;

        for(int i =0; i< towers.size();i++)
        {
           for (int j =0; j< enemies.size();j++)
           {
               //khoang cach giua tower va enemy
               float a= (enemies.get(j).getX()-towers.get(i).getX());
               float b= (enemies.get(j).getY()-towers.get(i).getY());

              if (Math.sqrt(a*a+b*b) <= towers.get(i).getRange()*64)
              {

                    if (towers.get(i) instanceof NormalTower)
                    {
                        if (times % 24 == 0){
                            towers.get(i).bullet.add(new BulletNomal((Handler) handler,towers.get(i).getX(),towers.get(i).getY(),(towers.get(i).getX()-enemies.get(j).getX())/Math.sqrt(a*a+b*b),(towers.get(i).getY()-enemies.get(j).getY())/Math.sqrt(a*a+b*b)));
                             break;
                        }

                    }
                    else if  (towers.get(i) instanceof SniperTower)
                    {
                        if (times % 48 == 0)
                        {
                            towers.get(i).bullet.add(new BulletSniper((Handler) handler,towers.get(i).getX(),towers.get(i).getY(),(towers.get(i).getX()-enemies.get(j).getX())/Math.sqrt(a*a+b*b),(towers.get(i).getY()-enemies.get(j).getY())/Math.sqrt(a*a+b*b)));
                            times=0;
                            break;
                        }

                    }
                    else
                    {
                        if (times % 12 == 0){
                            towers.get(i).bullet.add(new BulletMachineGun((Handler) handler,towers.get(i).getX(),towers.get(i).getY(),(towers.get(i).getX()-enemies.get(j).getX())/Math.sqrt(a*a+b*b),(towers.get(i).getY()-enemies.get(j).getY())/Math.sqrt(a*a+b*b)));

                            break;
                        }

                    }
              }
           }
        }
        for(int i =0; i< enemies.size();i++)
                {
                    for  (int j =0; j< towers.size(); j++)
                    {
                        for (int k =0;  k< towers.get(j).bullet.size(); k++)
                        {
                            int xx=towers.get(j).bullet.get(k).getX();
                   int yy= towers.get(j).bullet.get(k).getY();
                    if (xx>=enemies.get(i).getX()&&xx<=enemies.get(i).getX()+64&&yy>=enemies.get(i).getY()&&yy<=enemies.get(i).getY() +64)
                    {
                       if (enemies.get(i).getArmor()>=0) enemies.get(i).setArmor(enemies.get(i).getArmor()-towers.get(j).bullet.get(k).getDamage());
                        else enemies.get(i).setHeath(enemies.get(i).getHeath()-towers.get(j).bullet.get(k).getDamage());
                        towers.get(j).bullet.remove(k);
                    }
                }
            }
        }
        for (int i = 0; i < towers.size(); i ++)
            for (int j = 0; j < towers.get(i).bullet.size(); j ++){
                int x1= towers.get(i).getX();
                int y1 = towers.get(i).getY();
                int x2 = towers.get(i).bullet.get(j).getX();
                int y2 = towers.get(i).bullet.get(j).getY();

                if ( Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2))> towers.get(i).getRange()*64)
                    towers.get(i).bullet.remove(j);
            }
        for  (int i =0;i< enemies.size(); i++)
        {
            if (enemies.get(i).getHeath()<=0) {
                money += enemies.get(i).getReward();
                enemies.remove(i);
                enemydie++;
            }

        }
    }
    @Override
    public void render(Graphics g) {
        if (heath_player>0&&enemydie<30)
        {
            if (play==true)
           {
            g.drawImage(Assets.pause,1100,650,50,50,null);
            }
           else
        {
            g.drawImage(Assets.play,1100,650,50,50,null);
        }
            g.drawImage(Assets.next,1170,650,50,50,null);
            map.render(g);
            enemy.render(g);
            tower.render(g);
            for (int i =0;i< towers.size(); i++)
            {
                for (int j =0; j< towers.get(i).bullet.size(); j++)
                {
                    towers.get(i).bullet.get(j).move();
                    towers.get(i).bullet.get(j).render(g);
                }
            }

            g.setColor(Color.BLACK);
            g.setFont(new Font("Algerian",Font.BOLD,20));
            g.drawString("$ : "+money,1110,50);

            g.setColor(Color.YELLOW);
            g.drawString("25$",275,620);
            g.drawString("40$",270*2,620);
            g.drawString("50$",270*3,620);
            int heartX=1100, heartY=10;
          for (int i =1 ; i<= heath_player/10; i++)
          {
              g.drawImage(Assets.heart,heartX+(i-1)*25,heartY,20,20,null);
          }

        }
        if (heath_player <= 0)
        {

           if (mark==0)
           {
               if (sound==true)
               {
                   Config.mp3Player= new MP3Player(Config.lose);
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

            gameover--;
            g.drawImage(Assets.gameover,0,0,1280,780,null);
        }
        if (enemydie ==30&&heath_player>0)
        {
            if (mark==0)
            {
                if (sound==true)
                {
                    Config.mp3Player= new MP3Player(Config.win);
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


            gameover--;
            g.drawImage(Assets.win,0,0,1280,780,null);
        }
        if (gameover == 0)
        {
            runningg=false;
        }
    }


}

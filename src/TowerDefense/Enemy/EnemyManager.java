package TowerDefense.Enemy;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Handler;
import static  TowerDefense.State.GameState.numberEnemy;
import static TowerDefense.Art.Map.MAP;

public class EnemyManager {
    public static List<Enemy> enemies;
    private  Handler handler;
    public EnemyManager(Handler handler) {
        this.handler= handler;
        enemies= new LinkedList<Enemy>();
    }
    private int a=100;
    public void tick()
    {
        if (a == 200 && numberEnemy > 0)
        {
            Random rd= new Random();
            int t = rd.nextInt();
            t=t%4;
            if (t==0) enemies.add( new SmallerEnemy(handler));
            else if (t==1) enemies.add(new NomalEnemy(handler));
            else if (t==2) enemies.add(new TankerEnemy(handler));
            else enemies.add(new BossEnemy(handler));
            a = 0;
            numberEnemy--;
        }
        for (Enemy enemy: enemies)
        {
            enemy.tick();
        }
        a++;
    }
    public void render(Graphics g)
    {
       for (Enemy enemy: enemies)
       {
           enemy.render(g);
       }
    }
}

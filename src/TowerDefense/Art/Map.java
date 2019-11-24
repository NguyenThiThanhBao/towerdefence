package TowerDefense.Art;

import java.awt.*;
import java.util.logging.Handler;

import TowerDefense.Image.*;

import static TowerDefense.Image.Assets.*;

public class Map {
    Handler handler;

    public Map(Handler handler) {
        this.handler = handler;
    }

    public static int[][] MAP = new int[][]
            {       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 1, 1, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 5, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 5, 0, 0},
                    {0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {2, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0},
                    {2, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0},
                    {1, 1, 1, 1, 1, 1, 1, 1, 4, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
            };
    public void render(Graphics g) {
        /*int x, y;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                x = 64 * j;
                y = 64 * i;
                if (MAP[i][j] == 0) {
                    g.drawImage(grass, x, y, 64, 64, null);
                } else if (MAP[i][j] == 5) {
                    g.drawImage(grass, x, y, 64, 64, null);
                    g.drawImage(tree, x, y, 64, 64, null);
                } else {
                    g.drawImage(way, x, y, 64, 64, null);
                }
            }
        }
        //g.drawImage(stone[0],)
        g.drawImage(tree,990,0,null);
        g.drawImage(tree,64*17,64,64,64,null);
        g.drawImage(home2,-50,-50,null);
        g.drawImage(treeAutumn,1150,300,null);
        g.drawImage(home1,1100,350,null);
        g.drawImage(tree,630,60,166,166,null);*/
        g.drawImage(tru[0],265,630,64,64,null);
        g.drawImage(tru[1],265*2,630,64,64,null);
        g.drawImage(tru[2],265*3,630,64,64,null);
        g.drawImage(map,0,0,1280,640,null);
    }


}

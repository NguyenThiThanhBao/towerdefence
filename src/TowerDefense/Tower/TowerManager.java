package TowerDefense.Tower;

import TowerDefense.Begin.Handler;
import TowerDefense.Input.MouseManager;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import static TowerDefense.State.GameState.money;
import static TowerDefense.Art.Map.MAP;

public class TowerManager {
    private static Handler handler;
    public static List<Tower> towers;
    private int[] mark = {0, 0, 0};

    public TowerManager(Handler handler) {
        this.handler = handler;
        towers = new LinkedList<Tower>();
    }

    public int check(int x, int y) {
        if ((x >= 265 && x <= 265 + 64 && y >= 630 && y <= 630 + 64) || (x >= 265 * 2 && x <= 265 * 2 + 64 && y >= 630 && y <= 630 + 64) || (x >= 265 * 3 && x <= 265 * 3 + 64 && y >= 630 && y <= 630 + 64) || MAP[(int) (y * 1.0 / 64)][(int) (x * 1.0 / 64)] == 1 || MAP[(int) (y * 1.0 / 64)][(int) (x * 1.0 / 64)] == 2 || MAP[(int) (y * 1.0 / 64)][(int) (x * 1.0 / 64)] == 3 || MAP[(int) (y * 1.0 / 64)][(int) (x * 1.0 / 64)] == 4)
            return 1;
        return 0;
    }

    public void tick() {

        if (handler.getMouseManager().isLeftPressed() == true || handler.getMouseManager().isRightPressed() == true) {
            int x = handler.getMouseManager().getMouseX();
            int y = handler.getMouseManager().getMouseY();
            try {
                if (check(x, y) == 0) {
                    if (mark[0] == 1 && money >= 25) {
                        towers.add(new NormalTower(handler, x, y));
                        money -= 25;
                        mark[0] = 0;
                    }
                    if (mark[1] == 1 && money >= 40) {
                        towers.add(new SniperTower(handler, x, y));
                        money -= 40;
                        mark[1] = 0;
                    }
                    if (mark[2] == 1 && money >= 50) {
                        towers.add(new MachineGunTower(handler, x, y));
                        money -= 50;
                        mark[2] = 0;
                    }
                }

            } catch (Exception e) {

            }

            if (x >= 265 && x <= 265 + 64 && y >= 630 && y <= 630 + 64 && mark[0] == 0) {
                mark[0]++;
            }
            if (x >= 265 * 2 && x <= 265 * 2 + 64 && y >= 630 && y <= 630 + 64 && mark[1] == 0) {
                mark[1]++;
            }
            if (x >= 265 * 3 && x <= 265 * 3 + 64 && y >= 630 && y <= 630 + 64 && mark[2] == 0) {
                mark[2]++;
            }
        }
    }

    public void render(Graphics g) {
        for (Tower tower1 : towers) {
            tower1.render(g);
            int x1=handler.getMouseManager().getMouseX();
            int y1= handler.getMouseManager().getMouseY();
            if(x1<=tower1.getX()&&x1>=tower1.getX()-64&&y1<=tower1.getY()&&y1>=tower1.getY()-64)
            {
                if (tower1 instanceof NormalTower)
                {
                     g.setColor(Color.pink);
                }
                else if (tower1 instanceof SniperTower)
                {
                    g.setColor(Color.blue);
                }
                else g.setColor(Color.red);
                g.drawOval(tower1.getX()-(int)tower1.getRange()*64,tower1.getY()-(int)tower1.getRange()*64,(int)tower1.getRange()*64*2, (int)tower1.getRange()*64*2);
            }
        }

    }
}

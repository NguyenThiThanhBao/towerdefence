package TowerDefense.Bullet;

import TowerDefense.Begin.Config;
import TowerDefense.Begin.Handler;
import TowerDefense.Image.Assets;

import java.awt.image.BufferedImage;

public class BulletNomal extends Bullet {
    public BulletNomal(Handler handler,int x, int y, double directX, double directY) {
        super(handler, x, y,Config.NORMAL_TOWER_SPEED,Config.NORMAL_TOWER_DAMAGE, Assets.bullet[0], directX, directY);

    }
}

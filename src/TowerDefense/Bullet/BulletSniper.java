package TowerDefense.Bullet;

import TowerDefense.Begin.Config;
import TowerDefense.Begin.Handler;
import TowerDefense.Image.Assets;

import java.awt.image.BufferedImage;

public class BulletSniper extends Bullet {
    public BulletSniper(Handler handler, int x, int y, double directX, double directY) {
        super(handler, x, y, Config.SNIPER_TOWER_SPEED,Config.SNIPER_TOWER_DAMAGE, Assets.bullet[1], directX, directY);
    }
}

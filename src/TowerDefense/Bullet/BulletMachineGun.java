package TowerDefense.Bullet;

import TowerDefense.Begin.Config;
import TowerDefense.Begin.Handler;
import TowerDefense.Image.Assets;

import java.awt.image.BufferedImage;

public class BulletMachineGun extends Bullet {
    public BulletMachineGun(Handler handler, int x, int y,double directX, double directY) {
        super(handler, x, y,Config.MACHINE_GUN_TOWER_SPEED,Config.MACHINE_GUN_TOWER_DAMAGE, Assets.bullet[2], directX, directY);
    }
}

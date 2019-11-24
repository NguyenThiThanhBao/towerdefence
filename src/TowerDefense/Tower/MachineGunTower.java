package TowerDefense.Tower;

import TowerDefense.Begin.Handler;
import TowerDefense.Image.Assets;
import TowerDefense.Begin.Config;
import java.awt.image.BufferedImage;

public class MachineGunTower extends Tower {
    public MachineGunTower(Handler handler, int x,int y) {
        super(handler, Assets.tru[2],Config.MACHINE_GUN_TOWER_RANGE,x,y);
    }
}

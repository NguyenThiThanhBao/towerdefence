package TowerDefense.Tower;

import TowerDefense.Begin.Handler;
import TowerDefense.Begin.Config;
import TowerDefense.Image.Assets;

import java.awt.image.BufferedImage;

public class SniperTower extends Tower {
    public SniperTower(Handler handler,int x, int y) {
        super(handler, Assets.tru[1], Config.SNIPER_TOWER_RANGE, x, y);
    }
}


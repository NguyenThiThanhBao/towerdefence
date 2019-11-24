package TowerDefense.Tower;

import TowerDefense.Begin.Config;
import TowerDefense.Begin.Handler;
import TowerDefense.Image.Assets;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class NormalTower extends Tower {
    public NormalTower(Handler handler, int x,  int y) {
        super(handler,Assets.tru[0],Config.NORMAL_TOWER_RANGE,x,y);

    }


}

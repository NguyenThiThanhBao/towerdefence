package TowerDefense.Enemy;


import TowerDefense.Image.Assets;
import TowerDefense.Begin.Config;

import java.awt.image.BufferedImage;
import java.util.logging.Handler;

public class TankerEnemy extends Enemy {
    
    public TankerEnemy(Handler handler) {
        super(handler,Config.TANKER_ENEMY_HEALTH,Config.TANKER_ENEMY_REWARD,Config.TANKER_ENEMY_SPEED,Config.TANKER_ENEMY_ARMOR, Assets.zombie[1]);
    }
}

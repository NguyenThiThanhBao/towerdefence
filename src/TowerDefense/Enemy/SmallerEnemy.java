package TowerDefense.Enemy;


import TowerDefense.Image.Assets;
import java.awt.image.BufferedImage;

import java.util.logging.Handler;
import TowerDefense.Begin.Config;
public class SmallerEnemy extends Enemy {
    public SmallerEnemy(Handler handler) {
        super(handler,Config.SMALLER_ENEMY_HEALTH,Config.SMALLER_ENEMY_REWARD,Config.SMALLER_ENEMY_SPEED,Config.SMALLER_ENEMY_ARMOR, Assets.zombie[0]);
    }
}

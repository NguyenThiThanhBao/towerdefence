package TowerDefense.Enemy;

import TowerDefense.Begin.Config;
import TowerDefense.Image.Assets;

import java.awt.image.BufferedImage;
import java.util.logging.Handler;

public class BossEnemy extends Enemy {

    public BossEnemy(Handler handler) {
        super(handler, Config.BOSS_ENEMY_HEALTH,Config.BOSS_ENEMY_REWARD,Config.BOSS_ENEMY_SPEED,Config.BOSS_ENEMY_ARMOR, Assets.zombie[2]);
    }
}

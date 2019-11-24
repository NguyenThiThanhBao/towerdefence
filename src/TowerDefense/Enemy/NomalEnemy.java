package TowerDefense.Enemy;


import TowerDefense.Image.Assets;

import javax.swing.*;
import java.awt.image.BufferedImage;

import java.util.logging.Handler;
import TowerDefense.Begin.Config;
public class NomalEnemy extends Enemy {
    public NomalEnemy(Handler handler) {
        super(handler,Config.NORMAL_ENEMY_HEALTH,Config.NORMAL_ENEMY_REWARD ,Config.NORMAL_ENEMY_SPEED,Config.NORMAL_ENEMY_ARMOR, Assets.zombie[3]);
    }
}

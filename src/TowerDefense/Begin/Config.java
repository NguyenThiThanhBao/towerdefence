package TowerDefense.Begin;

import jaco.mp3.player.MP3Player;

import java.io.File;

public class Config {
    public Config() {
    }

    //Tower
    public  static  final int NORMAL_TOWER_DAMAGE=8;
    public  static  final int MACHINE_GUN_TOWER_DAMAGE=10;
    public  static  final int SNIPER_TOWER_DAMAGE=15;

    public static final long NORMAL_TOWER_SPEED = 20;
    public static final double NORMAL_TOWER_RANGE = 4;

    public static final long MACHINE_GUN_TOWER_SPEED = 20;
    public static final double MACHINE_GUN_TOWER_RANGE = 3;

    public static final long SNIPER_TOWER_SPEED = 30;
    public static final double SNIPER_TOWER_RANGE = 5;
    // ENEMY
    public static final long NORMAL_ENEMY_HEALTH = 50;
    public static final long NORMAL_ENEMY_ARMOR = 30;
    public static final double NORMAL_ENEMY_SPEED = 1;
    public static final long NORMAL_ENEMY_REWARD = 10;

    public static final long SMALLER_ENEMY_HEALTH = 40;
    public static final long SMALLER_ENEMY_ARMOR = 10;
    public static final double SMALLER_ENEMY_SPEED = 2;
    public static final long SMALLER_ENEMY_REWARD = 10;

    public static final long TANKER_ENEMY_HEALTH = 70;
    public static final long TANKER_ENEMY_ARMOR = 70;
    public static final double TANKER_ENEMY_SPEED = 1;
    public static final long TANKER_ENEMY_REWARD = 15;

    public static final long BOSS_ENEMY_HEALTH = 80;
    public static final long BOSS_ENEMY_ARMOR = 80;
    public static final double BOSS_ENEMY_SPEED =1;
    public static final long BOSS_ENEMY_REWARD = 30;


    public static final File start = new File("res/texture/DoraemonNoUta-SatokoYamano-179702 (mp3cut.net).mp3"  );
    public static final File gun = new File("res/texture/machinegun.mp3"  );
    public static final  File lose=new File("res/texture/ChocoboRacingLose-HoaTau-3316610.mp3");
    public static final File win = new File("res/texture/ChocoboRacingWin-HoaTau-3316611.mp3");
    public static MP3Player mp3Player;
}
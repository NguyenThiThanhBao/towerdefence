package TowerDefense.State;
import java.awt.*;

import TowerDefense.Begin.Config;
import TowerDefense.Begin.Handler;
import TowerDefense.Image.Assets;
import TowerDefense.UI.ClickListener;
import TowerDefense.UI.UIImageButton;
import TowerDefense.UI.UIManager;
import jaco.mp3.player.MP3Player;

import static TowerDefense.Begin.Game.aa;
import static TowerDefense.Begin.Game.sound;

// man hinh bat dau choi
public class MenuState extends State {
    private int mark=0;
    private UIManager uiManager;
    private int time=0;
    public MenuState(Handler handler) {
            super(handler);
            Config.mp3Player=  new MP3Player(Config.start);
            Config.mp3Player.play();
        uiManager= new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UIImageButton(550, 300,200,100, Assets.btn_start, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().gameState);

                Config.mp3Player.stop();

            }
        }));
        uiManager.addObject(new UIImageButton(550, 450, 200, 100, Assets.instructions, new ClickListener() {
            @Override
            public void onClick() {
                time=500;
            }
        }));
        uiManager.addObject(new UIImageButton(550, 600, 200, 100, Assets.exit, new ClickListener() {
            @Override
            public void onClick() {
               System.exit(0);
            }
        }));
    }

    @Override
    public void tick() {
         uiManager.tick();
       if (sound==false){
           Config.mp3Player.pause();
           mark=1;
       }
       if (sound==true&&mark==1)
           {
               Config.mp3Player.play();
               mark=0;// de con chay tiep
           }

    }
    @Override
    public void render(Graphics g) {
        if (time>=0)
        {
            g.drawImage(Assets.Instruction,10,10,null);
            time--;
        }
        else
        {
            g.drawImage(Assets.menu,0,0,null);
            uiManager.render(g);
        }





    }
}

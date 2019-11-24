package TowerDefense.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class Assets{
    public static BufferedImage heart,win,menu,Instruction, Bulletproof,gameover,map,pause,play,next;
    public static BufferedImage zombie[][]= new BufferedImage[4][2];
    public static BufferedImage[] btn_start;
    public static BufferedImage[] loud;
    public static BufferedImage[] exit;
    public static BufferedImage[] tru= new BufferedImage[3];
    public static BufferedImage[] bullet= new BufferedImage[3];
    public static BufferedImage[] instructions;
   public static void init() {
       SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("res//texture//sheet.png"));
       Bulletproof= ImageLoader.loadImage("res//texture//bulletproof.png");
       gameover=ImageLoader.loadImage("res//texture//gameover.png");
       win=ImageLoader.loadImage("res//texture//win.png");
       map=ImageLoader.loadImage("res//texture//Map.png");
       pause=ImageLoader.loadImage("res//texture//pause.png");
       play=ImageLoader.loadImage("res//texture//play.png");
       next=ImageLoader.loadImage("res//texture//next.png");
       //loud
       loud= new BufferedImage[2];
       loud[0]= ImageLoader.loadImage("res//texture//loud.png");
       loud[1]= ImageLoader.loadImage("res//texture//loudX.png");
       //exit
       exit= new BufferedImage[2];
       exit[0]= ImageLoader.loadImage("res//texture//piv.png");
       exit[1]= ImageLoader.loadImage("res//texture//piv1.png");
       //instruction
       instructions = new BufferedImage[2];
       instructions[0]= ImageLoader.loadImage("res//texture//INSTRUCTION2.png");
       instructions[1]= ImageLoader.loadImage("res//texture//INSTRUCTION1.png");
       Instruction= ImageLoader.loadImage("res//texture//instruction.jpg");
       heart= ImageLoader.loadImage("res//texture//heart.png");
       // tru
       tru[0]= ImageLoader.loadImage("res//texture//tru1.png");
       tru[1]= ImageLoader.loadImage("res//texture//tru2.png");
       tru[2]= ImageLoader.loadImage("res//texture//tru.png");
       // begin
       btn_start = new BufferedImage[2];
       btn_start[0] = sheet1.crop(32 * 6, 32 * 4, 32 * 2, 32);
       btn_start[1] = sheet1.crop(32 * 6, 32 * 5, 32* 2, 32);
       menu= ImageLoader.loadImage("res//texture//BEGIN.png");
         // enemy
         zombie[0][0]=ImageLoader.loadImage("res//texture//enemy0.png");
         zombie[1][0]=ImageLoader.loadImage("res//texture//enemy1.png");
         zombie[2][0]=ImageLoader.loadImage("res//texture//enemy2.png");
         zombie[3][0]=ImageLoader.loadImage("res//texture//enemy3.png");
         zombie[0][1]=ImageLoader.loadImage("res//texture//enemy00.png");
       zombie[1][1]=ImageLoader.loadImage("res//texture//enemy11.png");
       zombie[2][1]=ImageLoader.loadImage("res//texture//enemy22.png");
       zombie[3][1]=ImageLoader.loadImage("res//texture//enemy33.png");
         // bullet
       bullet[0]=ImageLoader.loadImage("res//texture//bullet0.png");
       bullet[1]=ImageLoader.loadImage("res//texture//bullet1.png");
       bullet[2]=ImageLoader.loadImage("res//texture//bullet2.png");

   }
}

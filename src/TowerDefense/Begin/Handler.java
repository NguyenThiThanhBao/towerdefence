package TowerDefense.Begin;
import TowerDefense.Input.MouseManager;

import java.util.logging.LogRecord;
public class Handler extends java.util.logging.Handler {

    private Game game;

    public Handler(Game game){
        this.game = game;
    }


    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }


    @Override
    public void publish(LogRecord logRecord) {
        
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }
}

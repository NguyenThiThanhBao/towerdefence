package TowerDefense.State;

import java.awt.*;
import java.util.logging.Handler;

public abstract class State {
    protected Handler handler;

    public State(Handler handler) {
        this.handler = handler;
    }

    private static State currentState= null;
    public abstract void tick();

    public abstract void render(Graphics g);

    public static State getState() {
        return currentState;
    }

    public static void setState(State currentState) {
        State.currentState = currentState;
    }

}

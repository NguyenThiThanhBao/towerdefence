package TowerDefense.Input;

import TowerDefense.Tower.MachineGunTower;
import TowerDefense.Tower.NormalTower;
import TowerDefense.Tower.SniperTower;
import TowerDefense.UI.UIManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {
    private UIManager uiManager;
    private boolean leftPressed, rightPressed;
    private  int mouseX, mouseY;
    public MouseManager() {
    }

    public void setUiManager(UIManager uiManager) {
        this.uiManager = uiManager;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
          if (e.getButton()== MouseEvent.BUTTON1)
              leftPressed =  true;
          if  (e.getButton()==  MouseEvent.BUTTON3)
              rightPressed=  true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton()== MouseEvent.BUTTON1)
            leftPressed =  false;
        else if  (e.getButton()==  MouseEvent.BUTTON3)
            rightPressed=  false;
        if (uiManager!=null)
        {
            uiManager.onMouseRelease(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
          mouseX= mouseEvent.getX();
          mouseY= mouseEvent.getY();
          if (uiManager!=null)
          {
              uiManager.onMouseMove(mouseEvent);
          }
    }
    // getter and setter

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public void setLeftPressed(boolean leftPressed) {
        this.leftPressed = leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public void setRightPressed(boolean rightPressed) {
        this.rightPressed = rightPressed;
    }

    public int getMouseX() {
        return mouseX;
    }

    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }
}

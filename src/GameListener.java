import java.awt.*;

public class GameListener implements DrawListener {
    private Game game;

    public GameListener(Game game){
        this.game = game;
    }
    @Override
    public void keyPressed(int keycode) {

    }

    @Override
    public void keyTyped(char c) {

    }

    @Override
    public void keyReleased(int keycode) {

    }

    @Override
    public void mouseDragged(double x, double y) {

    }

    @Override
    public void mouseReleased(double x, double y) {

    }

    @Override
    public void mousePressed(double x, double y) {
        boolean tableClicked = game.selectTableAt(x, y);
        if (tableClicked) { System.out.println("hi");}

    }

}

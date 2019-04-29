import java.awt.*;

public class GameListener implements DrawListener {
    private Game game;
    Customer customerClicked;
    Table tableClicked;

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
        Customer customerClicked = game.selectCustomerAt(x, y);
        Table tableClicked = game.selectTableAt(x, y);

        if(customerClicked != null && tableClicked != null){
            System.out.println("hi");
        }

    }

    @Override
    public void mouseReleased(double x, double y) {

    }

    @Override
    public void mousePressed(double x, double y) {
        Customer customerClicked = game.selectCustomerAt(x, y);
        Table tableClicked = game.selectTableAt(x, y);

    }

}

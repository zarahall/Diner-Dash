import java.awt.*;

public class GameListener implements DrawListener {
    private Game game;
    Customer customerClicked;
    Table tableClicked;
    private boolean orderTaken;

    public GameListener(Game game){
        this.game = game;
        orderTaken = false;
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
        if(customerClicked != null){
            tableClicked = game.selectTableAt(x, y);
            if(tableClicked != null){
                customerClicked.setTable(tableClicked);
                tableClicked = null;
            }
        }
        if(tableClicked != null){

        }
    }

    @Override
    public void mouseReleased(double x, double y) {

    }

    @Override
    public void mousePressed(double x, double y) {
        customerClicked = null;
        tableClicked = null;
        customerClicked = game.selectCustomerAt(x, y);
        tableClicked = game.selectTableAt(x, y);

        if(tableClicked!= null){
            if(tableClicked.getReadyToOrder()){
                System.out.println("h");
                tableClicked.startFoodTimer();
                orderTaken = true;
            }
        }

    }

    public boolean isOrderTaken(){
        return orderTaken;
    }

    public void setOrderTaken(boolean b){
        orderTaken = b;
    }

}

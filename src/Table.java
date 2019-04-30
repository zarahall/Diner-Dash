import java.awt.*;

/**
 * Class for the tables in the restaurant. The game initially starts with two tables, but as the customer increases in level,
 * more tables can be added
 */

public class Table {
    //size of the table
    private int width;
    private int height;
    private int tableNum;
    private Game game;
    private boolean readyToOrder;
    private long foodStartTime;
    private boolean orderTaken;
    private boolean isFood;

    //x and y coordinates of the table
    private int x,y;
    //has the player selected this table
    private boolean isSelected = false;
    // table has customers
    private boolean hasCustomers;
    // Table number
    String num;

    public Table(int x, int y, int w, int h, int tableNum, Game game, String num){
        this.x = x;
        this.y = y;
        width = w;
        height = h;
        this.tableNum = tableNum;
        this.game = game;
        this.hasCustomers = false;
        this.num = num;
        readyToOrder = false;
        orderTaken = false;
        isFood = false;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public int getTableNum() { return tableNum; }

    public boolean gatHasCustomers() { return hasCustomers; }

    public boolean containsPoint(double x, double y) {
        if(x < this.x+(width/2.0) && x > this.x-(width/2.0)){
            if(y < this.y+(width/2.0) && y > this.y-(width/2.0)){
                return true;
            }
        }
        return false;
    }

    public void setSelected(boolean selected) { isSelected = selected; }

    public void drawMenu() {
        if(!(isOrderTaken() || isFood)) {
            game.getWindow().setPenColor(221, 206, 217);
            game.getWindow().filledRectangle(x - 7, y + 4, 2, 3);
            game.getWindow().setPenColor(Color.BLACK);
            Font font = new Font("Dialog", Font.PLAIN, 11);
            game.getWindow().setFont(font);
            game.getWindow().text(x - 7, y + 6, "Menu");
        }
    }

    public void readyToOrder() {
        readyToOrder = true;
    }

    public void startFoodTimer(){
        foodStartTime = System.currentTimeMillis();
    }

    public long updateFoodTime(){
        long time = (System.currentTimeMillis() - foodStartTime)/1000;
        return time;
    }


    public boolean getReadyToOrder(){
        return readyToOrder;
    }

    public void drawReadyToOrder(){
        game.getWindow().setPenColor(Color.green);
        game.getWindow().filledRectangle(x+7, y+6, 3, 3);
        game.getWindow().setPenColor(Color.black);
        Font font = new Font("Dialog", Font.PLAIN, 11);
        game.getWindow().setFont(font);
        game.getWindow().text(x+7, y+6.5, "Ready to");
        game.getWindow().text(x+7, y+5, "order");
    }

    public void draw() {
        int y2 = y+10;
        game.getWindow().setPenColor(31,31,31);
        game.getWindow().filledRectangle(x, y, width/2.0, height/2.0);
        game.getWindow().setPenColor(Color.BLACK);
        game.getWindow().line(x, y2, x, y+3);
        game.getWindow().filledRectangle(x, y2, width/6.7, width/6.7);
        game.getWindow().setPenColor(157, 159, 152);
        game.getWindow().filledRectangle(x, y2, width/7.5, width/7.5);
        if (hasCustomers) {
            drawMenu();
        }
        tableText();
    }

    public void drawFood(MenuItem food){
        game.getWindow().picture(x,y,food.getFileName(),10,10);
    }
    public boolean isOrderTaken(){
        return orderTaken;
    }

    public void setOrderTaken(boolean b){
        orderTaken = b;
    }

    public void setIsFood(boolean i){
        isFood = i;
    }
    public boolean getIsFood(){
         return isFood;
    }


    public void tableText() {
        Font gameFont = new Font("Dialog", Font.PLAIN, 30);
        game.getWindow().setFont(gameFont);
        game.getWindow().setPenColor(Color.black);
        game.getWindow().text(x, y+10, num);
    }
}

import java.awt.*;
import java.util.ArrayList;

public class Game {
    //window in which the game will take place;
    private Draw window;
    private ArrayList<Table> tableList;
    private ArrayList<MenuItem> menuItemList;
    private ArrayList<Customer> customersList;
    private Draw window2;
    private long startTime;
    private long elapsedTime;
    private GameListener listener;

    public Game(){
        window = new Draw("Diner Dash");
        window.enableDoubleBuffering();
        window.setXscale(0,100);
        window.setYscale(0,100);
        tableList = new ArrayList<>();
        menuItemList = new ArrayList<>();
        setMenuItemList();
        customersList = new ArrayList<>();
        listener = new GameListener(this);
        window.addListener(listener);
        startTime = System.currentTimeMillis();
        elapsedTime = 0;
    }

    public Draw getWindow() { return window; }

    public void setMenuItemList() {
        menuItemList.add(new MenuItem(10.15, "Hamburger", "images/hamburger.png"));
        menuItemList.add(new MenuItem(6.99, "French Fries", "images/fries.png"));
        menuItemList.add(new MenuItem(9.99, "Chicken Caesar Salad", "images/salad.png"));
        menuItemList.add(new MenuItem(3.95, "Lemonade", "images/lemonade.png"));
        menuItemList.add(new MenuItem(6.45, "Key Lime Pie", "images/keyLimePie.png"));
        menuItemList.add(new MenuItem(7.15, "Cheese Pizza Slice", "images/pizza.png"));
    }

    public MenuItem getMenuItem(int index) { return menuItemList.get(index); }

    public Table selectTableAt(double x, double y) {
        Table tableClicked = null;
        for (Table t : tableList) {
            if (t.containsPoint(x, y)) {
                t.setSelected(true);
                tableClicked = t;
                break;
            }
        }
        // If one was clicked, deselect the rest
        if (tableClicked != null) {
            for (Table t: tableList) {
                if (t != tableClicked) {
                    t.setSelected(false);
                }
            }
        }
        return tableClicked;
    }


    public Customer selectCustomerAt(double x, double y) {
        Customer customerClicked = null;
        for (Customer c : customersList) {
            if (c.containsPoint(x, y)) {
                c.setSelected(true);
                customerClicked = c;
                break;
            }
        }
        // If one was clicked, deselect the rest
        if (customerClicked != null) {
            for (Customer c : customersList) {
                if (c != customerClicked) {
                    c.setSelected(false);
                }
            }
        }
        return customerClicked;
    }

    public long updateTime(){
        elapsedTime =( System.currentTimeMillis() - startTime)/1000;
        return elapsedTime;
    }

    public void displayTime() {
        window.setPenColor(209, 196, 208);
        window.filledRectangle(90, 90, 4, 4);
        Font gameFont = new Font("Dialog", Font.PLAIN, 30);
        window.setFont(gameFont);
        window.setPenColor(Color.black);
        window.text(90, 90, 180-updateTime()+"");
    }

    public GameListener getListener(){
        return listener;
    }

    /** Adds given portal to this window. */
    public void add(Customer c) { customersList.add(c); }

    /** Adds given portal to this window. */
    public void add(Table t) { tableList.add(t); }



    public static void main(String[] args){
        Game game = new Game();
        Board board = new Board(game);
        board.drawBoard();
        Customer cust1 = new Customer("images/green.png", game,15,15,15,20);
        cust1.drawInLine(15,20);
        game.add(cust1);

        while(true){
            if(cust1.getTable()!=null){
                game.window.clear();
                board.drawBoard();
                cust1.drawaAtTable();
                cust1.updateTime();
                if (cust1.isReadyForOrder()) {
                    cust1.getTable().readyToOrder();
                    if(cust1.getTable().isOrderTaken()){
                        cust1.orderFood();
                    }
                }
                cust1.drawFood();
                cust1.pay();

            }
            cust1.updateHappiness();
            game.displayTime();
            game.window.show();

        }



    }
}
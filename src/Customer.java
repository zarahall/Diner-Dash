
/**
 * A customer who comes into the restaurant
 */
public class Customer {
    //location
    private int x;
    private int y;
    //name of the file in which the customer's picture is stored
    private String pictureFileName;
    private int height;
    private int width;
    //happiness of the customer, goes down based on time
    private int happiness;
    //time that the customer enters the restaurant
    private long startTime;
    private long elapsedTime;
    private long orderStartTime;
    private long orderTime;
    private boolean readyForOrder;


    private double charge;

    private double tip;

    private boolean isSelected = false;

    private int orderIndex;

    private Table table;
    private Game game;

    public Customer(String filename, Game game, int width, int heigth, int x, int y){
        this.x = x;
        this.y = y;
        pictureFileName = filename;
        this.width = width;
        this.height = heigth;
        this.happiness = 100;
        startTime = System.currentTimeMillis();
        elapsedTime = 0;
        this.game = game;
        readyForOrder = false;
    }

    public void updateHappiness(){
        elapsedTime = System.currentTimeMillis() - startTime;
        long secondsElapsed = elapsedTime / 1000;
        if(secondsElapsed > 120){
            happiness = 0;
        }else if(secondsElapsed > 60){
            happiness = 30;
            pictureFileName = "red.png";
        }else if(secondsElapsed > 30){
            happiness = 70;
            pictureFileName = "yellow.png";
        }
    }

    public long updateTime(){
        elapsedTime =( System.currentTimeMillis() - startTime)/1000;
        return elapsedTime;
    }

    public void setTable(Table table) {
        this.table = table;
        drawaAtTable();
        orderStartTime = System.currentTimeMillis();
    }

    public boolean isReadyForOrder(){
        orderTime = (System.currentTimeMillis() - orderStartTime)/1000;
        if(orderTime >= 5){
            readyForOrder = true;
        }
        return readyForOrder;
    }

    public Table getTable(){ return table;}

    public void drawInLine(int xLoc, int yLoc) {
        x = xLoc;
        y = yLoc;
        game.getWindow().picture(x, y, pictureFileName, width, height);
    }

    public boolean containsPoint(double x, double y) {
        double deltaX = x - this.x;
        double deltaY = y - this.y;
        double dist = Math.sqrt(deltaX*deltaX + deltaY*deltaY);
        return dist <= width/2.0;
    }

    public void setSelected(boolean selected) { isSelected = selected; }


    public void drawaAtTable() {
        x = table.getX();
        y = table.getY();
        game.getWindow().picture(x, y - 7, pictureFileName, width, height);
        table.drawMenu();
    }
    public MenuItem order() {
        orderIndex = (int) (Math.random() * 6 + 1);
        charge = game.getMenuItem(orderIndex).getPrice();
        return game.getMenuItem(orderIndex);
    }

    public void orderFood(){
        if(table.updateFoodTime()>=5){
            MenuItem food = order();
            if(order().getName().equals("Hamburger")){
                table.drawFood("hamburger.png");
            }
            if(order().getName().equals("French Fries")){
                table.drawFood("fries.png");
            }
            if(order().getName().equals("Key Lime Pie")){
                table.drawFood("keyLimePie.png");
            }
            if(order().getName().equals("Lemonade")){
                table.drawFood("lemonade.png");
            }
            if(order().getName().equals("Chicken Caesar Salad")){
                table.drawFood("salad.png");
            }
            if(order().getName().equals("Cheese Pizza Slice")){
                table.drawFood("pizza.png");
            }

        }
    }

    public void calcTip() {
        tip = charge * .2 * happiness / 5;
        tip = (double) Math.round(tip * 100) / 100;
    }
}
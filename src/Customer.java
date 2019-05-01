
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
    private boolean foodReady;
    private MenuItem order;
    private boolean hasOrdered;
    private boolean hasPaid;

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
        foodReady = false;
        hasOrdered = false;
        hasPaid = false;
    }

    public int getX(){ return x;}
    public int getY(){ return y;}


    public void updateHappiness(){
        elapsedTime = System.currentTimeMillis() - startTime;
        long secondsElapsed = elapsedTime / 1000;
        if(secondsElapsed > 120){
            happiness = 0;
        }else if(secondsElapsed > 60){
            happiness = 30;
            pictureFileName = "images/red.png";
        }else if(secondsElapsed > 30){
            happiness = 70;
            pictureFileName = "images/yellow.png";
        }
    }

    public long updateTime(){
        elapsedTime =( System.currentTimeMillis() - startTime)/1000;
        return elapsedTime;
    }

    public void setTable(Table table) {
        this.table = table;
        drawaAtTable();
        table.setHasCustomers(true);
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
        game.getWindow().picture(x, y - 14, pictureFileName, width, height);
        table.drawMenu();
        table.drawReadyToOrder();
    }
    public MenuItem order() {
        orderIndex = (int) (Math.random() * 6 );
        charge = game.getMenuItem(orderIndex).getPrice();
        return game.getMenuItem(orderIndex);
    }

    public void orderFood(){
        long seconds = table.updateFoodTime();
        if(seconds>=5){
            order = order();
            table.setIsFood(true);
            table.startEatingTimer();
            table.setOrderTaken(false);
            hasOrdered = true;
        }
    }

    public void pay(){
        if(hasOrdered) {
            long seconds = table.updateEatingTime();
            if (seconds >= 5) {
                table.setMoney(true);
                table.setIsFood(false);
                table.drawMoney();
                calcTip();
                double charge = order.getPrice() + tip;
                if(!hasPaid) {
                    game.addMoney(charge);
                    hasPaid = true;
                }
            }
        }
    }

    public void drawFood(){
        if(table.getIsFood()){
            table.drawFood(order);
        }
    }

    public void calcTip() {
        tip = charge * .2 * (happiness / 100);
        tip = (double) Math.round(tip * 100) / 100;
    }

    public boolean leave(){
        if(!table.getHasCustomers()){
            table = null;
            return true;
        }
        return false;
    }

    public boolean gethasPaid(){
        return hasPaid;
    }

    public boolean setHasPaid(boolean h){
        return hasPaid = h;
    }
}
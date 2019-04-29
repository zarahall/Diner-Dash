
/**
 * A customer who come into the restaurant
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
    }

    public void updateHappiness(){
        elapsedTime = System.currentTimeMillis() - startTime;
        long secondsElapsed = elapsedTime / 1000;
        if(secondsElapsed > 120){
            happiness = 0;
        }else if(secondsElapsed > 60){
            happiness = 30;
        }

    }
    
    public void setTable(Table table) { this.table = table; }
    
    public void drawInLine(int xLoc, int yLoc) {
        game.getWindow().picture(xLoc, yLoc, pictureFileName);
    }
    
    public void drawaAtTable() {
        int xTableLoc = table.getX();
        int yTableLoc = table.getY();
    }
    public void order(){

    }

}

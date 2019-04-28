
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

    public Customer(String filename, int width, int heigth, int x, int y){
        this.x = x;
        this.y = y;
        pictureFileName = filename;
        this.width = width;
        this.height = heigth;
        this.happiness = 50;
        startTime = System.currentTimeMillis();
        elapsedTime = 0;
    }

    public void updateHappiness(){
        elapsedTime = System.currentTimeMillis() - startTime;
        long secondsElapsed = elapsedTime / 1000;
       // if(secondsElapsed >)
    }


    public void order(){

    }

}

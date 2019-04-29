/**
 * Class for the tables in the restaurant. The game initially starts with two tables, but as the customer increases in level,
 * more tables can be added
 */
public class Table {
    //size of the table
    private int width;
    private int height;
    private Game game;

    //x and y coordinates of the table
    private int x,y;
    //has the player selected this table
    private boolean isSelected = false;

    public Table(int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        width = w;
        height = h;
    }

    public void draw(){
        game.getWindow().filledRectangle(x,y,width/2.0,height/2.0);
    }


}

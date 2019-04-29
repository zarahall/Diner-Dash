import java.awt.*;

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
    // Table number
    String num;

    public Table(int x, int y, int w, int h, Game game, String num){
        this.x = x;
        this.y = y;
        width = w;
        height = h;
        this.game = game;
        this.num = num;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void draw() {
        game.getWindow().setPenColor(Color.gray);
        game.getWindow().filledRectangle(x, y, width/2.0, height/2.0);
    }

    public void tableText(Table table) {
        game.getWindow().text(table.getX(), table.getY(), num);
    }
}

import java.awt.*;
import java.util.ArrayList;

public class Game {
    //window in which the game will take place;
    private Draw window;
    private ArrayList<Table> tableList;
    private ArrayList<MenuItem> menuItemList;

    public Game(){
        window = new Draw("Diner Dash");
        window.enableDoubleBuffering();
        window.setXscale(0,100);
        window.setYscale(0,100);
        tableList = new ArrayList<>();
        GameListener listener = new GameListener(this);
        window.addListener(listener);

    }

    public Draw getWindow() {
        return window;
    }

    public boolean selectTableAt(double x, double y) {
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
        return (tableClicked != null);
    }



    /** Adds given portal to this window. */
    public void add(Table t) { tableList.add(t); }


    public static void main(String[] args){
        Game game = new Game();
        // Set background color
        game.window.setPenColor(Color.lightGray);
        game.window.filledRectangle(50, 50, 50, 50);
        // Make tables
        Table table1 = new Table(40, 50, 22, 22, 1, game, "1");
        table1.draw();
        game.add(table1);
        Table table2 = new Table(80, 50, 22, 22, 2, game, "2");
        table2.draw();
        game.add(table2);
        Table table3 = new Table(40, 20, 22, 22, 3, game, "3");
        table3.draw();
        game.add(table3);
        Table table4 = new Table(80, 20, 22, 22, 4, game, "4");
        table4.draw();
        game.add(table4);

        Customer cust1 = new Customer("green.png",game,15,15,15,20);
        cust1.drawInLine(15,20);

        //Draw kitchen
        Kitchen kitchen = new Kitchen(game);
        kitchen.draw();

        game.window.show();


    }


}


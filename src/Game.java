import java.awt.*;
import java.util.ArrayList;

public class Game {
    //window in which the game will take place;
    private Draw window;
    private ArrayList<Table> tableList;

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
        Table table3 = new Table(30, 20, 25, 25, game, "3");
        table3.draw();
        game.add(table3);
        Table table4 = new Table(70, 20, 25, 25, game, "4");
        table4.draw();
        game.add(table4);
        Table table1 = new Table(30, 50, 25, 25, game, "1");
        table1.draw();
        game.add(table1);
        Table table2 = new Table(70, 50, 25, 25, game, "2");
        table2.draw();
        game.add(table2);

        //Draw kitchen
        Kitchen kitchen = new Kitchen(game);
        kitchen.draw();

        game.window.show();


    }


}


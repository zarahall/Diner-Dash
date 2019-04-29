import java.awt.*;

public class Game {
    //window in which the game will take place;
    private Draw window;

    public Game(){
        window = new Draw("Diner Dash");
        window.enableDoubleBuffering();
        window.setXscale(0,100);
        window.setYscale(0,100);

        GameListener listener = new GameListener(this);
        window.addListener(listener);

    }

    public Draw getWindow() {
        return window;
    }

    public static void main(String[] args){
        Game game = new Game();
        // Set background color
        game.window.setPenColor(Color.lightGray);
        game.window.filledRectangle(50, 50, 50, 50);
        // Make tables
        Table table1 = new Table(30, 20, 25, 25, game, "1");
        table1.draw();
        Table table2 = new Table(70, 20, 25, 25, game, "2");
        table2.draw();
        Table table3 = new Table(30, 50, 25, 25, game, "3");
        table3.draw();
        Table table4 = new Table(70, 50, 25, 25, game, "4");
        table4.draw();

        //Draw kitchen
        Kitchen kitchen = new Kitchen(game);
        kitchen.draw();

        game.window.show();


    }


}


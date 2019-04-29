import java.awt.*;

public class Board {

    private Game game;

    public Board(Game game) {
        this.game = game;
    }


    public void drawKitchen() {
        game.getWindow().setPenColor(Color.lightGray);
        game.getWindow().filledRectangle(50, 50, 50, 50);
        game.getWindow().setPenColor(240, 200, 81);
        game.getWindow().filledRectangle(50, 90, 50, 10);
        game.getWindow().picture(50, 90, "chef.png", 20, 20);
        game.getWindow().setPenColor(40, 96, 109);
        game.getWindow().filledRectangle(50, 80, 50, 3);
        // Kitchen label
        game.getWindow().filledRectangle(10, 95, 9, 3);
        game.getWindow().setPenColor(Color.black);
        game.getWindow().text(10, 95, "KITCHEN");
        game.getWindow().setPenColor(131, 23, 23);
        game.getWindow().filledRectangle(25, 40, 1, 34);
    }

    public void drawTables() {
        // Make tables
        Table table1 = new Table(45, 50, 22, 22, 1, game, "1");
        table1.draw();
        game.add(table1);
        Table table2 = new Table(80, 50, 22, 22, 2, game, "2");
        table2.draw();
        game.add(table2);
        Table table3 = new Table(45, 20, 22, 22, 3, game, "3");
        table3.draw();
        game.add(table3);
        Table table4 = new Table(80, 20, 22, 22, 4, game, "4");
        table4.draw();
        game.add(table4);
    }

    public void drawBoard() {
        drawKitchen();
        drawTables();
    }


}

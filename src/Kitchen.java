import java.awt.*;

public class Kitchen {
    private Game game;

    public Kitchen(Game game) {
        this.game = game;
    }

    public void draw() {
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
        //game.getWindow().line(20, 70, 20, 20);
    }
}

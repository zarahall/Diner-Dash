
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

    public static void main(String[] args){
        Game game = new Game();
        game.window.show();

    }




}

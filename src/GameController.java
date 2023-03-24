import java.util.Scanner;

public class GameController {

    private Player challenger;
    private Player opponent;
    private Board board;

    public GameController(DiscordUser challenger, DiscordUser opponent, Deck c_deck, Deck o_deck){
        this.challenger = new Player(c_deck, challenger);
        this.opponent = new Player(o_deck, opponent);
        this.board = new Board(this.challenger, this.opponent);
    }

    public void start(){
        System.out.println("Game start:");
        System.out.println("Drawing one card for each player");
        challenger.drawTo(1);
        opponent.drawTo(1);
        while(!board.isGame_over()){
            board.takeTurn(challenger, opponent);
            board.abortGame();
        }
    }
}

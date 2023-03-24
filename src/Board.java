import java.util.Locale;
import java.util.Scanner;
public class Board {

    private Player p1;
    private Player p2;
    private int gamestate = 0; //0 for diplomacy, 1 for combat
    private boolean game_over = false;

    public Board(Player p1, Player p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public void takeTurn(Player p){
        p.printHand();
        Scanner scnr = new Scanner(System.in);

    }

    /*public void p1Play(){

        int handPos = 1; //TODO: implement connection with bot for player input
        Card c = p1.play(handPos);

        if(c instanceof Event){
            c.ability(p1, p2);
            p1.discard(c);
            return;
        }else if(c.getAbilityType().equals(AType.on_play)){
            c.ability(p1, p2);
        }

        for(int i = 0; i < 5; i++){
            if(p1.warriors_board[i] == null){
                p1.warriors_board[i] = c;
            }
        }

        checkEndGame();
    } */

    private void parseCommand(String command){
        if(command.toLowerCase().equals("draw")){

        }
    }

    public int flipGameState(){
        if(gamestate == 0) {
            gamestate = 1;
            return gamestate;
        }
        gamestate = 0;
        return gamestate;
    }

    public boolean isGame_over(){
        return game_over;
    }
    public void checkEndGame(){
        if(p1.getHP() <= 0 || p2.getHP() <= 0){
            game_over = true;
        }
    }

    public void abortGame() {
        game_over = true;
    }
}

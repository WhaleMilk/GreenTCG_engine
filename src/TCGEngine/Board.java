package TCGEngine;

import java.util.Locale;
import java.util.Scanner;
import java.util.Dictionary;
import java.util.Hashtable;
import cards.*;
public class Board {

    private Player p1;
    private Player p2;
    private int gamestate = 0; //0 for diplomacy, 1 for combat
    private boolean game_over = false;

    public Board(Player p1, Player p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public void takeTurn(Player p, Player o){
        p.printHand();
        Scanner scnr = new Scanner(System.in);
        System.out.println("Waiting for command: {command, use number 1, use number 2}");
        String command = scnr.nextLine();

        Hashtable<String, String> header = parseHeader(command);

        while(!header.get("command").equals("pass")) {
            switch(header.get("command")){
                case "play":
                    Card c = p.play(Integer.parseInt(header.get("use1")));

                    if(c instanceof Event){
                        playEvent(c, p, o);
                    } else if(c instanceof FlairWarrior){
                        playFW(c, p, o);
                    }
                    break;
                case "combat":
                    flipGameState();
                    break;
                case "ability":
                    String where = header.get("use1");
                    if(where.equals("warrior")){
                        if(p.warriors_board[Integer.parseInt(header.get("use2"))].getAbilityType() == AType.none){break;}
                        p.warriors_board[Integer.parseInt(header.get("use2"))].ability(p, o);
                    } else if(where.equals("battle")) {
                        p.battles_board.get(Integer.parseInt(header.get("use2"))).ability(p, o);
                    }
                    break;
            }
            checkEndGame();
            p.printHand();
            System.out.println("Waiting for command: ");
            command = scnr.nextLine();
            header = parseHeader(command);
        }

    }

    private void playEvent(Card c, Player p, Player o){
        c.ability(p, o);
        p.discard(c);
    }

    private boolean playFW(Card c, Player p, Player o){
        if (c.getAbilityType() == AType.on_play) c.ability(p, o);

        for(int i = 0; i < 5; i++){
            if(p1.warriors_board[i] == null) {
                p1.warriors_board[i] = c;
                return true;
            }
        }
        return false;
    }

    private boolean useAbility(Card c, Player p, Player o){
        return false;
    }

    //obsolete method that is being scavenged for parts in takeTurn()
    /*public void p1Play(){

        int handPos = 1;
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

    private Hashtable<String, String> parseHeader(String command){
        Hashtable<String, String> header = new Hashtable<String, String>();
        Scanner commandScnr = new Scanner(command);

        header.put("command", commandScnr.next().toLowerCase());
        if(commandScnr.hasNext()) header.put("use1", commandScnr.next());
        if(commandScnr.hasNext())  header.put("use2", commandScnr.next());
        if(commandScnr.hasNext()) header.put("use3", commandScnr.next());
        if(commandScnr.hasNext()) header.put("use4", commandScnr.next());
        return header;
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


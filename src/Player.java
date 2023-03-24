import java.util.ArrayList;

public class Player {

    public Card[] warriors_board = new Card[5];
    public ArrayList<Card> battles_board = new ArrayList<>();
    private Deck deck;
    private DiscordUser user;
    private ArrayList<Card> hand;
    private int player_hp = 20;

    public Player(Deck deck, DiscordUser user) {
        this.deck = deck;
        this.user = user;
        hand = new ArrayList<>();
    }

    public int getHP(){
        return player_hp;
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public ArrayList<Card> getBattles_board(){
        return battles_board;
    }

    public Card[] getWarriors_board(){
        return warriors_board;
    }

    public void drawTo(int count){
        for(int i = 0; i < count; i++){
            hand.add(deck.draw());
        }
    }

    public void discard(int handNum){
        deck.discard(hand.get(handNum));
        hand.remove(handNum);
    }

    public void discard(Card c){
        deck.discard(c);
    }

    public Card play(int handPos){
        Card c = hand.get(handPos);
        hand.remove(handPos);

        return c;
    }

    public void printHand(){
        for(Card c : hand){
            System.out.print("Name: " + c.getname() + "\nAbility:" + c.getAbilityText() + "\n");
        }
    }
}

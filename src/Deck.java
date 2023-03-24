import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Deck {

    Deque<Card> deck;
    ArrayList<Card> graveyard = new ArrayList<Card>();

    public Deck(Deque<Card> deck){
        this.deck = deck;
    }

    public void shuffle(){
        if(deck.peek() == null){ return; }

        List<Card> list = new ArrayList<Card>(deck.size());
        Deque<Card> newDeck;

        while(deck.peek() != null){
            list.add(deck.remove());
        }

        Collections.shuffle(list);
        newDeck = new ArrayDeque<Card>(list);
        this.deck = newDeck;
    }

    public void mill(int count){
        for(int i = 0; i < count; i++){
            if(deck.peek() != null){ return; }
            graveyard.add(deck.remove());
        }
    }

    public void addBottom(Card[] cards){
        for(Card c : cards){
            deck.addLast(c);
        }
    }

    public void addTop(Card[] cards){
        for(Card c : cards){
            deck.addFirst(c);
        }
    }

    public Card draw(){
        return deck.remove();
    }

    public void discard(Card c){
        graveyard.add(c);
    }
}

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Card PoG = new PotOfGreen("url", 001);

        DiscordUser c = new DiscordUser("01", 12345, "01", false);
        DiscordUser o = new DiscordUser("02", 23456, "02", false);

        Deque<Card> deque_c = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            deque_c.add(new PotOfGreen("dumburl", i));
        }
        Deck d_c = new Deck(deque_c);
        Deck d_o = new Deck(deque_c);

        GameController controller = new GameController(c, o, d_c, d_o);
        controller.start();
    }
}

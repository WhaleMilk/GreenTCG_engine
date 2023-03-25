package cards;
import TCGEngine.*;

import java.util.ArrayList;

public class PotOfGreen extends Event {

    public PotOfGreen(int id) {
        super("Pot Of Green", id);
        ability_text = "Event: Draw two cards.";
    }

    @Override
    public void ability(Player owner, Player opponent) {
        owner.drawTo(2);
        System.out.println("Drawing two cards");
    }
}


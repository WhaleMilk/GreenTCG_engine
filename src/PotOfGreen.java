import java.util.ArrayList;

public class PotOfGreen extends Event{

    public PotOfGreen(String img, int id) {
        super("Pot Of Green", img, id);
        ability_text = "Event: Draw two cards.";
    }

    @Override
    public void ability(Player owner, Player opponent) {
        owner.drawTo(2);
    }
}

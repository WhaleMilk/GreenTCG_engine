package cards;
import TCGEngine.*;

public class Spectre extends FlairWarrior{
    String abilityName = "get fucked";
    public Spectre(int id){
        super("Spectre", id, AType.on_play, 3, 3);
    }

    @Override
    public void ability(Player p1, Player p2){
        p1.nukeHand();
        p1.drawTo(7);
        p2.nukeHand();
        p1.drawTo(7);
    }
}

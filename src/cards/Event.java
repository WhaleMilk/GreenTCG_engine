package cards;
import TCGEngine.*;

public abstract class Event extends Card {


    public Event(String name, int id){
        super(name, id, AType.on_play);
    }
    public abstract void ability(Player owner, Player opponent);

}

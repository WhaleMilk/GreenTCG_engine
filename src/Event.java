public abstract class Event extends Card{


    public Event(String name, String img, int id){
        super(name, img, id, AType.on_play);
    }
    public abstract void ability(Player owner, Player opponent);

}

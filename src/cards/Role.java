package cards;
import TCGEngine.*;

public abstract class Role extends Card{
    FlairWarrior target = null;
    public Role(String name, int id, FlairWarrior target){
        super(name, id, AType.passive);
        this.target = target;
        target.addRole(this);
    }

    public void removeTarget(){
        target = null;
    }

    public abstract void attachTo(FlairWarrior flairWarrior);
    public abstract void ability(Player p1, Player p2);
}

package cards;

import TCGEngine.Player;

public class Muted extends Role{

    AType default_type;
    public Muted(int id, FlairWarrior target){
        super("Muted", id, target);
        default_type = target.getAbilityType();
        ability();
    }

    @Override
    public void removeTarget(){
        target.setAType(default_type);
        target = null;
    }

    @Override
    public void attachTo(FlairWarrior flairWarrior) {
        removeTarget();
        target = flairWarrior;
        ability();
    }

    @Override
    public void ability(Player p1, Player p2) {
        return;
    }

    public void ability(){
        target.setAType(AType.none);
    }
}

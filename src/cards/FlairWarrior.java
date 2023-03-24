package cards;
import TCGEngine.*;
public abstract class FlairWarrior extends Card {
    private int hp;
    private int atk;

    public FlairWarrior(String name, String img, int id, AType type, int hp, int atk){
        super(name, img, id, type);
        this.hp = hp;
        this.atk = atk;
    }

    public abstract void ability(Player p1, Player p2);
}


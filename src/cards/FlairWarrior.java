package cards;
import TCGEngine.*;

import java.util.ArrayList;

public abstract class FlairWarrior extends Card {
    private int hp;
    private int atk;
    private ArrayList<Role> roles = new ArrayList<>();

    public FlairWarrior(String name, int id, AType type, int hp, int atk){
        super(name, id, type);
        this.hp = hp;
        this.atk = atk;
    }

    public ArrayList<Role> getRoles(){
        return this.roles;
    }
    public void addRole(Role role){
        roles.add(role);
    }

    public void setAType(AType type){
        this.type = type;
    }
    public abstract void ability(Player p1, Player p2);
}


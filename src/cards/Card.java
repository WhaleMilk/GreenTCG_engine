package cards;

import TCGEngine.Player;

public abstract class Card{
    String name;
    String img;
    int id;
    AType type; //an enum to determine when and how a cards ability can be activated

    String ability_text;
    public Card(String name, String img, int id, AType type){
        this.name = name;
        this.img = img;
        this.id = id; //idk why each card would have an ID but it's here just in case
        this.type = type;
    }

    public String getimg(){ return img; }

    public int getid(){ return id; }

    public String getname(){ return name; }

    public AType getAbilityType(){ return type; }

    public String getAbilityText(){ return ability_text; }

    public abstract void ability(Player owner, Player opponent);

}


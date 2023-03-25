package cards;
import TCGEngine.*;
import java.util.Random;

public class Let extends FlairWarrior{
    String ability_name = "Mass Ping";
    String attribute_name = "UwU";

    public Let(int id) {super("Let", id, AType.on_activation, 2, 3); }

    public void ability(Player p1, Player p2){
        Random random = new Random();

        int num = random.nextInt(0,2);

        for(int i = 0; i < 2; i++){
            if(num == 0){
                num = random.nextInt(0,5);
                while(p1.warriors_board[num] ==null){
                    num = random.nextInt(0,5);
                }
                p1.warriors_board[num] = null;
            } else if(num == 0){
                num = random.nextInt(0,5);
                while(p2.warriors_board[num] == null){
                    num = random.nextInt(0,5);
                }
                p2.warriors_board[num] = null;
            }
        }

        Muted mute = new Muted(002, this);
    }
}


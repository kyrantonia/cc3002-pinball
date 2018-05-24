package logic.bonus;

import controller.Game;

public class JackPotBonus extends AbstractBonus {

    private static JackPotBonus instance;
    int timesTriggered;
    private JackPotBonus(){
        super();
    }
    public static JackPotBonus getInstance(){
        if(instance==null){
            instance= new JackPotBonus();
        }
        return instance;
    }

    @Override
    public void trigger(Game game) {
        Game.getInstance().increaseScore(100000);
    }
}

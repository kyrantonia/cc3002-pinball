package logic.bonus;

import controller.Game;

public class ExtraBallBonus extends AbstractBonus {
    private static ExtraBallBonus instance;
    int timesTriggered;
    private ExtraBallBonus(){
        super();
    }
    public static ExtraBallBonus getInstance(){
        if(instance==null){
            instance= new ExtraBallBonus();
        }
        return instance;

    }

    @Override
    public void trigger(Game game) {
        Game.getInstance().increaseNumberOfBalls(1);
    }
}

package logic.bonus;

import controller.Game;
import logic.gameelements.bumper.Bumper;

public class DropTargetBonus extends AbstractBonus{
    private static DropTargetBonus instance;
    int timesTriggered;
    private DropTargetBonus(){
        super();
    }
    public static DropTargetBonus getInstance(){
        if(instance==null){
            instance= new DropTargetBonus();
        }
        return instance;

    }

    @Override
    public void trigger(Game game) {
        Game.getInstance().increaseScore(1000000);
        Game.getInstance().getTable().upgradeAllBumpers();
        increaseTimesTriggered();
    }
}

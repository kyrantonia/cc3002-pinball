package logic.bonus;

import controller.Game;
import logic.gameelements.bumper.Bumper;
import logic.table.Table;
import logic.table.Visitor;

public class DropTargetBonus extends AbstractBonus{
    @Override
    public void trigger(Game game) {
        Game.getInstance().increaseScore(1000000);
        Game.getInstance().getTable().upgradeAllBumpers();
        increaseTimesTriggered();
    }

    public void accept(Visitor visitor) {
        visitor.visitDropTargetBonus(this);
    }

}

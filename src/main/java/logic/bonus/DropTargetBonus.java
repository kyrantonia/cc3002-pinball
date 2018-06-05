package logic.bonus;

import controller.Game;
import logic.table.Visitor;

public class DropTargetBonus extends AbstractBonus{
    @Override
    public void trigger(Game game) {
        game.increaseScore(1000000);
        game.getTable().upgradeAllBumpers();
        increaseTimesTriggered();
    }

    public void accept(Visitor visitor) {
        visitor.visitDropTargetBonus(this);
    }

}

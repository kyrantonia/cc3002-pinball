package logic.bonus;

import controller.Game;
import logic.table.Visitor;

public class ExtraBallBonus extends AbstractBonus {

    @Override
    public void trigger(Game game) {
        game.increaseNumberOfBalls(1);
        increaseTimesTriggered();
    }
    public void accept(Visitor visitor) {
        visitor.visitExtraBallBonus(this);
    }
}

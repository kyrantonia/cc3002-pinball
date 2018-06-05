package logic.bonus;

import controller.Game;
import logic.table.Visitor;

/**
 * Bonus que se puede obtener cuando un bumper hace upgrade o al pegrale a un DropTarget
 * aaumenta el número de pelotas en el juego
 * @author Kyra
 */
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

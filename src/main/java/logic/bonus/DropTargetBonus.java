package logic.bonus;

import controller.Game;
import logic.table.Visitor;

/**
 * Bonus que se obtiene cuando se golpean todos los dropTargets
 * aumenta el puntaje en un millón y hace upgrade a todos los bumpers de la mesa
 */
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

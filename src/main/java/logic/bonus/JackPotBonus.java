package logic.bonus;

import controller.Game;
import logic.table.Visitor;

/**
 * Se obtiene al golpear a un spotTarget
 * aumenta el puntaje del juego en cien mil puntos
 * @author Kyra
 */
public class JackPotBonus extends AbstractBonus {

    @Override
    public void trigger(Game game) {
        Game.getInstance().increaseScore(100000);
        increaseTimesTriggered();
    }
    public void accept(Visitor visitor) {
        visitor.visitJackPotBonus(this);
    }
}

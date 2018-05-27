package logic.gameelements.target;


import controller.Game;
import logic.bonus.Bonus;
import logic.bonus.JackPotBonus;

public class SpotTarget extends AbstractTarget {

    public SpotTarget() {
        super(0, Game.getInstance().getJackPotBonus());
    }

}

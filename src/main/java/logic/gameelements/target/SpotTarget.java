package logic.gameelements.target;


import controller.Game;

public class SpotTarget extends AbstractTarget {

    public SpotTarget() {
        super(0, Game.getInstance().getJackPotBonus(),1);
    }

}

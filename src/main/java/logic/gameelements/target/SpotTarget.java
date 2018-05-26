package logic.gameelements.target;


import controller.Game;

public class SpotTarget extends AbstractTarget {

    public SpotTarget() {
        super(0);
    }

    @Override
    public void invokeBonus(){
        Game.getInstance().getJackPotBonus().trigger(Game.getInstance());
    }
}

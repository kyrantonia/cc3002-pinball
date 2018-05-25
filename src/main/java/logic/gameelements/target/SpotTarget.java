package logic.gameelements.target;


import controller.Game;
import controller.Visitor;

public class SpotTarget extends AbstractTarget {

    public SpotTarget() {
        super(0);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSpotTarget(this);
    }
    protected void invokeBonus(){
        Game.getInstance().getJackPotBonus().trigger(Game.getInstance());
    }
}

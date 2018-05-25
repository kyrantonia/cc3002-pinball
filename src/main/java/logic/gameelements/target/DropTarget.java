package logic.gameelements.target;

import controller.Game;
import controller.Visitor;

public class DropTarget extends AbstractTarget {

    public DropTarget() {
        super(100);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitDropTarget(this);
    }

    protected void invokeBonus(){
        Game.getInstance().getDropTargetBonus().trigger(Game.getInstance());
    }
}

package logic.gameelements.target;

import controller.Game;

public class DropTarget extends AbstractTarget {

    public DropTarget() {
        super(100);
    }

    @Override
    public void invokeBonus(){
        Game.getInstance().getDropTargetBonus().trigger(Game.getInstance());
    }
}

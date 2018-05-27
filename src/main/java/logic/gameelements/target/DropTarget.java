package logic.gameelements.target;
import controller.Game;
import logic.bonus.DropTargetBonus;

public class DropTarget extends AbstractTarget {

    public DropTarget() {
        super(100, Game.getInstance().getExtraBallBonus());
    }

    @Override
    public void deactivate() {
        super.deactivate();
        setChanged();
        notifyObservers(Game.getInstance().getDropTargetBonus());
    }

    @Override
    public void resetDropTargets() {
        super.reset();
    }
}

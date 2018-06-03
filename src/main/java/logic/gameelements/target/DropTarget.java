package logic.gameelements.target;
import controller.Game;

public class DropTarget extends AbstractTarget {

    public DropTarget() {
        super(100, Game.getInstance().getExtraBallBonus(),0.3);
    }

    @Override
    public void deactivate() {
        super.deactivate();
        setChanged();
        notifyObservers(Game.getInstance().getDropTargetBonus());
    }

    public void resetDropTargets() {
        super.reset();
    }
}

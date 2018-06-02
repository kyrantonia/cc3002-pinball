package logic.gameelements.target;
import controller.Game;

public class DropTarget extends AbstractTarget {

    public DropTarget() {
        super(100, Game.getInstance().getExtraBallBonus());
    }

    @Override
    public void deactivate() {
        super.deactivate();
        if (Game.getInstance().getARandomNumber()<0.3){
            setChanged();
            notifyObservers(Game.getInstance().getDropTargetBonus());
        }
    }

    public void resetDropTargets() {
        super.reset();
    }
}

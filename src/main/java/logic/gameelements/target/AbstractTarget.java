package logic.gameelements.target;

import controller.Game;
import logic.gameelements.AbstractHittable;
import logic.table.Visitor;

abstract public class AbstractTarget extends AbstractHittable implements Target {
    private boolean isActive;
    AbstractTarget(int score) {
        super(score);
        this.isActive=true;
    }
    @Override
    public int hit() {
        int increment=0;
        if (isActive()){
            increment=this.getScore();
            setChanged();
            notifyObservers(increment);
        }
        return increment;
    }
    public int hit1() {
        int increment=0;
        if (isActive()){
            increment=this.getScore();
            Game.getInstance().increaseScore(increment);
            setChanged();
            notifyObservers(this);
            invokeBonus();
            deactivate();
        }
        return increment;
    }


    public void deactivate(){
        this.isActive=false;
    }
    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void reset() {
        this.isActive=true;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTarget(this);
    }

}

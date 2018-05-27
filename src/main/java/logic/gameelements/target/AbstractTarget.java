package logic.gameelements.target;

import controller.Game;
import logic.bonus.Bonus;
import logic.gameelements.AbstractHittable;

abstract public class AbstractTarget extends AbstractHittable implements Target {
    private boolean isActive;
    AbstractTarget(int score,Bonus bonus) {
        super(score, bonus);
        this.isActive=true;
    }
    @Override
    public int hit() {
        int increment=0;
        if (isActive()){
            increment=this.getScore();
            this.deactivate();
            setChanged();
            notifyObservers(getBonus());
        }
        Game.getInstance().increaseScore(increment);
        return increment;
    }

    public void deactivate(){
        this.isActive=false;
    }
    @Override
    public boolean isActive() {
        return this.isActive;
    }
    public void reset(){
        this.isActive=true;
    }
    @Override
    public void resetDropTargets() {
    }

}

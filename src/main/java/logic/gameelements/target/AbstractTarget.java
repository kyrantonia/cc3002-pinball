package logic.gameelements.target;

import controller.Game;
import logic.gameelements.AbstractHittable;
import logic.gameelements.GameElement;

abstract public class AbstractTarget extends AbstractHittable implements Target,GameElement {
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
            Game.getInstance().increaseScore(increment);
            setChanged();
            notifyObservers();
            invokeBonus();
            deactivate();
        }
        return increment;
    }

    protected abstract void invokeBonus();

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

}

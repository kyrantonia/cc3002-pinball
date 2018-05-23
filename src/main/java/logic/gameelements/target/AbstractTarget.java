package logic.gameelements.target;

import controller.Game;
import logic.gameelements.AbstractHittable;

abstract public class AbstractTarget extends AbstractHittable implements Target {
    private boolean isActive;
    AbstractTarget(int score) {
        super(score);
        this.isActive=true;
    }
    @Override
    public int hit() {
        int increment=this.getScore();
        Game.getInstance().increaseScore(increment);
        return increment;
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

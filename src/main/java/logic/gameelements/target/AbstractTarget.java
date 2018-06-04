package logic.gameelements.target;

import controller.Game;
import logic.bonus.Bonus;
import logic.gameelements.AbstractHittable;

abstract public class AbstractTarget extends AbstractHittable implements Target {
    private boolean isActive;
    private double prob;
    AbstractTarget(int score,Bonus bonus, double prob) {
        super(score, bonus);
        this.isActive=true;
        this.prob=prob;
    }
    @Override
    public int hit() {
        int increment=this.getScore();
        if (isActive()){
            this.deactivate();
            if(Game.getInstance().getARandomNumber()< this.prob)
                setChanged();
                notifyObservers(getBonus());
        }
        Game.getInstance().increaseScore(increment);
        return increment;
    }

    public void deactivate(){
        this.isActive = false;
        this.score = 0;
    }
    @Override
    public boolean isActive() {
        return this.isActive;
    }
    public void reset(){
        this.isActive = true;
        this.score = defaultScore;
    }
    public void resetDropTarget() {
    }

}

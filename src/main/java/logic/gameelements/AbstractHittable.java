package logic.gameelements;
import controller.Game;
import logic.bonus.Bonus;

import java.util.Observable;

public abstract class AbstractHittable extends Observable implements Hittable {
    protected int score;
    protected Bonus bonus;
    protected int defaultScore;
    public  AbstractHittable(int score, Bonus bonus){
        this.score=score;
        this.bonus=bonus;
        this.defaultScore = score;
    }
    public int getScore() {
        return this.score;
    }
    public void addObserver(){
        addObserver(Game.getInstance().getTable());
    }
    public Bonus getBonus(){
        return this.bonus;
    }
}

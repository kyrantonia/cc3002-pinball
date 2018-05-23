package logic.gameelements;
import controller.Game;
import logic.table.Table;

import java.util.Observable;
public abstract class AbstractHittable extends Observable implements Hittable {
    protected int score;
    public  AbstractHittable(int score){
        this.score=score;
    }

    public int getScore() {
        return this.score;
    }
    public void addObserver(){
        addObserver(Game.getInstance().getTable());
    }


}

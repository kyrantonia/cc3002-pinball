package logic.gameelements;
import controller.Game;
import logic.Notification;
import logic.bonus.Bonus;
import logic.table.Visitor;

import java.util.Observable;

/**
 * Clase abstracta de  Hittable
 */
public abstract class AbstractHittable extends Observable implements Hittable, Notification {
    protected int score;
    protected Bonus bonus;
    public  AbstractHittable(int score, Bonus bonus){
        this.score=score;
        this.bonus=bonus;
    }
    public int getScore() {
        return this.score;
    }
    public void addObserver(){
        addObserver(Game.getInstance().getTable());
    }

    /**
     * Se entrega el bonus que se obtiene cuando se mejoran los bumper o al golpear un target
     * según correponda
     * @return Bonus que se obtiene cuando se mejoran los bumper o al golpear un target
     * según correponda
     */
    public Bonus getBonus(){
        return this.bonus;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visitHittable( this);
    }
}

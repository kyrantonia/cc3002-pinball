package logic.bonus;

import logic.Notification;

/**
 * Clase abstracta que representa a los Bonus del juego
 * @author Kyra
 */
abstract public class AbstractBonus implements Bonus, Notification {
    int timesTriggered;
     AbstractBonus(){
        this.timesTriggered=0;
    }
    @Override
    public int timesTriggered() {
        return this.timesTriggered;
    }

    public void increaseTimesTriggered(){
        this.timesTriggered += 1;
    }




}

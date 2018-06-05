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

    /**
     * Aumento en uno las veces que se ejecuta el método trigger en un bumper
     */
    public void increaseTimesTriggered(){
        this.timesTriggered += 1;
    }




}

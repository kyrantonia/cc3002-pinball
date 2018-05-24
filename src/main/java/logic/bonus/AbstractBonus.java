package logic.bonus;

import controller.Game;


abstract public class AbstractBonus implements Bonus {
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
    @Override
    public void trigger(Game game) {

    }



}

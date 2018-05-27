package logic.bonus;

import controller.Game;
import logic.table.Visitor;


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




}

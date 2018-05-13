package logic.table;

import logic.gameelements.bumper.Bumper;
import logic.gameelements.target.Target;

import java.util.List;

public class ConcreteTable implements logic.table.Table {
    private String name;
    ConcreteTable(String name){
        this.name=name;
    }
    @Override
    public String getTableName() {
        return name;
    }

    @Override
    public int getNumberOfDropTargets() {
        return 0;
    }

    @Override
    public int getCurrentlyDroppedDropTargets() {
        return 0;
    }

    @Override
    public List<Bumper> getBumpers() {
        return null;
    }

    @Override
    public List<Target> getTargets() {
        return null;
    }

    @Override
    public void resetDropTargets() {

    }

    @Override
    public void upgradeAllBumpers() {

    }

    @Override
    public boolean isPlayableTable() {
        return false;
    }


}

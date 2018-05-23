package logic.table;

import controller.Game;
import logic.gameelements.ConcreteHittableFactory;
import logic.gameelements.Hittable;
import logic.gameelements.HittableFactory;
import logic.gameelements.bumper.Bumper;
import logic.gameelements.bumper.KickerBumper;
import logic.gameelements.target.Target;
import java.util.Observable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTable extends Observable implements logic.table.Table {
    ArrayList<Bumper> bumpers;
    ArrayList<Target> targets;
    String name;
    int numberOfBumpers;
    double prob;
    int numberOfSpotTargets;
    int numberOfDropTargets;
    HittableFactory hittableFactory;



    public AbstractTable(String name, int numberOfBumpers, double prob, int numberOfSpotTargets, int numberOfDropTargets){
        this.name=name;
        this.numberOfBumpers=numberOfBumpers;
        this.prob=prob;
        this.bumpers=new ArrayList<Bumper>();
        this.targets=new ArrayList<Target>();
        this.numberOfSpotTargets=numberOfSpotTargets;
        this.numberOfDropTargets=numberOfDropTargets;
        this.hittableFactory=new ConcreteHittableFactory();
    }
    int getNumberOfBumpers(){
        return this.numberOfBumpers;
    }
    double getProb(){
        return this.prob;
    }
    int getNumberOfPopBumper(){
        return (int) (getNumberOfBumpers()*getProb());
    }
    int getNumberOfKickerBumper(){
        return getNumberOfBumpers()-getNumberOfPopBumper();
    }

    void createHittablesOnTable() {
        for(int i=0;i<getNumberOfKickerBumper();i++){
            bumpers.add(hittableFactory.createKickerBumper());
        }
        for(int i=0;i<getNumberOfPopBumper();i++){
            bumpers.add(hittableFactory.createPopBumper());
        }
        for(int i=0;i<numberOfSpotTargets;i++){
            targets.add(hittableFactory.createSpotTarget());
        }
        for(int i=0;i<numberOfDropTargets;i++){
            targets.add(hittableFactory.createDropTarget());
        }
    }
    @Override
    public String getTableName() {
        return name;
    }

    @Override
    public int getNumberOfDropTargets() {
        return numberOfDropTargets;
    }

    @Override
    public int getCurrentlyDroppedDropTargets() {
        return 0;
    }

    @Override
    public List<Bumper> getBumpers() {
        return bumpers;
    }

    @Override
    public List<Target> getTargets() {
        return targets;
    }

    @Override
    public void resetDropTargets() {

    }

    @Override
    public void upgradeAllBumpers() {

    }
    @Override
    public void update(Observable observable, Object o) {
        System.out.println("me notificaron soy table "+o+" "+observable);
        setChanged();
        notifyObservers();
    }

    @Override
    public boolean isPlayableTable() {
        return false;
    }
    public void addObserver(){
        addObserver(Game.getInstance());
    }
}

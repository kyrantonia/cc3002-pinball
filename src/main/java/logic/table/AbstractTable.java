package logic.table;

import controller.Game;
import logic.bonus.Bonus;
import logic.bonus.DropTargetBonus;
import logic.bonus.ExtraBallBonus;
import logic.bonus.JackPotBonus;
import logic.gameelements.ConcreteHittableFactory;
import logic.gameelements.HittableFactory;
import logic.gameelements.bumper.Bumper;
import logic.gameelements.target.DropTarget;
import logic.gameelements.target.Target;
import java.util.Observable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTable implements Table,Visitor {
    private boolean activeDropTargetBonus;
    ArrayList<Bumper> bumpers;
    ArrayList<Target> targets;
    ArrayList<DropTarget> dropTargets;
    String name;
    int numberOfBumpers;
    double prob;
    int numberOfSpotTargets;
    int numberOfDropTargets;
    HittableFactory hittableFactory;
    boolean isPlayable;
    int currentlyDroppedDropTargets;


    public AbstractTable(String name, int numberOfBumpers, double prob, int numberOfSpotTargets, int numberOfDropTargets){
        this.name=name;
        this.numberOfBumpers=numberOfBumpers;
        this.prob=prob;
        this.bumpers=new ArrayList<Bumper>();
        this.targets=new ArrayList<Target>();
        this.numberOfSpotTargets=numberOfSpotTargets;
        this.numberOfDropTargets=numberOfDropTargets;
        this.hittableFactory=new ConcreteHittableFactory();
        this.currentlyDroppedDropTargets =0;
    }
    void resetCurrentlyDroppedTargets(){
        this.currentlyDroppedDropTargets =0;
    }
    int getNumberOfBumpers(){
        return this.numberOfBumpers;
    }
    double getProb(){
        return this.prob;
    }


    @Override
    public String getTableName() {
        return name;
    }

    @Override
    public int getNumberOfDropTargets() {
        return numberOfDropTargets;
    }
    public int getNumberOfSpotTargets() {
        return numberOfSpotTargets;
    }

    @Override
    public int getCurrentlyDroppedDropTargets() {
        return this.currentlyDroppedDropTargets;
    }
    public void increaseCurrentlyDroppedDropTargets(int increase){
        this.currentlyDroppedDropTargets += increase;
    }
    public int remainingHitsToDropTargetBonus(){
        return Math.max(getNumberOfDropTargets()-getCurrentlyDroppedDropTargets(),0);
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
        for(Target target: this.getTargets()){
            target.resetDropTargets();
        }
        resetCurrentlyDroppedTargets();
    }

    @Override
    public void upgradeAllBumpers() {
        for(Bumper bumper: this.getBumpers()){
            bumper.upgrade();
        }
    }
    @Override
    public void update(Observable observable, Object o) {
        //System.out.println("me notificaron soy table "+o+" "+observable);
        ((Bonus)o).accept(this);
        //setChanged();
        //notifyObservers();
    }

    @Override
    public boolean isPlayableTable() {
        return isPlayable;
    }

    @Override
    public void visitDropTargetBonus(DropTargetBonus dropTargetBonus) {
        this.increaseCurrentlyDroppedDropTargets(1);
        if(remainingHitsToDropTargetBonus() == 0){
            dropTargetBonus.trigger(Game.getInstance());
        }
    }

    @Override
    public void visitExtraBallBonus(ExtraBallBonus extraBallBonus) {
        extraBallBonus.trigger(Game.getInstance());
    }

    @Override
    public void visitJackPotBonus(JackPotBonus jackPotBonus) {
            jackPotBonus.trigger(Game.getInstance());
    }

}

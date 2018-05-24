package controller;

import logic.bonus.Bonus;
import logic.bonus.DropTargetBonus;
import logic.bonus.ExtraBallBonus;
import logic.bonus.JackPotBonus;
import logic.gameelements.bumper.Bumper;
import logic.gameelements.target.Target;
import logic.table.FullPlayableTable;
import logic.table.Table;
import logic.table.NullTable;

import java.util.Observable;
import java.util.Observer;

/**
 * Game logic controller class.
 *
 * @author Juan-Pablo Silva
 */
public class Game implements Observer {
    private int currentScore;
    private int numberOfBalls;
    private Bonus JackPotBonus;
    private Bonus ExtraBallBonus;
    private Bonus DropTargetBonus;
    private static Game uniqueInstance;
    private Table table;
    private Game()  {
        this.currentScore = 0;
        this.numberOfBalls = 5;
        table =new NullTable();
    }

    public Bonus getJackPotBonus() {
        return JackPotBonus;
    }

    public Bonus getDropTargetBonus() {
        return DropTargetBonus;
    }

    public Bonus getExtraBallBonus() {
        return ExtraBallBonus;
    }

    public static Game getInstance(){
        if(uniqueInstance==null){
            uniqueInstance=new Game();
        }
        return uniqueInstance;
    }
    public int getCurrentScore() {
        return this.currentScore;

    }
    public void setTable(Table table){
        this.table =table;
        addObserverBumper();
        addObseverTarget();
        getTable().addObserver();

    }
    public void addObserverBumper(){
        for(Bumper b: Game.getInstance().table.getBumpers()){
            b.addObserver();
        }
    }
    public void addObseverTarget(){
        for(Target t: Game.getInstance().table.getTargets()){
            t.addObserver();
        }
    }
    public Table getTable() {
        return table;
    }


    public int getNumberOfBalls() {
        return numberOfBalls;
    }

    public void increaseNumberOfBalls(int increment) {
        this.numberOfBalls += increment;
    }

    public void increaseScore(int increment){
        this.currentScore += increment;
    }

    @Override
    public void update(Observable observable, Object o) {
        System.out.printf("me notificaron soy game "+ observable+" "+o);

    }

    public static void main(String[] args) {
        Game.getInstance();
        Game.getInstance().setTable(new FullPlayableTable("mesa",6,0,1,1));
        for(Bumper b: Game.getInstance().table.getBumpers()){
            b.hit();
            System.out.println(Game.getInstance().getCurrentScore());
        }
        Bumper bumper=Game.getInstance().table.getBumpers().get(1);
        for(int i=0;i<6;i++){
            bumper.hit();
        }
        for(Target target: Game.getInstance().table.getTargets()){
            target.hit();
            System.out.println(Game.getInstance().getCurrentScore());
        }

    }

}

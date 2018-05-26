package controller;

import logic.bonus.DropTargetBonus;
import logic.bonus.ExtraBallBonus;
import logic.bonus.JackPotBonus;
import logic.gameelements.Hittable;
import logic.gameelements.bumper.Bumper;
import logic.gameelements.target.Target;
import logic.table.FullPlayableTable;
import logic.table.Table;
import logic.table.NullTable;

/**
 * Game logic controller class.
 *
 * @author Juan-Pablo Silva
 */
public class Game {
    private int currentScore;
    private int numberOfBalls;
    private JackPotBonus JackPotBonus;
    private ExtraBallBonus ExtraBallBonus;
    private DropTargetBonus DropTargetBonus;
    private static Game uniqueInstance;
    private Table table;
    private Game()  {
        this.currentScore = 0;
        this.numberOfBalls = 5;
        table =new NullTable();
    }

    public JackPotBonus getJackPotBonus() {
        System.out.printf("JackPotBonus");
        return JackPotBonus.getInstance();
    }

    public DropTargetBonus getDropTargetBonus() {
        System.out.printf("DropTargetBonus");
        return DropTargetBonus.getInstance();
    }

    public ExtraBallBonus getExtraBallBonus() {
        System.out.printf("Extra Ball Bonus");
        return ExtraBallBonus.getInstance();
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

package controller;

import logic.bonus.Bonus;
import logic.bonus.DropTargetBonus;
import logic.bonus.ExtraBallBonus;
import logic.bonus.JackPotBonus;
import logic.gameelements.bumper.Bumper;
import logic.gameelements.target.Target;
import logic.table.NullTable;
import logic.table.Table;

import java.util.Random;

/**
 * Game logic controller class.
 *
 * @author Juan-Pablo Silva
 */
public class Game {
    private int currentScore;
    private int numberOfBalls;
    private Bonus JackPotBonus;
    private Bonus ExtraBallBonus;
    private Bonus DropTargetBonus;
    private static Game uniqueInstance;
    private Table table;
    private Random random;
    private boolean gameOver;
    private Game()  {
        this.gameOver = false;
        this.currentScore = 0;
        this.numberOfBalls = 5;
        table = new NullTable();
        this.JackPotBonus = new JackPotBonus();
        this.ExtraBallBonus = new ExtraBallBonus();
        this.DropTargetBonus = new DropTargetBonus();
        this.random = new Random();

    }
    public void setRandom(long seed){
       random=new Random(seed);
    }
    public double getARandomNumber(){
        double number;
        number = this.random.nextDouble();
        return number;
    }
    public boolean gameOver() {
        if (getNumberOfBalls() == 0)
            gameOver=true;
        return gameOver;
    }

    public int dropBall(){
        this.numberOfBalls=Math.max(this.numberOfBalls-1,0);
        return getNumberOfBalls();
    }
    public Bonus getJackPotBonus() {
        return this.JackPotBonus;
    }

    public Bonus getDropTargetBonus() {
        return this.DropTargetBonus;
    }

    public Bonus getExtraBallBonus() {
        return this.ExtraBallBonus;
    }

    public static Game getInstance(){
        if(uniqueInstance==null){
            uniqueInstance=new Game();
        }
        return uniqueInstance;
    }

    public static void resetInstance(){
        uniqueInstance= null;
    }

    public int getCurrentScore() {
        return this.currentScore;

    }
    public void setTable(Table table){
        this.table = table;
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
        return this.table;
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


}

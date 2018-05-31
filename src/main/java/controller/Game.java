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
    private Game()  {
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
        boolean gameOver=false;
        if (getNumberOfBalls() == 0)
            gameOver=true;
        return gameOver;
    }

    public int dropBall(){
        this.numberOfBalls=this.numberOfBalls-1;
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


    public static void main(String[] args) {
        Game g=Game.getInstance();
        g.setTable(new FullPlayableTable("mesa",6,0,1,1));
        for(Bumper b: g.table.getBumpers()){
            b.hit();
        }
        Bumper bumper=g.table.getBumpers().get(1);
        for(int i=0;i<6;i++){
            bumper.hit();
        }
        for(Target target: g.table.getTargets()){
            target.hit();
        }

    }

}

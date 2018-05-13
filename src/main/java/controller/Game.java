package controller;

import logic.gameelements.Hittable;
import logic.gameelements.bumper.*;

/**
 * Game logic controller class.
 *
 * @author Juan-Pablo Silva
 */
public class Game {
    private int currentScore;
    private static Game uniqueInstance;

    private Game() {
        this.currentScore = 0;
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
    public void increaseScore(int increment){
        this.currentScore += increment;
    }

    public static void main(String[] args) {
        Bumper PB= new KickerBumper();
        System.out.println(PB.hit());
        System.out.println(PB.hit());
        System.out.println(PB.hit());
        System.out.println(PB.hit());
        System.out.println(PB.hit());
        System.out.println(PB.hit());
        System.out.println(Game.getInstance().currentScore);
        PB.downgrade();
        System.out.println(PB.hit());

    }

}

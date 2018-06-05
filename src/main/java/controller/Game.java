package controller;

import logic.bonus.Bonus;
import logic.bonus.DropTargetBonus;
import logic.bonus.ExtraBallBonus;
import logic.bonus.JackPotBonus;
import logic.gameelements.bumper.Bumper;
import logic.gameelements.target.Target;
import logic.table.NullTable;
import logic.table.Table;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

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

    /**
     * Entrega una instancia de game
     * @return Instancia del juego
     */
    public static Game getInstance(){
        if(uniqueInstance==null){
            uniqueInstance=new Game();
        }
        return uniqueInstance;
    }

    /** Cambia el random actual del juego por uno con un nuevo seed
     * @param seed semilla del random que se genera
     */
    public void setRandom(long seed){
       random=new Random(seed);
    }

    /**
     * Entrega un número random
     * @return número generado usando Random
     */
    public double getARandomNumber(){
        double number;
        number = this.random.nextDouble();
        return number;
    }

    /**
     * Revisa si el juego se terminó dado que no quedan bolas
     * @return retorna el estado del juego, verdadero si se terminó y verdadero si aún no termina
     */
    public boolean gameOver() {
        if (getNumberOfBalls() == 0)
            gameOver=true;
        return gameOver;
    }

    /**
     * Disminuye en uno el número de bolas del juego
     * @return el número de bolas del juego después de que este terminó
     */
    public int dropBall(){
        this.numberOfBalls=Math.max(this.numberOfBalls-1,0);
        return getNumberOfBalls();
    }

    /**
     * Se entrega el JackPotBonus actual del juego
     * @return JackPotBonus del juego
     */
    public Bonus getJackPotBonus() {
        return this.JackPotBonus;
    }

    /**
     * Se entrega el DropTargetBonus actual del juego
     * @return DropTargetBonus del juego
     */
    public Bonus getDropTargetBonus() {
        return this.DropTargetBonus;
    }

    /**
     * Se entrega el ExtraBallBonus actual del juego
     * @return ExtraBallBonus del juego
     */
    public Bonus getExtraBallBonus() {
        return this.ExtraBallBonus;
    }

    /**
     * Se hace que la instancia de juego sea null
     */
    public static void resetInstance(){
        uniqueInstance= null;
    }

    /**
     * Se devuelve el puntaje actual del juego
     * @return puntaje actual dl juego
     */
    public int getCurrentScore() {
        return this.currentScore;

    }

    /**
     * Se establece una nueva mesa para el juego
     * @param table Nueva mesa que se usará en el juego
     */

    public void setTable(Table table){
        this.table = table;
        addObserverBumper();
        addObseverTarget();
        this.table.addObserver();
    }

    /**
     * Metodo para agregar los observer a los bumpers
     */
    public void addObserverBumper(){
        for(Bumper b: Game.getInstance().table.getBumpers()){
            b.addObserver();
        }
    }
    /**
     * Metodo para agregar los observer a los targets
     */
    public void addObseverTarget(){
        for(Target t: Game.getInstance().table.getTargets()){
            t.addObserver();
        }
    }

    /**
     * Se entrega la mesa actual del juego
     * @return mesa actual del juego
     */
    public Table getTable() {
        return this.table;
    }

    /**
     * Se entrega el número actual de bolas
     * @return Número actla de bolas en el juego
     */
    public int getNumberOfBalls() {
        return numberOfBalls;
    }

    /**
     * Aumenta el número de bolas en el juego en una cantidad increment
     * @param increment Cantidad en la que se aumentará el número de bolas
     */
    public void increaseNumberOfBalls(int increment) {
        this.numberOfBalls += increment;
    }

    /**
     * Aumenta el puntaje del juego en una cantidad increment
     * @param increment Cantidad en la que se aumentará el puntaje del juego
     */
    public void increaseScore(int increment){
        this.currentScore += increment;
    }

    /**
     * Se aumenta el puntaje del juego cuando se llega una notificación
     * @param observable quien manda la notificación
     * @param o objeto mandado
     */

    @Override
    public void update(Observable observable, Object o) {
        increaseScore((Integer)o);
    }
}

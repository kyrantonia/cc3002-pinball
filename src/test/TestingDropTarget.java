import controller.Game;
import logic.gameelements.target.Target;
import logic.table.FullPlayableTable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestingDropTarget {
    private Game game;
    private Target dropTargetNotHit;
    private int gameScoreNotHit;
    private int timesTriggerEBBonusNotHit;
    private Target dropTargetHitOnce;
    private int scoreDropTargetHitOnce;
    private int gameScoreHitOnce;
    private int timesTriggerEBBonusHitOnce;
    private int numberOfBallsHitOnce;
    private Target dropTargetHitAHundredTimes;
    private int scoreDropTargetHitAHundredTimesLastHit;
    private int gameScoreHitAHundredTimesLastHit;
    private int timesTriggerEBBonusHitAHundredTimesLastHit;
    private int numberOfBallsHitAHundredTimesLastHit;
    private int scoreHitLastNotHit;
    private int gameScoreHitlastNotHit;
    private int timesTriggerDTBonusNotHit;
    private int timesTriggerDTBonusHitOnce;
    private int timesTriggerDTBonusHitAHundredTimesLastHit;
    private int numberOfBallsNotHit;
    private int numberOfBallsHitLastNotHit;
    private int timesTriggerEBBonusHitLastNotHit;
    private int timesTriggerDTBonusHitLastNotHit;
    private int scoreDropTargetHitAHundredTimesFirstHit;
    private int gameScoreHitAHundredTimesFirstHit;
    private int timesTriggerEBBonusHitAHundredTimesFirstHit;
    private int timesTriggerDTBonusHitAHundredTimesFirstHit;
    private int numberOfBallsHitAHundredTimesFirstHit;

    @After
    public void resetGame(){
        Game.resetInstance();
    }
    @Before
    public void setup(){
        game= Game.getInstance();
        game.setRandom(10);
        game.setTable(new FullPlayableTable("mesaConTargets",0,1,0,3));
        dropTargetNotHit=game.getTable().getTargets().get(0);
        gameScoreNotHit=game.getCurrentScore();
        timesTriggerEBBonusNotHit = game.getExtraBallBonus().timesTriggered();
        timesTriggerDTBonusNotHit = game.getDropTargetBonus().timesTriggered();
        numberOfBallsNotHit=game.getNumberOfBalls();


        dropTargetHitOnce = game.getTable().getTargets().get(1);
        scoreDropTargetHitOnce =  dropTargetHitOnce.hit();
        gameScoreHitOnce=game.getCurrentScore();
        timesTriggerEBBonusHitOnce=game.getExtraBallBonus().timesTriggered();
        timesTriggerDTBonusHitOnce=game.getDropTargetBonus().timesTriggered();
        numberOfBallsHitOnce=game.getNumberOfBalls();

        dropTargetHitAHundredTimes = game.getTable().getTargets().get(2);
        scoreDropTargetHitAHundredTimesFirstHit = dropTargetHitAHundredTimes.hit();
        gameScoreHitAHundredTimesFirstHit= game.getCurrentScore();
        timesTriggerEBBonusHitAHundredTimesFirstHit= game.getExtraBallBonus().timesTriggered();
        timesTriggerDTBonusHitAHundredTimesFirstHit= game.getDropTargetBonus().timesTriggered();
        numberOfBallsHitAHundredTimesFirstHit= game.getNumberOfBalls();
        for(int i=0;i<99;i++){
            dropTargetHitAHundredTimes.hit();
        }
        scoreDropTargetHitAHundredTimesLastHit = dropTargetHitAHundredTimes.hit();
        gameScoreHitAHundredTimesLastHit = game.getCurrentScore();
        timesTriggerEBBonusHitAHundredTimesLastHit =game.getExtraBallBonus().timesTriggered();
        timesTriggerDTBonusHitAHundredTimesLastHit =game.getDropTargetBonus().timesTriggered();
        numberOfBallsHitAHundredTimesLastHit =game.getNumberOfBalls();

        scoreHitLastNotHit =dropTargetNotHit.hit();
        gameScoreHitlastNotHit =game.getCurrentScore();
        timesTriggerEBBonusHitLastNotHit =game.getExtraBallBonus().timesTriggered();
        timesTriggerDTBonusHitLastNotHit =game.getDropTargetBonus().timesTriggered();
        numberOfBallsHitLastNotHit =game.getNumberOfBalls();
    }
    @Test
    public void testHit(){
        int expectedTimesTriggerEBBonusNotHit = 0;
        int expectedTimesTriggerEBBonusHitOnce = 0;
        int expectedTimesTriggerEBBonusHitAHundredTimesFirstHit=1;
        int expectedTimesTriggerEBBonusHitAHundredTimesLastHit = 1;
        int expectedTimesTriggerEBBonusHitLastNotHit = 2;

        int expectedTimesTriggerDTBonusNotHit = 0;
        int expectedTimesTriggerDTBonusHitOnce = 0;
        int expectedTimesTriggerDTBonusHitAHundredTimesFirstHit=0;
        int expectedTimesTriggerDTBonusHitAHundredTimesLastHit = 0;
        int expectedTimesTriggerDTBonusHitLastNotHit = 1;

        int expectedNotHitScore = 100;
        int expectedNotHitScoreGame = 0;
        int expectedNumberOfBallsNotHit = 5;
        assertEquals(expectedNotHitScore, dropTargetNotHit.getScore());
        assertEquals(expectedNotHitScoreGame,gameScoreNotHit);
        assertEquals(expectedNumberOfBallsNotHit,numberOfBallsNotHit);
        assertEquals(expectedTimesTriggerEBBonusNotHit,timesTriggerEBBonusNotHit);
        assertEquals(expectedTimesTriggerDTBonusNotHit,timesTriggerDTBonusNotHit);


        int expectedHitOnceScore = 100;
        int expectedHitOnceScoreGame = 100;
        int expectedNumberOfBallsHitOnce = 5;
        assertEquals(expectedHitOnceScore, scoreDropTargetHitOnce);
        assertEquals(expectedHitOnceScoreGame,gameScoreHitOnce);
        assertEquals(expectedTimesTriggerEBBonusHitOnce,timesTriggerEBBonusHitOnce);
        assertEquals(expectedTimesTriggerDTBonusHitOnce,timesTriggerDTBonusHitOnce);
        assertEquals(expectedNumberOfBallsHitOnce,numberOfBallsHitOnce);

        int expectedHitAHundredTimesFisrtHitScore = 100;
        int expectedHitAHundredTimesScoreGameFirstHit = 200;
        int expectedNumberOfBallsHitAHundredTimesFirstHit = 6;
        assertEquals(expectedHitAHundredTimesFisrtHitScore, scoreDropTargetHitAHundredTimesFirstHit);
        assertEquals(expectedHitAHundredTimesScoreGameFirstHit, gameScoreHitAHundredTimesFirstHit);
        assertEquals(expectedTimesTriggerEBBonusHitAHundredTimesFirstHit, timesTriggerEBBonusHitAHundredTimesFirstHit);
        assertEquals(expectedTimesTriggerDTBonusHitAHundredTimesFirstHit, timesTriggerDTBonusHitAHundredTimesFirstHit);
        assertEquals(expectedNumberOfBallsHitAHundredTimesFirstHit,numberOfBallsHitAHundredTimesFirstHit);

        int expectedHitAHundredTimesLastHitScore = 0;
        int expectedHitAHundredTimesScoreGameLastHit = 200;
        int expectedNumberOfBallsHitAHundredTimesLastHit = 6;
        assertEquals(expectedHitAHundredTimesLastHitScore, scoreDropTargetHitAHundredTimesLastHit);
        assertEquals(expectedHitAHundredTimesScoreGameLastHit, gameScoreHitAHundredTimesLastHit);
        assertEquals(expectedTimesTriggerEBBonusHitAHundredTimesLastHit, timesTriggerEBBonusHitAHundredTimesLastHit);
        assertEquals(expectedTimesTriggerDTBonusHitAHundredTimesLastHit, timesTriggerDTBonusHitAHundredTimesLastHit);
        assertEquals(expectedNumberOfBallsHitAHundredTimesLastHit, numberOfBallsHitAHundredTimesLastHit);

        int expectedHitLastNotHitScore = 100;
        int expectedHitLastNotHitScoreGame = 1000300;
        int expectedNumberOfBallsHitLastNotHit = 7;
        assertEquals(expectedHitLastNotHitScore, scoreHitLastNotHit);
        assertEquals(expectedHitLastNotHitScoreGame,gameScoreHitlastNotHit);
        assertEquals(expectedTimesTriggerEBBonusHitLastNotHit, timesTriggerEBBonusHitLastNotHit);
        assertEquals(expectedTimesTriggerDTBonusHitLastNotHit, timesTriggerDTBonusHitLastNotHit);
        assertEquals(expectedNumberOfBallsHitLastNotHit,numberOfBallsHitLastNotHit);

    }
    @Test
    public void testGetScore(){

    }
    @Test
    public void testIsActive(){

    }
    @Test
    public void testReset(){

    }
    @Test
    public void testResetDropTargets(){

    }
    @Test
    public void deactivate() {

    }

}


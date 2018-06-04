import controller.Game;
import logic.gameelements.target.DropTarget;
import logic.gameelements.target.Target;
import logic.table.FullPlayableTable;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestingDropTarget {
    private static Game game;
    private static Target dropTargetNotHit;
    private static int gameScoreNotHit;
    private static int timesTriggerEBBonusNotHit;
    private static Target dropTargetHitOnce;
    private static int scoreDropTargetHitOnce;
    private static int gameScoreHitOnce;
    private static int timesTriggerEBBonusHitOnce;
    private static int numberOfBallsHitOnce;
    private static Target dropTargetHitAHundredTimes;
    private static int scoreDropTargetHitAHundredTimesLastHit;
    private static int gameScoreHitAHundredTimesLastHit;
    private static int timesTriggerEBBonusHitAHundredTimesLastHit;
    private static int numberOfBallsHitAHundredTimesLastHit;
    private static int scoreHitLastNotHit;
    private static int gameScoreHitlastNotHit;
    private static int timesTriggerDTBonusNotHit;
    private static int timesTriggerDTBonusHitOnce;
    private static int timesTriggerDTBonusHitAHundredTimesLastHit;
    private static int numberOfBallsNotHit;
    private static int numberOfBallsHitLastNotHit;
    private static int timesTriggerEBBonusHitLastNotHit;
    private static int timesTriggerDTBonusHitLastNotHit;
    private static int scoreDropTargetHitAHundredTimesFirstHit;
    private static int gameScoreHitAHundredTimesFirstHit;
    private static int timesTriggerEBBonusHitAHundredTimesFirstHit;
    private static int timesTriggerDTBonusHitAHundredTimesFirstHit;
    private static int numberOfBallsHitAHundredTimesFirstHit;

    private Target dropTargetWithoutTableNotHit;
    private Target dropTargetWithoutTableHitOnce;
    private Target dropTargetWithoutTableHitAHundredTimes;

    @After
    public void resetGame(){
        Game.resetInstance();
    }
    @BeforeClass
    public static void BeforeClass(){
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
    @Before
    public void setup(){
        dropTargetWithoutTableNotHit =new DropTarget();

        dropTargetWithoutTableHitOnce=new DropTarget();
        dropTargetWithoutTableHitOnce.hit();

        dropTargetWithoutTableHitAHundredTimes=new DropTarget();
        for(int i = 0; i < 100; i++){
            dropTargetWithoutTableHitAHundredTimes.hit();
        }
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
        int expectedNotHitScore = 100;
        int expectedHitOnceScore = 100;
        int expectedHitAHundredTimesScore = 100;

        assertEquals(expectedNotHitScore, dropTargetWithoutTableNotHit.getScore());
        assertEquals(expectedHitOnceScore, dropTargetWithoutTableHitOnce.getScore());
        assertEquals(expectedHitAHundredTimesScore, dropTargetWithoutTableHitAHundredTimes.getScore());
    }
    @Test
    public void testIsActive(){
        assertTrue(dropTargetWithoutTableNotHit.isActive());
        assertFalse(dropTargetWithoutTableHitOnce.isActive());
        assertFalse(dropTargetWithoutTableHitAHundredTimes.isActive());
    }
    @Test
    public void testReset(){
        boolean dropTargetNotHitBeforeReset = dropTargetWithoutTableNotHit.isActive();
        dropTargetWithoutTableNotHit.reset();
        boolean dropTargetNotHitAfterReset = dropTargetWithoutTableNotHit.isActive();
        boolean dropTargetHitOnceBeforeReset = dropTargetWithoutTableHitOnce.isActive();
        dropTargetWithoutTableHitOnce.reset();
        boolean dropTargetHitOnceAfterReset = dropTargetWithoutTableHitOnce.isActive();
        boolean dropTargetHitAHundredTimesBeforeReset = dropTargetWithoutTableHitAHundredTimes.isActive();
        dropTargetWithoutTableHitAHundredTimes.reset();
        boolean dropTargetHitAHundredTimesAfterReset = dropTargetWithoutTableHitAHundredTimes.isActive();

        assertTrue(dropTargetNotHitBeforeReset);
        assertTrue(dropTargetNotHitAfterReset);
        assertFalse(dropTargetHitOnceBeforeReset);
        assertTrue(dropTargetHitOnceAfterReset);
        assertFalse(dropTargetHitAHundredTimesBeforeReset);
        assertTrue(dropTargetHitAHundredTimesAfterReset);
    }
    @Test
    public void testResetDropTargets(){
        boolean dropTargetNotHitBeforeReset = dropTargetWithoutTableNotHit.isActive();
        dropTargetWithoutTableNotHit.resetDropTarget();
        boolean dropTargetNotHitAfterReset = dropTargetWithoutTableNotHit.isActive();
        boolean dropTargetHitOnceBeforeReset = dropTargetWithoutTableHitOnce.isActive();
        dropTargetWithoutTableHitOnce.resetDropTarget();
        boolean dropTargetHitOnceAfterReset = dropTargetWithoutTableHitOnce.isActive();
        boolean dropTargetHitAHundredTimesBeforeReset = dropTargetWithoutTableHitAHundredTimes.isActive();
        dropTargetWithoutTableHitAHundredTimes.resetDropTarget();
        boolean dropTargetHitAHundredTimesAfterReset = dropTargetWithoutTableHitAHundredTimes.isActive();

        assertTrue(dropTargetNotHitBeforeReset);
        assertTrue(dropTargetNotHitAfterReset);
        assertFalse(dropTargetHitOnceBeforeReset);
        assertTrue(dropTargetHitOnceAfterReset);
        assertFalse(dropTargetHitAHundredTimesBeforeReset);
        assertTrue(dropTargetHitAHundredTimesAfterReset);
    }
    @Test
    public void deactivate() {
        boolean dropTargetNotHitBeforeDeactivate = dropTargetWithoutTableNotHit.isActive();
        dropTargetWithoutTableNotHit.deactivate();
        boolean dropTargetNotHitAfterDeactivate = dropTargetWithoutTableNotHit.isActive();
        boolean dropTargetHitOnceBeforeDeactivate = dropTargetWithoutTableHitOnce.isActive();
        dropTargetWithoutTableHitOnce.deactivate();
        boolean dropTargetHitOnceAfterDeactivate = dropTargetWithoutTableHitOnce.isActive();
        boolean dropTargetHitAHundredTimesBeforeDeactivate = dropTargetWithoutTableHitAHundredTimes.isActive();
        dropTargetWithoutTableHitAHundredTimes.deactivate();
        boolean dropTargetHitAHundredTimesAfterDeactivate = dropTargetWithoutTableHitAHundredTimes.isActive();

        assertTrue(dropTargetNotHitBeforeDeactivate);
        assertFalse(dropTargetNotHitAfterDeactivate);
        assertFalse(dropTargetHitOnceBeforeDeactivate);
        assertFalse(dropTargetHitOnceAfterDeactivate);
        assertFalse(dropTargetHitAHundredTimesBeforeDeactivate);
        assertFalse(dropTargetHitAHundredTimesAfterDeactivate);
    }

}


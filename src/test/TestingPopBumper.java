import controller.Game;
import logic.gameelements.bumper.Bumper;
import logic.table.PlayableTableWithNoTargets;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestingPopBumper {
    private Bumper popBumperHitOnce;
    private int scorePopBumperHitOnce;
    private Bumper popBumperHitThreeTimes;
    private Bumper popBumperHitAHundredTimes;
    private int scorePopBumperHitAHundredTimes;
    private Bumper popBumperNotHit;
    private int scorePopBumperHitThreeTimes;
    private int gameScoreNotHit;
    private int gameScoreHitOnce;
    private int gameScoreHitThreeTimes;
    private int gameScoreHitAHundredTimes;
    private int numberOfBallsNotHit;
    private int timesTriggerBonusNotHit;
    private int timesTriggerBonusHitOnce;
    private int numberOfBallsHitOnce;
    private int timesTriggerBonusHitThreeTimes;
    private int numberOfBallsHitThreeTimes;
    private int timesTriggerBonusHitAHundredTimes;
    private int numberOfBallsHitAHundredTimes;
    private Game game;

    @After
    public void resetGame(){
        Game.resetInstance();
    }
    @Before
    public void setup(){
        game= Game.getInstance();
        game.setRandom(17);
        game.setTable(new PlayableTableWithNoTargets("mesaSinTarget",4,1));
        popBumperNotHit=game.getTable().getBumpers().get(0);
        gameScoreNotHit=game.getCurrentScore();
        timesTriggerBonusNotHit=game.getExtraBallBonus().timesTriggered();
        numberOfBallsNotHit=game.getNumberOfBalls();

        popBumperHitOnce = game.getTable().getBumpers().get(1);
        scorePopBumperHitOnce =  popBumperHitOnce.hit();
        gameScoreHitOnce=game.getCurrentScore();
        timesTriggerBonusHitOnce=game.getExtraBallBonus().timesTriggered();
        numberOfBallsHitOnce =game.getNumberOfBalls();

        popBumperHitThreeTimes = game.getTable().getBumpers().get(2);
        for(int i=0;i<2;i++){
            popBumperHitThreeTimes.hit();
        }
        scorePopBumperHitThreeTimes= popBumperHitThreeTimes.hit();
        gameScoreHitThreeTimes=game.getCurrentScore();
        timesTriggerBonusHitThreeTimes=game.getExtraBallBonus().timesTriggered();
        numberOfBallsHitThreeTimes =game.getNumberOfBalls();

        popBumperHitAHundredTimes = game.getTable().getBumpers().get(3);
        for(int i=0;i<99;i++){
            popBumperHitAHundredTimes.hit();
        }
        scorePopBumperHitAHundredTimes= popBumperHitAHundredTimes.hit();
        gameScoreHitAHundredTimes=game.getCurrentScore();
        timesTriggerBonusHitAHundredTimes=game.getExtraBallBonus().timesTriggered();
        numberOfBallsHitAHundredTimes =game.getNumberOfBalls();

    }
    @Test
    public void testHit(){
        int expectedNumberOfBallsNotHit = 5;
        int expectedTimesTriggerBonusNotHit = 0;
        int expectedNumberOfBallsHitOnce = 5;
        int expectedTimesTriggerBonusHitOnce = 0;
        int expectedTimesTriggerBonusHitThreeTimes = 1;
        int expectedNumberOfBallsHitThreeTimes = 6;
        int expectedTimesTriggerBonusHitAHundredTimes = 1;
        int expectedNumberOfBallsHitAHundredTimes =6;

        int expectedNotHit = 100;
        int expectedNotHitScoreGame = 0;
        assertEquals(expectedNotHit, popBumperNotHit.getScore());
        assertEquals(expectedNotHitScoreGame,gameScoreNotHit);
        assertEquals(expectedNumberOfBallsNotHit, numberOfBallsNotHit);
        assertEquals(expectedTimesTriggerBonusNotHit,timesTriggerBonusNotHit);

        int expectedHitOnce = 100;
        int expectedHitOnceScoreGame = 100;
        assertEquals(expectedHitOnce, scorePopBumperHitOnce);
        assertEquals(expectedHitOnceScoreGame,gameScoreHitOnce);
        assertEquals(expectedNumberOfBallsHitOnce, numberOfBallsHitOnce);
        assertEquals(expectedTimesTriggerBonusHitOnce,timesTriggerBonusHitOnce);

        int expectedHitThreeTimes = 300;
        int expectedHitThreeTimesScoreGame = 600;
        assertEquals(expectedHitThreeTimes, scorePopBumperHitThreeTimes);
        assertEquals(expectedHitThreeTimesScoreGame,gameScoreHitThreeTimes);
        assertEquals(expectedNumberOfBallsHitThreeTimes, numberOfBallsHitThreeTimes);
        assertEquals(expectedTimesTriggerBonusHitThreeTimes,timesTriggerBonusHitThreeTimes);


        int expectedHitAHundredTimes=300;
        int expectedHitAHundredTimesScoreGame=200+98*300+600;
        assertEquals(expectedHitAHundredTimes, scorePopBumperHitAHundredTimes);
        assertEquals(expectedHitAHundredTimesScoreGame,gameScoreHitAHundredTimes);
        assertEquals(expectedNumberOfBallsHitAHundredTimes, numberOfBallsHitAHundredTimes);
        assertEquals(expectedTimesTriggerBonusHitAHundredTimes,timesTriggerBonusHitAHundredTimes);
    }
    @Test
    public void testGetScore(){
        int expectedNotHit = 100;
        int expectedHitOnce = 100;
        int expetedHitThreeTimes = 300;
        int expetedHitAHundredTimes = 300;
        assertEquals(expectedNotHit, popBumperNotHit.getScore());
        assertEquals(expectedHitOnce, popBumperHitOnce.getScore());
        assertEquals(expetedHitThreeTimes, popBumperHitThreeTimes.getScore());
        assertEquals(expetedHitAHundredTimes,popBumperHitAHundredTimes.getScore());
    }

    @Test
    public void testRemainingHitsToUpgrade(){
        int expectedNotHit = 3;
        int expectedHitOnce = 2;
        int expetedHitThreeTimes = 0;
        int expetedHitAHundredTimes = 0;
        assertEquals(expectedNotHit, popBumperNotHit.remainingHitsToUpgrade());
        assertEquals(expectedHitOnce, popBumperHitOnce.remainingHitsToUpgrade());
        assertEquals(expetedHitThreeTimes, popBumperHitThreeTimes.remainingHitsToUpgrade());
        assertEquals(expetedHitAHundredTimes,popBumperHitAHundredTimes.remainingHitsToUpgrade());
    }

    @Test
    public void testIsUpgraded(){
        assertFalse(popBumperNotHit.isUpgraded());
        assertFalse(popBumperHitOnce.isUpgraded());
        assertTrue(popBumperHitThreeTimes.isUpgraded());
        assertTrue(popBumperHitAHundredTimes.isUpgraded());
    }

    @Test
    public void testUpgrade(){
        /*
         0.0443859375038691
        0.23973661293649284
        0.707454821689446
            0.6594836922590074
0.858996580616418
0.003754742582413595
         */
        //before Upgrade
        int expectedNumberOfBallsNotHit = 5;
        int expectedTimesTriggerBonusNotHit = 0;
        int expectedNumberOfBallsHitOnce = 5;
        int expectedTimesTriggerBonusHitOnce = 0;
        int expectedTimesTriggerBonusHitThreeTimes = 1;
        int expectedNumberOfBallsHitThreeTimes = 6;
        int expectedTimesTriggerBonusHitAHundredTimes = 1;
        int expectedNumberOfBallsHitAHundredTimes =6;
        //After Upgrade
        int expectedNumberOfBallsNotHitAfterUpgrade = 6;
        int expectedTimesTriggerBonusNotHitAfterUpgrade = 1;
        int expectedNumberOfBallsHitOnceAfterUpgrade = 6;
        int expectedTimesTriggerBonusHitOnceAfterUpgrade = 1;
        int expectedTimesTriggerBonusHitThreeTimesAfterUpgrade = 1;
        int expectedNumberOfBallsHitThreeTimesAfterUpgrade = 6;
        int expectedTimesTriggerBonusHitAHundredTimesAfterUpgrade = 2;
        int expectedNumberOfBallsHitAHundredTimesAfterUpgrade =7;

        boolean popBumperNotHitBeforeUpgrade=popBumperNotHit.isUpgraded();
        popBumperNotHit.upgrade();
        boolean popBumperNotHitAfterUpgrade=popBumperNotHit.isUpgraded();
        assertFalse(popBumperNotHitBeforeUpgrade);
        assertTrue(popBumperNotHitAfterUpgrade);
        assertEquals(expectedNumberOfBallsNotHit, numberOfBallsNotHit);
        assertEquals(expectedTimesTriggerBonusNotHit,timesTriggerBonusNotHit);
        assertEquals(expectedNumberOfBallsNotHitAfterUpgrade, game.getNumberOfBalls());
        assertEquals(expectedTimesTriggerBonusNotHitAfterUpgrade,game.getExtraBallBonus().timesTriggered());

        boolean popBumperHitOnceBeforeUpgrade=popBumperHitOnce.isUpgraded();
        popBumperHitOnce.upgrade();
        boolean popBumperHitOnceAfterUpgrade=popBumperHitOnce.isUpgraded();
        assertFalse(popBumperHitOnceBeforeUpgrade);
        assertTrue(popBumperHitOnceAfterUpgrade);
        assertEquals(expectedNumberOfBallsHitOnce, numberOfBallsHitOnce);
        assertEquals(expectedTimesTriggerBonusHitOnce,timesTriggerBonusHitOnce);
        assertEquals(expectedNumberOfBallsHitOnceAfterUpgrade, game.getNumberOfBalls());
        assertEquals(expectedTimesTriggerBonusHitOnceAfterUpgrade,game.getExtraBallBonus().timesTriggered());

        boolean popBumperHitThreeTimesBeforeUpgrade=popBumperHitThreeTimes.isUpgraded();
        popBumperHitThreeTimes.upgrade();
        boolean popBumperHitThreeTimesAfterUpgrade=popBumperHitThreeTimes.isUpgraded();
        assertTrue(popBumperHitThreeTimesBeforeUpgrade);
        assertTrue(popBumperHitThreeTimesAfterUpgrade);
        assertEquals(expectedNumberOfBallsHitThreeTimes, numberOfBallsHitThreeTimes);
        assertEquals(expectedTimesTriggerBonusHitThreeTimes,timesTriggerBonusHitThreeTimes);
        assertEquals(expectedNumberOfBallsHitThreeTimesAfterUpgrade, game.getNumberOfBalls());
        assertEquals(expectedTimesTriggerBonusHitThreeTimesAfterUpgrade,game.getExtraBallBonus().timesTriggered());

        boolean popBumperHitAHundredTimesBeforeUpgrade=popBumperHitAHundredTimes.isUpgraded();
        popBumperHitAHundredTimes.upgrade();
        boolean popBumperHitAHundredTimesAfterUpgrade=popBumperHitAHundredTimes.isUpgraded();
        assertTrue(popBumperHitAHundredTimesBeforeUpgrade);
        assertTrue(popBumperHitAHundredTimesAfterUpgrade);
        assertEquals(expectedNumberOfBallsHitAHundredTimes, numberOfBallsHitAHundredTimes);
        assertEquals(expectedTimesTriggerBonusHitAHundredTimes,timesTriggerBonusHitAHundredTimes);
        assertEquals(expectedNumberOfBallsHitAHundredTimesAfterUpgrade, game.getNumberOfBalls());
        assertEquals(expectedTimesTriggerBonusHitAHundredTimesAfterUpgrade,game.getExtraBallBonus().timesTriggered());
    }

    @Test
    public void testDowngrade(){
        boolean popBumperNotHitBeforeDowngrade=popBumperNotHit.isUpgraded();
        popBumperNotHit.downgrade();
        boolean popBumperNotHitAfterDowngrade=popBumperNotHit.isUpgraded();
        assertFalse(popBumperNotHitBeforeDowngrade);
        assertFalse(popBumperNotHitAfterDowngrade);

        boolean popBumperHitOnceBeforeDowngrade=popBumperHitOnce.isUpgraded();
        popBumperHitOnce.downgrade();
        boolean popBumperHitOnceAfterDowngrade=popBumperHitOnce.isUpgraded();
        assertFalse(popBumperHitOnceBeforeDowngrade);
        assertFalse(popBumperHitOnceAfterDowngrade);

        boolean popBumperHitThreeTimesBeforeDowngrade=popBumperHitThreeTimes.isUpgraded();
        popBumperHitThreeTimes.downgrade();
        boolean popBumperHitThreeTimesAfterDowngrade=popBumperHitThreeTimes.isUpgraded();
        assertTrue(popBumperHitThreeTimesBeforeDowngrade);
        assertFalse(popBumperHitThreeTimesAfterDowngrade);

        boolean popBumperHitAHundredTimesBeforeDowngrade=popBumperHitAHundredTimes.isUpgraded();
        popBumperHitAHundredTimes.downgrade();
        boolean popBumperHitAHundredTimesAfterDowngrade=popBumperHitAHundredTimes.isUpgraded();
        assertTrue(popBumperHitAHundredTimesBeforeDowngrade);
        assertFalse(popBumperHitAHundredTimesAfterDowngrade);

    }
    @Test
    public void TestDecreaseHitsToUpgrade(){
        int expectRemainingHitBeforeDecrease=3;
        assertEquals(expectRemainingHitBeforeDecrease,popBumperNotHit.remainingHitsToUpgrade());

        popBumperNotHit.decreaseHitsToUpgrade(1);
        int expectRemainingHitAfterDecreaseInOne=2;
        assertEquals(expectRemainingHitAfterDecreaseInOne,popBumperNotHit.remainingHitsToUpgrade());

        popBumperNotHit.decreaseHitsToUpgrade(4);
        int expectRemainingHitAfterDecreaseByFour=0;
        assertEquals(expectRemainingHitAfterDecreaseByFour,popBumperNotHit.remainingHitsToUpgrade());

    }

}


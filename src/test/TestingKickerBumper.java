import controller.Game;
import logic.gameelements.bumper.Bumper;
import logic.table.PlayableTableWithNoTargets;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestingKickerBumper {
    private Bumper kickerBumperHitOnce;
    private int scoreKickerBumperHitOnce;
    private Bumper kickerBumperHitFiveTimes;
    private Bumper kickerBumperHitAHundredTimes;
    private int scoreKickerBumperHitAHundredTimes;
    private Bumper kickerBumperNotHit;
    private int scoreKickerBumperHitFiveTimes;
    private int gameScoreNotHit;
    private int gameScoreHitOnce;
    private int gameScoreHitFiveTimes;
    private int gameScoreHitAHundredTimes;
    private int numberOfBallsNotHit;
    private int timesTriggerBonusNotHit;
    private int timesTriggerBonusHitOnce;
    private int numberOfBallsHitOnce;
    private int timesTriggerBonusHitFiveTimes;
    private int numberOfBallsHitFiveTimes;
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
        game.setTable(new PlayableTableWithNoTargets("mesaSinTarget",4,0));
        kickerBumperNotHit=game.getTable().getBumpers().get(0);
        gameScoreNotHit=game.getCurrentScore();
        timesTriggerBonusNotHit=game.getExtraBallBonus().timesTriggered();
        numberOfBallsNotHit=game.getNumberOfBalls();

        kickerBumperHitOnce = game.getTable().getBumpers().get(1);
        scoreKickerBumperHitOnce =  kickerBumperHitOnce.hit();
        gameScoreHitOnce=game.getCurrentScore();
        timesTriggerBonusHitOnce=game.getExtraBallBonus().timesTriggered();
        numberOfBallsHitOnce =game.getNumberOfBalls();

        kickerBumperHitFiveTimes = game.getTable().getBumpers().get(2);
        for(int i=0;i<4;i++){
            kickerBumperHitFiveTimes.hit();
        }
        scoreKickerBumperHitFiveTimes= kickerBumperHitFiveTimes.hit();
        gameScoreHitFiveTimes=game.getCurrentScore();
        timesTriggerBonusHitFiveTimes=game.getExtraBallBonus().timesTriggered();
        numberOfBallsHitFiveTimes =game.getNumberOfBalls();

        kickerBumperHitAHundredTimes = game.getTable().getBumpers().get(3);
        for(int i=0;i<99;i++){
            kickerBumperHitAHundredTimes.hit();
        }
        scoreKickerBumperHitAHundredTimes= kickerBumperHitAHundredTimes.hit();
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
        int expectedTimesTriggerBonusHitFiveTimes = 1;
        int expectedNumberOfBallsHitFiveTimes = 6;
        int expectedTimesTriggerBonusHitAHundredTimes = 1;
        int expectedNumberOfBallsHitAHundredTimes =6;

        int expectedNotHit=500;
        int expectedNotHitScoreGame=0;
        assertEquals(expectedNotHit, kickerBumperNotHit.getScore());
        assertEquals(expectedNotHitScoreGame,gameScoreNotHit);
        assertEquals(expectedNumberOfBallsNotHit, numberOfBallsNotHit);
        assertEquals(expectedTimesTriggerBonusNotHit,timesTriggerBonusNotHit);

        int expectedHitOnce=500;
        int expectedHitOnceScoreGame=500;
        assertEquals(expectedHitOnce, scoreKickerBumperHitOnce);
        assertEquals(expectedHitOnceScoreGame,gameScoreHitOnce);
        assertEquals(expectedNumberOfBallsHitOnce, numberOfBallsHitOnce);
        assertEquals(expectedTimesTriggerBonusHitOnce,timesTriggerBonusHitOnce);

        int expectedHitFiveTimes=1000;
        int expectedHitFiveTimesScoreGame=3500;
        assertEquals(expectedHitFiveTimes, scoreKickerBumperHitFiveTimes);
        assertEquals(expectedHitFiveTimesScoreGame,gameScoreHitFiveTimes);
        assertEquals(expectedNumberOfBallsHitFiveTimes, numberOfBallsHitFiveTimes);
        assertEquals(expectedTimesTriggerBonusHitFiveTimes,timesTriggerBonusHitFiveTimes);


        int expectedHitAHundredTimes=1000;
        int expectedHitAHundredTimesScoreGame=101500;
        assertEquals(expectedHitAHundredTimes, scoreKickerBumperHitAHundredTimes);
        assertEquals(expectedHitAHundredTimesScoreGame,gameScoreHitAHundredTimes);
        assertEquals(expectedNumberOfBallsHitAHundredTimes, numberOfBallsHitAHundredTimes);
        assertEquals(expectedTimesTriggerBonusHitAHundredTimes,timesTriggerBonusHitAHundredTimes);
    }
    @Test
    public void testGetScore(){
        int expectedNotHit=500;
        int expectedHitOnce=500;
        int expetedHitFiveTimes=1000;
        int expetedHitAHundredTimes=1000;
        assertEquals(expectedNotHit, kickerBumperNotHit.getScore());
        assertEquals(expectedHitOnce, kickerBumperHitOnce.getScore());
        assertEquals(expetedHitFiveTimes, kickerBumperHitFiveTimes.getScore());
        assertEquals(expetedHitAHundredTimes,kickerBumperHitAHundredTimes.getScore());
    }

    @Test
    public void testRemainingHitsToUpgrade(){
        int expectedNotHit=5;
        int expectedHitOnce=4;
        int expetedHitFiveTimes=0;
        int expetedHitAHundredTimes=0;
        assertEquals(expectedNotHit, kickerBumperNotHit.remainingHitsToUpgrade());
        assertEquals(expectedHitOnce, kickerBumperHitOnce.remainingHitsToUpgrade());
        assertEquals(expetedHitFiveTimes, kickerBumperHitFiveTimes.remainingHitsToUpgrade());
        assertEquals(expetedHitAHundredTimes,kickerBumperHitAHundredTimes.remainingHitsToUpgrade());
    }

    @Test
    public void testIsUpgraded(){
        assertFalse(kickerBumperNotHit.isUpgraded());
        assertFalse(kickerBumperHitOnce.isUpgraded());
        assertTrue(kickerBumperHitFiveTimes.isUpgraded());
        assertTrue(kickerBumperHitAHundredTimes.isUpgraded());
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
        int expectedTimesTriggerBonusHitFiveTimes = 1;
        int expectedNumberOfBallsHitFiveTimes = 6;
        int expectedTimesTriggerBonusHitAHundredTimes = 1;
        int expectedNumberOfBallsHitAHundredTimes =6;
        //After Upgrade
        int expectedNumberOfBallsNotHitAfterUpgrade = 6;
        int expectedTimesTriggerBonusNotHitAfterUpgrade = 1;
        int expectedNumberOfBallsHitOnceAfterUpgrade = 6;
        int expectedTimesTriggerBonusHitOnceAfterUpgrade = 1;
        int expectedTimesTriggerBonusHitFiveTimesAfterUpgrade = 1;
        int expectedNumberOfBallsHitFiveTimesAfterUpgrade = 6;
        int expectedTimesTriggerBonusHitAHundredTimesAfterUpgrade = 2;
        int expectedNumberOfBallsHitAHundredTimesAfterUpgrade =7;

        boolean kickerBumperNotHitBeforeUpgrade=kickerBumperNotHit.isUpgraded();
        kickerBumperNotHit.upgrade();
        boolean kickerBumperNotHitAfterUpgrade=kickerBumperNotHit.isUpgraded();
        assertFalse(kickerBumperNotHitBeforeUpgrade);
        assertTrue(kickerBumperNotHitAfterUpgrade);
        assertEquals(expectedNumberOfBallsNotHit, numberOfBallsNotHit);
        assertEquals(expectedTimesTriggerBonusNotHit,timesTriggerBonusNotHit);
        assertEquals(expectedNumberOfBallsNotHitAfterUpgrade, game.getNumberOfBalls());
        assertEquals(expectedTimesTriggerBonusNotHitAfterUpgrade,game.getExtraBallBonus().timesTriggered());

        boolean kickerBumperHitOnceBeforeUpgrade=kickerBumperHitOnce.isUpgraded();
        kickerBumperHitOnce.upgrade();
        boolean kickerBumperHitOnceAfterUpgrade=kickerBumperHitOnce.isUpgraded();
        assertFalse(kickerBumperHitOnceBeforeUpgrade);
        assertTrue(kickerBumperHitOnceAfterUpgrade);
        assertEquals(expectedNumberOfBallsHitOnce, numberOfBallsHitOnce);
        assertEquals(expectedTimesTriggerBonusHitOnce,timesTriggerBonusHitOnce);
        assertEquals(expectedNumberOfBallsHitOnceAfterUpgrade, game.getNumberOfBalls());
        assertEquals(expectedTimesTriggerBonusHitOnceAfterUpgrade,game.getExtraBallBonus().timesTriggered());

        boolean kickerBumperHitFiveTimesBeforeUpgrade=kickerBumperHitFiveTimes.isUpgraded();
        kickerBumperHitFiveTimes.upgrade();
        boolean kickerBumperHitFiveTimesAfterUpgrade=kickerBumperHitFiveTimes.isUpgraded();
        assertTrue(kickerBumperHitFiveTimesBeforeUpgrade);
        assertTrue(kickerBumperHitFiveTimesAfterUpgrade);
        assertEquals(expectedNumberOfBallsHitFiveTimes, numberOfBallsHitFiveTimes);
        assertEquals(expectedTimesTriggerBonusHitFiveTimes,timesTriggerBonusHitFiveTimes);
        assertEquals(expectedNumberOfBallsHitFiveTimesAfterUpgrade, game.getNumberOfBalls());
        assertEquals(expectedTimesTriggerBonusHitFiveTimesAfterUpgrade,game.getExtraBallBonus().timesTriggered());

        boolean kickerBumperHitAHundredTimesBeforeUpgrade=kickerBumperHitAHundredTimes.isUpgraded();
        kickerBumperHitAHundredTimes.upgrade();
        boolean kickerBumperHitAHundredTimesAfterUpgrade=kickerBumperHitAHundredTimes.isUpgraded();
        assertTrue(kickerBumperHitAHundredTimesBeforeUpgrade);
        assertTrue(kickerBumperHitAHundredTimesAfterUpgrade);
        assertEquals(expectedNumberOfBallsHitAHundredTimes, numberOfBallsHitAHundredTimes);
        assertEquals(expectedTimesTriggerBonusHitAHundredTimes,timesTriggerBonusHitAHundredTimes);
        assertEquals(expectedNumberOfBallsHitAHundredTimesAfterUpgrade, game.getNumberOfBalls());
        assertEquals(expectedTimesTriggerBonusHitAHundredTimesAfterUpgrade,game.getExtraBallBonus().timesTriggered());
    }

    @Test
    public void testDowngrade(){
        boolean kickerBumperNotHitBeforeDowngrade=kickerBumperNotHit.isUpgraded();
        kickerBumperNotHit.downgrade();
        boolean kickerBumperNotHitAfterDowngrade=kickerBumperNotHit.isUpgraded();
        assertFalse(kickerBumperNotHitBeforeDowngrade);
        assertFalse(kickerBumperNotHitAfterDowngrade);

        boolean kickerBumperHitOnceBeforeDowngrade=kickerBumperHitOnce.isUpgraded();
        kickerBumperHitOnce.downgrade();
        boolean kickerBumperHitOnceAfterDowngrade=kickerBumperHitOnce.isUpgraded();
        assertFalse(kickerBumperHitOnceBeforeDowngrade);
        assertFalse(kickerBumperHitOnceAfterDowngrade);

        boolean kickerBumperHitFiveTimesBeforeDowngrade=kickerBumperHitFiveTimes.isUpgraded();
        kickerBumperHitFiveTimes.downgrade();
        boolean kickerBumperHitFiveTimesAfterDowngrade=kickerBumperHitFiveTimes.isUpgraded();
        assertTrue(kickerBumperHitFiveTimesBeforeDowngrade);
        assertFalse(kickerBumperHitFiveTimesAfterDowngrade);

        boolean kickerBumperHitAHundredTimesBeforeDowngrade=kickerBumperHitAHundredTimes.isUpgraded();
        kickerBumperHitAHundredTimes.downgrade();
        boolean kickerBumperHitAHundredTimesAfterDowngrade=kickerBumperHitAHundredTimes.isUpgraded();
        assertTrue(kickerBumperHitAHundredTimesBeforeDowngrade);
        assertFalse(kickerBumperHitAHundredTimesAfterDowngrade);

    }
    @Test
    public void TestDecreaseHitsToUpgrade(){
        int expectRemainingHitBeforeDecrease=5;
        assertEquals(expectRemainingHitBeforeDecrease,kickerBumperNotHit.remainingHitsToUpgrade());

        kickerBumperNotHit.decreaseHitsToUpgrade(1);
        int expectRemainingHitAfterDecreaseInOne=4;
        assertEquals(expectRemainingHitAfterDecreaseInOne,kickerBumperNotHit.remainingHitsToUpgrade());

        kickerBumperNotHit.decreaseHitsToUpgrade(4);
        int expectRemainingHitAfterDecreaseByFour=0;
        assertEquals(expectRemainingHitAfterDecreaseByFour,kickerBumperNotHit.remainingHitsToUpgrade());

    }

}

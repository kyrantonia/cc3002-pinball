import controller.Game;
import logic.gameelements.target.Target;
import logic.table.FullPlayableTable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestingSpotTarget {
    private Game game;
    private Target spotTargetNotHit;
    private int gameScoreNotHit;
    private int timesTriggerBonusNotHit;
    private Target spotTargetHitOnce;
    private int scoreSpotTargetHitOnce;
    private int gameScoreHitOnce;
    private int timesTriggerBonusHitOnce;
    private Target spotTargetHitAHundredTimes;
    private int scoreSpotTargetHitAHundredTimes;
    private int gameScoreHitAHundredTimes;
    private int timesTriggerBonusHitAHundredTimes;

    @After
    public void resetGame(){
        Game.resetInstance();
    }
    @Before
    public void setup(){
        game= Game.getInstance();
        game.setRandom(17);
        game.setTable(new FullPlayableTable("mesaConTargets",0,1,3,0));
        spotTargetNotHit=game.getTable().getTargets().get(0);
        gameScoreNotHit=game.getCurrentScore();
        timesTriggerBonusNotHit = game.getJackPotBonus().timesTriggered();

        spotTargetHitOnce = game.getTable().getTargets().get(1);
        scoreSpotTargetHitOnce =  spotTargetHitOnce.hit();
        gameScoreHitOnce=game.getCurrentScore();
        timesTriggerBonusHitOnce=game.getJackPotBonus().timesTriggered();

        spotTargetHitAHundredTimes = game.getTable().getTargets().get(2);
        for(int i=0;i<99;i++){
            spotTargetHitAHundredTimes.hit();
        }
        scoreSpotTargetHitAHundredTimes= spotTargetHitAHundredTimes.hit();
        gameScoreHitAHundredTimes=game.getCurrentScore();
        timesTriggerBonusHitAHundredTimes=game.getJackPotBonus().timesTriggered();
    }
    @Test
    public void testHit(){
        int expectedTimesTriggerBonusNotHit = 0;
        int expectedTimesTriggerBonusHitOnce = 1;
        int expectedTimesTriggerBonusHitAHundredTimes = 2;

        int expectedNotHit = 0;
        int expectedNotHitScoreGame = 0;
        assertEquals(expectedNotHit, spotTargetNotHit.getScore());
        assertEquals(expectedNotHitScoreGame,gameScoreNotHit);
        assertEquals(expectedTimesTriggerBonusNotHit,timesTriggerBonusNotHit);

        int expectedHitOnce = 0;
        int expectedHitOnceScoreGame = 100000;
        assertEquals(expectedHitOnce, scoreSpotTargetHitOnce);
        assertEquals(expectedHitOnceScoreGame,gameScoreHitOnce);
        assertEquals(expectedTimesTriggerBonusHitOnce,timesTriggerBonusHitOnce);

        int expectedHitAHundredTimes=0;
        int expectedHitAHundredTimesScoreGame=200000;
        assertEquals(expectedHitAHundredTimes, scoreSpotTargetHitAHundredTimes);
        assertEquals(expectedHitAHundredTimesScoreGame,gameScoreHitAHundredTimes);
        assertEquals(expectedTimesTriggerBonusHitAHundredTimes,timesTriggerBonusHitAHundredTimes);
    }
    @Test
    public void testGetScore(){
        int expectedNotHit=0;
        int expectedHitOnce=0;
        int expetedHitAHundredTimes=0;
        assertEquals(expectedNotHit, spotTargetNotHit.getScore());
        assertEquals(expectedHitOnce, spotTargetHitOnce.getScore());
        assertEquals(expetedHitAHundredTimes,spotTargetHitAHundredTimes.getScore());
    }
    @Test
    public void testIsActive(){
        assertTrue(spotTargetNotHit.isActive());
        assertFalse(spotTargetHitOnce.isActive());
        assertFalse(spotTargetHitAHundredTimes.isActive());
    }
    @Test
    public void testReset(){
        boolean spotTargetNotHitBeforeReset = spotTargetNotHit.isActive();
        spotTargetNotHit.reset();
        boolean spotTargetNotHitAfterReset = spotTargetNotHit.isActive();

        boolean spotTargeHitOnceBeforeReset = spotTargetHitOnce.isActive();
        spotTargetHitOnce.reset();
        boolean spotTargetHitOnceAfterReset = spotTargetHitOnce.isActive();

        boolean spotTargetHitAHundredTimesBeforeReset = spotTargetHitAHundredTimes.isActive();
        spotTargetHitAHundredTimes.reset();
        boolean spotTargetHitAHundredTimesAfterReset = spotTargetHitAHundredTimes.isActive();

        assertTrue(spotTargetNotHitBeforeReset);
        assertTrue(spotTargetNotHitAfterReset);
        assertFalse(spotTargeHitOnceBeforeReset);
        assertTrue(spotTargetHitOnceAfterReset);
        assertFalse(spotTargetHitAHundredTimesBeforeReset);
        assertTrue(spotTargetHitAHundredTimesAfterReset);
    }
    @Test
    public void testResetDropTargets(){
        boolean spotTargetNotHitBeforeReset = spotTargetNotHit.isActive();
        spotTargetNotHit.resetDropTargets();
        boolean spotTargetNotHitAfterReset = spotTargetNotHit.isActive();

        boolean spotTargeHitOnceBeforeReset = spotTargetHitOnce.isActive();
        spotTargetHitOnce.resetDropTargets();
        boolean spotTargetHitOnceAfterReset = spotTargetHitOnce.isActive();

        boolean spotTargetHitAHundredTimesBeforeReset = spotTargetHitAHundredTimes.isActive();
        spotTargetHitAHundredTimes.resetDropTargets();
        boolean spotTargetHitAHundredTimesAfterReset = spotTargetHitAHundredTimes.isActive();

        assertTrue(spotTargetNotHitBeforeReset);
        assertTrue(spotTargetNotHitAfterReset);
        assertFalse(spotTargeHitOnceBeforeReset);
        assertFalse(spotTargetHitOnceAfterReset);
        assertFalse(spotTargetHitAHundredTimesBeforeReset);
        assertFalse(spotTargetHitAHundredTimesAfterReset);
    }
    @Test
    public void deactivate() {
        boolean spotTargetNotHitBeforeDeactivate = spotTargetNotHit.isActive();
        spotTargetNotHit.deactivate();
        boolean spotTargetNotHitAfterDeactivate = spotTargetNotHit.isActive();

        boolean spotTargeHitOnceBeforeDeactivate = spotTargetHitOnce.isActive();
        spotTargetHitOnce.deactivate();
        boolean spotTargetHitOnceAfterDeactivate = spotTargetHitOnce.isActive();

        boolean spotTargetHitAHundredTimesBeforeDeactivate = spotTargetHitAHundredTimes.isActive();
        spotTargetHitAHundredTimes.deactivate();
        boolean spotTargetHitAHundredTimesAfterDeactivate = spotTargetHitAHundredTimes.isActive();

        assertTrue(spotTargetNotHitBeforeDeactivate);
        assertFalse(spotTargetNotHitAfterDeactivate);
        assertFalse(spotTargeHitOnceBeforeDeactivate);
        assertFalse(spotTargetHitOnceAfterDeactivate);
        assertFalse(spotTargetHitAHundredTimesBeforeDeactivate);
        assertFalse(spotTargetHitAHundredTimesAfterDeactivate);
    }

}

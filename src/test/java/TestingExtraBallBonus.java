import controller.Game;
import logic.bonus.Bonus;
import logic.bonus.DropTargetBonus;
import logic.bonus.ExtraBallBonus;
import logic.bonus.JackPotBonus;
import logic.gameelements.target.DropTarget;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestingExtraBallBonus {
    private Bonus extraBallBonus;
    private Game game;

    @Before
    public void setup(){
        Game.resetInstance();
        game=Game.getInstance();
        extraBallBonus = new ExtraBallBonus();
    }
    @Test
    public void testTrigger(){
        assertEquals(5,game.getNumberOfBalls());
        extraBallBonus.trigger(game);
        assertEquals(6,game.getNumberOfBalls());
    }
    @Test
    public void testTimesTrigger(){
        assertEquals(0,extraBallBonus.timesTriggered());
        extraBallBonus.trigger(game);
        assertEquals(1,extraBallBonus.timesTriggered());
        for(int i=0; i<99;i++){
            extraBallBonus.trigger(game);
        }
        assertEquals(100,extraBallBonus.timesTriggered());
    }
    @Test
    public void testIncreaseTimesTriggered(){
        assertEquals(0,extraBallBonus.timesTriggered());
        extraBallBonus.increaseTimesTriggered();
        assertEquals(1,extraBallBonus.timesTriggered());
        for(int i=0; i<99;i++){
            extraBallBonus.increaseTimesTriggered();
        }
        assertEquals(100,extraBallBonus.timesTriggered());
    }

}


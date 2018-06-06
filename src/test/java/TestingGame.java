import controller.Game;
import logic.table.FullPlayableTable;
import logic.table.NullTable;
import logic.table.Table;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestingGame {
    private Game game;
    private Table fullPlayableTable;
    private Table tableNull;

    @Before
    public void setup() {
        Game.resetInstance();
        game=Game.getInstance();
        tableNull =game.getTable();
        fullPlayableTable = new FullPlayableTable("fullTable", 3, 0.5, 1, 2);
        game.setTable(fullPlayableTable);
    }
    @Test
    public void testStartGame(){
        assertEquals(0, game.getCurrentScore());
        assertFalse(tableNull.isPlayableTable());
        assertEquals(tableNull.getClass(),NullTable.class);
        assertEquals(5,game.getNumberOfBalls());
        assertEquals(0,game.getDropTargetBonus().timesTriggered());
        assertEquals(0,game.getExtraBallBonus().timesTriggered());
        assertEquals(0,game.getJackPotBonus().timesTriggered());
    }
    @Test
    public void testDropBall(){
        assertEquals(5,game.getNumberOfBalls());
        game.dropBall();
        assertEquals(4,game.getNumberOfBalls());
        for(int i=0; i<100;i++)
            game.dropBall();
        assertEquals(0 ,game.getNumberOfBalls());
    }

    @Test
    public void testGameOver(){
        assertFalse(game.gameOver());
        game.dropBall();
        assertFalse(game.gameOver());
        for(int i=0; i<100;i++)
            game.dropBall();
        assertTrue(game.gameOver());

    }
}

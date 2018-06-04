import controller.Game;
import logic.table.PlayableTableWithNoTargets;
import logic.table.Table;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestingNotTargetsTable {
    private Game game;
    private Table playableWithNotTargets;

    @Before
    public void setup() {
        game=Game.getInstance();
        playableWithNotTargets = new PlayableTableWithNoTargets("notTargetsTable", 2, 0.3);
        game.setTable(playableWithNotTargets);
    }
    @Test
    public void testGetTableName(){
        String expectedNameNTT = "notTargetsTable";
        assertEquals(expectedNameNTT,playableWithNotTargets.getTableName());
    }

    @Test
    public void getNumberOfDropTargets(){
        int expectedNumberOfDroptTargets = 0;
        assertEquals(expectedNumberOfDroptTargets,playableWithNotTargets.getNumberOfDropTargets());
    }

    @Test
    public void  getCurrentlyDroppedDropTargets(){
        int expectedNumberOfDroptTargetsNTT = 0;
        assertEquals(expectedNumberOfDroptTargetsNTT,playableWithNotTargets.getCurrentlyDroppedDropTargets());
    }

    @Test
    public void  getBumpers(){}

    @Test
    public void getTargets(){
    }

    @Test
    public void resetDropTargets(){

    }

    @Test
    public void upgradeAllBumpers(){

    }

    @Test
    public void isPlayableTable(){
        assertTrue(playableWithNotTargets.isPlayableTable());
    }
}

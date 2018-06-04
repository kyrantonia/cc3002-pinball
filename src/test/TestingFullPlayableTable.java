import controller.Game;
import logic.table.FullPlayableTable;
import logic.table.Table;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestingFullPlayableTable {
    private Game game;
    private Table fullPlayableTable;
    @Before
    public void setup() {
        game=Game.getInstance();
        fullPlayableTable = new FullPlayableTable("fullTable", 3, 0.5, 0, 2);
        game.setTable(fullPlayableTable);
    }
    @Test
    public void testGetTableName(){
        String expectedName = "fullTable";
        assertEquals(expectedName,fullPlayableTable.getTableName());
    }

    @Test
    public void getNumberOfDropTargets(){
        int expectedNumberOfDroptTargets = 2;
        assertEquals(expectedNumberOfDroptTargets, fullPlayableTable.getNumberOfDropTargets());
    }

    @Test
    public void  getCurrentlyDroppedDropTargets(){
        int expectedNumberOfDroptTargets = 0;
        assertEquals(expectedNumberOfDroptTargets, fullPlayableTable.getCurrentlyDroppedDropTargets());
        fullPlayableTable.getTargets().get(0).hit();
        int expectedNumberOfDroptTargetsFTHitFirst = 1;
        assertEquals(expectedNumberOfDroptTargetsFTHitFirst,fullPlayableTable.getCurrentlyDroppedDropTargets());
        fullPlayableTable.getTargets().get(1).hit();
        int expectedNumberOfDroptTargetsFTHitSecond = 2;
        assertEquals(expectedNumberOfDroptTargetsFTHitSecond,fullPlayableTable.getCurrentlyDroppedDropTargets());
        fullPlayableTable.getTargets().get(1).hit();
        int expectedNumberOfDroptTargetsFTHitSecondAgain = 2;
        assertEquals(expectedNumberOfDroptTargetsFTHitSecondAgain,fullPlayableTable.getCurrentlyDroppedDropTargets());
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
        assertTrue(fullPlayableTable.isPlayableTable());
    }
}

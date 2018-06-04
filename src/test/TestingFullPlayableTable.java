import controller.Game;
import logic.gameelements.bumper.Bumper;
import logic.gameelements.target.Target;
import logic.table.FullPlayableTable;
import logic.table.Table;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestingFullPlayableTable {
    private Game game;
    private Table fullPlayableTable;
    @Before
    public void setup() {
        Game.resetInstance();
        game=Game.getInstance();
        fullPlayableTable = new FullPlayableTable("fullTable", 3, 0.5, 1, 2);
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
        fullPlayableTable.getTargets().get(1).hit();
        int expectedNumberOfDroptTargetsFTHitFirst = 1;
        assertEquals(expectedNumberOfDroptTargetsFTHitFirst,fullPlayableTable.getCurrentlyDroppedDropTargets());
        fullPlayableTable.getTargets().get(2).hit();
        int expectedNumberOfDroptTargetsFTHitSecond = 2;
        assertEquals(expectedNumberOfDroptTargetsFTHitSecond,fullPlayableTable.getCurrentlyDroppedDropTargets());
        fullPlayableTable.getTargets().get(2).hit();
        int expectedNumberOfDroptTargetsFTHitSecondAgain = 2;
        assertEquals(expectedNumberOfDroptTargetsFTHitSecondAgain,fullPlayableTable.getCurrentlyDroppedDropTargets());
    }

    @Test
    public void  getBumpers(){

    }

    @Test
    public void getTargets(){
    }

    @Test
    public void resetDropTargets(){
        for (Target target : fullPlayableTable.getTargets()) {
                target.hit();
        }
        for (Target target : fullPlayableTable.getTargets()) {
            assertFalse(target.isActive());
        }
        fullPlayableTable.resetDropTargets();
        assertFalse(fullPlayableTable.getTargets().get(0).isActive());
        assertTrue(fullPlayableTable.getTargets().get(1).isActive());
        assertTrue(fullPlayableTable.getTargets().get(2).isActive());
    }

    @Test
    public void upgradeAllBumpers(){
        for (Bumper bumper : fullPlayableTable.getBumpers()) {
            assertFalse(bumper.isUpgraded());
        }
        fullPlayableTable.upgradeAllBumpers();
        for (Bumper bumper : fullPlayableTable.getBumpers()) {
            assertTrue(bumper.isUpgraded());
        }
    }

    @Test
    public void isPlayableTable(){
        assertTrue(fullPlayableTable.isPlayableTable());
    }
}

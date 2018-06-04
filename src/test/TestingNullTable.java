import controller.Game;
import logic.table.NullTable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestingNullTable {
    private Game game;
    private NullTable nullTable;

    @Before
    public void setup() {
        Game.resetInstance();
        game=Game.getInstance();
        nullTable = new NullTable();
        game.setTable(nullTable);
    }
    @Test
    public void testGetTableName(){
        String expectedNameNull = "";
        assertEquals(expectedNameNull,nullTable.getTableName());
    }

    @Test
    public void getNumberOfDropTargets(){
        int expectedNumberOfDroptTargets = 0;
        assertEquals(expectedNumberOfDroptTargets, nullTable.getNumberOfDropTargets());
    }

    @Test
    public void  getCurrentlyDroppedDropTargets(){
        int expectedNumberOfDroptTargets = 0;
        assertEquals(expectedNumberOfDroptTargets, nullTable.getCurrentlyDroppedDropTargets());
    }

    @Test
    public void  getBumpers(){}

    @Test
    public void getTargets(){
    }

    @Test
    public void isPlayableTable(){
        assertFalse(nullTable.isPlayableTable());
    }
}

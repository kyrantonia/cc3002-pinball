package logic.table;

import java.util.Observable;

public class NullTable extends AbstractTable {
    public NullTable() {
        super(" ", 0, 0, 0, 0);
        isPlayable=false;
    }


}

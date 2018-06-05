package logic.table;

/**
 * Mesa que no tiene nombre, ni bumpesr ni targets.
 * @author Kyra
 */
public class NullTable extends AbstractTable {
    public NullTable() {
        super("", 0, 0, 0, 0);
        isPlayable=false;
    }


}

package logic.table;

import java.util.Observable;

public class PlayableTableWithNoTargets extends AbstractTable {
    public PlayableTableWithNoTargets(String name, int numberOfBumpers, double prob) {
        super(name, numberOfBumpers, prob, 0, 0);
        targets=hittableFactory.createTargets(getNumberOfSpotTargets(),getNumberOfDropTargets());
        isPlayable=true;
    }


}

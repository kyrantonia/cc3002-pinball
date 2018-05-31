package logic.table;

import java.util.Observable;

public class FullPlayableTable extends AbstractTable {
    public FullPlayableTable(String name, int numberOfBumpers, double prob, int numberOfSpotTargets, int numberOfDropTargets) {
        super(name, numberOfBumpers, prob, numberOfSpotTargets, numberOfDropTargets);
        bumpers=hittableFactory.createBumpers(getNumberOfBumpers(),getProb());
        targets=hittableFactory.createTargets(getNumberOfSpotTargets(),getNumberOfDropTargets());
        isPlayable=true;
    }


}

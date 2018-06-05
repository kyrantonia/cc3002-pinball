package logic.table;

/**
 * Mesa que no tiene targets
 * @author Kyra
 */
public class PlayableTableWithNoTargets extends AbstractTable {
    public PlayableTableWithNoTargets(String name, int numberOfBumpers, double prob) {
        super(name, numberOfBumpers, prob, 0, 0);
        bumpers=hittableFactory.createBumpers(getNumberOfBumpers(),getProb());
        isPlayable=true;
    }


}

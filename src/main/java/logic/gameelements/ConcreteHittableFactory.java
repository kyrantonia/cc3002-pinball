package logic.gameelements;

import controller.Game;
import logic.gameelements.bumper.Bumper;
import logic.gameelements.bumper.KickerBumper;
import logic.gameelements.bumper.PopBumper;
import logic.gameelements.target.DropTarget;
import logic.gameelements.target.SpotTarget;
import logic.gameelements.target.Target;

import java.util.ArrayList;

/**
 * Fabrica que genera arreglos de bumpers y targets
 * @author Kyra
 */
public class ConcreteHittableFactory implements HittableFactory {

    public ArrayList<Target> createTargets(int numberOfSpotTargets, int numberOfDropTargets) {
        ArrayList<Target>targets=new ArrayList<Target>();
        for(int i=0;i<numberOfSpotTargets;i++){
            targets.add(new SpotTarget());
        }
        for(int i=0;i<numberOfDropTargets;i++){
            targets.add(new DropTarget());
        }
        return targets;
    }
    public ArrayList<Bumper> createBumpers(int numberOfBumpers, double prob) {
        ArrayList<Bumper>bumpers=new ArrayList<Bumper>();
        for (int i = 0; i < numberOfBumpers; i++) {
            if(Game.getInstance().getARandomNumber() < prob){
                bumpers.add(new PopBumper());
            }
            else{
                bumpers.add(new KickerBumper());
            }
        }
        return bumpers;
    }
}

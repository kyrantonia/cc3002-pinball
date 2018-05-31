package logic.gameelements;

import logic.gameelements.bumper.Bumper;
import logic.gameelements.target.Target;

import java.util.ArrayList;

public interface HittableFactory {
    public ArrayList<Bumper> createBumpers(int numberOfBumpers, double prob);
    public ArrayList<Target> createTargets(int numberOfSpotTargets, int numberOfDropTargets);
}
package controller;

import logic.gameelements.bumper.KickerBumper;
import logic.gameelements.bumper.PopBumper;
import logic.gameelements.target.DropTarget;
import logic.gameelements.target.SpotTarget;

public interface Visitor {
    public void visitDropTarget(DropTarget target);
    public void visitSpotTarget(SpotTarget spotTarget);
    public void visitKickerBumper(KickerBumper kickerBumper);
    public void visitPopBumper(PopBumper popBumper);
}

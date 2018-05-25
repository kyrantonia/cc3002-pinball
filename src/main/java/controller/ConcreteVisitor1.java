package controller;

import logic.gameelements.bumper.KickerBumper;
import logic.gameelements.bumper.PopBumper;
import logic.gameelements.target.DropTarget;
import logic.gameelements.target.SpotTarget;

public class ConcreteVisitor1 implements Visitor {
    @Override
    public void visitDropTarget(DropTarget dropTarget) {
        dropTarget.hit();
    }

    @Override
    public void visitSpotTarget(SpotTarget spotTarget) {
        spotTarget.hit();
    }

    @Override
    public void visitKickerBumper(KickerBumper kickerBumper) {
        kickerBumper.hit();
    }

    @Override
    public void visitPopBumper(PopBumper popBumper) {
        popBumper.hit();
    }
}

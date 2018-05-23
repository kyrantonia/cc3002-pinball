package logic.gameelements;


import logic.gameelements.bumper.KickerBumper;
import logic.gameelements.bumper.PopBumper;
import logic.gameelements.target.DropTarget;
import logic.gameelements.target.SpotTarget;

public class ConcreteHittableFactory implements HittableFactory {

    @Override
    public PopBumper createPopBumper() {
        return new PopBumper();
    }

    @Override
    public KickerBumper createKickerBumper() {
        return new KickerBumper();
    }

    @Override
    public DropTarget createDropTarget() {
        return new DropTarget();
    }

    @Override
    public SpotTarget createSpotTarget() {
        return new SpotTarget();
    }
}

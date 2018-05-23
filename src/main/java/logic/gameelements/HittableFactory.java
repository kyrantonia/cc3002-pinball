package logic.gameelements;

import logic.gameelements.bumper.KickerBumper;
import logic.gameelements.bumper.PopBumper;
import logic.gameelements.target.DropTarget;
import logic.gameelements.target.SpotTarget;

public interface HittableFactory {
    public PopBumper createPopBumper();
    public KickerBumper createKickerBumper();
    public DropTarget createDropTarget();
    public SpotTarget createSpotTarget();
}

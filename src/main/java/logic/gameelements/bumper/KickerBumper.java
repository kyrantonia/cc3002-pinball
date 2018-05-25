package logic.gameelements.bumper;

import controller.Visitor;

public class KickerBumper extends AbstractBumper {

    public KickerBumper() {
        super(500, 5,1000);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitKickerBumper(this);
    }
}

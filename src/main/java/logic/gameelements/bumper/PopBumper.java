package logic.gameelements.bumper;

import controller.Visitor;

public class PopBumper extends AbstractBumper{

    public PopBumper() {
        super(100, 3,300);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPopBumper(this);
    }
}

package logic.table;

import logic.gameelements.bumper.Bumper;
import logic.gameelements.target.Target;

public interface Visitor {
    public void visitTarget(Target target);
    public void visitBumper(Bumper bumper);

}

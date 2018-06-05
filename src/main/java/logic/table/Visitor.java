package logic.table;

import logic.bonus.DropTargetBonus;
import logic.bonus.ExtraBallBonus;
import logic.bonus.JackPotBonus;
import logic.gameelements.Hittable;


public interface Visitor {
    public void visitDropTargetBonus(DropTargetBonus dropTargetBonus);
    public void visitExtraBallBonus(ExtraBallBonus extraBallBonus);
    public void visitJackPotBonus(JackPotBonus jackPotBonus);
    public void visitHittable(Hittable hittable);
}

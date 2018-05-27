package logic.table;

import logic.bonus.DropTargetBonus;
import logic.bonus.ExtraBallBonus;
import logic.bonus.JackPotBonus;


public interface Visitor {
    public void visitDropTargetBonus(DropTargetBonus dropTargetBonus);
    public void visitExtraBallBonus(ExtraBallBonus extraBallBonus);
    public void visitJackPotBonus(JackPotBonus jackPotBonus);

}

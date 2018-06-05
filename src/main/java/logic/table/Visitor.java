package logic.table;

import logic.bonus.DropTargetBonus;
import logic.bonus.ExtraBallBonus;
import logic.bonus.JackPotBonus;
import logic.gameelements.Hittable;

/**
 * Implentación de la clase Visitor para utilizar el patrón de diseño Visitor
 * @author Kyra
 */

public interface Visitor {
    /**
     * Acciones que se realizan cuando el elemento visitado es un dropTargetBonus
     * @param dropTargetBonus dropTargetBonus visitado
     */
    public void visitDropTargetBonus(DropTargetBonus dropTargetBonus);

    /**
     * Acciones que se realizan cuando el elemento visitado es un ExtraBall bonus
     * @param extraBallBonus extraBallBonus visitado
     */
    public void visitExtraBallBonus(ExtraBallBonus extraBallBonus);

    /**
     * Acciones que se realizan cuando el elemento visitado es un JackPotBonus
     * @param jackPotBonus jackPotBonus visitado
     */
    public void visitJackPotBonus(JackPotBonus jackPotBonus);

    /**
     *  Acciones que se realizan cuando el elemento visitado es un Hittable
     * @param hittable hittable visitado
     */
    public void visitHittable(Hittable hittable);
}

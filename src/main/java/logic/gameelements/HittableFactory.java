package logic.gameelements;

import logic.gameelements.bumper.Bumper;
import logic.gameelements.target.Target;

import java.util.ArrayList;

/**Se crean arreglos de los hittables que se usarán en el juego
 * @author Kyra Cossio
 */
public interface HittableFactory {
    /**
     * Se crea un arreglo de bumpers
     * @param numberOfBumpers número total de bumpers que se quieren crear
     * @param prob probabilidad  de crear un PopBumper
     * @return arreglo de bumpers
     */
    public ArrayList<Bumper> createBumpers(int numberOfBumpers, double prob);

    /**
     * Se crea un arreglo de targets
     * @param numberOfSpotTargets cantidad de SpotTargets a crear
     * @param numberOfDropTargets cantidad de DropTarget a crear
     * @return arreglo de targets
     */
    public ArrayList<Target> createTargets(int numberOfSpotTargets, int numberOfDropTargets);
}
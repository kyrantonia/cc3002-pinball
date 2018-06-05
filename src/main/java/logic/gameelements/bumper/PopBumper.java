package logic.gameelements.bumper;
/**
 * Bumper que entrega por defecto 100 puntos al ser golpeado.
 * Puede hace upgrade cuando es golpeado  3 veces
 * con lo que entregará desde ese momento 300 puntos por golpe.
 * @author Kyra
 */

public class PopBumper extends AbstractBumper{

    public PopBumper() {
        super(100, 3,300);
    }

}

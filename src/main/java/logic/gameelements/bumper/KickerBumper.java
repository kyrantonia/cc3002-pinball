package logic.gameelements.bumper;

/**
 * Bumper que entrega por defecto 500 puntos al ser golpeado.
 * Puede hace upgrade cuando es golpeado  5 veces
 * con lo que entregará desde ese momento mil puntos por golpe.
 * @author Kyra
 */
public class KickerBumper extends AbstractBumper {

    public KickerBumper() {
        super(500, 5,1000);
    }
}

package logic.bonus;

import logic.gameelements.Hittable;

import java.util.Observable;
import java.util.Observer;

import controller.Game;

public class JackPotBonus extends AbstractBonus {

    @Override
    public void update(Observable observable, Object o) {
        if(observable instanceof Hittable){
            Hittable hittable= (Hittable) observable;
            Game.getInstance().increaaseNumberOfBalls(1);
            System.out.printf("holi");

        }
    }

}

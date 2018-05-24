package logic.bonus;

public class JackPotBonus extends AbstractBonus {

    private static JackPotBonus instance;
    int timesTriggered;
    private JackPotBonus(){
        super();
    }
    public static JackPotBonus getInstance(){
        if(instance==null){
            instance= new JackPotBonus();
        }
        return instance;
    }
}

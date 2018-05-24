package logic.bonus;

public class ExtraBallBonus extends AbstractBonus {
    private static ExtraBallBonus instance;
    int timesTriggered;
    private ExtraBallBonus(){
        super();
    }
    public static ExtraBallBonus getInstance(){
        if(instance==null){
            instance= new ExtraBallBonus();
        }
        return instance;

    }
}

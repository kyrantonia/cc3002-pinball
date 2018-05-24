package logic.bonus;

public class DropTargetBonus extends AbstractBonus{
    private static DropTargetBonus instance;
    int timesTriggered;
    private DropTargetBonus(){
        super();
    }
    public static DropTargetBonus getInstance(){
        if(instance==null){
            instance= new DropTargetBonus();
        }
        return instance;

    }
}

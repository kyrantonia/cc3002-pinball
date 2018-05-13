package logic.gameelements;


public abstract class AbstractHittable implements logic.gameelements.Hittable {
    protected int score;
    public  AbstractHittable(int score){
        this.score=score;
    }

    public int getScore() {
        return score;
    }

}

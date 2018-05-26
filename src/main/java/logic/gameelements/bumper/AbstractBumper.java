package logic.gameelements.bumper;

import controller.Game;
import logic.gameelements.AbstractHittable;
import logic.table.Visitor;

abstract public class AbstractBumper extends AbstractHittable implements Bumper {
    private int defaultScore;
    private int defaultHitsToUpgrade;
    private int hitsToUpgrade;
    private int upgradedScore;
    private boolean isUpgrade;


    AbstractBumper(int score, int hitsToUpgrade,int upgradedScore){
        super(score);
        this.hitsToUpgrade = hitsToUpgrade;
        this.upgradedScore = upgradedScore;
        this.isUpgrade = false;
        this.defaultScore = score;
        this.defaultHitsToUpgrade = hitsToUpgrade;
    }
    public int hit(){
        int increment=this.getScore();
        setChanged();
        notifyObservers(increment);
        return increment;
    }
    public int hit1() {
        int increment=this.getScore();
        Game.getInstance().increaseScore(increment);
        if(this.remainingHitsToUpgrade()== 0 && !isUpgraded()) {
            this.upgrade();
            this.invokeBonus();
        }
        return increment;
    }

    public int remainingHitsToUpgrade(){
        this.hitsToUpgrade = Math.max(0,hitsToUpgrade-1);
        return hitsToUpgrade;
    }
    public boolean isUpgraded(){
        return isUpgrade;
    }

    private int getUpgradedScore(){
        return this.upgradedScore;
    }
    public void invokeBonus(){
        Game.getInstance().getExtraBallBonus().trigger(Game.getInstance());
    }
    @Override
    public void upgrade() {
        score = this.getUpgradedScore();
        isUpgrade = true;
    }

    @Override
    public void downgrade() {
        this.score = this.defaultScore;
        this.hitsToUpgrade = defaultHitsToUpgrade;
        isUpgrade = true;
    }

    public void accept(Visitor visitor) {
        visitor.visitBumper(this);
    }

}

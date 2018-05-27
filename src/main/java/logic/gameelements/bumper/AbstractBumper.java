package logic.gameelements.bumper;

import controller.Game;
import logic.gameelements.AbstractHittable;

abstract public class AbstractBumper extends AbstractHittable implements Bumper {
    private int defaultScore;
    private int defaultHitsToUpgrade;
    private int hitsToUpgrade;
    private int upgradedScore;
    private boolean isUpgrade;


    AbstractBumper(int score, int hitsToUpgrade,int upgradedScore){
        super(score, Game.getInstance().getExtraBallBonus());
        this.hitsToUpgrade = hitsToUpgrade;
        this.upgradedScore = upgradedScore;
        this.isUpgrade = false;
        this.defaultScore = score;
        this.defaultHitsToUpgrade = hitsToUpgrade;
    }
    public int hit(){
        int increment=this.getScore();
        decreaseHitsToUpgrade(1);
        if(this.remainingHitsToUpgrade()== 0 && !this.isUpgraded()) {
            this.upgrade();
            setChanged();
            notifyObservers(getBonus());
        }
        Game.getInstance().increaseScore(increment);
        return increment;
    }

    public void decreaseHitsToUpgrade(int decrease){
        this.hitsToUpgrade=Math.max(hitsToUpgrade-decrease,0);
    }
    public int remainingHitsToUpgrade(){
        this.hitsToUpgrade = Math.max(0,hitsToUpgrade);
        return hitsToUpgrade;
    }
    public boolean isUpgraded(){
        return isUpgrade;
    }

    private int getUpgradedScore(){
        return this.upgradedScore;
    }

    @Override
    public void upgrade() {
        score = this.getUpgradedScore();
        isUpgrade = true;
        this.hitsToUpgrade=0;
        }

    @Override
    public void downgrade() {
        this.score = this.defaultScore;
        this.hitsToUpgrade = defaultHitsToUpgrade;
        isUpgrade = true;
    }


}

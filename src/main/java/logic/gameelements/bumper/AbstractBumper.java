package logic.gameelements.bumper;

import controller.Game;
import logic.gameelements.AbstractHittable;

abstract public class AbstractBumper extends AbstractHittable implements Bumper {
    private int defaultScore;
    private int defaultHitsToUpgrade;
    private int hitsToUpgrade;
    private int upgradedScore;
    private boolean isUpgrade;
    

    public AbstractBumper(int score, int hitsToUpgrade,int upgradedScore){
        super(score);
        this.hitsToUpgrade = hitsToUpgrade;
        this.upgradedScore = upgradedScore;
        this.isUpgrade=false;
        this.defaultScore=score;
        this.defaultHitsToUpgrade=hitsToUpgrade;
    }

    public int hit() {
        int increment=this.getScore();
        Game.getInstance().increaseScore(increment);
        if(this.remainingHitsToUpgrade()==0) {
            this.upgrade();
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

    public int getUpgradedScore(){
        return this.upgradedScore;
    }

    @Override
    public void upgrade() {
        score = this.getUpgradedScore();
        isUpgrade = true;
    }

    @Override
    public void downgrade() {
        this.score = this.defaultScore;
        this.hitsToUpgrade=defaultHitsToUpgrade;
        isUpgrade = true;
    }


}

public class U2 extends Rocket{

    private static final double percentToCalculateLaunchExplosion = 0.04;
    private static final double percentToCalculateLandCrash = 0.08;

    public U2(){
        super(120, 18, 29);
    }

    public boolean launch() {
        double chanceExplosion = percentToCalculateLaunchExplosion * (this.cargoCarried / (this.maxWeight));
        double random = Math.random();
        if(random > chanceExplosion) {
            return true;
        } else {
            return false;
        }
    }
    public boolean land() {
        double chanceExplosion = percentToCalculateLandCrash * (this.cargoCarried / (this.maxWeight));
        double random = Math.random();
        if(random > chanceExplosion) {
            return true;
        } else {
            return false;
        }
    }

}


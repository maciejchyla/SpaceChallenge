public class U1 extends Rocket{

    private static final double percentToCalculateLaunchExplosion = 0.05;
    private static final double percentToCalculateLandCrash = 0.01;

     public U1(){
         super(100, 10, 18);
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

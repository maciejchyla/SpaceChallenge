public class Rocket implements SpaceShip {

    public int rocketCost;
    public int rocketWeight;
    public int maxWeight;
    public int cargoCarried;

    public Rocket(int rocketCost, int rocketWeightInTone, int maxWeightInTone){
        this.rocketCost = rocketCost;
        this.rocketWeight = toneToKg(rocketWeightInTone);
        this.maxWeight = toneToKg(maxWeightInTone);
        this.cargoCarried = this.rocketWeight;
    }

    public boolean launch() {
        return true;
    }
    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        if(this.cargoCarried+item.weight <= (this.maxWeight)){
            return true;
        } else {
            return false;
        }
    }

    public void carry(Item item) {
        this.cargoCarried += item.weight;
    }

    public int toneToKg(int tone){
        return tone *1000;
    }
}

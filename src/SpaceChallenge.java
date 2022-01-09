import java.util.ArrayList;

public class SpaceChallenge {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();

        ArrayList<Item> itemsPhase1 = simulation.loadItems("phase-1.txt");
        ArrayList<Item> itemsPhase2 = simulation.loadItems("phase-2.txt");

        ArrayList<Rocket> rocketsU1Phase1 = simulation.loadU1(itemsPhase1);
        ArrayList<Rocket> rocketsU1Phase2 = simulation.loadU1(itemsPhase2);
        int costRocketsPhase1 = simulation.runSimulation(rocketsU1Phase1);
        int costRocketsPhase2 = simulation.runSimulation(rocketsU1Phase2);

        simulation.printResults("U1 rocket simulation", costRocketsPhase1, costRocketsPhase2);

        ArrayList<Rocket> rocketsU2Phase1 = simulation.loadU2(itemsPhase1);
        ArrayList<Rocket> rocketsU2Phase2 = simulation.loadU2(itemsPhase2);
        costRocketsPhase1 = simulation.runSimulation(rocketsU2Phase1);
        costRocketsPhase2 = simulation.runSimulation(rocketsU2Phase2);

        simulation.printResults("U2 rocket simulation", costRocketsPhase1, costRocketsPhase2);
    }
}

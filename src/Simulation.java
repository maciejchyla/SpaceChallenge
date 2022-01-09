import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public ArrayList<Item> loadItems(String fileName){
        File file = new File(fileName);
        Scanner scanner = null;
        ArrayList<Item> items = new ArrayList<>();
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        while (scanner.hasNextLine()){

            String[] product = scanner.nextLine().split("=");
            items.add(new Item(product[0], Integer.parseInt(product[1])));
        }
        scanner.close();
        return items;
    }
    public ArrayList<Rocket> loadU1 (ArrayList<Item> rocketItems){
        return loadRocket(rocketItems, "U1");
    }

    public ArrayList<Rocket> loadU2 (ArrayList<Item> rocketItems){
        return loadRocket(rocketItems, "U2");
    }

    public ArrayList<Rocket> loadRocket (ArrayList<Item> rocketItems, String rocketType){
        ArrayList<Rocket> rockets = new ArrayList<>();
        ArrayList<Item> items = new ArrayList<>(rocketItems);
        Rocket rocket = null;

        while(items.size() > 0){

            switch (rocketType) {
                case "U1":   rocket = new U1();
                break;
                case "U2":   rocket = new U2();
                break;
            }

            boolean rocketFull = false;
            while (!rocketFull) {
                Item item = new Item();
                for (Item value : items) {
                    if (item.weight < value.weight && rocket.canCarry(value)) {
                        item = value;
                    }
                }

                rocket.carry(item);
                items.remove(item);

                rocketFull = true;
                for (Item value : items) {
                    if (rocket.canCarry(value)){
                        rocketFull = false;
                    }
                }
            }
            rockets.add(rocket);
        }
//        System.out.println("number of rockets: " + rockets.size());
        return rockets;
    }

    public int runSimulation(ArrayList<Rocket> rockets){
        int cost = 0;
        int lostRocket = 0;

        for (Rocket rocket : rockets) {
            boolean launch = false;
            boolean land = false;

                do {
                    cost += rocket.rocketCost;
                    launch = rocket.launch();
                    if (launch) {
                        land = rocket.land();
                        if (!land){
                            lostRocket++;
                            launch = false;
                        }
                    } else {
                        lostRocket++;
                    }
                } while (!launch || !land);
        }
//        System.out.println("lost Rockets: " + lostRocket);
        return cost;
    }

    public void printResults(String title, int costRocketsPhase1, int costRocketsPhase2){
        System.out.println(title.toUpperCase());
        System.out.println("Phase-1 Budget needed: $" + costRocketsPhase1 + " Million");
        System.out.println("Phase-2 Budget needed: $" + costRocketsPhase2 + " Million");
        System.out.println("Total budget required: $" + (costRocketsPhase1 + costRocketsPhase2) + " Million\n");
    }
}

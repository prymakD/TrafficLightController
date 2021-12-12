package trafficController;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //User decides how many cycles of moving  program will simulate
        System.out.print("Enter number of cycles: ");
        int numberOfCycles = Integer.valueOf(scanner.nextLine());

        while (numberOfCycles != 0) {
            System.out.print("Please enter number of Cars on road A(if it's not first cycle please put " +
                    " new number of cars on road A from previous cycle: ");
            int numberOfCarsA = Integer.valueOf(scanner.nextLine());
            driver(numberOfCarsA, numberOfCarsB());
            numberOfCycles--;
        }
    }

    private static void driver(int numberOfCarsA, int numberOfCarsB) {
        /*
        Param:
            int numberOfCarsA - input from user and if second and more cycle you need to put new number from previous cylce
            int numberOfCarsB - random number from method numberOfCarsB()
        Usage:
            do one cycle of using both A and B roads, using 4 priority rules and stops after
            cycle of road B
            if there is no cars on road A still uses rule for and grand another cycle for road B
         */

        System.out.println("Cars on road A: " + numberOfCarsA);

        System.out.println("Road A: YR");
        System.out.println("Road A: G");
        //priority rule 1
        for (int i = 20; i != 0; i -= 2) {
            if (!inductiveLoops(numberOfCarsA)) {
                break;
            }
            System.out.printf("Car on road A passed \n");
            numberOfCarsA--;
        }
        System.out.println("\n Are there still cars on road A: " + inductiveLoops(numberOfCarsA));
        System.out.println("Left cars on road A: " + numberOfCarsA);

        //priority rule 2
        if (inductiveLoops(numberOfCarsA)) {
            while (numberOfCarsA != 0) {
                System.out.println("Car on road A passed");
                numberOfCarsA--;
            }
        }

        System.out.println("\nRoad A: Y");
        System.out.println("Road A: R");
        System.out.println("Road B: YR");
        System.out.println("Road B: G\n");

        System.out.println("Number of cars road B: " + numberOfCarsB);

        //priority rule 3
        for (int i = 20; i != 0; i -= 2) {
            if (!inductiveLoops(numberOfCarsB)) {
                break;
            }
            System.out.println("Car on road B passed ");
            numberOfCarsB--;
        }

        System.out.println("\nRoad B: Y");
        System.out.println("Road B: R\n");

        int newNumberOfCarsA = numberOfCarsA();
        System.out.println("Number of cars on road B left: " + numberOfCarsB);
        System.out.println("New number of cars road A: " + newNumberOfCarsA);
        System.out.println("Are there any cars waiting on road A: " + inductiveLoops(newNumberOfCarsA));

        //priority rule 4
        if (!inductiveLoops(newNumberOfCarsA)) {
            System.out.println("Road B: YR");
            System.out.println("Road B: G");
            while (numberOfCarsB != 0) {
                System.out.println("Car on road B passed");
                numberOfCarsB--;
            }
            System.out.println("Road B: Y");
            System.out.println("Road B: R");
        }
    }

    private static boolean inductiveLoops(int numberOfCars) {
        /*
        return true if there are cars staying on the traffic light
        false if there are no cars
         */
        if (numberOfCars > 0) {
            return true;
        }
        return false;
    }

    //rendomising number of cars on the road not more than 15
    private static int numberOfCarsA() {
        int numberOfCarsA = ThreadLocalRandom.current().nextInt(0, 20 + 1);
        return numberOfCarsA;
    }

    private static int numberOfCarsB() {
        int numberOfCarsB = ThreadLocalRandom.current().nextInt(0, 20 + 1);
        return numberOfCarsB;
    }
}

package com.abdullah.AirportSystem;

public class Main {
    public static void main(String[] args) throws Exception {
        FuelBaseQueue landingQueue = new FuelBaseQueue(); // this is priority on fuel base queue (based on low fuels).
        ArrivalTimeBaseQueue arrivalTimeBaseQueue = new ArrivalTimeBaseQueue(); // this is circular queue that im using dyanamic array.
        landingQueue.addForLanding(1001, 5);
        landingQueue.addForLanding(1002, 4);
        landingQueue.addForLanding(1003, 3);
        landingQueue.addForLanding(1004, 2);
        System.out.println("Landing Queue (by fuel priority):");
        landingQueue.displayLandingPlanes();
        System.out.println();
        System.out.println("Takeoff Queue (FIFO):");
        arrivalTimeBaseQueue.insertInTimeBaseQueue(1001, 1);
        arrivalTimeBaseQueue.insertInTimeBaseQueue(1002, 2);
        arrivalTimeBaseQueue.insertInTimeBaseQueue(1003, 3);
        arrivalTimeBaseQueue.insertInTimeBaseQueue(1004, 4);

        arrivalTimeBaseQueue.displayTimeBaseQueue();
        System.out.println();
        System.out.println("Landing Planes: ");
        System.out.println(landingQueue.removeForLanding() + " has landed.");
        System.out.println(landingQueue.removeForLanding() + " has landed.");
        System.out.println();
        System.out.println("Landing Queue (by fuel priority):");
        landingQueue.displayLandingPlanes();
        System.out.println();
        System.out.println("Takeoff Planes: ");
        System.out.println(arrivalTimeBaseQueue.remove()+ " has taken off.");
        System.out.println(arrivalTimeBaseQueue.remove()+ " has taken off.");
        System.out.println();
        System.out.println("Takeoff Queue (FIFO):");
        arrivalTimeBaseQueue.displayTimeBaseQueue();
    }
}

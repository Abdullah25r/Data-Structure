package com.abdullah.AirportSystem;

import java.util.ArrayList;

public class FuelBaseQueue {
    ArrayList<Plane> planes = new ArrayList<>();
    public void addForLanding(int planeId, int priority) {
         planes.add(new Plane(planeId, priority));
    }
    public Plane removeForLanding() {
        int minFuelLevel = Integer.MAX_VALUE;
        for (Plane plane : planes) {
            if (plane.fuelLevel < minFuelLevel) {
                minFuelLevel = plane.fuelLevel;
            }
        }
        for (Plane plane : planes) {
            if (plane.fuelLevel == minFuelLevel) {
                planes.remove(plane);
                return plane;
            }
        }
        return null;
    }
    public void displayLandingPlanes(){
        for (Plane plane : planes) {
            System.out.println(plane);
        }
    }




    private class Plane{
        int planeId;
        int fuelLevel;

        public Plane() {
        }

        public Plane(int planeId, int fuelLevel) {
            this.planeId = planeId;
            this.fuelLevel = fuelLevel;
        }

        @Override
        public String toString() {
            return
                    "Plane ID:  L" + planeId +
                    ", Fuel Level: " + fuelLevel;
        }
    }
}

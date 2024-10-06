package com.abdullah.Airpot;

public class ArrivalTimeBaseQueue  {
    // I am using array approach to implement it

     Plane[] timeBaseQueue;
    public final int DEFAULT_CAPACITY = 10;
    protected int end = 0;
    protected int front = 0;
    private int size = 0;
    public ArrivalTimeBaseQueue() {
        timeBaseQueue = new Plane[DEFAULT_CAPACITY];
    }

    public ArrivalTimeBaseQueue(int capacity) {
        timeBaseQueue = new Plane[capacity];
    }
    public boolean insertInTimeBaseQueue(int planeId, int arrivalTime) {
        if (isFull()) {
            Plane[] temp = new Plane[timeBaseQueue.length * 2];
            for (int i = 0; i < timeBaseQueue.length; i++) {
                temp[i] = timeBaseQueue[(front + i) % timeBaseQueue.length];
            }
            front = 0;
            end = timeBaseQueue.length - 1;
            timeBaseQueue = temp;
        }
        timeBaseQueue[end++] = new Plane(planeId, arrivalTime);
        end = end % timeBaseQueue.length;
        size++;
        return true;
    }
    public Plane remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }

        Plane removed = timeBaseQueue[front++];
        front = front % timeBaseQueue.length;
        size--;
        return removed;
    }
    public void displayTimeBaseQueue(){
        if(isEmpty()){
            System.out.println("Circular Queue is empty");
            return;
        }
        int i = front;
        do {
            System.out.println(timeBaseQueue[i]);
            i++;
            i%=timeBaseQueue.length;
        }while (i!=end);

    }

    public boolean isFull() {
        return size == timeBaseQueue.length;
    }
    public boolean isEmpty() {
        return size == 0;
    }


    private class Plane{
        int planeId;
        int arrivalTime;

        public Plane() {
        }



        public Plane(int planeId, int arrivalTime) {
            this.planeId = planeId;
            this.arrivalTime = arrivalTime;
        }

        @Override
        public String toString() {
            return
                    "Plane ID = T" + planeId +
                    ", Arrival Time=" + arrivalTime;
        }
    }
}

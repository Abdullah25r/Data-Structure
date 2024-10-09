package com.abdullah.Queue;

public class CustomQueue {
    int[] data;
    int DEFAULT_CAPACITY = 5;
    int ptr = -1;
    int front = 0;
    int size;
    public CustomQueue() {
        data = new int[DEFAULT_CAPACITY];
    }
    public CustomQueue(int capacity) {
        data = new int[capacity];
    }
    public void enqueue(int item) {
        if (isFull()) {
            int[] temp = new int[data.length * 2];
            System.arraycopy(data, 0, temp, 0, data.length);
            data = temp;
        }
        size++;
        ptr++;
        data[ptr] = item;
    }
    public int dequeue() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        int item = data[front];
        // Shift element to back index 1
        for(int i = 1; i < data.length; i++){
            data[i-1] = data[i];
        }
        size--;
        return item;
    }
    public void display(){
        for(int i = 0; i < size; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println("END");
    }
    public boolean isEmpty() {
        return ptr == -1;
    }
    public boolean isFull() {
       return ptr == data.length-1;
    }
}

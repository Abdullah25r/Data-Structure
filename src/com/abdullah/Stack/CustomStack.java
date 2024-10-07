package com.abdullah.Stack;

public class CustomStack {
    protected int val;
    protected int ptr = -1;
    protected int[] data;
   protected final int DEFAULT_CAPACITY = 10;
    public CustomStack() {
        data = new int[DEFAULT_CAPACITY];
    }
    public CustomStack(int capacity) {
        data = new int[capacity];
    }
    public int peak() throws Exception {
        if(isEmpty()){
            throw new Exception("Stack is empty");
        }
        return data[ptr];
    }
    public void push(int val) {
        if(isFull()){
            int[] temp = new int[data.length * 2];
            System.arraycopy(data, 0, temp, 0, data.length);
            data = temp;
        }
        ptr++;
        data[ptr] = val;
    }
    public int pop() throws Exception {
        if(isEmpty()){
            throw new Exception("Stack is empty");
        }
        return data[ptr--];
    }
    public void display(){
        int temp = 0;
        while(temp <= ptr){
            System.out.print(data[temp] + " ");
            temp++;
        }
        System.out.println();
    }


    public boolean isEmpty() {
        return ptr == -1;
    }
    public boolean isFull() {
        return ptr == data.length - 1;
    }


}

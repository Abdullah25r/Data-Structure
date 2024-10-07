package com.abdullah.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        CustomStack stack = new CustomStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.display();
        System.out.println(stack.pop());
        stack.display();
        stack.push(50);
        stack.push(60);
        stack.display();
        System.out.println(stack.pop());
        stack.display();
    }
}

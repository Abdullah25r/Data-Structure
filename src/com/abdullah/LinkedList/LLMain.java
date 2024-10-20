package com.abdullah.LinkedList;

public class LLMain {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(7);
        list.insertFirst(6);
//        list.display();
//        System.out.println();
//        System.out.println(list.deleteFirst());
//        System.out.println(list.deleteLast());
//        list.display();
//        System.out.println();
//        list.insertAt(2,2);
        list.display();
        System.out.println("\nRecursively displaying list");
        list.insertRec(9, 2);
        list.display();
    }
}

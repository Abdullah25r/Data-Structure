package com.abdullah.LinkedList;

public class DLLMain {
    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.insertFirst(5);
        dll.insertFirst(4);
        dll.insertFirst(3);
        dll.insertFirst(2);
        dll.insertFirst(1);
        dll.insertFirst(0);
        dll.display();
//        dll.displayRev();
        dll.insertAt(2, 0);
        dll.display();
        System.out.println(dll.deleteFirst());
        dll.display();
        System.out.println(dll.deleteLast());
        dll.display();
        System.out.println(dll.deleteAt(1));
        dll.display();
        System.out.println(dll.size);
    }
}

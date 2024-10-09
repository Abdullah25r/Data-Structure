package com.abdullah.LinkedList;

import java.util.LinkedList;

public class CLLMain {
    public static void main(String[] args) {
        CLL list = new CLL();
        list.insert(5);
        list.insert(3);
        list.insert(2);
        list.insert(1);
        list.insert(0);
        list.insert(4);
        list.display();
        list.delete(2);
        list.display();

    }
}

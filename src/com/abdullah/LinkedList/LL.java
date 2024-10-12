package com.abdullah.LinkedList;

public class LL {
    Node head;
    Node tail;
    int size;
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else{
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }
    public void insertAt(int index, int data) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
        }
        Node newNode = new Node(data);
        if (index == 0) {
            insertFirst(data);
            return;
        }
        if (index == size) {
            insertLast(data);
            return;
        }
        Node temp = head;
        for (int i = 1; i <= index; i++) {
            if (i == index) {
                newNode.next = temp.next;
                temp.next = newNode;
            }
            temp = temp.next;
        }
    }
    public int deleteFirst(){
        if (head == null) {
            return -1;
        }
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }
    public int deleteLast(){
        if (head == null) {
            return -1;
        }
        if (head.next == null) {
            int data = head.data;
            head = null;
            tail = null;
            return data;
        }
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        int data = temp.data;
        tail = temp;
        tail.next = null;
        size--;
        return data;
    }
    public int deleteAt(int index){
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return -1;
        }
        if (index == 0) {
            int data = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return data;
        }
        Node temp = head;
        for (int i = 0; i < index-1; i++) {
            temp = temp.next;
        }
        if (temp.next == tail) {
            int data = tail.data;
            temp.next = null;
            tail = temp;
            size--;
            return data;
        }
        int data = temp.next.data;
        temp.next = temp.next.next;
        return data;

    }
    public void display(){
        if (head == null) {
            System.out.println("List is empty");
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }






     class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }

    }
}

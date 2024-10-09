package com.abdullah.LinkedList;

public class DLL {
    Node head;
    Node tail;
    public DLL(){
        head = null;
        tail = null;
    }
    int size = 0;
    public void insertFirst(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }
    public void insertLast(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }
    public void insertAt(int index, int val){
        Node newNode = new Node(val);
        if (index == 0){
            insertFirst(val);
            return;
        }
        if (index == size){
            insertLast(val);
            return;
        }
        if(index<0 || index>size){
            System.out.println("invalid index");
            return;
        }
        Node temp = head;
        for(int i = 0; i < index-1; i++){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;
    }
    public int deleteFirst(){
        if(head == null){
            System.out.println("List is empty.");
            return -1;
        }
        size--;
        int val = head.data;
        head = head.next;
        head.prev = null;
        return val;
    }
    public int deleteLast(){
        if(head == null){
            System.out.println("List is empty.");
            return -1;
        }
        int val = tail.data;
        //this is intellisense
//        tail = tail.prev;
//        tail.next = null;
        // this is my logic
        size--;
        tail.prev.next = null;
        tail = tail.prev;
        return val;
    }
    public int deleteAt(int index){
        if(index == 1){
            return deleteFirst();
        }
        if(index == size){
            return deleteLast();
        }
        if(index < 0 || index > size){
            System.out.println("invalid index");
            return -1;
        }
        Node temp = head;
        for(int i = 0; i < index-1; i++){
            temp = temp.next;
        }
        int val = temp.data;
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        return val;
    }







    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void displayRev(){
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }












    private class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data) {
            this.data = data;
        }
        public Node() {}
        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}

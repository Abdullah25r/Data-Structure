package com.abdullah.LinkedList;

public class CLL {
    Node head;
    Node tail;
    public CLL() {
        this.head = null;
        this.tail = null;
    }
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        newNode.next = head;
    }
    public void display() {
        Node temp = head;
        if(temp != null){
            do{
                System.out.print(temp.data + " ");
                if(temp.next !=  null){
                    temp = temp.next;
                }
            }while(temp != head);
        }
        System.out.println();
    }
    public void delete(int data) {
        Node temp = head;
        if(temp == null){
            System.out.println("The list is empty");
            return;
        }
        if(head == tail){
            head = null;
            tail = null;
            return;
        }
        if(temp.data == data){
            head = temp.next;
            tail.next = head;
            return;
        }
        do{
            Node next = temp.next;
            if(next.data == data){
                temp.next = next.next;
                break;
            }
            temp = temp.next;
        }while (temp != head);
    }




    private class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
}

package com.abdullah.BrowsingHistory;

public class BrowsingHistory {

    Node head;
    Node tail;
    Node current;
    public BrowsingHistory(){
        current = null;
    }
    public void visit(String url) {
        Node newNode = new Node(url);
        if (head == null) {
            head = newNode;
            tail = newNode;
            current = newNode;
            return;
        }
        if (current != tail) {
            current.next = null;
            tail = current;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        current = newNode;
    }


    public void goBack() {
        if (current == null) {
            System.out.println("History list is empty.");
            return;
        }
        if (current.prev == null) {
            System.out.println("No history backward.");
            return;
        }
        current = current.prev; // Move current to the previous node
        System.out.println("Back to: " + current.url); // Print the updated current URL
    }


    public void goForward() {
        if (current == null) {
            System.out.println("History list is empty.");
            return;
        }
        if (current.next == null) {
            System.out.println("No history forward.");
            return;
        }
        current = current.next; // Move current to the next node
        System.out.println("Forward to: " + current.url); // Print the updated current URL
    }


    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head; // Use a temporary pointer to traverse the list
        while (temp != null) {
            System.out.println("Visited: " + temp.url);
            temp = temp.next;
        }
        System.out.println();
    }








    private class Node{
        String url;
        Node prev;
        Node next;
        public Node(String url){
            this.url = url;
        }
    }
}

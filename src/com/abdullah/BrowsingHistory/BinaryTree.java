package com.abdullah.BrowsingHistory;

import java.util.Stack;

public class BinaryTree {

    Node root;



    public void insertNode(String name, int score) {
        Node newNode = new Node(name, score);

        if (root == null) {
            root = newNode;
            return;
        }

        Node ptr = root;
        Node parent = null;

        while (ptr != null) {
            parent = ptr;

            if (newNode.score > ptr.score) {
                ptr = ptr.right;
            } else {
                ptr = ptr.left;
            }
        }

        // Now we know where to insert the new node
        if (newNode.score > parent.score) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
    }

    public void displaytraversal() {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.right;
            }

            current = stack.pop();
            System.out.print(current.name + " "+ current.score);
            System.out.println();
            current = current.left;
        }
    }



    private  class Node{
        String name;
        int score;
        Node left;
        Node right;
        public Node(String name, int score){
            this.name = name;
            this.score = score;
        }
    }
}

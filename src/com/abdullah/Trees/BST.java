package com.abdullah.Trees;

public class BST {
     Node root;
    public BST() {}
    // iterative algorithms
    public void insert(int val) {
        if(root == null){
            root = new Node(val);
            return;
        }
        Node current = root;
        while(current != null){
            if(val < current.data){
                if(current.left == null) {
                    current.left = new Node(val);
                    break;
                }
                current = current.left;
            }
            else if(val > current.data){
                if(current.right == null) {
                    current.right = new Node(val);
                    break;
                }
                current = current.right;

            }

        }
    }
    public void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + "-->");
    }
    public void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.data + "-->");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + "-->");
        inOrder(root.right);
    }

    public void display() {
        int height = getHeight(root);
        printTree(root, 0, height);
    }

    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    private void printTree(Node node, int level, int height) {
        if (node == null) {
            return;
        }

        int nodesInLevel = (int) Math.pow(2, level);
        int spacesBetween = (int) Math.pow(2, height - level + 1) - 1;
        int spacesBefore = (int) Math.pow(2, height - level) - 1;

        // Print leading spaces for the current level
        printSpaces(spacesBefore);

        // Print nodes in the current level
        printLevelNodes(node, spacesBetween);

        System.out.println();

        // Print branches (slashes) for the current level
        if (level < height - 1) {
            printBranches(node, spacesBefore, spacesBetween);
        }

        // Recursively print the left and right subtrees
        printTree(node.left, level + 1, height);
        printTree(node.right, level + 1, height);
    }

    private void printLevelNodes(Node node, int spacesBetween) {
        if (node == null) {
            return;
        }
        System.out.print(node.data);
        printSpaces(spacesBetween);
    }

    private void printBranches(Node node, int spacesBefore, int spacesBetween) {
        if (node == null) {
            return;
        }
        printSpaces(spacesBefore);
        System.out.print('/');
        printSpaces(spacesBetween);
        System.out.print('\\');
        System.out.println();
    }

    private void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }


    private class Node{
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
        }
    }
}

package com.abdullah.Trees;

import java.util.Scanner;

public class BinaryTree {
     Node root;
    public BinaryTree() {}
    public void populate(Scanner scanner) {
        System.out.print("Enter the root Node: ");
        root = new Node(scanner.nextInt());
        populate(scanner, root);
    }
    public void populate(Scanner scanner, Node node) {
        System.out.print("Do you want to Enter the left Node of " + node.data + ": ");
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.print("Enter the value of the left of "+ node.data + ": ");
            node.left = new Node(scanner.nextInt());
            populate(scanner, node.left);
        }
        System.out.print("Do you want to Enter the right Node of " + node.data + ": ");
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.print("Enter the value of the right of "+ node.data+ ": ");
            node.right = new Node(scanner.nextInt());
            populate(scanner, node.right);
        }
    }
    public void autoPopulate(int val){
        root = autoPopulate(root,val);
    }
    public Node autoPopulate(Node node ,int val){
        if(node == null){
            return new Node(val);
        }
        if(val<node.data){
            node.left = autoPopulate(node.left,val);
        }
        if(val>node.data){
            node.right = autoPopulate(node.right,val);
        }
        return node;
    }
    public void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + "-->");
        inOrder(root.right);
    }
    public void display() {
        display(this.root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.data);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.data);
        } else {
            System.out.println(node.data);
        }
        prettyDisplay(node.left, level + 1);
    }








    private class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }
}

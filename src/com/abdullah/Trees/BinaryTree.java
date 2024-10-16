package com.abdullah.Trees;

import com.abdullah.Stack.CustomStack;

import java.util.Scanner;
import java.util.Stack;

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
    public void iterativePostOrder() throws Exception {
        iterativePostOrder(root);
    }
    public void iterativePostOrder(Node root) throws Exception {
        Node temp = root;
        Node lastVisited = null;
        Stack<Node> stack = new Stack<Node>();
        while(!stack.isEmpty() || temp != null){
            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            }else{
                Node peek = stack.peek();
                if(peek.right != null && lastVisited != peek.right){
                    temp = peek.right;
                }else {
                    System.out.print(peek.data + " ");
                    lastVisited = stack.pop();
                }
            }
        }


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

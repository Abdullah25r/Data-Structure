package com.abdullah.Trees;

public class AVLTree {


    Node root;
    public void insert(int key){
        root = insert(root, key);
    }
    public Node insert(Node root, int key){
        if(root == null){
            return new Node(key);
        }
        if(key<root.val){
            root.left = insert(root.left, key);
        }
        if(key>root.val){
            root.right = insert(root.right, key);
        }else
            return root;
        root.height = 1 + max(height(root.left), height(root.right));

        int balance = getBalance(root);
        if(balance>1 && key < root.left.val){
            return rightRotate(root);
        }
        if(balance < -1 && key>root.right.val){
            return leftRotate(root);
        }
        if(balance> 1 && key > root.left.val){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if(balance>-1 && key < root.right.val){
            root.right = rightRotate(root.right);
            return leftRotate(root);

        }
        return root;
    }
    public Node leftRotate(Node root){
        Node y = root.right;
        root.right = y.left;
        y.left = root;
        root.height = max(height(root.left), height(root.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return y;
    }
    public Node rightRotate(Node root){
        Node y = root.left;
        root.left = y.right;
        y.right = root;
        y.height = max(height(y.left), height(y.right)) + 1;
        root.height = max(height(root.left), height(root.right)) + 1;
        return y;
    }


    public int height(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }
    public int getBalance(Node node){
        if(node == null) return 0;
        return height(node.left) - height(node.right);
    }
    public int max(int a, int b){
        return Math.max(a, b);
    }
    public void preOrder(Node node){
        if(node==null) return;
        System.out.println(node.val+ " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public class Node {
        int val;
        int height;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
            height = 1;
        }

    }
}
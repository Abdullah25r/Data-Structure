package com.abdullah.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {
     Node root;
    public BST() {}
    // iterative algorithm
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
    public int minTerm(){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        Node current = root;
        while(current != null){
            min = Math.min(min, current.data);
            current = current.left;
        }
        return min;
    }
    public int maxTerm(){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int max = Integer.MIN_VALUE;
        Node current = root;
        while(current != null){
            max = Math.max(max, current.data);
            current = current.right;
        }
        return max;
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
    public void BFS(Node root){

        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.data + "-->");
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }
    public void DFS(Node root){
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.data + "-->");
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }

        }
    }



    private static class Node{
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
        }
    }
}

package com.abdullah.Trees;

public class AVLMain {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        for (int i = 1; i <= 5 ; i++) {
            tree.insert(i);
        }
        tree.preOrder(tree.root);
    }
}

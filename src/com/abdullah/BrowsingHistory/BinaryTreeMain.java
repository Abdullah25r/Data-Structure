package com.abdullah.BrowsingHistory;

public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTree bst = new BinaryTree();
        bst.insertNode("Alice", 85);
        bst.insertNode("bob", 92);
        bst.insertNode("charlie", 78);
        bst.insertNode("Eva", 88);
        bst.insertNode("frank", 75);
        bst.insertNode("grace", 95);
        bst.insertNode("hunnah", 82);
        bst.insertNode("isaac", 91);
        bst.insertNode("jack", 89);
//        bst.rightLeftRootTraversal();
        bst.displaytraversal();
    }
}

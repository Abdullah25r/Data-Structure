package com.abdullah.Trees;

public class BSTMain {
    public static void main(String[] args) {
        int[] arr = new int[]{65,83, 71, 81, 91, 30, 15, 43, 10, 17,3,35,39};
        BST bst = new BST();
        for(int e: arr){
            bst.insert(e);
        }
        bst.inOrder(bst.root);
        System.out.println();
        bst.preOrder(bst.root);
        System.out.println();
        bst.postOrder(bst.root);

    }
}

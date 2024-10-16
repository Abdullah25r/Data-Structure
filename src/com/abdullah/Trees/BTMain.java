package com.abdullah.Trees;

import java.util.Scanner;

public class BTMain {
    public static void main(String[] args) throws Exception {
        BinaryTree bt = new BinaryTree();
//        bt.populate(new Scanner(System.in));
//        bt.prettyDisplay();
          int[] arr = new int[]{65,83, 71, 81, 91, 30, 15, 43, 10, 17,3,35,39};
          for(int e: arr){
              bt.autoPopulate(e);
          }
//        bt.prettyDisplay();
//          bt.inOrder(bt.root);
//          System.out.println();
//          bt.preOrder(bt.root);
//          System.out.println();
//          bt.postOrder(bt.root);
        bt.iterativePostOrder();
    }
}

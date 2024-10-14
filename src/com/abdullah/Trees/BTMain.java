package com.abdullah.Trees;

import java.util.Scanner;

public class BTMain {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.populate(new Scanner(System.in));
        bt.prettyDisplay();
    }
}

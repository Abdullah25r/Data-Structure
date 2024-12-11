package com.abdullah.Servers;

public class Main {
    public static void main(String[] args) {
        AVL avlTree = new AVL();
        BinaryHeap maxHeap = new BinaryHeap();

        // Adding servers with IDs and capacities
        int[] serverIDs = {101, 102, 103, 104, 105};
        int[] cpuCapacities = {50, 80, 30, 60, 90};

        for (int i = 0; i < serverIDs.length; i++) {
            avlTree.insert(serverIDs[i]);
            maxHeap.insert(cpuCapacities[i]);
        }

        // Print initial AVL tree and heap
        System.out.print("Initial AVL Tree (InOrder): ");
        avlTree.inOrder();
        System.out.println();

        System.out.print("Initial Max-Heap: ");
        maxHeap.printHeap();

        // Task Assignment
        System.out.println("\nAssigning task of 20 units to server with max capacity");
        int maxCapacity = maxHeap.extractMax();
        maxHeap.insert(maxCapacity - 20);
        System.out.print("Updated Max-Heap: ");
        maxHeap.printHeap();

        // Adding new server
        System.out.println("\nAdding new server (ID: 106, Capacity: 75)");
        avlTree.insert(106);
        maxHeap.insert(75);
        System.out.print("Updated AVL Tree (InOrder): ");
        avlTree.inOrder();
        System.out.println();
        System.out.print("Updated Max-Heap: ");
        maxHeap.printHeap();

        // Removing server
        System.out.println("\nRemoving server with ID: 103");
        avlTree.delete(103);
        maxHeap.extractMax();
        System.out.print("Updated AVL Tree (InOrder): ");
        avlTree.inOrder();
        System.out.println();
        System.out.print("Update Binary heap (InOrder): ");
        maxHeap.printHeap();

    }



}

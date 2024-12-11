package com.abdullah.Heaps;

import java.util.ArrayList;

public class BinaryHeap {
    ArrayList<Integer> list;

    public BinaryHeap() {
        list = new ArrayList<>();
    }

    // Max heap insertion
    public void insert(int value) {
        list.add(value); // Add the value to the end of the list
        heapifyUp(list.size() - 1); // Fix the heap from the newly added node upwards
    }

    public void heapifyUp(int index) {
        int parentIndex = getParent(index);

        // If the current node is greater than its parent, swap them
        if (parentIndex >= 0 && list.get(index) > list.get(parentIndex)) {
            swap(index, parentIndex);
            heapifyUp(parentIndex); // Recursively heapify the parent
        }
    }

    public void swap(int index1, int index2) {
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    public void printHeap() {
        System.out.println(list);
    }

    public int getParent(int index) {
        return (index - 1) / 2; // Parent index formula
    }

    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap();
        int[] arr = {30, 80, 90, 50, 60};
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
        }
        heap.printHeap();
    }
}

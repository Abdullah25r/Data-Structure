package com.abdullah.Servers;
import java.util.*;
public class BinaryHeap {
    ArrayList<Integer> capacities;

    public BinaryHeap() {
        capacities = new ArrayList<>();
    }

    public void insert(int value) {
        capacities.add(value);
        heapifyUp(capacities.size() - 1);
    }

    public void heapifyUp(int index) {
        int parentIndex = getParent(index);
        if (parentIndex >= 0 && capacities.get(index) > capacities.get(parentIndex)) {
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }
    }

    public int extractMax() {
        if (capacities.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        int max = capacities.get(0);
        capacities.set(0, capacities.get(capacities.size() - 1));
        capacities.remove(capacities.size() - 1);
        heapifyDown(0);
        return max;
    }

    public void heapifyDown(int index) {
        int largest = index;
        int leftChild = getLeft(index);
        int rightChild = getRight(index);

        if (leftChild < capacities.size() && capacities.get(leftChild) > capacities.get(largest)) {
            largest = leftChild;
        }
        if (rightChild < capacities.size() && capacities.get(rightChild) > capacities.get(largest)) {
            largest = rightChild;
        }
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    public void updateCapacity(int oldCapacity, int newCapacity) {
        int index = capacities.indexOf(oldCapacity);
        if (index != -1) {
            capacities.set(index, newCapacity);
            heapifyUp(index);
            heapifyDown(index);
        }
    }

    public void swap(int index1, int index2) {
        int temp = capacities.get(index1);
        capacities.set(index1, capacities.get(index2));
        capacities.set(index2, temp);
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }

    public int getLeft(int index) {
        return 2 * index + 1;
    }

    public int getRight(int index) {
        return 2 * index + 2;
    }

    public void printHeap() {
        System.out.println(capacities);
    }
}


package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapInJava {
    public static void main(String[] args) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(30);
        maxHeap.add(100);


        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
    }
}

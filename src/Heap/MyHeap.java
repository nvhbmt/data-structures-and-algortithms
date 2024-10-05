package Heap;

import java.util.Scanner;

public class MyHeap {
    private final int MAX_SIZE = 100;
    private int[] arr = new int[MAX_SIZE + 1];
    private int size;

    MyHeap() {
        this.size = 0;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    private void swap(int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public int peek() {
        if (isEmpty()) {
            // throw Exception
            System.out.println("Error: Heap is empty!");
            return -1;
        }
        return arr[1];
    }

    public void add(int value) {
        size++;
        arr[size] = value;

        // heapify up
        int currentIndex = size;
        int parentIndex = currentIndex / 2;

        while (parentIndex != 0 && arr[parentIndex] > arr[currentIndex]) {
            swap(parentIndex, currentIndex);
            currentIndex = parentIndex;
            parentIndex = currentIndex / 2;
        }
    }

    public int poll() {
        if (isEmpty()) {
            // throw Exception
            System.out.println("Error: Heap is empty!");
            return -1;
        }

        int root = arr[1];
        arr[1] = arr[size];
        size--;

        // heapify down
        heaptifyDown(1);

        return root;
    }

    private void heaptifyDown(int currentIndex) {
        int leftChildIndex = currentIndex * 2;

        while (leftChildIndex <= size) {
            int rightChildIndex = leftChildIndex + 1;
            int smallerChildIndex = leftChildIndex;

            if (rightChildIndex <= size && arr[rightChildIndex] < arr[leftChildIndex]) {
                smallerChildIndex = rightChildIndex;
            }

            if (arr[currentIndex] > arr[smallerChildIndex]) {
                swap(currentIndex, smallerChildIndex);
                currentIndex = smallerChildIndex;
                leftChildIndex = currentIndex * 2;
            } else {
                break;
            }
        }
    }

    public void remove(int value) {
        int currentIndex = -1;
        for (int i = 1; i <= size; i++) {
            if (arr[i] == value) {
                currentIndex = i;
                break;
            }
        }

        if (currentIndex == -1) {
            System.out.println("Error: Element is not found!");
            return;
        }
        arr[currentIndex] = arr[size];
        size--;
        heaptifyDown(currentIndex);
    }

    public static void main(String[] args) {
        MyHeap myHeap = new MyHeap();
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q > 0) {
            int t = sc.nextInt();
            if (t == 1) {
                //add
                myHeap.add(sc.nextInt());
            } else if (t == 2) {
                // remove
                myHeap.remove(sc.nextInt());
            } else {
                System.out.println(myHeap.peek());
            }

            q--;
        }
    }
}

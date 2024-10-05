package Hash;

import java.util.ArrayList;

public class MyHashSet {
    private final int SIZE = 1000;
    private ArrayList<Integer>[] myBucket;

    MyHashSet() {
        this.myBucket = new ArrayList[SIZE];
        for (int i = 0; i < myBucket.length; i++) {
            myBucket[i] = new ArrayList<>();
        }
    }

    private int hashFunction(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int hashValueIndex = hashFunction(key);
        ArrayList<Integer> bucket = myBucket[hashValueIndex];
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    public void remove(int key) {
        int hashValueIndex = hashFunction(key);
        ArrayList<Integer> bucket = myBucket[hashValueIndex];
        bucket.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int hashValueIndex = hashFunction(key);
        ArrayList<Integer> bucket = myBucket[hashValueIndex];
        return bucket.contains(key);
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(1);
        myHashSet.add(2);
        myHashSet.remove(1);
        System.out.println(myHashSet.contains(2));
    }
}

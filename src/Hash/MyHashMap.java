package Hash;

import java.util.ArrayList;

public class MyHashMap {
    private final int SIZE = 1000;

    private ArrayList<Data>[] mybucket;

    private class Data {
        int key;
        int value;


        Data(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Data) {
                return this.key == ((Data) obj).key;
            }
            return false;
        }
    }

    public MyHashMap() {
        mybucket = new ArrayList[SIZE];
        for (int i = 0; i < mybucket.length; i++) {
            mybucket[i] = new ArrayList<>();
        }
    }

    private int hashFunction(int key) {
        return key % SIZE;
    }

    private void put(int key, int value) {
        int hashValue = hashFunction(key);
        var bucket = mybucket[hashValue];
        Data newData = new Data(key, value);
        int keyIndex = bucket.indexOf(newData);
        if (keyIndex >= 0) {
            bucket.get(keyIndex).value = value;
        } else {
            bucket.add(newData);
        }
    }

    private void remove(int key) {
        int hashValue = hashFunction(key);
        var bucket = mybucket[hashValue];
        bucket.remove(new Data(key, 0));
    }

    private int get(int key) {
        int hashValue = hashFunction(key);
        var bucket = mybucket[hashValue];
        int keyIndex = bucket.indexOf(new Data(key, 0));
        if (keyIndex >= 0) {
            return bucket.get(keyIndex).value;
        }
        return -1;
    }

    public static void main(String[] args) {
        MyHashMap myMap = new MyHashMap();
        myMap.put(7, 3);
        myMap.put(11, 1);
        myMap.put(12, 1);
        System.out.println(myMap.get(7));
    }
}

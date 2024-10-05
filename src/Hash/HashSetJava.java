package Hash;

import java.util.HashSet;
import java.util.Set;

public class HashSetJava {
    public static void main(String[] args) {
        Set<Integer> mySet = new HashSet<>();
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        mySet.add(1);
        mySet.add(2);

        for (Integer i : mySet)
            System.out.println(i);

        System.out.println(mySet.contains(0));
        mySet.remove(2);
        for (Integer i : mySet)
            System.out.println(i);
    }
}

package QueueAndStack;

import java.util.LinkedList;
import java.util.Queue;

public class StackQueueJava {
    public static void main(String[] args) {
//        Stack<Integer> myStack = new Stack<>();
//
//        myStack.push(1);
//        myStack.push(2);
//        myStack.push(3);
//        myStack.push(4);
//
//        for (Integer i : myStack) {
//            System.out.println(i);
//        }
//
//        System.out.println("Peek: " + myStack.peek());
//        System.out.println("Pop: " + myStack.pop());
//        System.out.println("Pop: " + myStack.pop());
//        System.out.println("Pop: " + myStack.pop());
//
//        for (Integer i : myStack) {
//            System.out.println(i);
//        }
//        System.out.println(myStack.isEmpty());

        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);

        for (Integer i : myQueue) {
            System.out.println(i);
        }

        myQueue.poll();
        myQueue.poll();
        System.out.println("Remove " + myQueue.remove());
        System.out.println(myQueue.isEmpty());

    }
}

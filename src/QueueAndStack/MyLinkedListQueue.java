package QueueAndStack;

public class MyLinkedListQueue implements IStackQueue {

    Node headNode;
    Node tailNode;

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public MyLinkedListQueue() {
        this.headNode = this.tailNode = null;
    }

    @Override
    public boolean push(int value) {
        if (isFull()) return false;

        Node newNode = new Node(value);
        if (isEmpty()) {
            headNode = tailNode = newNode;
        } else {
            tailNode.next = newNode;
            tailNode = newNode;
        }
        return true;
    }

    @Override
    public int pop() {
        if (isEmpty()) return -1;
        int value = headNode.value;
        if (headNode == tailNode) {
            headNode = tailNode = null;
        } else {
            headNode = headNode.next;
        }
        return value;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return headNode == null && tailNode == null;
    }

    @Override
    public void show() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        Node tempNode = headNode;
        while (tempNode != null) {
            System.out.print(tempNode.value + " ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyLinkedListQueue queue = new MyLinkedListQueue();

        queue.push(1);
        queue.push(2);
        queue.push(3);

        queue.show();
        queue.pop();
        queue.show();
        queue.pop();
        queue.show();
        queue.pop();
        queue.show();
    }
}

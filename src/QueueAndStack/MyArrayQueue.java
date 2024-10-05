package QueueAndStack;

public class MyArrayQueue implements IStackQueue {
    int[] array;
    int size;
    private int headIndex, tailIndex;

    public MyArrayQueue(int size) {
        this.size = size;
        this.array = new int[size];
        this.headIndex = this.tailIndex = -1;
    }

    @Override
    public boolean push(int value) {
        if (!isFull()) {
            if (isEmpty()) {
                headIndex++;
            }
            tailIndex++;
            array[tailIndex] = value;
            return true;
        }
        return false;
    }

    @Override
    public int pop() {
        int value = -1;
        if (!isEmpty()) {
            value = array[headIndex];
            headIndex++;
            if (headIndex > tailIndex) {
                headIndex = tailIndex = -1;
            }
        }
        return value;
    }

    @Override
    public boolean isFull() {
        return this.tailIndex == this.size - 1;
    }

    @Override
    public boolean isEmpty() {
        return (this.headIndex == -1) && (this.tailIndex == -1);
    }

    @Override
    public void show() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            for (int i = headIndex; i <= tailIndex; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MyArrayQueue myQueue = new MyArrayQueue(3);

        System.out.println(myQueue.push(1));
        System.out.println(myQueue.push(2));
        System.out.println(myQueue.push(3));
        System.out.println(myQueue.push(4));
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        myQueue.show();
        System.out.println(myQueue.push(5));
    }
}


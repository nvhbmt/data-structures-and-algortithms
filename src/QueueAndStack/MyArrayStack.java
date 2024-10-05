package QueueAndStack;

public class MyArrayStack implements IStackQueue {

    private int[] array;
    private int size;
    private int topIndex;

    public MyArrayStack(int size) {
        this.size = size;
        this.array = new int[size];
        topIndex = -1;
    }

    @Override
    public boolean push(int value) {
        if (!isFull()) {
            topIndex++;
            array[topIndex] = value;
            return true;
        }
        return false;
    }

    @Override
    public int pop() {
        if (!isEmpty()) {
            int value = array[topIndex];
            topIndex--;
            return value;
        }
        return -1;
    }

    @Override
    public boolean isFull() {
        return topIndex == size - 1;
    }

    @Override
    public boolean isEmpty() {
        return topIndex == -1;
    }

    @Override
    public void show() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            for (int i = 0; i <= topIndex; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MyArrayStack myStack = new MyArrayStack(3);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.show();

        myStack.pop();
        myStack.show();

        myStack.pop();
        myStack.show();

        myStack.pop();
        myStack.show();
    }
}

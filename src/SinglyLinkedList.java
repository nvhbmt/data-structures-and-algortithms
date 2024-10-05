public class SinglyLinkedList {
    public static  class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void printLinkedList(Node head) {
        if (head == null) System.out.println("List is empty!");

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value);
            temp = temp.next;
            if (temp != null)
                System.out.print("->");
            else
                System.out.println();
        }
    }

    public static Node addToHead(Node headNode, int value) {
        Node newNode = new Node(value);
        if (headNode != null) newNode.next = headNode;
        return newNode;
    }

    public static Node addToTail(Node headNode, int value) {
        Node newNode = new Node(value);
        if (headNode == null) return newNode;

        Node lastNode = headNode;
        while (lastNode.next != null) lastNode = lastNode.next;
        lastNode.next = newNode;

        return headNode;
    }

    public static Node addToIndex(Node headNode, int value, int index) {
        if (index == 0) return addToHead(headNode, value);

        Node current = headNode;
        int count = 0;
        while (current != null) {
            count++;
            if (count == index) {
                // handle add
                Node newNode = new Node(value);
                newNode.next =current.next;
                current.next = newNode;
                break;
            }
            current = current.next;
        }

        return headNode;
    }

    public static Node removeAtHead(Node headNode) {
        if (headNode != null)
            return headNode.next;
        return headNode;
    }

    public static Node removeAtTail(Node headNode) {
        if (headNode == null) return null;
        Node lastNode = headNode;
        Node prevNode = null;
        while (lastNode.next != null) {
            prevNode = lastNode;
            lastNode = lastNode.next;
        }
        if (prevNode == null)
            return null;
        else prevNode.next = null;

        return headNode;
    }

    public static Node removeAtIndex(Node headNode, int index) {
        if (index == 0) return removeAtHead(headNode);
        if (headNode == null || index < 0) return null;

        int count = 0;
        Node curNode = headNode;
        Node prevNode = null;
        boolean isFound = false;

        while (curNode != null) {
            if (index == count) {
                isFound = true;
                break;
            };
            prevNode = curNode;
            curNode = curNode.next;
            count++;
        }

        if (isFound) prevNode.next = curNode.next;


        return headNode;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next = n2;
        n2.next = n3;

        printLinkedList(n1);
        Node n0 = addToHead(n1,0);
        printLinkedList(n0);

        addToTail(n0,4);
        n0 = addToHead(n0,0);
        addToTail(n0,6);
        printLinkedList(n0);
        n0 = addToIndex(n0,5,0);
        printLinkedList(n0);

        addToIndex(n0,5,8);
        printLinkedList(n0);

        n0 = removeAtHead(n0);
        n0 = removeAtHead(n0);
        printLinkedList(n0);
        removeAtTail(n0);
        printLinkedList(n0);
        removeAtIndex(n0,2);
        printLinkedList(n0);
        removeAtIndex(n0,3);
        printLinkedList(n0);
    }
}

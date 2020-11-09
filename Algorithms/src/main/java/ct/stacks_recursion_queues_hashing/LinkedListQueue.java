package ct.stacks_recursion_queues_hashing;

public class LinkedListQueue {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    //10 20 30 40 50
    public void enqueue(int value) {
        var node = new Node(value);
        if(isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public int dequeue() {
        int value = first.value;
        Node current = first.next;
        first.next = null;
        first = current;
        size--;
        return value;
    }

    public int peek() {
        return first.value;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void print() {
        Node current = first;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }


}

package ct.linkedlists;

import java.util.NoSuchElementException;

public class LinkedList {

    public class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public LinkedList() {
        this.first = this.last = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void addLast(int item) {
        Node node = new Node(item);
        System.out.println("Adding and item: " + item);
        if(isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void deleteLast() {
        System.out.println("Deleting last item : " + last.value);
        if(isEmpty())
            throw new NoSuchElementException();
        if(first == last)
            first = last = null;
        else {
            Node previous = first;
            Node current = first;
            while(current.next != null) {
                previous = current;
                current = current.next;
            }
            previous.next = null;
            last = previous;
        }
        size--;
    }

    public void print() {
        if(isEmpty())
            throw new NoSuchElementException();
        Node current = first;
        while(current != null) {
            System.out.println("Value: " + current.value);
            current = current.next;
        }
    }


}

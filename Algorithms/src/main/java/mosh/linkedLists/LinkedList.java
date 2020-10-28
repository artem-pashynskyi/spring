package mosh.linkedLists;

import java.util.NoSuchElementException;

public class LinkedList {
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

    //addLast
    public void addLast(int item) {
        Node node = new Node(item);
        if(first == null)
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    //addFirst
    public void addFirst(int item) {
        Node node = new Node(item);
        if(first == null)
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    //indexOf
    public int indexOf(int value) {
        int index = 0;
        Node current = first;
        while(current != null) {
            if(current.value == value) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    //contains
    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    //deleteFirst
    public void removeFirst() {
        if(first == null)
            throw new NoSuchElementException();
        if(first == last) {
            first = last = null;
        } else {
            Node second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    //deleteLast
    public void removeLast() {
        if(first == null)
            throw new NoSuchElementException();
        if(first == last) {
            first = last = null;
        } else {
            Node current = first;
            while(current != null) {
                if(current.next == last) break;
                current = current.next;
            }
            last = current;
            last.next = null;
        }
        size--;
    }

    //size
    public int size() {
        return size;
    }

    //toArray
    public int[] toArray() {
        int[] array = new int[size];
        int index = 0;
        Node current = first;
        while(current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    //reverse
    public void reverse() {
        if(first == null)
            return;
        Node current = first;
        Node next = first;
        while(current.next != null) {
            next = current.next;
            current.next = next.next;
            next.next = first;
            first = next;
        }
        last = current;
    }

    //Find the Kth node from the end of a linked list in one pass.
    public int getKthFromTheEnd(int k) {
        if(first == null) {
            throw new IllegalStateException();
        }
        Node a = first;
        Node b = first;
        for(int i = 0 ; i < k - 1 ; i++) {
            b = b.next;
            if(b == null) {
                throw new IllegalArgumentException();
            }
        }
        while(b.next != null) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    //Find the middle of a linked list in one pass
    public void printMiddle() {

    }
}

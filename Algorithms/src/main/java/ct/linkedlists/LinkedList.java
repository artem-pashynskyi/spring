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

    //10 20 30 40 50
    //50 40 30 20 10
    public void reverse() {
        if(isEmpty())
            throw new NoSuchElementException();
        if(first == last)
            return;
        else {
            var next = first;
            var current = first;
            while(current.next != null) {
                next = current.next;
                current.next = next.next;
                next.next = first;
                first = next;
            }
            last = current;
        }
    }

    //10 20 [30 40] 50 60
    public int findKthNodeFromTheEnd(int k) {
        if(k > size)
            throw new NoSuchElementException();
        var a = first;
        var b = first;
        for(int i = 0 ; i < k ; i++) {
            b = b.next;
        }
        while(b != null) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    //10 20 [30] 40 50
    public void findMiddle() {
        var a = first;
        var b = first;
        while(b.next != null && b.next.next != null) {
            a = a.next;
            b = b.next.next;
        }
        if(b.next == null) {
            System.out.println("Odd Linked List, returned one value: " + a.value);
        } else {
            System.out.println("Even Linked List, returned two values: " + a.value + " and " + a.next.value);
        }
    }

    //10 20 30 40 30 20 10
    public boolean isPalindrome() {
        Node current = first;
        Node newList = new Node(first.value);

        while(current.next != null) {
            Node node = new Node(current.next.value);
            node.next = newList;
            newList = node;
            current = current.next;
        }

        Node list1 = first;
        Node list2 = newList;

        while(list1 != null) {
            if(list1.value != list2.value) {
                return false;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return true;
    }

}

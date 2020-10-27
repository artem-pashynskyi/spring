package mosh.linkedLists;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(90);
        System.out.println(list.indexOf(30));
        System.out.println(list.contains(20));
        list.removeFirst();
        list.removeLast();
        System.out.println(list.size());
        System.out.println(Arrays.toString(list.toArray()));
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        System.out.println(Arrays.toString(list.toArray()));
        list.reverse();
        System.out.println(Arrays.toString(list.toArray()));
        list.reverse();
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.getKthFromTheEnd(2));
    }
}

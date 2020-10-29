package ct.linkedlists;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println(list.isEmpty());
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.print();
        list.deleteLast();
        list.print();
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);
        list.reverse();
        list.print();
        System.out.println(list.findKthNodeFromTheEnd(2));
        list.findMiddle();
        list.print();
        list.reverse();
        list.deleteLast();
        list.deleteLast();
        list.deleteLast();
        list.addLast(40);
        list.addLast(30);
        list.addLast(20);
        list.addLast(10);
        list.print();
        System.out.println(list.isPalindrome());
    }
}

package ct.linkedlists;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println("isEmpty()");
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
        System.out.println("reverse()");
        list.print();
        System.out.println("findKthNodeFromTheEnd()");
        System.out.println(list.findKthNodeFromTheEnd(2));
        list.findMiddle();
        list.print();
        list.reverse();
        System.out.println("reverse()");
        list.deleteLast();
        list.deleteLast();
        list.addLast(40);
        list.addLast(30);
        list.addLast(20);
        list.addLast(10);
        list.print();
        System.out.println("IsPalindrome1()");
        System.out.println(list.isPalindrome());
        System.out.println("IsPalindrome2()");
        System.out.println(list.isPalindrome2());
        list = new LinkedList();
        list.addLast(10);
        list.addLast(40);
        list.addLast(15);
        list.addLast(20);
        list.addLast(30);
        list.addLast(70);
        list.addLast(25);
        list.addLast(50);
        list.print();
        list.sortListDesc();
        System.out.println("sortListDesc()");
        list.print();
        list.sortListAsc();
        System.out.println("sortListAsc()");
        list.print();
    }
}

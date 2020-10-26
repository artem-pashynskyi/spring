package mosh.arrays;

public class Main {
    public static void main(String[] args) {
        Array numbers = new Array(3);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.removeAt(1);
        numbers.print();
        System.out.println(numbers.indexOf(30));
        System.out.println(numbers.max());
        numbers.reverse();
        numbers.print();
        numbers.reverse();
        numbers.print();
        System.out.println("InsertAt");
        numbers.insertAt(55, 1);
        numbers.print();
    }
}

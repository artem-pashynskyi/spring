package mosh.hashTables;

public class Main {
    public static void main(String[] args) {

        CharFinder charFinder = new CharFinder();
        String str = "a green apple";
        System.out.println("***findFirstNonRepeatingChar***");
        System.out.println(charFinder.findFirstNonRepeatingChar(str));
        System.out.println(charFinder.findFirstNonRepeatingChar2(str));

        System.out.println("***fistRepeatedChar***");
        str = "a green apple";
        System.out.println(charFinder.fistRepeatedChar(str));

        //Hashing
        System.out.println("***Hashing***");
        String s = "orangej;4";
        System.out.println(s.hashCode());
        int i = 0;
        for(char ch : s.toCharArray())
            i =+ ch;
        System.out.println(i % 1000);

        System.out.println("***HashTable 1***");
        HashTable hashTable = new HashTable();
        hashTable.put(123456, "Apple");
        hashTable.put(454585, "Orange");
        System.out.println(hashTable.get(123456));
        hashTable.put(123456, "Mango");
        System.out.println(hashTable.get(123456));

        System.out.println("***HashTable 2***");
        HashTable hashTable2 = new HashTable();
        hashTable2.put(6, "A");
        hashTable2.put(8, "B");
        hashTable2.put(11, "C");
        hashTable2.put(21, "D");
        System.out.println(hashTable2.get(11));
    }
}

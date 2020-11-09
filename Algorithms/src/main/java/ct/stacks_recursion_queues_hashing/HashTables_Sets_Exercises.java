package ct.stacks_recursion_queues_hashing;

import java.util.HashMap;
import java.util.HashSet;

public class HashTables_Sets_Exercises {
    public static void main(String[] args) {
        String str1 = "a green apple";
        System.out.println(firstNonRepeatedChar(str1));

        String str2 = "green apple";
        System.out.println(firstRepeatedChar(str2));
    }

    public static char firstNonRepeatedChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = str.toCharArray();
        for(char ch : arr) {
            int count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }
        for(char ch : arr) {
            if(map.get(ch) == 1)
                return ch;
        }
        return 0;
    }

    public static char firstRepeatedChar(String str) {
        HashSet<Character> set = new HashSet<>();
        char[] arr = str.toCharArray();
        for(char ch : arr) {
            if(set.contains(ch))
                return ch;
            set.add(ch);
        }
        return 0;
    }

}

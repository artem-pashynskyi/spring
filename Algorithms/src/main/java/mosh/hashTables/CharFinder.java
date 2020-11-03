package mosh.hashTables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {

    public char findFirstNonRepeatingChar(String str) {
        char[] arr = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, count = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    count++;
            }
            if (count == 1 && !map.containsKey(arr[i])) {
                return arr[i];
            }
            map.put(arr[i], count);
            count = 0;
        }
        return 0;
    }

    public char findFirstNonRepeatingChar2(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();

        for(char ch : chars) {
            int count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        for(char ch : chars)
            if(map.get(ch) == 1)
                return ch;

        return 0;
    }

    public char fistRepeatedChar(String str) {
        Set<Character> set = new HashSet<>();
        char[] chars = str.toCharArray();

        for(char ch : chars) {
            if(set.contains(ch))
                return ch;
            set.add(ch);
        }

        return Character.MIN_VALUE;
    }

}

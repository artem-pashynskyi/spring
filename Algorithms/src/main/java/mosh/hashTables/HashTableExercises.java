package mosh.hashTables;

import java.util.HashMap;
import java.util.Map;

public class HashTableExercises {

    public int mostFrequent(int[] input) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : input) {
            var index = map.containsKey(i) ? map.get(i) : 0;
            map.put(i, index + 1);
        }

        int result = input[0];
        int temp = Integer.MIN_VALUE;
        for(int i : input) {
            if(map.get(i) > temp) {
                result = i;
                temp = map.get(i);
            }
        }
        return result;
    }

    public int countPairsWithDiff(int[] input, int k) {
        int count = 0;

        for(int i = 0 ; i < input.length ; i++) {
            for(int j = i+1 ; j < input.length ; j++) {
                if(input[i] - input[j] == k || input[j] - input[i] == k) {
                    count++;
                }
            }
        }

        return count;
    }

}

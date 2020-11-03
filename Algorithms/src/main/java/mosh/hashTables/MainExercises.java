package mosh.hashTables;

public class MainExercises {
    public static void main(String[] args) {

        int[] array = {1,2,2,3,3,3,4};
        HashTableExercises hashTableExercises = new HashTableExercises();
        System.out.println("***mostFrequent***");
        System.out.println(hashTableExercises.mostFrequent(array));

        int[] array2 = {1,7,5,9,2,12,3};
        System.out.println("***mostFrequent***");
        System.out.println(hashTableExercises.countPairsWithDiff(array2, 2));


    }
}

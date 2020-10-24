import java.util.Arrays;

public class Algorithms_Day1 {

    public static void main(String[] args) {
        int[][] matrix = {{10,11,12,13,14},{15,16,17,18,19},{20,21,22,23,24},{25,26,27,28,29},{30,31,32,33,34}};
        System.out.println("***Initial Matrix***");
        Arrays.stream(matrix).forEach(a -> {
            Arrays.stream(a).forEach(n -> {
                System.out.print(n + " ");
            });
            System.out.println();
        });

    //1. Reverse order of an array of unordered integers.
        int[][] rotatedMatrix = new Algorithms_Day1().rotateAnMatrix90DegreesRightInPlace(matrix);
        System.out.println("***Rotated Matrix***");
        Arrays.stream(rotatedMatrix).forEach(a -> {
            Arrays.stream(a).forEach(n -> {
                System.out.print(n + " ");
            });
            System.out.println();
        });

        int[] arr = {5,22,44,67,8,87,56,43,2};

    //2. Rotate an (n x n) matrix 90 degrees right in place.
        System.out.println(Arrays.toString(Arrays.stream(new Algorithms_Day1().reverseAnArray(arr)).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(new Algorithms_Day1().reverseAnArray2(arr)).toArray()));
    }

    public int[][] rotateAnMatrix90DegreesRightInPlace(int[][] matrix) {
        int[][] copyOfMatrix = Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);
        for (int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[i].length ; j++) {
                matrix[i][matrix[i].length-(j+1)] = copyOfMatrix[j][i];
            }
        }
        return matrix;
    }

    public int[] reverseAnArray(int[] arr) {
        int[] newArr = Arrays.stream(arr).toArray();
        for (int i = 0 ; i < arr.length ; i++) {
            newArr[i] = arr[arr.length - (i+1)];
        }
        return newArr;
    }

    public int[] reverseAnArray2(int[] arr) {
        for (int i = 0, k = arr.length-1 ; i < arr.length / 2; i++, k--) {
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
        return arr;
    }

}


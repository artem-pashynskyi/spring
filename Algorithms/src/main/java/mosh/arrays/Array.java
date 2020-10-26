package mosh.arrays;

public class Array {

    private int[] array;
    private int insertionCounter = 0;

    public Array(int[] array) {
        this.array = array;
    }

    public Array(int length) {
        this.array = new int[length];
    }

    public void insert(int item) {
        if(insertionCounter == array.length) {
            int[] newArr = new int[insertionCounter * 2];
            for(int i = 0 ; i < insertionCounter ; i++) {
                newArr[i] = array[i];
            }
            array = newArr;
        }
        array[insertionCounter++] = item;
    }

    public void removeAt(int index) {
        if(index < 0 || index >= insertionCounter)
            throw new IllegalArgumentException();
        for(int i = index ; i < insertionCounter ; i++)
            array[i] = array[i+1];
        insertionCounter--;
    }

    public int indexOf(int item) {
        for(int i = 0 ; i < insertionCounter ; i++){
            if(array[i] == item) return i;
        }
        return -1;
    }

    public void print() {
        for(int i = 0 ; i < insertionCounter ; i++) {
            System.out.println(array[i]);
        }
    }

    public int max() {
        int maxNum = array[0];
        for(int i = 0 ; i < insertionCounter ; i++) {
            if(array[i] < array[i+1]) maxNum = array[i+1];
        }
        return maxNum;
    }

    public void reverse() {
        for(int start = 0, end = insertionCounter - 1 ; start < insertionCounter / 2 ; start++, end--) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
    }

    public void insertAt(int item, int index) {
        if(index < 0 || index >= insertionCounter)
            throw new IllegalArgumentException();
        int[] newArr = new int[insertionCounter * 2];
        for(int i = 0 ; i < insertionCounter ; i++) {
            newArr[i] = array[i];
        }
        newArr[index] = item;
        for(int i = index + 1 ; i <= insertionCounter ; i++) {
            newArr[i] = array[i-1];
        }
        insertionCounter++;
        array = newArr;
    }

}

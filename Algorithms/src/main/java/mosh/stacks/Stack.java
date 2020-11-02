package mosh.stacks;

import java.util.Arrays;

public class Stack {

    int size = 0;
    int[] stack = new int[5];

    public void push(int n) {
        if(stack.length == size + 1) {
            stack = returnBigger(stack);
        }
        stack[size++] = n;
    }

    public void pop() {
        if(size == 0)
            throw new IllegalArgumentException();
        stack[size--] = 0;
        if(stack.length / 2 > size + 1) {
            stack = returnSmaller(stack);
        }
    }

    public int peek() {
        if(size == 0)
            throw new IllegalStateException();
        return stack[size-1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        var content =  Arrays.copyOfRange(stack, 0, size);
        return Arrays.toString(content);
    }

    private int[] returnBigger(int[] arr) {
        int[] temp = new int[arr.length * 2];
        for(int i = 0 ; i < arr.length ; i++) {
            temp[i] = arr[i];
        }
        return temp;
    }

    private int[] returnSmaller(int[] arr) {
        int[] temp = new int[arr.length / 2];
        for(int i = 0 ; i < temp.length ; i++) {
            temp[i] = arr[i];
        }
        return temp;
    }

}

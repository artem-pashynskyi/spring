package mosh.stacks;

public class MinStack {

    int[] stack = new int[5];
    int count = 0;
    int min = Integer.MAX_VALUE;

    public void push(int n) {
        if(count > stack.length - 1)
            throw new StackOverflowError();
        stack[count++] = n;
        if(n < min) {
            min = n;
        }
    }

    public int pop() {
        if(count == 0)
            throw new IllegalArgumentException();
        if(stack[count - 1] == min)
            min = Integer.MAX_VALUE;
            for(int i = 0 ; i < count - 2 ; i++) {
                if(stack[i] < min)
                    min = stack[i];
            }
        return stack[count--];
    }

    public int min() {
        return min;
    }

}

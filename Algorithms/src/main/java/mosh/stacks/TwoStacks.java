package mosh.stacks;

public class TwoStacks {

    int[] stack = new int[10];
    int count1 = 0;
    int count2 = stack.length-1;

    public void push1(int n) {
        if(count1 > stack.length / 2 - 1)
            throw new StackOverflowError();
        if(count1 == stack.length / 2 - 1)
            stack[count1] = n;
        else {
            stack[count1++] = n;
        }
    }

    public void push2(int n) {
        if(count2 < stack.length / 2)
            throw new StackOverflowError();
        if(count2 == stack.length / 2)
            stack[count2] = n;
        else {
            stack[count2--] = n;
        }
    }

    public void pop1() {
        if(isEmpty1())
            throw new IllegalArgumentException();
        stack[count1--] = 0;
    }

    public void pop2() {
        if(isEmpty2())
            throw new IllegalArgumentException();
        stack[count2++] = 0;
    }

    public boolean isEmpty1() {
        return count1 == 0;
    }

    public boolean isEmpty2() {
        return count2 == stack.length - 1;
    }

    public boolean isFull1() {
        return count1 == stack.length / 2 - 1;
    }

    public boolean isFull2() {
        return count2 == stack.length / 2;
    }

}

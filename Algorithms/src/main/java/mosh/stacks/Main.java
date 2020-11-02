package mosh.stacks;

public class Main {
    public static void main(String[] args) {

        StringReverser stringReverser = new StringReverser();
        String reverse = "abcd";
        System.out.println(stringReverser.reverse(reverse));

        Expression expression = new Expression();
        String balanced = "(([1] + <2>))[a]";
        System.out.println(expression.isBalanced(balanced));
        System.out.println(expression.isBalanced2(balanced));
        balanced = "(1 + 2]";
        System.out.println(expression.isBalanced(balanced));
        System.out.println(expression.isBalanced2(balanced));
        balanced = ")1 + 2(";
        System.out.println(expression.isBalanced(balanced));
        System.out.println(expression.isBalanced2(balanced));

        System.out.println("Stack");
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        System.out.println(stack);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        stack.pop();
        stack.pop();
        System.out.println(stack.isEmpty());

        System.out.println("Two Stacks");
        TwoStacks twoStacks = new TwoStacks();
        System.out.println(twoStacks.isEmpty1());
        twoStacks.push1(10);
        twoStacks.push1(20);
        twoStacks.push1(30);
        twoStacks.push1(40);
        twoStacks.push1(50);
        System.out.println(twoStacks.isFull1());
        twoStacks.pop1();
        System.out.println(twoStacks.isEmpty1());
        System.out.println(twoStacks.isFull1());

        System.out.println(twoStacks.isEmpty2());
        twoStacks.push2(10);
        twoStacks.push2(20);
        twoStacks.push2(30);
        twoStacks.push2(40);
        twoStacks.push2(50);
        System.out.println(twoStacks.isFull2());
        twoStacks.pop2();
        System.out.println(twoStacks.isEmpty2());
        System.out.println(twoStacks.isFull2());

        MinStack minStack = new MinStack();
        System.out.println("MinStack");
        minStack.push(5);
        minStack.push(2);
        minStack.push(10);
        minStack.push(1);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }
}

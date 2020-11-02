package mosh.stacks;

public class Main {
    public static void main(String[] args) {
        StringReverser stringReverser = new StringReverser();
        Expression expression = new Expression();
        String reverse = "abcd";
        System.out.println(stringReverser.reverse(reverse));
        String balanced = "(([1] + <2>))[a]";
        System.out.println(expression.isBalanced(balanced));
        System.out.println(expression.isBalanced2(balanced));
        balanced = "(1 + 2]";
        System.out.println(expression.isBalanced(balanced));
        System.out.println(expression.isBalanced2(balanced));
        balanced = ")1 + 2(";
        System.out.println(expression.isBalanced(balanced));
        System.out.println(expression.isBalanced2(balanced));
    }
}

package mosh.stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {
    List<Character> openBrackets = Arrays.asList('(', '[', '{', '<');
    List<Character> closeBrackets = Arrays.asList(')', ']', '}', '>');

    public boolean isBalanced(String input) {
        String left = "([{<";
        String right = ")]}>";
        Stack<Character> stack = new Stack<>();
        for(char ch : input.toCharArray()){
            if(left.contains(String.valueOf(ch)))
                stack.push(ch);

            if(right.contains(String.valueOf(ch))){
                if(stack.empty()) return false;
                var last = stack.pop();
                if(ch == ')' && last != '(' ||
                   ch == ']' && last != '[' ||
                   ch == '}' && last != '{' ||
                   ch == '>' && last != '<')
                    return false;
            }
        }
        return true;
    }

    public boolean isBalanced2(String input) {
        Stack<Character> stack = new Stack<>();
        for(char ch : input.toCharArray()) {
            if(isLeftBracket(ch))
                stack.push(ch);
            if(isRightBracket(ch)) {
                if(stack.empty()) return false;
                var last = stack.pop();
                if(!bracketsMatch(last, ch))
                    return false;
            }
        }
        return stack.empty();
    }

    private boolean isLeftBracket(char ch) {
        return openBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch) {
        return closeBrackets.contains(ch);
    }

    private boolean bracketsMatch(char open, char close) {
        return openBrackets.indexOf(open) == closeBrackets.indexOf(close);
    }
}

package LeetCode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                if (token.equals("+")) {
                    stack.push(a + b);
                }
                if (token.equals("-")) {
                    stack.push(b - a);
                }
                if (token.equals("*")) {
                    stack.push(b * a);
                }
                if (token.equals("/")) {
                    stack.push(b / a);
                }
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}

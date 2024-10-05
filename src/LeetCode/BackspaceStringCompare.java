package LeetCode;

import java.util.Stack;

public class BackspaceStringCompare {
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stack1.isEmpty()) stack1.pop();
            } else {
                stack1.add(c);
            }
        }

        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (!stack2.isEmpty()) stack2.pop();
            } else {
                stack2.add(c);
            }
        }

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.pop() != stack2.pop()) return false;
        }

        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        System.out.println(backspaceCompare(s, t));
    }
}

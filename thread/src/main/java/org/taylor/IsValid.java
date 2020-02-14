package org.taylor;

import java.util.Stack;

public class IsValid {

    public static void main(String[] args) {
        String s="()[]{}";
        boolean valid = isValidSimple(s);
        System.out.println(valid);
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                char d = stack.pop();
                char match;
                if (c == ')') {
                    match = '(';
                } else if (c == ']') {
                    match = '[';
                } else {
                    match = '{';
                }
                if (d != match) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    private static boolean isValidSimple(String s) {
        Stack<Character>stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c=='(')stack.push(')');
            else if(c=='[')stack.push(']');
            else if(c=='{')stack.push('}');
            else if(stack.isEmpty()||c!=stack.pop())return false;
        }
        return stack.isEmpty();
    }

}

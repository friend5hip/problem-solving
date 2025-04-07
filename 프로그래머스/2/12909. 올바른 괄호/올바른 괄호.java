import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        if (stack.isEmpty() && s.charAt(0) == ')') {
            answer = false;
        } else {
            stack.push(s.charAt(0));
        }
    
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '(' && current == ')') {
                stack.pop();
            } else {
                stack.push(current);
            }
        }
        
        if (!stack.isEmpty()) answer = false;

        return answer;
    }
}
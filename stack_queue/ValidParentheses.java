package stack_queue;

import java.util.Stack;

class ValidParentheses {

    /**
     * Validates whether the input string of parentheses is properly balanced.
     * A string is valid if:
     * - Open brackets are closed by the same type of brackets
     * - Brackets are closed in the correct order
     *
     * @param s the input string containing only '(', ')', '{', '}', '[' and ']'
     * @return true if the string is valid, false otherwise
     */
    public boolean isValid(String s) {
        // 1. Use a stack to track opening brackets
        Stack<Character> stack = new Stack<>();
        char[] sChar = s.toCharArray();

        // 2. Traverse each character in the string
        for (char c1 : sChar) {
            // If it's an opening bracket, push to stack
            if (c1 == '(' || c1 == '{' || c1 == '[') {
                stack.push(c1);
            } else {
                // If stack is empty, there's no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }

                // Pop from stack and check if it matches the closing bracket
                char c2 = stack.pop();
                if ((c1 == ')' && c2 != '(') ||
                    (c1 == '}' && c2 != '{') ||
                    (c1 == ']' && c2 != '[')) {
                    return false;
                }
            }
        }

        // 3. If stack is empty, all brackets were matched; otherwise, it's invalid
        return stack.isEmpty();
    }
}


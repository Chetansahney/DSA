class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1; // 1 means '+', -1 means '-'

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } 
            else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } 
            else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } 
            else if (c == '(') {
                // Push current result and sign
                stack.push(result);
                stack.push(sign);
                // Reset for new sub-expression
                result = 0;
                sign = 1;
            } 
            else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop(); // Multiply by sign before '('
                result += stack.pop(); // Add previous result
            }
        }

        // Add remaining number
        if (number != 0) {
            result += sign * number;
        }

        return result;
    }
}

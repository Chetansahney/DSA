class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26]; // frequency of each character
        boolean[] inStack = new boolean[26]; // tracks if a char is already in the result
        Stack<Character> stack = new Stack<>();

        // Step 1: Count frequency of all characters
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Step 2: Process each character
        for (char c : s.toCharArray()) {
            count[c - 'a']--; // one occurrence used

            // If already in stack, skip it
            if (inStack[c - 'a']) continue;

            // Step 3: Maintain lexicographical order using stack
            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                inStack[stack.pop() - 'a'] = false; // remove top from stack
            }

            // Step 4: Add current char to stack
            stack.push(c);
            inStack[c - 'a'] = true;
        }

        // Step 5: Build result from stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }
}

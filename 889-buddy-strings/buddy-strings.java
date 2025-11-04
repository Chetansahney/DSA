import java.util.HashSet;

class Solution {
    public boolean buddyStrings(String s, String goal) {
        // Step 1: Check length
        if (s.length() != goal.length()) return false;

        // Step 2: If both strings are identical
        if (s.equals(goal)) {
            HashSet<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                if (!set.add(c)) {
                    // duplicate found → valid swap possible
                    return true;
                }
            }
            return false; // all unique → can't swap to change anything
        }

        // Step 3: Find mismatched indices
        int first = -1, second = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (first == -1) first = i;
                else if (second == -1) second = i;
                else return false; // more than 2 mismatches
            }
        }

        // Step 4: Check swap validity
        return second != -1 &&
               s.charAt(first) == goal.charAt(second) &&
               s.charAt(second) == goal.charAt(first);
    }
}

import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Put all words in a set for O(1) lookups
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();

        // dp[i] = true means substring s[0...i) can be segmented
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;  // base case: empty string is valid

        // Try to build s[0...i)
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // If prefix s[0...j) is valid and s[j...i) is in dict
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;  // no need to check further splits
                }
            }
        }

        return dp[n];  // whether full string can be segmented
    }}
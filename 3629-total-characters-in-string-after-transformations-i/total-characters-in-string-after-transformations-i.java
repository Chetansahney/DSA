class Solution {
    private static final int MOD = 1_000_000_007;

    /**
     * Calculates the length of the string after t transformations modulo 10^9 + 7.
     * @param s The initial string.
     * @param t The number of transformations.
     * @return The length of the resulting string modulo 10^9 + 7.
     */
    public int lengthAfterTransformations(String s, int t) {
        // 1. Initialize frequency count array (0='a', 25='z')
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a'] = (count[c - 'a'] + 1) % MOD;
        }
        
        // 2. Perform t transformations
        for (int step = 0; step < t; step++) {
            int[] newCount = new int[26];
            
            // Loop through the old counts (j represents char index 'a' + j)
            for (int j = 0; j < 26; j++) {
                // 'a' through 'y' (indices 0 to 24) -> next letter (index j+1)
                if (j < 25) {
                    newCount[j + 1] = (newCount[j + 1] + count[j]) % MOD;
                } 
                // 'z' (index 25) -> "ab" (indices 0 and 1)
                else {
                    // 'z' transforms to 'a' (index 0)
                    newCount[0] = (newCount[0] + count[25]) % MOD;
                    // 'z' transforms to 'b' (index 1)
                    newCount[1] = (newCount[1] + count[25]) % MOD;
                }
            }
            // Update the count for the next iteration
            count = newCount;
        }
        
        // 3. Sum the final counts to get the total length
        long totalLength = 0;
        for (int freq : count) {
            totalLength = (totalLength + freq) % MOD;
        }
        
        return (int) totalLength;
    }
}
import java.util.*;

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0; // diff can't be negative

        Map<Integer, Integer> freq = new HashMap<>();

        // build frequency map
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        int count = 0;

        if (k == 0) {
            // need duplicates
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getValue() >= 2) {
                    count++;
                }
            }
        } else {
            // check for x+k
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                int x = entry.getKey();
                if (freq.containsKey(x + k)) {
                    count++;
                }
            }
        }

        return count;
    }
}

import java.util.*;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // Step 1: Count frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int longest = 0;
        
        // Step 2: For each key, check if key+1 exists
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                int length = map.get(key) + map.get(key + 1);
                longest = Math.max(longest, length);
            }
        }
        
        return longest;
    }
}

import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int count = 0;
        
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Step 2: Fix the largest side nums[k] and use two pointers
        for (int k = n - 1; k >= 2; k--) {
            int i = 0;          // left pointer
            int j = k - 1;      // right pointer
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += (j - i); // all pairs (i, ..., j-1) work
                    j--;               // move right pointer left
                } else {
                    i++;               // move left pointer right
                }
            }
        }
        return count;
    }
}

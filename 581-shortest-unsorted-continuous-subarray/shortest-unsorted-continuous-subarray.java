class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;

        // 1. Find first element from left which is out of order
        while (left < n - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }

        // Already sorted
        if (left == n - 1) return 0;

        // 2. Find first element from right which is out of order
        while (right > 0 && nums[right] >= nums[right - 1]) {
            right--;
        }

        // 3. Find min and max in this subarray
        int subMin = Integer.MAX_VALUE, subMax = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            subMin = Math.min(subMin, nums[i]);
            subMax = Math.max(subMax, nums[i]);
        }

        // 4. Expand left boundary
        while (left > 0 && nums[left - 1] > subMin) {
            left--;
        }

        // 5. Expand right boundary
        while (right < n - 1 && nums[right + 1] < subMax) {
            right++;
        }

        return right - left + 1;
    }
}

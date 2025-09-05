import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // O(n log n)

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // Early pruning: if the current number is > 0, further sums can't be 0
            if (nums[i] > 0) break;

            // Skip duplicate anchors
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i];
            int l = i + 1, r = n - 1;

            while (l < r) {
                int sum = nums[l] + nums[r];

                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    // Move both pointers & skip duplicates
                    int leftVal = nums[l], rightVal = nums[r];
                    while (l < r && nums[l] == leftVal) l++;
                    while (l < r && nums[r] == rightVal) r--;
                } else if (sum < target) {
                    l++; // need a bigger sum
                } else {
                    r--; // need a smaller sum
                }
            }
        }
        return res;
    }
}

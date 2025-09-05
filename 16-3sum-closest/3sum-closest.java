import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        // Initialize with the first valid triple
        int bestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate anchors (optional but faster)
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Optional pruning: check the min/max possible sums with this anchor
            int minPossible = nums[i] + nums[i + 1] + nums[i + 2];
            if (minPossible > target) {
                if (Math.abs(minPossible - target) < Math.abs(bestSum - target)) {
                    bestSum = minPossible;
                }
                break; // later anchors only make minPossible larger
            }
            int maxPossible = nums[i] + nums[n - 2] + nums[n - 1];
            if (maxPossible < target) {
                if (Math.abs(maxPossible - target) < Math.abs(bestSum - target)) {
                    bestSum = maxPossible;
                }
                continue; // this anchor can’t reach target; try next i
            }

            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                // Update best if closer
                if (Math.abs(sum - target) < Math.abs(bestSum - target)) {
                    bestSum = sum;
                }

                if (sum == target) {
                    return sum; // exact match is the closest possible
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return bestSum;
    }
}

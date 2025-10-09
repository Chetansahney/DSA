import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int low = 0; // minimum distance
        int high = nums[n - 1] - nums[0]; // maximum distance

        while (low < high) {
            int mid = (low + high) / 2;
            int count = countPairs(nums, mid);
            
            if (count >= k)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    private int countPairs(int[] nums, int mid) {
        int count = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && nums[j] - nums[i] <= mid)
                j++;
            count += j - i - 1;
        }
        return count;
    }
}

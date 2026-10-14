import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int i = 0;
        int closest=nums[0]+nums[1]+nums[2];
        
        while (i < n-1) {
            int j = i + 1;
            int k = n - 1;
        
            
            while (k > j) {
                int sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(sum-target)<Math.abs(closest-target))
                closest=sum;
                if (sum < target)
                    j++;
                else if (sum > target)
                    k--;
                else
                    return sum;

            }
            i++;

        }

        return closest;
    }
}

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;
        
        while (i < j) {
            if (nums[i] % 2 > nums[j] % 2) {
                // swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

            // move left pointer if even
            if (nums[i] % 2 == 0) i++;
            // move right pointer if odd
            if (nums[j] % 2 == 1) j--;
        }
        return nums;
    }
}

class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicate = -1, missing = -1;

        // Step 1: Detect duplicate by marking
        for (int num : nums) {
            int index = Math.abs(num) - 1; // Convert num to index
            if (nums[index] < 0)
                duplicate = Math.abs(num);  // Found duplicate
            else
                nums[index] *= -1;          // Mark as visited
        }

        // Step 2: Find missing number
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {              // Not visited => missing
                missing = i + 1;
                break;
            }
        }

        return new int[]{duplicate, missing};
    }
}

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Mark visited positions
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // index to mark
            if (nums[index] > 0) {
                nums[index] = -nums[index]; // mark as visited
            }
        }

        // Find numbers that are not marked
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); // i+1 is missing
            }
        }

        return result;
    }
}


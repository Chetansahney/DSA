class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int x : nums) {
            max = Math.max(max, x);
            min = Math.min(min, x);
        }
        
        int diff = max - min;
        int result = diff - 2 * k;
        
        return Math.max(0, result);
    }
}

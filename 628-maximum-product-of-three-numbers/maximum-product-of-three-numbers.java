class Solution {
    public int maximumProduct(int[] nums) 
    {
        Arrays.sort(nums);
       
        int prod1=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int prod2 = nums[0] * nums[1] * nums[nums.length - 1];

        // return the larger one
        return Math.max(prod1, prod2);
    }
}
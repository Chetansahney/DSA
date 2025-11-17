class Solution {
    public boolean checkSubarraySum(int[] nums, int k) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // Important: handles subarray starting at index 0
        
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) 
        {
            sum += nums[i];
            int rem = sum % k;
            
            if (!map.containsKey(rem)) {
                map.put(rem, i);   // store index only first time
            } else {
                if (i - map.get(rem) >= 2) {
                    return true;   // subarray length must be at least 2
                }
            }
        }
        
        return false;
    }
}

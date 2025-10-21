class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap <Integer,Integer> map=new HashMap<>();
        HashMap <Integer,Integer> first=new HashMap<>();
        HashMap <Integer,Integer> last=new HashMap<>();
        for(int i=nums.length-1;i>=0;i--) //last index of num
        {
            if(!last.containsKey(nums[i]))
            last.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++)    //first index of num
        {
            if(!first.containsKey(nums[i]))
            first.put(nums[i],i);
        }
        for(int n: nums)
        {
           map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int degree = Collections.max(map.values());
        int minLen = nums.length;

        for (int num : map.keySet()) {
            if (map.get(num) == degree) {
                int len = last.get(num) - first.get(num) + 1;
                minLen = Math.min(minLen, len);
            }
        }

        return minLen;

        
    }
}
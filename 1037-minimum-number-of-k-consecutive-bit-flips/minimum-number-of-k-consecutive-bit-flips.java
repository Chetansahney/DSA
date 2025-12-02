class Solution {
    public int minKBitFlips(int[] nums, int k) 
    {
        int flipcount=0;
        int flips=0;
        boolean arr[]=new boolean[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            if(i>=k&&arr[i-k])
            {
                flipcount--;
            }
            

            if(flipcount%2==nums[i])
            { 
                if(i+k>nums.length)
                {return -1;}

                flipcount++;
                flips++;
                arr[i]=true;
            }
        }
        return flips;
    }
}
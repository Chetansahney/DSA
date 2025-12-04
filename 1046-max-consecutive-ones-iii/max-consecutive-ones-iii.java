class Solution {
    public int longestOnes(int[] nums, int k) 
    {
        int zeros=0;int maxlen=0;int i=0;int j=0;
        int n=nums.length;

        while(j<n)
        {
            if(nums[j]==0)
            zeros++;

            if(zeros>k)
            {
                if(nums[i]==0)
                zeros--;

                i++;
            }

            if(zeros<=k)
            {
                int len=j-i+1;
                maxlen=Math.max(len,maxlen);
            }
            j++;
        }
        return maxlen;
    }
}
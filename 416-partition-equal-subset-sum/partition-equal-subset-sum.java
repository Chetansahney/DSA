class Solution {
    public boolean canPartition(int[] nums) {
        int target=0;int n=nums.length;
        for(int i=0;i<n;i++)
        {
            target+=nums[i];
        }
        if(target%2!=0)return false;
        target/=2;

        boolean dp[][]=new boolean[nums.length][target+1];
        for(int i=0;i<n;i++)dp[i][0]=true;
        if (nums[0] <= target) dp[0][nums[0]] = true;

        for(int i=1;i<n;i++)
        {
            for(int k=1;k<=target;k++)
            {
                boolean nottake=dp[i-1][k];
                boolean take=false;
                if(k>=nums[i])
                {
                    take=dp[i-1][k-nums[i]];
                }
                dp[i][k]=take||nottake;
            }
        }
        return dp[n-1][target];
        
    }
}
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalsum=0;int n=stones.length;
        for(int i=0;i<n;i++)
        {
            totalsum+=stones[i];
        }
        int target=totalsum;
        boolean dp[][]=new boolean[n][target+1];
        for(int i=0;i<n;i++)dp[i][0]=true;
        if (stones[0] <= target) dp[0][stones[0]] = true;

        for(int i=1;i<n;i++)
        {
            for(int k=1;k<=target;k++)
            {
                boolean nottake=dp[i-1][k];
                boolean take=false;
                if(k>=stones[i])
                {
                    take=dp[i-1][k-stones[i]];
                }
                dp[i][k]=take||nottake;
            }
        }
        int min=Integer.MAX_VALUE;
        for(int s1=0;s1<=totalsum/2;s1++)
        {
            if(dp[n-1][s1]==true)
            {
                min=Math.min(min,Math.abs((totalsum-s1)-s1));
            }
        }
        return min;
        
    }
}
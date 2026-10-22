class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int dp[][]=new int[m][n];
        for(int j=0;j<n;j++)
        dp[0][j]=matrix[0][j];

        for(int i=1;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {

                
                
                int above      = dp[i-1][j];
                int aboveLeft  = (j > 0)     ? dp[i-1][j-1] : Integer.MAX_VALUE;
                int aboveRight = (j < n - 1) ? dp[i-1][j+1] : Integer.MAX_VALUE;
                dp[i][j] = matrix[i][j] + Math.min(above, Math.min(aboveLeft, aboveRight));


                
            }
        }int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++)
            ans = Math.min(ans, dp[m-1][j]);
        return ans;
}}
class Solution {
    int count=0;
    public void dfs(int[][] grid,int i,int j, int[][] vis)
    {
        int n=grid.length;
        int m=grid[0].length;
        if(i<0 || j<0 || i>=n || j>=m || vis[i][j] == 1 || grid[i][j] == 0){
            return;
        }

        vis[i][j]=1;
        count--;
        dfs(grid,i,j+1,vis);
        dfs(grid,i+1,j,vis);
        dfs(grid,i,j-1,vis);
        dfs(grid,i-1,j,vis);
    }
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int vis[][]=new int[n][m];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                count ++;
            }
        }
        for(int j=0;j<m;j++)
        {
            if(grid[0][j]==1)
            dfs(grid,0,j,vis);
        }
        for(int j=0;j<m;j++)
        {
            if(grid[n-1][j]==1)
            dfs(grid,n-1,j,vis);
        }
        for(int i=0;i<n;i++)
        {
            if(grid[i][0]==1)
            dfs(grid,i,0,vis);
        }
        for(int i=0;i<n;i++)
        {
            if(grid[i][m-1]==1)
            dfs(grid,i,m-1,vis);
        }

        return count;


        
    }
}
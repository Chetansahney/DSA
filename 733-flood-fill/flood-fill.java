class Solution {
    private void dfs(int row,int col,int ans[][],int[][] image,int color,int [] delrow, int[] delcol,int initial)
    {
        ans[row][col]=color;
        int n=image.length;
        int m=image[0].length;
        for(int k=0;k<4;k++)
        {
            int nrow=delrow[k]+row;
            int ncol=delcol[k]+col;
            if(nrow>=0&&nrow<n &&ncol>=0&&ncol<m &&image[nrow][ncol]==initial && ans[nrow][ncol]!=color)
            {
                dfs(nrow,ncol,ans,image,color,delrow,delcol,initial);
            }
            
        }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) 
    {
        int initial=image[sr][sc];
        int n=image.length;
        int m=image[0].length;
        int ans[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                ans[i][j]=image[i][j];
            }
        
        }
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        dfs(sr,sc,ans,image,color,delrow,delcol,initial);
        return ans;
    }
}
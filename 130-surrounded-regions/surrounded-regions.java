class Solution {

    void dfs(char[][] board,int start,int end, int vis[][])
    {
        int n=board.length;
        int m=board[0].length;
        if(start<0||end<0||start>=n||end>=m|| vis[start][end]==1||board[start][end]=='X')return;

        vis[start][end]=1;
        dfs(board,start+1,end,vis);
        dfs(board,start,end-1,vis);
        dfs(board,start,end+1,vis);
        dfs(board,start-1,end,vis);
    }
    public void solve(char[][] board) 
    {
      int n=board.length;
      int m=board[0].length;
      int vis[][]=new int[n][m];

      for(int j=0;j<m;j++)
      {
        if(board[0][j]=='O')
        dfs(board,0,j,vis);
      }
      for(int j=0;j<m;j++)
      {
        if(board[n-1][j]=='O')
        dfs(board,n-1,j,vis);
      }
      for(int i=0;i<n;i++)
      {
        if(board[i][0]=='O')
        dfs(board,i,0,vis);
      }
      for(int i=0;i<n;i++)
      {
        if(board[i][m-1]=='O')
        dfs(board,i,m-1,vis);
      }

      for(int i=0;i<n;i++)
      {
        for(int j=0;j<m;j++)
        {
            if(vis[i][j]==0)
            {
                if(board[i][j]=='O')
                board[i][j]='X';
            }
        }
      }
    }
}
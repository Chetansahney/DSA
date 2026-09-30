class Solution {
    int n,m;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public boolean dfs(int k,int j,char[][]board, String word,int[][]vis,int idx)
    { if (idx == word.length() - 1) return true;
        vis[k][j]=1;
        for(int i=0;i<4;i++)
        {
            int nrow= k + dr[i];
            int ncol=j+dc[i];
            if(nrow>=0&& nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && board[nrow][ncol] == word.charAt(idx + 1)&& dfs(nrow,ncol,board,word,vis,idx+1))return true;
        }
        vis[k][j]=0;
        return false;


    }
    public boolean exist(char[][] board, String word) {
        //if a character matches, go to its neighbors
         n=board.length;
         m=board[0].length;
        int vis[][]=new int[n][m];
    
        for(int k=0;k<n;k++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[k][j]==word.charAt(0))
                if(dfs(k,j,board,word,vis,0))return true;
            }
        }
        return false;        
    }
}
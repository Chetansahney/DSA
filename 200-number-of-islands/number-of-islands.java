class Solution {
    public void bfs(int i,int j, boolean [][]visited,char[][] grid)
    { int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

            for (int k = 0; k < 4; k++) {
                int nrow = row + delRow[k];
                int ncol = col + delCol[k];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    !visited[nrow][ncol] &&
                    grid[nrow][ncol] == '1') {

                    visited[nrow][ncol] = true;
                    q.add(new int[]{nrow, ncol});
                }
            }
        }
    }
    
    public int numIslands(char[][] grid) 
    {
       int n=grid.length;int m=grid[0].length;
       boolean visited[][]=new boolean[n][m];
       int count=0;
       for(int row=0;row<n;row++)
       {
        for(int col=0;col<m;col++)
        {
            if(visited[row][col]==false && grid[row][col]=='1')
            {
                bfs(row,col,visited,grid);
                count++;
            }
        }
       }
       return count;

    }
}
class Pair
{
    int first;int second;
    Pair(int f,int s)
    {
        this.first=f;
        this.second=s;
    }
}
class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int visited[][] = new int[m][n];
        int count=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] != 1 && grid[i][j] == 0) {
                    Queue<Pair> q = new LinkedList<>();
                    q.offer(new Pair(i, j));
                    visited[i][j] = 1;
                    boolean isclosed = true;
                    int[] dirx = { 0, 1, 0, -1 };
                    int[] diry = { -1, 0, 1, 0 };
                    while (!q.isEmpty()) {
                        int row = q.peek().first;
                        int col = q.peek().second;
                        q.remove();

                        for (int k = 0; k < 4; k++) {
                            int nrow = row + dirx[k];
                            int ncol = col + diry[k];
                            if (nrow < 0 || nrow >= m || ncol < 0 || ncol >= n) {
                                isclosed = false;
                                continue;
                            }
                            if (visited[nrow][ncol] == 0 && grid[nrow][ncol] == 0) {
                                q.offer(new Pair(nrow, ncol));
                                visited[nrow][ncol] = 1;
                            }
                        }
                        

                    }
                    if(isclosed) count++;
                }
            }
        }
        return count;

    }
}
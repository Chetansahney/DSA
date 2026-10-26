
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
    public int countIslands(int[][] grid, int k) 
    {
        int m=grid.length;
        int n=grid[0].length;
        int visited[][] = new int[m][n];
        int count=0;
        int[] dirx = { 0, 1, 0, -1 };
        int[] diry = { -1, 0, 1, 0 };
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(visited[i][j]!=1 && grid[i][j]!=0)
                {   long sum=0;
                    Queue<Pair> q=new LinkedList<>();
                    q.offer(new Pair(i,j));
                    sum+=grid[i][j];
                    visited[i][j]=1;
                    
                    while(!q.isEmpty())
                    {
                        int row=q.peek().first;
                        int col=q.peek().second;
                        q.remove();
                        visited[i][j] = 1;
                        
                        for(int p=0;p<4;p++)
                        {
                            int nrow=row+dirx[p];
                            int ncol=col+diry[p];
                            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && visited[nrow][ncol]!=1 && grid[nrow][ncol]!=0)
                            {
                                q.offer(new Pair(nrow,ncol));
                                sum+=grid[nrow][ncol];
                                visited[nrow][ncol]=1;
                            }
                        }


                    }if(sum%k==0)count++;
                }
            }

        }
        return count;
       


        
    }
}
class Tuple{
    int first,second,third;
    Tuple(int f, int s, int t)
    {
        this.first=f;
        this.second=s;
        this.third=t;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) 
    {
        PriorityQueue <Tuple> pq = new PriorityQueue<>((x,y)-> x.first-y.first);
        int n=heights.length;
        int m=heights[0].length;
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dist[i][j]=(int)1e9;
            }
        }
        dist[0][0]=0;
        pq.offer(new Tuple(0,0,0));
        int dr[]={-1,0,1,0};
        int dc[]={0,-1,0,1};
        while(!pq.isEmpty())
        {
            Tuple it=pq.peek();
            pq.remove();
            int diff=it.first;
            int row=it.second;
            int col=it.third;

            if(row==n-1&&col==m-1)return diff;

            for(int i=0;i<4;i++)
            {
                int nrow=row+dr[i];
                int ncol=col+dc[i];
                if(nrow>=0 && nrow<n && ncol>=0 &&ncol<m)
                {
                    int neweffort=Math.max(Math.abs(heights[row][col]-heights[nrow][ncol]),diff);
                    if(neweffort<dist[nrow][ncol])
                    {
                        dist[nrow][ncol]=neweffort;
                        pq.add(new Tuple(neweffort,nrow,ncol));

                    }
                }
            }

        }
        return 0;
    }
}
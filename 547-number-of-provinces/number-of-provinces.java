class Solution {
    public void dfs(int node,int[][] connected,boolean[] vis,int n)
    {
        vis[node]=true;
        for(int i=0;i<n;i++)
        {
            if(connected[node][i]==1 && !vis[i])
            {
                dfs(i,connected,vis,n);
            }

        }
    }
    public int findCircleNum(int[][] isConnected) 
    {
        int n=isConnected.length;
        boolean visited[]=new boolean[n+1];
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {dfs(i,isConnected,visited,n);count++;}
        }
        return count;

    }

}
class Solution {
    boolean dfscheck(int node, int[][] graph, int [] vis, int[] patvis, int[] check )
    {
        vis[node]=1;
        patvis[node]=1;
        check[node]=0;

        for(int next: graph[node])
        {
            if(vis[next]==0)
            {
                if(dfscheck(next,graph,vis,patvis,check)==true)
                {
                    return true;
                }
            }
            else if(patvis[next]==1)
            return true;
        }
        check[node]=1;
        patvis[node]=0;
        return false;

    }
    public List<Integer> eventualSafeNodes(int[][] graph) 
    {
        int n=graph.length;
        int vis[]=new int[n];
        int patvis[]=new int[n];
        int check[]=new int[n];
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0) dfscheck(i,graph,vis,patvis,check);

        }
        List<Integer> safe=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(check[i]==1)safe.add(i);
        }
        return safe;
    }
}
class Solution {
    int minquite;
    public int[] loudAndRich(int[][] richer, int[] quiet) 
    {
        int n=quiet.length;
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int [] val: richer)
        {
            int u=val[0];
            int v=val[1];
            graph.get(v).add(u);
        }
        int res[]=new int[n];
        for(int i=0;i<n;i++)
        {
            minquite=-1;
            dfs(graph,i,new boolean[n],quiet);
            res[i]=minquite;

        }
        return res;

    }
    public void dfs(List<List<Integer>> graph, int node, boolean[] vis, int[] quite)
    {
        vis[node]=true;
        for(int next: graph.get(node))
        {
            if(!vis[next])
            {
                dfs(graph,next,vis,quite);
            }
        }
        minquite=(minquite==-1 ||quite[node]<quite[minquite])?node:minquite;
    }
}
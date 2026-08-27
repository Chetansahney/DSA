class Solution {
    private List<List<Integer>> adj;
    private boolean[] visited;

    public int[] findRedundantConnection(int[][] edges) {

        int n=edges.length;
        adj=new ArrayList<>();
        for (int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int edge[]: edges)
        {
            int u=edge[0];
            int v=edge[1];
            visited=new boolean[n+1];


            if(dfs(u,v))
            {
                return edge;
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return new int[0];
        
    }

    private boolean dfs(int cur,int target)
    {
        if(cur==target)return true;

        visited[cur]=true;
        for(int next: adj.get(cur))
        {
            if(!visited[next]&&dfs(next,target))
            return true;
        }
        return false;
    }
}
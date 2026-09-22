class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        //see if GrapH is bipartite or not

        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int d[]: dislikes)
        {
            adj.get(d[0]).add(d[1]);
            adj.get(d[1]).add(d[0]);
        }

        int color[]=new int[n+1];
        Arrays.fill(color,-1);
        for(int start=1;start<=n;start++)
        {
            if(color[start]==-1)
            {
                Queue<Integer> q=new LinkedList<>();
                q.offer(start);
                color[start]=0;

                while(!q.isEmpty())
                {
                    int node=q.poll();
                    for(int next:adj.get(node))
                    {
                        if(color[next]==-1){
                        color[next]=1-color[node];

                        q.offer(next);}
                        else if(color[next]==color[node])return false;
                    }
                }
            }
        }
        return true;
    }
}
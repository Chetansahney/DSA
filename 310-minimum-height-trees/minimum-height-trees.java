class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) 
    {
       if(n==1)
       {
        List <Integer> result=new ArrayList<>();
        result.add(0);
        return result;
       } 

       List<Set<Integer>> graph=new ArrayList<>();

       for(int i=0;i<n;i++)
       {
        graph.add(new HashSet<>());
       }
       for(int[] edge: edges)
       {
        graph.get(edge[0]).add(edge[1]);
        graph.get(edge[1]).add(edge[0]);
       }

       List<Integer> leaves=new ArrayList<>();
       for(int i=0;i<n;i++)
       {
        if(graph.get(i).size()==1)
        leaves.add(i);
       }
       int remainingnodes=n;

       while(remainingnodes>2)
       {
        remainingnodes-=leaves.size();
        List <Integer> newleaves=new ArrayList<>();
        for(int leaf:leaves)
        {
            int neighbor=graph.get(leaf).iterator().next();
            graph.get(neighbor).remove(leaf);
            if(graph.get(neighbor).size()==1)
            newleaves.add(neighbor);
        }
        leaves=newleaves;
       }

       return leaves;
       

    }
}
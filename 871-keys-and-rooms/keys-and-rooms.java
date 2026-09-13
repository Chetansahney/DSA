class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) 
    {   int n=rooms.size();
        boolean visited[]=new boolean[n];
        dfs(rooms,0,visited);
        for(boolean x: visited)
        {
            if(x==false)return false;
        }
        return true;
        
    }
    void dfs(List<List<Integer>> rooms, int node, boolean[] visited)
    {
        visited[node]=true;
        for(int next: rooms.get(node))
        {
            if(visited[next]==false)
            {
                dfs(rooms,next,visited);
            }
        }


    }
}
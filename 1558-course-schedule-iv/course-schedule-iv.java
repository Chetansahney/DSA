class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int indegree[] = new int[numCourses];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int p[]:prerequisites)
        {
            adj.get(p[0]).add(p[1]);
            indegree[p[1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)q.offer(i);
        }
        Map<Integer,Set<Integer>>map=new HashMap<>();
        for(int i=0;i<numCourses;i++)
        {
            map.put(i,new HashSet<>());
        }

        while(!q.isEmpty())
        {
            int node=q.poll();
            for(int next: adj.get(node))
            {
                map.get(next).add(node);
                map.get(next).addAll(map.get(node));
                indegree[next]--;
                if(indegree[next]==0)q.offer(next);
            }
        }
        List<Boolean> res =new ArrayList<>();
        for(int query[]:queries)
        {
            res.add(map.get(query[1]).contains(query[0]));
        }
        return res;


    }
}
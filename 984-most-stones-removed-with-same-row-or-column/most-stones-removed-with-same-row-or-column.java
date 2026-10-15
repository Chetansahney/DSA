class Solution {
    class DSU {
        int[] parent, size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int node) {
            if (parent[node] == node)
                return node;

            return parent[node] = find(parent[node]);
        }

        void unionBySize(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv) return;

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }
    public int removeStones(int[][] stones) {
        int maxrow=0;
        int maxcol=0;
        int n=stones.length;
        for(int i=0;i<n;i++)
        {
            maxrow=Math.max(maxrow,stones[i][0]);
            maxcol=Math.max(maxcol,stones[i][1]);
        }
        DSU ds=new DSU(maxrow+maxcol+2);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int noderow=stones[i][0];
            int nodecol=stones[i][1]+maxrow+1;
            ds.unionBySize(noderow,nodecol);
            map.put(noderow,1);
            map.put(nodecol,1);


        }

        int count=0;
        for(Map.Entry<Integer,Integer> it:map.entrySet()){
            if(ds.find(it.getKey())==it.getKey()){
                count++;
            }
        }
        return n-count;
       
    }
}
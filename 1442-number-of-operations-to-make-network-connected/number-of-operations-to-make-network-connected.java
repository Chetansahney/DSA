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
    public int makeConnected(int n, int[][] connections) {
        DSU ds=new DSU(n);
        int extra=0;
        for(int [] edge: connections)
        {
            int u=edge[0];
            int v=edge[1];
            if(ds.find(u)==ds.find(v))
            extra++;

            else
            ds.unionBySize(u,v);
        }

        int ans=0;
        for(int i=0;i<n;i++)
        {
            if(ds.parent[i]==i)
            ans++;
        }

        return extra>=ans-1?ans-1:-1;
        
    }
}
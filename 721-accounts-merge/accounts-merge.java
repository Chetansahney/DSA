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

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        HashMap<String ,Integer> map=new HashMap<>();
        DSU ds=new DSU(n);
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<accounts.get(i).size();j++)
            {
                String mail=accounts.get(i).get(j);
                if(!map.containsKey(mail))
                map.put(mail,i);
                else
                ds.unionBySize(i,map.get(mail));

            }
        }
        HashMap<Integer,List<String>> comp=new HashMap<>();
        for(Map.Entry<String,Integer> it: map.entrySet())
        {
            String mail=it.getKey();
            int node=ds.find(it.getValue());
            comp.computeIfAbsent(node,k->new ArrayList<>()).add(mail);
        }
        List<List<String>> ans=new ArrayList<>();
        for(int i: comp.keySet())
        {
            List<String> emails=comp.get(i);
            Collections.sort(emails);
            emails.add(0,accounts.get(i).get(0));
            ans.add(emails);
        }
        return ans;
    }
}
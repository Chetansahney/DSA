class Solution {
    public int openLock(String[] deadends, String target) 
    {
       Set<String> dead=new HashSet<>(Arrays.asList(deadends)) ;
       if(dead.contains("0000"))return -1;
       if(target.equals("0000"))return 0;


       Queue<String> q=new LinkedList<>();
       Set<String> visited=new HashSet<>();
       q.offer("0000");
       visited.add("0000");

       int level=0;

       while(!q.isEmpty())
       {
        int size=q.size();
        level++;

        for(int i=0;i<size;i++)
        {
            String cur=q.poll();
            for(String next: neighbor(cur))
            {
                if(visited.contains(next)||dead.contains(next))continue;
                if(next.equals(target))return level;
                visited.add(next);
                q.offer(next);
            }
        }
       }
       return -1;


    }

    private List<String> neighbor(String s)
    {
        List<String> res=new ArrayList<>();
        char a[]=s.toCharArray();
        for(int i=0;i<4;i++){

            char old = a[i];
            a[i] = (old == '9') ? '0' : (char)(old + 1);   // turn up (wraps)
            res.add(new String(a));
            a[i] = (old == '0') ? '9' : (char)(old - 1);   // turn down (wraps)
            res.add(new String(a));
            a[i] = old;


        }
        return res;
        
    }
}
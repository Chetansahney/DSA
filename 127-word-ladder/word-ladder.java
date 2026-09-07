class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words=new HashSet<>(wordList);//put wordlist into the set
        Queue<String> q=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int level=1;
        while(!q.isEmpty())
        {
            int size=q.size();
            level++;
            for(int i=0;i<size;i++)
            {
                String curr=q.poll();
                for(String next:neighbor(curr))
                {
                    if(visited.contains(next)||!words.contains(next)) continue;
                    if(next.equals(endWord))return level;
                    visited.add(next);
                    q.offer(next);
                }
            }
            
        }return 0;
    }
    
    private List<String> neighbor(String s)
    {
        List<String> res=new ArrayList<>();
        char a[]=s.toCharArray();
        for(int i=0;i<a.length;i++)
        {
            char old=a[i];
            for(char ch='a';ch<='z';ch++)
            {
                if(ch==old)continue;
                a[i]=ch;
                res.add(new String(a));
            }
            a[i]=old;

        }
        return res;
    }
}
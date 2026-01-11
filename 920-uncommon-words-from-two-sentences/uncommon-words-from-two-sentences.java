class Solution {
    public String[] uncommonFromSentences(String s1, String s2) 
    {
        HashMap<String,Integer> map=new HashMap<>(); List<String> list = new ArrayList<>();
        // process s1
        for (String word : s1.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // process s2
        for (String word : s2.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for(String str:map.keySet())
        {
                if(map.get(str)==1)
                {
                    list.add(str);
                }
            

        }
        return list.toArray(new String[0]);


    }
}
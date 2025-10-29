class Solution {
    public int numJewelsInStones(String jewels, String stones) 
    {
        HashMap <Character, Integer> map =new HashMap<>();
        for (char ch : stones.toCharArray()) {
    map.put(ch, map.getOrDefault(ch, 0) + 1);
}
Set<Character> set = new HashSet<>();
for (char ch : jewels.toCharArray()) {
            set.add(ch);
        }
int sum=0;
for(char key: map.keySet())
{
    if(set.contains(key))
    {
        sum+=map.get(key);
    }
}
return sum;

    }
}
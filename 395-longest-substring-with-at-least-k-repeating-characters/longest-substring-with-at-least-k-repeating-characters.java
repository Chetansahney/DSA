class Solution {
    public int longestSubstring(String s, int k) 
    {if (s.length() == 0 || k > s.length()) return 0;
        HashMap <Character, Integer> map=new HashMap<>();
        for(char ch: s.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);

        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) < k) {
                // split around invalid char
                int left = longestSubstring(s.substring(0, i), k);
                int right = longestSubstring(s.substring(i + 1), k);
                return Math.max(left, right);
            }
        }

        return s.length();
    }
}
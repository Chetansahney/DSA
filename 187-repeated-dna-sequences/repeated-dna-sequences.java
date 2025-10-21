import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) return new ArrayList<>();

        List<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (String ss : map.keySet()) {
            if (map.get(ss) > 1)
                list.add(ss);
        }

        return list;
    }
}

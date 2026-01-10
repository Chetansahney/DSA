class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            HashMap<Character, Integer> newmap = new HashMap<>();

            for (char c : words[i].toCharArray()) {
                newmap.put(c, newmap.getOrDefault(c, 0) + 1);
            }
            boolean canForm=true;
            for (char c : newmap.keySet()) {
                if (map.getOrDefault(c, 0) < newmap.get(c)) {
                    canForm = false;
                    break;
                }
            }
            if (canForm)
                count += words[i].length();

        }

        return count;
    }
}
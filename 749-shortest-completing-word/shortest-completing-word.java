class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        // Step 1: Count frequencies of letters in licensePlate
        Map<Character, Integer> target = buildFreqMap(licensePlate);
        String result = "";

        // Step 2: Check each word
        for (String word : words) {
            Map<Character, Integer> wordMap = buildFreqMap(word);

            if (covers(wordMap, target)) {
                if (result.equals("") || word.length() < result.length()) {
                    result = word;
                }
            }
        }

        return result;
    }

    // Build a frequency map for letters in a string
    private Map<Character, Integer> buildFreqMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        return map;
    }

    // Check if wordMap covers all characters from target
    private boolean covers(Map<Character, Integer> wordMap, Map<Character, Integer> target) {
        for (char c : target.keySet()) {
            if (wordMap.getOrDefault(c, 0) < target.get(c)) {
                return false;
            }
        }
        return true;
    }
}

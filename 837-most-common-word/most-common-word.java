import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // Convert banned words to a HashSet for quick lookup
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        // Normalize: lowercase and replace punctuation with spaces
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");

        // Split paragraph into words
        String[] words = paragraph.split("\\s+");

        // Count word frequencies
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            if (!bannedSet.contains(word) && word.length() > 0) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }

        // Find the word with the maximum frequency
        String res = "";
        int max = 0;
        for (String word : count.keySet()) {
            if (count.get(word) > max) {
                res = word;
                max = count.get(word);
            }
        }

        return res;
    }
}

  class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26]; // For 'a' to 'z'

        // Count each letter in the magazine
        for (char c : magazine.toCharArray()) {
            letters[c - 'a']++;
        }

        // Try to use letters for ransomNote
        for (char c : ransomNote.toCharArray()) {
            if (letters[c - 'a'] == 0) {
                return false; // Not enough letters
            }
            letters[c - 'a']--;
        }

        return true; // All letters matched
    }
}

    
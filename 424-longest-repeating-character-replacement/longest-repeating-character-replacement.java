class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, maxCount = 0, maxLength = 0;
        int[] freq = new int[26];

        while (right < s.length()) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;

            maxCount = Math.max(maxCount, freq[ch - 'A']);

            // If replacements needed > k, shrink the window
            while ((right - left + 1) - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}

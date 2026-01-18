class Solution {
    public String findValidPair(String s) {
        int[] freq = new int[10];

        // Count frequency of each digit
        for (char c : s.toCharArray()) {
            freq[c - '0']++;
        }

        // Check adjacent pairs
        for (int i = 0; i < s.length() - 1; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);

            if (a != b &&
                freq[a - '0'] == (a - '0') &&
                freq[b - '0'] == (b - '0')) {
                return "" + a + b;
            }
        }

        return "";
    }
}
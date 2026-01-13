class Solution {
    public String sortString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int remaining = s.length();

        while (remaining > 0) {
            // increasing a -> z
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    sb.append((char) ('a' + i));
                    freq[i]--;
                    remaining--;
                }
            }
            // decreasing z -> a
            for (int i = 25; i >= 0; i--) {
                if (freq[i] > 0) {
                    sb.append((char) ('a' + i));
                    freq[i]--;
                    remaining--;
                }
            }
        }
        return sb.toString();
    }
}

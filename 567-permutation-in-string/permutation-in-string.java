class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 > l2) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // count frequency of s1
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }

        // sliding window over s2
        for (int i = 0; i < l2; i++) {
            count2[s2.charAt(i) - 'a']++;

            // remove char that goes out of window
            if (i >= l1) {
                count2[s2.charAt(i - l1) - 'a']--;
            }

            // check if counts match
            if (matches(count1, count2)) return true;
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
